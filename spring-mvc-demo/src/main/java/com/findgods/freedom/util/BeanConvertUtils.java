package com.findgods.freedom.util;


import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.*;


/**
 * Created by huangxx on 2017/5/15.
 */
@Log4j2
public class BeanConvertUtils {

    /**
     * @param object
     * @param beanClass
     * @return
     * @see org.apache.commons.beanutils.BeanUtils#copyProperties(Object, Object)
     */
    public static Object beanReflectConvert(Object object, Class<?> beanClass) {
        Object obj = null;
        try {
            obj = beanClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                String name = field.getName();
                Object value = field.get(object);
                if (null == value) {
                    continue;
                }
                Field objField = obj.getClass().getDeclaredField(name);
                if (null == objField || Modifier.isStatic(objField.getModifiers()) || Modifier.isFinal(objField.getModifiers())) {
                    continue;
                }
                objField.setAccessible(true);
                try {
                    objField.set(obj, value);
                } catch (IllegalArgumentException e) {
                    log.error("beanReflectConvert error", e);
                }
            }
        } catch (Exception e) {
            log.error("beanReflectConvert error", e);
        }
        return obj;
    }


    /**
     * Map to Java Object
     *
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null || map.size() <= 0)
            return null;

        Object obj = beanClass.newInstance();
        //获取关联的所有类，本类以及所有父类
        boolean ret = true;
        Class oo = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();
        while (ret) {
            clazzs.add(oo);
            oo = oo.getSuperclass();
            if (oo == null || oo == Object.class) break;
        }

        for (int i = 0; i < clazzs.size(); i++) {
            Field[] fields = clazzs.get(i).getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod) || null == map.get(field.getName())) {
                    continue;
                }
                //由字符串转换回对象对应的类型
                if (field != null) {
                    field.setAccessible(true);
                    if (field.getType() == Date.class && map.get(field.getName()).getClass() == Long.class) {
                        // Long -> Date
                        field.set(obj, new Date((Long) map.get(field.getName())));
                    } else if ((field.getType() == BigDecimal.class && map.get(field.getName()).getClass() == String.class)) {
                        // String -> BigDecimal
                        field.set(obj, new BigDecimal(map.get(field.getName()).toString()));
                    } else {
                        field.set(obj, map.get(field.getName()));
                    }
                }
            }
        }
        return obj;
    }

    /**
     * Java Object to Map
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        //获取关联的所有类，本类以及所有父类
        boolean ret = true;
        Class oo = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();
        while (ret) {
            clazzs.add(oo);
            oo = oo.getSuperclass();
            if (oo == null || oo == Object.class) break;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        for (int i = 0; i < clazzs.size(); i++) {
            Field[] declaredFields = clazzs.get(i).getDeclaredFields();
            for (Field field : declaredFields) {
                int mod = field.getModifiers();
                //过滤 static 和 final 类型
                field.setAccessible(true);
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod) || null == field.get(obj)) {
                    continue;
                }
                map.put(field.getName(), field.get(obj));
            }
        }
        return map;
    }

}
