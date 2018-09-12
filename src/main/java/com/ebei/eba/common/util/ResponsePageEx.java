package com.ebei.eba.common.util;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author: Huangweicai
 * @date 2018-02-05 16:10
 * @Description:请求封装基础类--分页
 *              结构如下
 *              {
 *                  status:200,
 *                  message:success,
 *                  data:{
 *                      result:[],      --返回内容(集合)
 *                      totalCount:100, --总共条数
 *                      pageSize:10,    --每页条数
 *                      totalPage:10    --总共页数
 *                  }
 *              }
 *
 *              基础类 {@link ResponseEx}
 */
public class ResponsePageEx<T> {
    private int status;
    private String message;

    private TPageBean data;


    private ResponsePageEx(int status) {
        this.status = status;
    }

    private ResponsePageEx(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private ResponsePageEx(int status, TPageBean data) {
        this(status, "", data);
    }

    private ResponsePageEx(int status, String message,TPageBean data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

//    public static ResponsePageEx createSuccess() {
//        return new ResponsePageEx(ResponseConstants.CODE_SUCCESS);
//    }

    public static <T> ResponsePageEx<T> createSuccess(T t, Integer totalCount) {
        return createSuccess(t, "", totalCount);
    }

    public static <T> ResponsePageEx<T> createSuccess(T t, String message,Integer totalCount) {
        return new ResponsePageEx(ResponseConstants.CODE_SUCCESS,message, TPageBean.createSuccess(t, totalCount));
    }
    
    public static <T> ResponsePageEx<T> createSuccess(T t, Integer totalCount,Integer current,Integer size,Integer pages) {
        return createSuccess(t, "", totalCount, current, size, pages);
    }

    public static <T> ResponsePageEx<T> createSuccess(T t, String message,Integer totalCount,Integer current,Integer size,Integer pages) {
        return new ResponsePageEx(ResponseConstants.CODE_SUCCESS,message, TPageBean.createSuccess(t, totalCount, current, size, pages));
    }

    @JSONField(serialize=false)
    public boolean isSuccess() {
        return this.status >= 0;
    }
    
    /**
     * 
     * Description : 对象转JSON
     * @param features 自定义序列
     * @return
     * @author FanHua
     */
    @JSONField(serialize=false)
	public String toJson(SerializerFeature... features) {
    	SerializerFeature[] SerializerFeatureArray;
    	if(features != null){
    		SerializerFeatureArray = new SerializerFeature[6 + features.length];
    	}else{
    		SerializerFeatureArray = new SerializerFeature[6];
    	}
    	
		SerializerFeatureArray[0] = SerializerFeature.PrettyFormat;
		SerializerFeatureArray[1] = SerializerFeature.WriteMapNullValue;
		SerializerFeatureArray[2] = SerializerFeature.WriteNullStringAsEmpty;
		SerializerFeatureArray[3] = SerializerFeature.DisableCircularReferenceDetect;
		SerializerFeatureArray[4] = SerializerFeature.WriteNullListAsEmpty;
		SerializerFeatureArray[5] = SerializerFeature.WriteDateUseDateFormat;

		if(features != null){
			int i = 5;
			for (SerializerFeature serializerFeature : features) {
				i++;
				SerializerFeatureArray[i] = serializerFeature;
			}
		}

		return JSONObject.toJSONString(this, SerializerFeatureArray);
	}
    
    /**
     * 
     * Description : 对象转JSON
     * @param complexPropertyPreFilter 手动过滤对象
     * @param features 自定义序列
     * @return
     * @author FanHua
     */
    @JSONField(serialize=false)
    public String toJson(ComplexPropertyPreFilter complexPropertyPreFilter,SerializerFeature... features) {
    	SerializerFeature[] SerializerFeatureArray;
    	if(features != null){
    		SerializerFeatureArray = new SerializerFeature[6 + features.length];
    	}else{
    		SerializerFeatureArray = new SerializerFeature[6];
    	}
    	
		SerializerFeatureArray[0] = SerializerFeature.PrettyFormat;
		SerializerFeatureArray[1] = SerializerFeature.WriteMapNullValue;
		SerializerFeatureArray[2] = SerializerFeature.WriteNullStringAsEmpty;
		SerializerFeatureArray[3] = SerializerFeature.DisableCircularReferenceDetect;
		SerializerFeatureArray[4] = SerializerFeature.WriteNullListAsEmpty;
		SerializerFeatureArray[5] = SerializerFeature.WriteDateUseDateFormat;

		if(features != null){
			int i = 5;
			for (SerializerFeature serializerFeature : features) {
				i++;
				SerializerFeatureArray[i] = serializerFeature;
			}
		}

		return JSONObject.toJSONString(this, complexPropertyPreFilter, SerializerFeatureArray);
    }
    
    public static ResponsePageEx createError(String message) {
        return createError(ResponseConstants.CODE_ERROR, message);
    }

    public static ResponsePageEx createException(String message) {
        return createError(ResponseConstants.CODE_BUSINESS_ERROR, message);
    }

    public static ResponsePageEx createError(int status,String message) {
        return new ResponsePageEx(status,message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TPageBean getData() {
        return data;
    }

    public void setData(TPageBean data) {
        this.data = data;
    }
}
