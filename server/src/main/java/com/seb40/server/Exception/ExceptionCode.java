package com.seb40.server.Exception;

import lombok.Getter;

public enum ExceptionCode {
    USER_NOT_FOUND(404, "User not found"),
    USER_EXISTS(409, "User exists"),
    Question_NOT_FOUND(404, "Question not found"),
    Question_EXISTS(409, "Question exists"),
    NOT_IMPLEMENTATION(501, "Not Implementation"),
    ANSWER_NOT_FOUND(404, "Answer not found"),
    TAG_NOT_FOUND(404, "Tag not found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
