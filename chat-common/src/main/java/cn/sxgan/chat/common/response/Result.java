package cn.sxgan.chat.common.response;

import cn.sxgan.chat.common.enums.ResStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description: 响应结果封装
 * @Author: sxgan
 * @Date: 24/8/1 15:13
 * @Version: 1.0
 **/
@Data
@Builder
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * response timestamp.
     */
    private long timestamp;
    
    /**
     * response code, 200 -> OK.
     */
    private Integer status;
    
    /**
     * response message.
     */
    private String message;
    
    /**
     * response data size.
     */
    private Integer total;
    
    /**
     * response data.
     */
    private T data;
    
    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> Result<T> success() {
        return success(null, 0);
    }
    
    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> Result<T> success(String message) {
        return Result.<T>builder().data(null)
                .message(message)
                .total(0)
                .status(ResStatusEnum.SUCCESS.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }
    
    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> Result<T> success(T data) {
        return Result.<T>builder().data(data)
                .message(ResStatusEnum.SUCCESS.getMsg())
                .total(1)
                .status(ResStatusEnum.SUCCESS.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }
    
    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> Result<T> success(T data, int total) {
        return Result.<T>builder().data(data)
                .message(ResStatusEnum.SUCCESS.getMsg())
                .total(total)
                .status(ResStatusEnum.SUCCESS.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }
    
    
    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> Result<T> fail(String message) {
        return fail(null, message);
    }
    
    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> Result<T> fail(T data, String message) {
        return Result.<T>builder().data(data)
                .message(message)
                .total(0)
                .status(ResStatusEnum.FAIL.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }
    
    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> Result<T> fail(T data, Integer status, String message) {
        return Result.<T>builder().data(data)
                .message(message)
                .status(status)
                .total(0)
                .timestamp(System.currentTimeMillis())
                .build();
    }
    
    
}
