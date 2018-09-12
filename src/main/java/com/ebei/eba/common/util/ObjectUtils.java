package com.ebei.eba.common.util;

import java.lang.reflect.*;
import java.util.*;


/**
 * ObjectUtils
 * 
 * @author 姓名 工号
 * @version [版本号, 2014-9-16]
 */
public class ObjectUtils
{
    /**
     * 判断字符串是否为空
     * 
     * @param value
     * @return
     */
    public static Boolean isEmpty(String value)
    {
        if (value == null)
        {
            return true;
        }
        
        else
        {
            if (value.equals(""))
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 判断字符串有效
     * 
     * @param value
     * @return
     */
    public static Boolean isNotEmpty(String value)
    {
        if (value != null && !value.equals("") && !value.equals("null"))
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 判断集合是否为空
     * 
     * @param collection
     * @return
     */
    public static <E> Boolean isEmpty(Collection<E> collection)
    {
        if (collection == null)
        {
            return true;
        }
        
        else
        {
            if (collection.isEmpty())
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 判断集合不为空
     * 
     * @param collection
     * @return
     */
    public static <E> Boolean isNotEmpty(Collection<E> collection)
    {
        if (collection != null && !collection.isEmpty())
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 判断对象是否为空
     * 
     * @param value
     * @return
     */
    public static Boolean isNull(Object value)
    {
        if (value == null)
        {
            return true;
        }
        
        return false;
    }
    
    public static String getIsNullValue(Object o, String errorMsg) 
    {
        if(o == null)
        {
            return errorMsg;
        }
        
        return "";
    }
    
    /**
     * 判断对象不为空
     * 
     * @param value
     * @return
     */
    public static Boolean isNotNull(Object value)
    {
        if (value != null)
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 判断数组不为空
     * 
     * @param
     * @return
     */
    public static Boolean isNotEmptyArray(Object[] arr)
    {
        if (arr != null && arr.length > 0)
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 
     * Discription : isMapEmpty判断map是否为空
     * 
     * @return <b>true</b>表示为空 <b>false</b>表示不为空
     * @throws
     * @author : dison
     */
    public static boolean isEmpty(Map<?, ?> map)
    {
        return (null == map || map.isEmpty()) ? true : false;
    }
    
    /**
     * 
     * Discription : isMapNotEmpty判断map是否不为空
     * 
     * @return <b>true</b>表示不为空 <b>false</b>表示为空
     * @throws
     * @author : dison
     */
    public static boolean isNotEmpty(Map<?, ?> map)
    {
        return !isEmpty(map);
    }
    
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj)
    {
        if (obj.getClass().isArray() && Array.getLength(obj) == 0)
        {
            return true;
        }
        if (obj instanceof Collection && ((Collection)obj).isEmpty())
        {
            return true;
        }
        if (obj instanceof Map && ((Map)obj).isEmpty())
        {
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        
        if (obj.getClass().isArray() && Array.getLength(obj) > 0)
        {
            return true;
        }
        if (obj instanceof Collection && !((Collection)obj).isEmpty())
        {
            return true;
        }
        if (obj instanceof Map && !((Map)obj).isEmpty())
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 判断map是否包含key <一句话功能简述> <功能详细描述>
     * 
     * @param map
     * @param key
     * @return
     */
    public static boolean mapIsContainsKey(Map<?, ?> map, String key)
    {
        if (isEmpty(map))
        {
            return false;
        }
        return map.containsKey(key);
    }
    
    public static Long[] stringToLong(String stringArray[])
    {
        if (stringArray == null || stringArray.length < 1)
        {
            return null;
        }
        Long[] longArray = new Long[stringArray.length];
        for (int i = 0; i < longArray.length; i++)
        {
            try
            {
                longArray[i] = Long.valueOf(stringArray[i]);
            }
            catch (NumberFormatException e)
            {
                return null;
            }
        }
        return longArray;
    }
    
    /**
     * map转成String
     * 
     * @param map
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String transMapToString(Map map)
    {
        Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            entry = (Map.Entry)iterator.next();
            sb.append(entry.getKey().toString())
                .append("'")
                .append(null == entry.getValue() ? "" : entry.getValue().toString())
                .append(iterator.hasNext() ? "^" : "");
        }
        return sb.toString();
    }
    
    /**
     * 字符串转map
     * @param
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map transStringToMap(String mapString)
    {
        Map map = new HashMap();
        StringTokenizer items;
        for (StringTokenizer entrys = new StringTokenizer(mapString, "^"); entrys.hasMoreTokens(); map.put(items.nextToken(),
            items.hasMoreTokens() ? ((Object)(items.nextToken())) : null))
            items = new StringTokenizer(entrys.nextToken(), "'");
        
        return map;
    }
    
    public static<T> List<T> transListToBeanList(List<Map<Object,Object>> mapList , Class<T> classt)
    {
    	List<T> list = new ArrayList<T>();
    	for(Map<Object,Object> map : mapList){
    		list.add(transMapToDomain(map,classt));
    	}
        return list;
    }
    
    public static<T> Map<String, Object> transDomainToMap(T model)
    {
    	Map<String, Object> map = new HashMap<String, Object>();
        try {
        	Class thisClass = model.getClass();
            for (Field field:thisClass.getDeclaredFields()) { // 遍历所有属性
            	Object oValue = getFieldName(model, field);
            	if(null != oValue){
            		map.put(field.getName(), oValue);
            	}
            }
            
            if(model instanceof Object){
            	for (Field field:thisClass.getSuperclass().getDeclaredFields()) { // 遍历父类所有属性
                	Object oValue = getFieldName(model, field);
                	if(null != oValue){
                		map.put(field.getName(), oValue);
                	}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return map;
    }
    
    /**
     * 暂时只支持一层反射 20180517
     * 不是基础类型时返回null
     * @author yangsumeng
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    private static<T> Object getFieldName(T model, Field field) throws IllegalArgumentException, IllegalAccessException{
		
    	Object result = "";
    	
    	//是否是静态成员
    	boolean isStatic = Modifier.isStatic(field.getModifiers());
    	
    	if(!isStatic){
    		String type = field.getGenericType().toString(); // 获取属性的类型
    		field.setAccessible(true); //设置些属性是可以访问的  
    		Object value = field.get(model);//得到此属性的值     
    		
    		if(type.equals("class java.util.Date")){
    			result = null==value ? "" : DateUtils.convertDateToString((Date)value);
    		} else if(type.equals("class java.lang.Long")){
    			result = null==value ? "" : value;
    		}else if(type.equals("class java.lang.Integer")){
    			result = null==value ? "" : value;
    		} else if(type.equals("int")){
                result = null==value ? "" : value;
            } else if(type.equals("double")){
                result = null==value ? "" : value;
            } else if(type.equals("long")){
                result = null==value ? "" : value;
            } else if(type.equals("class java.lang.Double")){
                result = null==value ? "" : value;
            } else if (type.equals("class java.lang.String")) {
    			result = null==value ? "" : value;
    		} else {
    			result = null; //对象不展示
    		}
    	} else {
    		result = null; //对象不展示
    	}
		return result;
    }
    
    public static<T> T transMapToDomain(Map<Object, Object> map , Class<T> classt)
    {
    	T model = null;
        try {
        	model = (T)classt.newInstance();
        	Field[] fields = model.getClass().getDeclaredFields(); 
            for (Field field:fields) { // 遍历所有属性
            	doInvoke(map, model, field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return model;
    }

	private static <T> void doInvoke(Map<Object, Object> map, T model, Field field)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String domainFiledName = field.getName(); // 获取属性的名字
		String tempMethodName = domainFiledName.substring(0, 1).toUpperCase() + domainFiledName.substring(1); // 将属性的首字符大写，方便构造get，set方法
		String type = field.getGenericType().toString(); // 获取属性的类型
		String dbFiledName = convertToDbFieldName(domainFiledName);
		
		Method m = null;
		if (type.equals("class java.lang.String")) {
			m = model.getClass().getMethod("set" + tempMethodName, String.class);
			if (map.containsKey(dbFiledName)) {
				Object value = map.get(dbFiledName);
				if(null != value){
					m.invoke(model, map.get(dbFiledName).toString());
				}
			} else if (map.containsKey(domainFiledName)){
				Object value = map.get(domainFiledName);
				if(null != value){
					m.invoke(model, map.get(domainFiledName).toString());
				}
			}
		} else if(type.equals("class java.lang.Long")){
			m = model.getClass().getMethod("set" + tempMethodName, Long.class);
			if (map.containsKey(dbFiledName)) {
				Object value = map.get(dbFiledName);
				if(null != value){
					m.invoke(model, Long.valueOf(map.get(dbFiledName).toString()));
				}
			}else if (map.containsKey(domainFiledName)){
				Object value = map.get(domainFiledName);
				if(null != value){
					m.invoke(model, Long.valueOf(map.get(domainFiledName).toString()));
				}
			}
		} else if(type.equals("class java.lang.Integer")){
			m = model.getClass().getMethod("set" + tempMethodName, Integer.class);
			if (map.containsKey(dbFiledName)) {
				Object value = map.get(dbFiledName);
				if(null != value){
					m.invoke(model, Integer.valueOf(map.get(dbFiledName).toString()));
				}
			}else if (map.containsKey(domainFiledName)){
				Object value = map.get(domainFiledName);
				if(null != value){
					m.invoke(model, Integer.valueOf(map.get(domainFiledName).toString()));
				}
			}
		} 
		else if(type.equals("class java.util.Date")){//class java.util.Date
			m = model.getClass().getMethod("set" + tempMethodName, Date.class);
			if (map.containsKey(dbFiledName)) {
				Object value = map.get(dbFiledName);
				if(null != value){
					m.invoke(model, map.get(dbFiledName));
				}
			}else if (map.containsKey(domainFiledName)){
				Object value = map.get(domainFiledName);
				if(null != value){
					m.invoke(model, map.get(domainFiledName));
				}
			}
		} else {
			return;
		}
	}
	
	//将 userName 转换为 user_name
	private static String convertToDbFieldName(String domainFiledName){
		StringBuffer sb = new StringBuffer();
		if(null!= domainFiledName){
			char[] chars = domainFiledName.toCharArray();
			for(char c : chars){
				if(Character.isUpperCase(c)){ //如果是大写
					sb.append("_");
					sb.append(Character.toLowerCase(c));
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
    
}
