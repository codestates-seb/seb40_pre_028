package com.seb40.server.Quesiton.Exception;

import lombok.Getter;

public enum ExceptionCode {
    Question_NOT_FOUND(404, "Question not found"),
    Question_EXISTS(409, "Question exists"),
    NOT_IMPLEMENTATION(501, "Not Implementation");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}