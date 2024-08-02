package com.baimiaomiao.springcloud.entities;

import lombok.Data;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className CommonResult
 * @since 1.0
 */

@Data
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
