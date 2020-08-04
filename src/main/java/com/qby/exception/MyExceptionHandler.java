package com.qby.exception;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qby
 * @date 2020/6/6 16:58
 */
@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> map = new HashMap();
//        map.put("code", "user.notexists");
//        map.put("message", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap();
        map.put("code", "user.notexists");
        map.put("message", "出错误啦！");
        // String ERROR_STATUS_CODE = "javax.servlet.error.status_code";
        request.setAttribute("javax.servlet.error.status_code", 400);

        request.setAttribute("ext", map);
        // 转发 /error
        return "forward:/error";
    }
}
