package com.turing.wallet.common;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.turing.wallet.config.AwsFileConfig;
import com.turing.wallet.utils.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * AWS 文件服务 工具类
 */
@Slf4j
@Component
public class AwsFileUtil {

  @Autowired
  private AwsFileConfig config;

  final String buckName = "coinstore-sg-encryption";

  /**
   * 上传到aws
   * @param fileObjKeyName 上传到的桶文件路径
   * @param inputStream    要上传的文件的 文件流
   * @return
   */
  public String uploadAwsSDK(String fileObjKeyName, InputStream inputStream, long size) {

    try {
      //This code expects that you have AWS credentials set up per:
      // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
      AmazonS3 s3Client = new AmazonS3Client(new BasicAWSCredentials(config.getAccessKey(), config.getSecretKey()));
      if(config.getRegion().equals("cn-northwest-1")) {
        s3Client.setRegion(Region.getRegion(Regions.CN_NORTHWEST_1));
      }
      // Upload a text string as a new object.
      //s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");

      // Upload a file as a new object with ContentType and title specified.
      ObjectMetadata metadata = new ObjectMetadata();
      if (size > 0) {
        metadata.setContentLength(size);
      }
      PutObjectRequest request = new PutObjectRequest(config.getBucketName(), fileObjKeyName, inputStream, metadata);
      s3Client.putObject(request);
      return config.getAccessPrefix();
    } catch (AmazonServiceException e) {
      // The call was transmitted successfully, but Amazon S3 couldn't process
      // it, so it returned an error response.
      //呼叫已成upload功传输，但Amazon S3无法处理
      //所以它返回了一个错误响应。
      log.error("呼叫已成功传输，但Amazon S3无法处理");
      e.printStackTrace();
    } catch (SdkClientException e) {
      // Amazon S3 couldn't be contacted for a response, or the client
      // couldn't parse the response from Amazon S3.
      //无法联系Amazon S3以获得响应，或者客户端
      //无法解析来自Amazon S3的响应。
      log.error("无法联系Amazon S3以获得响应，或者客户端");
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 下载图片
   * @param url      要下载的问题的 路径
   */
  public String downloadFile(String url) {

    AmazonS3 amazonS3 = new AmazonS3Client(new BasicAWSCredentials(config.getAccessKey(), config.getSecretKey()));

    if(config.getRegion().equals("cn-northwest-1")) {
      amazonS3.setRegion(Region.getRegion(Regions.CN_NORTHWEST_1));
    }

    BufferedImage imgBuf;

    try {
      S3Object obj = amazonS3.getObject(config.getBucketName(), url);
      S3ObjectInputStream objectContent = obj.getObjectContent();
      imgBuf = ImageIO.read(objectContent);
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ImageIO.write(imgBuf, "jpg", out);
      byte[] bytes = out.toByteArray();
      return new Base64().encode(bytes);
    } catch (Exception e) {
      log.error("error", e);
    }

    return null;
  }
}
