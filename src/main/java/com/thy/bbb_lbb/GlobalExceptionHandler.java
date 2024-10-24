package com.thy.bbb_lbb;

import com.thy.bbb_lbb.result.GlobalException;
import com.thy.bbb_lbb.result.MultiGlobalException;
import com.thy.bbb_lbb.result.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ValidationException;
import java.util.Map;


@RestControllerAdvice
@Order(0)
public class GlobalExceptionHandler {
    private final Logger logger;

    GlobalExceptionHandler() {
        logger = LoggerFactory.getLogger(getClass());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultBody<GlobalException> defaultErrorHandler(Exception e) {
        ResultBody<GlobalException> resultBody;
        if (e instanceof ValidationException) {
            resultBody = ResultBody.err(e.getMessage());
        } else if (e instanceof HttpMessageConversionException) {
            resultBody = ResultBody.err(e.getMessage());
        } else {
            resultBody = ResultBody.err(e.getMessage());
            logger.error("uncached ex:", e);
        }
        return resultBody;
    }

    @ResponseBody
    @ExceptionHandler(MultiGlobalException.class)
    public ResultBody<Map<String, String>> errMapExceptionHandler(MultiGlobalException e) {
        return ResultBody.err(e.getErrorInfo(), e.getErrMap());
    }

    @ResponseBody
    @ExceptionHandler(GlobalException.class)
    public ResultBody<GlobalException> globalExceptionHandler(GlobalException e) {
        return ResultBody.err(e.getErrorInfo());
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public ResultBody<GlobalException> bindHandler(BindException e) {
        final var allErrors = e.getBindingResult().getAllErrors();
        StringBuilder sb = new StringBuilder("参数错误: ");
        for (ObjectError error : allErrors) {
            sb.append(error.getDefaultMessage()).append(";");
        }
        return ResultBody.err(sb.toString());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultBody<GlobalException> methodArgumentTypeMismatchHandler(MethodArgumentTypeMismatchException e) {
        return ResultBody.err("类型不匹配: " + e.getName());
    }
}
