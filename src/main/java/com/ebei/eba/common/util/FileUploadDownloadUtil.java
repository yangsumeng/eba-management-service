package com.ebei.eba.common.util;

//import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.http.HttpResponse;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Description:文件上传工具类
 *
 * @author xu
 * @date:2018/5/29
 * @Copyright (c) 2018 一碑科技
 */
public class FileUploadDownloadUtil {

    protected final static Logger logger = LoggerFactory.getLogger(FileUploadDownloadUtil.class);
    /**
     *
     * Discription : 上传文件到服务器
     * @param uuid uuid
     * @param file 文件流
     * @param dateFormat 时间格式
     * @param filename 文件名称
     * @param size 大小
     * @return
     * boolean
     * @throws
     * @author : Suyc
     */
    public static boolean fileUpload(String uuid, InputStream file, SimpleDateFormat dateFormat, String filename,Long size){
        try{
            HttpURLConnection conn=HttpRequestUtils.getUrlConnection(Constants.FILE_SERVER, Constants.BUFFER_SIZE);
            conn.setRequestProperty("type","1");//说明是上传
            conn.setRequestProperty("source", Constants.SYSTEM);//项目
            conn.setRequestProperty("range", String.valueOf(0));
            conn.setRequestProperty("filename", filename);
            conn.setRequestProperty("filecreatetime", dateFormat.format(new Date()));
            conn.setRequestProperty("fileid", uuid);
            conn.setRequestProperty("totalsize", String.valueOf(size));

            String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
            String inputName = "file";
            String contentType = "multipart/form-data";


            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
            strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            out.write(strBuf.toString().getBytes());
            int j=0;
            byte[] buf = new byte[Constants.BUFFER_SIZE];
            int nRead=0;
            try {
                DataInputStream in = new DataInputStream(file);
                int bytes = 0;
                byte[] bufferOut = new byte[1024];
                while ((bytes = in.read(bufferOut)) != -1) {
                    out.write(bufferOut, 0, bytes);
                }
                in.close();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();
            //读取返回数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }catch(Exception e){
            logger.error(ExceptionUtils.getExceptionDetail(e));
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * Description:
     *
     * 获取文件路径(主要是图片展示用)
     * 这里先获取ip
     */
    public static String getRemoteFilePath(HttpServletRequest request ,String fileId){
        String realIp = "";
        try{
            String requestUrl = request.getRequestURL().toString();
            //去掉http
            if(requestUrl.indexOf("https://") >= 0){
                requestUrl = requestUrl.substring(8);
            }else if(requestUrl.indexOf("http://") >= 0){
                requestUrl = requestUrl.substring(7);
            }
            //截掉后面部分
            if(requestUrl.indexOf(":") >= 0){
                requestUrl = requestUrl.substring(0,requestUrl.indexOf(":"));
            }else if(requestUrl.indexOf("/") >= 0){
                requestUrl = requestUrl.substring(0,requestUrl.indexOf("/"));
            }
            realIp = "localhost".equals(requestUrl) ?  "127.0.0.1" : requestUrl;
        }catch(Exception e){
            e.printStackTrace();
        }
        return FileUploadDownloadUtil.getRemoteFilePath(fileId, realIp);
    }

    /**
     * Description:
     * 这边是通过fileId 和id 拼接出地址
     *
     */
    public static String getRemoteFilePath(String fileId,String ip) {
        StringBuffer pathXml = new StringBuffer();
        String path = "";
        BufferedReader br = null;
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "2");
        map.put("fileid", fileId);
        map.put("realIp", ip);

        try {
            HttpResponse res = HttpRequestUtils.getHttpResponse(Constants.FILE_SERVER, map);
            br = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
            String sTempOneLine = new String("");
            while ((sTempOneLine = br.readLine()) != null){
                pathXml.append(sTempOneLine);
            }
        } catch (Exception e) {
            logger.info(ExceptionUtils.getExceptionDetail(e));
            e.printStackTrace();
        } finally{
            try {
                if (br != null)
                    br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(pathXml.length() > 0){
            path = FileUploadDownloadUtil.convertXMLtoString(pathXml.toString());
        }else{
            path = "-1";
        }

        return path;
    }

    /**
     * Description:把xml装换为字符串
     *
     */
    public static String convertXMLtoString(String xml) {
        Document doc = null;
        Element itemImg = null;
        Element itemCode = null;
        String filePath = "-1";
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            Iterator iterCode = rootElt.elementIterator("resultCode");
            if(iterCode.hasNext()){
                itemCode = (Element) iterCode.next();
            }
            if(itemCode!=null&&"0".equals(itemCode.getText())){
                Iterator iterImg = rootElt.elementIterator("fileWebPath");
                if(iterImg.hasNext()){
                    itemImg = (Element) iterImg.next();
                    filePath = itemImg.getText();
                }
            }
        } catch (DocumentException e) {
            logger.info(ExceptionUtils.getExceptionDetail(e));
            e.printStackTrace();
        }
        return filePath;
    }

    /**
     *
     * Discription :上传文件到tomcat目录下
     * @param file	上传的文件目录
     * @param filename	文件名称
     * @param savePathDirectory	要保存到那个文件目录
     * @param uuid	生成的uuid（文件名）
     * @return
     * @throws Exception
     * String
     * @throws
     * @author : shendx
     * @date 2014-7-14 上午9:19:00
     */
    public static String uploadFileToNativeAndReturnFilePath(HttpServletRequest request,MultipartFile file, String filename,String savePathDirectory,String uuid)
            throws Exception {
        String filepath = "";
        try {
            filename = filename.toLowerCase();
            int tc = filename.lastIndexOf(("."));
            // 获取文件类型
            String fileType = filename.substring(tc + 1);
            filepath = "";
            // 获取tomcat绝对路径
          //  String tomcatPath = request.getRealPath("/");
            File descfile = null;
            File folder = new File(savePathDirectory);
            // 查询是否有该目录,没有则创建
            if (!folder.exists()) {
                folder.mkdirs();
            }
            filepath = savePathDirectory + File.separator + uuid + "." + fileType;
            descfile = new File( filepath);
            // 上传文件主要路基
            copy(file, descfile);
        } catch (Exception e) {
            filepath = "";
        }
        return filepath;
    }

    /**
     * Copy file for file upload
     * @param src
     * @param dst
     * @throws Exception
     */
    public static void copy(MultipartFile src, File dst) throws Exception  {
        try {
            InputStream in = null ;
            OutputStream out = null ;
            try {
                in = new BufferedInputStream( src.getInputStream(), Constants.BUFFER_SIZE);
                out = new BufferedOutputStream( new FileOutputStream(dst), Constants.BUFFER_SIZE);
                byte [] buffer = new byte [Constants.BUFFER_SIZE];
                while (in.read(buffer) !=-1 ) {
                    out.write(buffer);
                    out.flush();
                    if(in.available()<Constants.BUFFER_SIZE && in.available()!=0){
                        buffer = new byte[in.available()];
                        logger.debug("buffer size: "+buffer.length);
                    }
                }
            } finally {
                if ( null != in) {
                    in.close();
                }
                if ( null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            logger.error("copy file error",e);
            throw e;
        }
    }

    /**
     * 删除文件，可以是单个文件或文件夹
     *
     * @param fileName 待删除的文件名
     * @return 文件删除成功返回true,否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        } else {
            if (file.isFile()) {

                return deleteFile(fileName);
            } else {
                return deleteDirectory(fileName);
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 被删除文件的文件名
     * @return 单个文件删除成功返回true,否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        } else {
            return false;
        }
    }
    /**
     * 删除目录（文件夹）以及目录下的文件
     *
     * @param dir 被删除目录的文件路径
     * @return 目录删除成功返回true,否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
            // 删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }

        if (!flag) {
            return false;
        }

        // 删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Description:
     *  spring上传会把文件封装成MultipartFile
     *  在需要对图图片进行压缩的时候转化为File 否则不管
     */
//    public static File constToFile(MultipartFile file) {
//        try{
//            File f = null;
//            try {
//                CommonsMultipartFile cf= (CommonsMultipartFile)file;
//                DiskFileItem fi = (DiskFileItem)cf.getFileItem();
//                f = fi.getStoreLocation();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return f;
//        }catch (Exception e){
//            logger.error(ExceptionUtils.getExceptionDetail(e));
//            e.printStackTrace();
//            return null;
//        }
//    }
}
