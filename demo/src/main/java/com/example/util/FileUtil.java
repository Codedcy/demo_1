package com.example.util;

import org.springframework.web.multipart.MultipartFile;

import com.example.bean.CommonResponseMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class FileUtil {
 
    //文件上传工具类服务方法
	public CommonResponseMap uploadFile(MultipartFile file, String filePath, String fileType, String fileName) {
 
        CommonResponseMap dataMap = new CommonResponseMap();
        try {
        	System.out.println("try");
        	String docUrl = "";
        	String fileSuf = "";
            if("image".equals(fileType)) {
            	System.out.println("if1");
            	if(file==null) {
            		System.out.println("file:null");
            	}
                String realFileName = file.getOriginalFilename();
                fileSuf = realFileName.substring(realFileName.lastIndexOf(".")+1);
                System.out.println(realFileName);
                System.out.println(fileSuf);
                if(!"png".equals(fileSuf) && !"jpg".equals(fileSuf) && !"jpeg".equals(fileSuf)) {
                    dataMap.fail(1, "文件类型只能是png,jpg,jpeg");
                    return dataMap;
                }
 
                if(file.getSize() > 5242880) {
                    dataMap.fail(1, "图片大小不能超过5MB");
                    return dataMap;
                }
                System.out.println("if2");
            }else {
            	System.out.println("else");
            	dataMap.fail(2, "后台文件类设定型错误！");
            	return dataMap;
            }
            long timeMillis = System.currentTimeMillis();
            docUrl = filePath.substring(filePath.indexOf("assets"))+"H"+timeMillis+fileName+"."+fileSuf;
            File f = new File(filePath+"H"+timeMillis+fileName+"."+fileSuf);
            if(!f.exists()) {
            	System.out.println(filePath+"H"+timeMillis+fileName+"."+fileSuf);
            	f.createNewFile();
            }
            System.out.println(f.getAbsolutePath());
            FileOutputStream out = new FileOutputStream(filePath+"H"+timeMillis+fileName+"."+fileSuf);
            
            out.write(file.getBytes());
            out.flush();
            out.close();
            dataMap.success();
            dataMap.put("fileUrl", docUrl);
            System.out.println("util:"+dataMap.getResMap().get("fileUrl"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } finally {
        	System.out.println("finally");
            return dataMap;
        }
    }
}