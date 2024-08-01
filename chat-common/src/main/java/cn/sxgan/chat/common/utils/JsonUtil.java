package cn.sxgan.chat.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: Json工具类
 * @Author: sxgan
 * @Date: 24/8/1 16:17
 * @Version: 1.0
 **/
@Slf4j
public class JsonUtil {
    
    /**
     * 将对象转换为json字符串
     *
     * @param object 实体对象
     * @return json字符串
     */
    public static String toJsonString(Object object) {
        ObjectMapper om = new ObjectMapper();
        String result = "";
        try {
            result = om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Json convert error", e);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 将json字符串转换为对象
     *
     * @param json  json
     * @param clazz 对象类型
     * @param <T>   转换类型声明
     * @return 对象
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        ObjectMapper om = new ObjectMapper();
        T result = null;
        try {
            result = om.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    
}