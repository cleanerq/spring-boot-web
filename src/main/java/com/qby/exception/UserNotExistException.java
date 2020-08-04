package com.qby.exception;

/**
 * @author qby
 * @date 2020/6/6 16:40
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在！");
    }
}
