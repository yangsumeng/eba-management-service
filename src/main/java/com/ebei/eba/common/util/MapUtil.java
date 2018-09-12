package com.ebei.eba.common.util;

import com.google.common.collect.Maps;
import org.apache.commons.beanutils.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description:
 * @Auther: yangsm
 * @Date: 2018/7/20 0020
 */
public class MapUtil {

    /**
     *
     *
     * Map转换层Bean，使用泛型免去了类型转换的麻烦。
     * @param <T>
     * @param map
     * @param class1
     * @return
     */
    public static <T> T map2Bean(Map<String, String> map, Class<T> class1) {
        T bean = null;
        try {
            bean = class1.newInstance();
            BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static <T> T getValue(Map<String, Object> map,String key ,T defaultValue ) {
        T r = defaultValue;
        if(null != map && null != map.get(key)){
            r = (T)map.get(key);
        }
        return r;
    }
    public static <T> T getValue(Map<String, Object> map,String key ) {
        T r = null;
        if(null != map && null != map.get(key)){
            r = (T)map.get(key);
        }
        return r;
    }

    public static String getStringValue(Map map,Object key,String defaultValue)
    {
        if(!map.containsKey(key)){
            return defaultValue;
        }
        return org.apache.commons.collections.MapUtils.getString(map, key, defaultValue);
    }

    public static int getIntValue(Map map,Object key,Integer defaultValue)
    {
        return org.apache.commons.collections.MapUtils.getInteger(map, key, defaultValue);
    }

    public static Double getDoubleValue(Map map,Object key,Double defaultValue)
    {
        return org.apache.commons.collections.MapUtils.getDoubleValue(map, key, defaultValue);
    }

    public static Long getLongValue(Map map,Object key,Long defaultValue)
    {
        if(!map.containsKey(key)){
            return defaultValue;
        }
        return org.apache.commons.collections.MapUtils.getLongValue(map, key, defaultValue);
    }

    public static Boolean getBooleanValue(Map map,Object key,Boolean defaultValue)
    {
        return org.apache.commons.collections.MapUtils.getBooleanValue(map, key, defaultValue);
    }

    public static Map<String,Object> bean2Map(Object bean){
        Map<String, Object> map = Maps.newConcurrentMap();
        try {
//            ConvertUtilsBean convertUtils = BeanUtilsBean.getInstance().getConvertUtils();
//            DateConverter dateConverter = new DateConverter();
//            dateConverter.setPattern("yyyy-MM-dd HH:mm:ss");
//            ConvertUtils.register(dateConverter, String.class);
//            convertUtils.register(new ConverterFacade(dateConverter), java.util.Date.class);
//            map = BeanUtils.describe(bean);
             map = PropertyUtils.describe(bean);
             map.remove("class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch(NoSuchMethodException e){
            e.printStackTrace();
        }
        return map;
    }
}
