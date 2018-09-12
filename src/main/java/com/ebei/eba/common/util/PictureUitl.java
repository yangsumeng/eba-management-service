package com.ebei.eba.common.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

/**
 * 
 * Description:图片工具类
 * @date:2017年5月18日
 * @Copyright (c) 2017 一碑科技
 * @version 
 */
public class PictureUitl {
	
	/**
	 * 
	 * Description:上传图片的时候 生成缩略图
	 * @param file 文件流
	 * @param filename 文件名
	 * @param dateFormat 
	 * @return  关联原图的uuid
	 * @throws Exception
	 * @version 
	 * @author xu
	 */
	 public static String doThumbnailatorUpload(HttpServletRequest request, MultipartFile file, String filename, SimpleDateFormat dateFormat) throws Exception {
	        String thumbnailatorFileId = null;
	        String tempDir = "bmblueprintTemp";
	        try {
	            String filePath = FileUploadDownloadUtil.uploadFileToNativeAndReturnFilePath(request,file, filename,
	                    tempDir + File.separator + "temp", UUID.getId());
	            filePath = filePath.replaceAll("\\\\", "/");
	            File descfile = new File( filePath);
	            
	            ThumbnailatorUtil.xferFile(descfile.getPath(), descfile.getParent(), 120, 120, "_small", 1);

	            String[] filePathEnd = filePath.split("\\.");
//	            File thumbnailatorfile = new File(
//						request.getRealPath("/") + File.separator + filePathEnd[0] + "_small." + filePathEnd[1]);
                File thumbnailatorfile = new File(filePathEnd[0] + "_small." + filePathEnd[1]);
	            thumbnailatorFileId = UUID.getId();
				if (!FileUploadDownloadUtil.fileUpload(thumbnailatorFileId,new FileInputStream(thumbnailatorfile) ,dateFormat, thumbnailatorfile.getName(), thumbnailatorfile.length())) {
	                thumbnailatorFileId = null;
	            }
	        } catch (Exception e) {
	            thumbnailatorFileId = null;
	            e.printStackTrace();
	        } finally {
				FileUploadDownloadUtil.delete(request.getRealPath("/") + File.separator + tempDir);
	        }
	        return thumbnailatorFileId;
	    }
	 
	 /**
	  * Description:把base64字符串转化临时文件
	  * @param base64
	  * @return
	  * @version 
	  * @author xu
	  */
	 public static File base64ToFile(String base64) {  
		 byte[] buffer;
		 String tempDir = "uploadtemp";
		 File filedir = new File(tempDir);
		 if(!filedir.exists()){
			 filedir.mkdirs(); 
		 }
		 String path = "uploadtemp"+File.separator+UUID.getId();
	        try {
	            buffer = new BASE64Decoder().decodeBuffer(base64);
	            FileOutputStream out = new FileOutputStream(path);
	            out.write(buffer);
	            out.close();
	            return new File(path);
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw new RuntimeException("base64字符串异常或地址异常\n" + e.getMessage());
	        }
		}  
}
