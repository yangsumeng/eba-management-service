package com.ebei.eba.common.util;

/**
 * 读取配置文件工具类
 * 
 * @author 姓名 工号
 * @version [版本号, 2016年9月14日]
 */
public class ExceptionUtils {
    /**
     * 获取异常的详细信息
     * @param e
     * @return
     */
    public static String getExceptionDetail(Exception e) {
        StringBuffer msg = new StringBuffer("");  
        if (e != null) {
            String message = e.toString();
            int length = e.getStackTrace().length;  
            if (length > 0) {  
                msg.append(message + "\r\n");  
                for (int i = 0; i < length; i++) {  
                    msg.append("\t" + e.getStackTrace()[i] + "\r\n");  
                }
            } else {  
                msg.append(message);  
            }  
        }  
        return msg.toString();  
    }
}
