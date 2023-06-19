package com.turing.wallet.config;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.turing.wallet.enums.OutputMode;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Base64;

import static com.turing.wallet.enums.OutputMode.BASE64;
import static com.turing.wallet.enums.OutputMode.PLAIN;

/**
 * 利用KMS对配置文件加密串进行解密
 */
@Slf4j
public class KmsEncryptablePropertyResolver implements EncryptablePropertyResolver {

    private static final Base64.Encoder BASE64_ENCODER = Base64.getEncoder();
    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();
    private static final String EMPTY_STRING = "";
    private static final boolean IS_ALGORITHM_AVAILABLE;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AWSKMS kms;
    private final AwsKmsConfig awsKmsConfig;

    public KmsEncryptablePropertyResolver(AwsKmsConfig signConfig) {
        this.awsKmsConfig = signConfig;
    }

    @Override
    public String resolvePropertyValue(String s) {
        if (null != s && s.startsWith(KmsEncryptablePropertyDetector.ENCODED_PASSWORD_HINT)) {
            // 调用KMS对配置文件加密值进行解密。加密方式可以自定义
            if (null != s && s.startsWith(KmsEncryptablePropertyDetector.ENCODED_PASSWORD_HINT)) {
                String encryptStr = s.substring(KmsEncryptablePropertyDetector.ENCODED_PASSWORD_HINT.length());
                s = decrypt(encryptStr);
                log.info("encrypt-decrypt-once-s:{}", s);
            }
        }
        return s;
    }

    public String encrypt(final String text) {
        if (text == null || text.isEmpty()) {
            return EMPTY_STRING;
        } else {
            final EncryptRequest encryptRequest = new EncryptRequest()
                    .withKeyId(awsKmsConfig.getKms_key_id())
                    .withPlaintext(ByteBuffer.wrap(text.getBytes()));

            if (IS_ALGORITHM_AVAILABLE && !awsKmsConfig.getKms_algorithm().equals("SYMMETRIC_DEFAULT")) {
                encryptRequest.setEncryptionAlgorithm(awsKmsConfig.getKms_algorithm());
            }
            final ByteBuffer encryptedBytes = kms.encrypt(encryptRequest).getCiphertextBlob();
            //Base64 encode
            return extractString(encryptedBytes, BASE64, true);
        }
    }

    public String decrypt(final String encryptedText) {
        if (encryptedText != null && !encryptedText.isEmpty()) {
            ByteBuffer bb = ByteBuffer.wrap(encryptedText.getBytes());
            //Base64 decode
            ByteBuffer encCipher = extractBB(bb, BASE64, false);
            DecryptRequest decryptRequest = (new DecryptRequest()).withCiphertextBlob(encCipher);
            if (IS_ALGORITHM_AVAILABLE && !awsKmsConfig.getKms_algorithm().equals("SYMMETRIC_DEFAULT")) {
                decryptRequest.setEncryptionAlgorithm(awsKmsConfig.getKms_algorithm());
            }
            decryptRequest.setKeyId(awsKmsConfig.getKms_key_id());
            //返回解密后的明文串
            return extractString(this.kms.decrypt(decryptRequest).getPlaintext(), PLAIN, false);
        } else {
            return "";
        }
    }

    private static ByteBuffer extractBB(final ByteBuffer bb, final OutputMode outputMode, final Boolean bEncode){
        if (bb.hasRemaining()){
            if (bEncode){
                return outputMode == BASE64 ? BASE64_ENCODER.encode(bb) : bb;
            }else {
                return outputMode == BASE64 ? BASE64_DECODER.decode(bb) : bb;
            }
        }else{
            return ByteBuffer.wrap("".getBytes());
        }
    }
    private static String extractString(final ByteBuffer bb, final OutputMode outputMode, final Boolean bEncode) {
        if (bb.hasRemaining()) {
            byte[] bytes = new byte[bb.remaining()];
            bb.get(bytes, bb.arrayOffset(), bb.remaining());
            if (bEncode) {
                return outputMode == BASE64 ? BASE64_ENCODER.encodeToString(bytes) : new String(bytes);
            }else{
                return outputMode == BASE64 ? new String(BASE64_DECODER.decode(bytes)) : new String(bytes);
            }
        } else {
            return "";
        }
    }

    private void checkAlgorithm(String algorithm) {
        if (isAsymmetricEncryption(algorithm) && !IS_ALGORITHM_AVAILABLE) {
            this.log.warn("Asymmetric encryption '{}' has been configured,but the version of aws-java-sdk you are using is outdated and does not support it. Please upgrade to a more recent version.", algorithm);
        }

    }

    private static boolean isAsymmetricEncryption(String algorithm) {
        return !algorithm.equals("SYMMETRIC_DEFAULT");
    }

    static {
        boolean available;
        try {
            Class.forName("com.amazonaws.services.kms.model.EncryptionAlgorithmSpec");
            available = true;
        } catch (Exception var2) {
            available = false;
        }

        IS_ALGORITHM_AVAILABLE = available;
    }
}
