package com.ebei.eba.common.util;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author: Huangweicai
 * @date 2018-02-05 16:10
 * @Description:请求封装基础类
 */
public class ResponseEx<T> {
    private int status;
    private String message;
    private T data;


    private ResponseEx() {}

    private ResponseEx(int status) {
        this.status = status;
    }

    private ResponseEx(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private ResponseEx(int status, T data) {
        this.status = status;
        this.data = data;
    }
    
    private ResponseEx(int status,String message, T data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static ResponseEx<Object> createSuccess() {
        return createSuccess("success");
    }

    public static ResponseEx<Object> createSuccess(int status) {
        return createSuccess(status,null);
    }

    public static <T> ResponseEx<T> createSuccess(T t) {
        return createSuccess(ResponseConstants.CODE_SUCCESS, t);
    }
    
    public static <T> ResponseEx<T> createNoDataSuccess(T t){
    	return createNoDataSuccess(ResponseConstants.CODE_NO_DATA, t);
    }

    public static <T> ResponseEx<T> createSuccess(int code,T t) {
        return new ResponseEx<T>(code, t);
    }
    
    public static <T> ResponseEx<T> createSuccess(String m,T t) {
        return createSuccess(ResponseConstants.CODE_SUCCESS, m, t);
    }
    
    public static <T> ResponseEx<T> createNoDataSuccess(int code,T t) {
        return new ResponseEx<T>(code, t);
    }

    public static ResponseEx<Object> createSuccess(String message) {
        return new ResponseEx<Object>(ResponseConstants.CODE_SUCCESS, message);
    }
    
    public static ResponseEx<Object> createNoDataSuccess(String message){
    	return new ResponseEx<Object>(ResponseConstants.CODE_NO_DATA, message);
    }

//    public static <T> ResponseEx<T> createSuccess(T t) {
//        return new ResponseEx<>(CODE_SUCCESS, t);
//    }

    public static ResponseEx<Object> createError(String message) {
        return createError(ResponseConstants.CODE_BUSINESS_ERROR, message);
    }

    public static ResponseEx<Object> createError(int code,String message) {
        return new ResponseEx<Object>(code,message);
    }

    public static ResponseEx<Object> createException(String message) {
        return createError(ResponseConstants.CODE_ERROR, message);
    }
    
    public static <T> ResponseEx<T> createSuccess(int code,String m,T t) {
        return new ResponseEx<T>(code, m, t);
    }


    @JSONField(serialize=false)
    public boolean isSuccess() {
        return this.status == ResponseConstants.CODE_SUCCESS;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
//  public static void main(String[] args) {
//	InvestProjectBean investProjectBean = new InvestProjectBean();
//    
//	investProjectBean.setProjectId("11");
//	investProjectBean.setProjectCode("sss");
//    
//	InvestProjectInfoBean investProjectInfoBean = new InvestProjectInfoBean();
//	investProjectInfoBean.setProjectInfoId("22");
//	
//	investProjectBean.setInvestProjectInfoBean(investProjectInfoBean);
//	
//    ResponseEx responseEx = ResponseEx.createSuccess(investProjectBean);
//
//    Map<Class<?>, String[]> excludes = new HashMap<Class<?>, String[]>();  
//    excludes.put(InvestProjectBean.class, new String[]{"cityCompartment","investProjectPartners","investProjectInfoBean.acquisition"}); 
//    excludes.put(InvestProjectInfoBean.class, new String[]{"acquisition"});  
//    ComplexPropertyPreFilter complexPropertyPreFilter = new ComplexPropertyPreFilter(excludes); 
//    
//    System.out.println(responseEx.toJson(complexPropertyPreFilter));
//}
}
