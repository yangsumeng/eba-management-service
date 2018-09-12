package com.ebei.eba.common.util;

public interface Constants {
    //文件服务器访问地址
//    public static final String FILE_SERVER = "http://127.0.0.1:5901/filemanager/FileUploadAndDownloadServlet";
    public static final String FILE_SERVER = "http://219.159.248.175:5901/filemanager/FileUploadAndDownloadServlet";
    //上传文件需要用到的常量
    public static final String FILE_DOT = ".";
    public static final int BUFFER_SIZE = 16 * 1024 ;
    public static final String FILENAME_REGEX = "\\(\\d+\\)";

    public static final String CHARTSET = "UTF-8";

    //上传涉及到的系统
//    public static final String SYSTEM = "s1";//组织架构
//    public static final String SYSTEM = "s2";//安全生产
    public static final String SYSTEM = "s3";//质量管控
//    public static final String SYSTEM = "s4";//预留
//    public static final String SYSTEM = "s5";//预留
}
