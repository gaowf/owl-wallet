package com.turing.wallet.service;

import com.turing.wallet.param.PrivateShares;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WalletBaseService {
    // AES_256 key for encrypt/decrypt, using AesEncryptUtils
    @Value("${private_aes_key}")
    String private_aes_key;
    public boolean savePrivateShares(Long uid, PrivateShares privateShares)
    {
        //1. encrypt the private shares respectively. aesEncrypt
        //2. query if users' private shares exists?
        //3. if exists:
             //a. check if they match the encrypted private shares
             //b. if not match, warning and log (Better to save the new private shares in db's another table or column)
             //c. if match, do nothing
        //4. if not exists:
             //a. insert user's private shares into db
        return true;
    }
    public String getServerPrivateShare(Long uid) {
        //1. query the encrypted server private share from DB
        //2. decrypt the query string. aesDecrypt
        //3. return decrypted server private share
        return "";
    }
}
