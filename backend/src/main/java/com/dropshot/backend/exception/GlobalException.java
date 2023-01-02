package com.dropshot.backend.exception;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalException {
    @ExceptionHandler(DuplicateEmailException.class)
    public JSONObject duplicateEmailException(){
        return ErrorResponse.JsonErrorResponse(400, "중복된 이메일 입니다.");
    }

    @ExceptionHandler(DuplicateNicknameException.class)
    public JSONObject duplicateNicknameException(){
        return ErrorResponse.JsonErrorResponse(400, "중복된 닉네임 입니다.");
    }
}
