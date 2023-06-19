package com.turing.wallet.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 */
@Component
public class SysAutowried {
    public static final Logger log = LoggerFactory.getLogger(SysAutowried.class);

    /**
     * @param file文件参数
     * @param realPath传入目录
     * @throws IOException
     * @author yufeng
     */
    public static String IMGUtil(MultipartFile file, String realPath) throws IOException {
//        if (file.isEmpty()) {
//        System.out.println("我在这里");
//            return "文件为空";
//        }
        BufferedOutputStream stream = null;
        String fileName = null;
        byte[] bytes = file.getBytes();
        String originalFilename = file.getOriginalFilename();
        String typeName = originalFilename.substring(originalFilename.indexOf("."), originalFilename.length());
        fileName = System.currentTimeMillis() + typeName;
        File filetaget = new File(realPath + fileName);
        File p = filetaget.getParentFile();
        if (!p.exists()) {
            p.mkdirs();
        }
        if (filetaget.exists()) {
            filetaget.delete();
        }
        filetaget.createNewFile();
        stream = new BufferedOutputStream(new FileOutputStream(filetaget));

        stream.write(bytes);
        stream.close();
        //stream = null;
        return fileName;// 返回的是一个新的图片123.jpg存入数据库的
    }

}
