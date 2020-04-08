package com.demo.sapient.controller;

import com.demo.sapient.model.ReasonCode;
import com.demo.sapient.model.TransactionStatus;

import java.util.Optional;

public class Response<T> {

    private Optional<T> body;

    private boolean success;

    private TransactionStatus transactionStatus;

    private Optional<Error> error;
/*
    public Response() {
    }*/

    public Response(T body, boolean success, TransactionStatus transactionStatus , Optional<Error> error) {
        this.body = Optional.ofNullable(body);
        this.success = success;
        this.transactionStatus = transactionStatus;
        this.error = error;
    }


    public static <T> Response<T> success(T body) {
        return new Response<T>(body, true, TransactionStatus.COMPLETED,Optional.empty());
    }

    public static <T> Response<T> failure(Error error) {
        return new Response<>(null, false, TransactionStatus.FAILED,Optional.ofNullable(error));
    }


    public Optional<T> getBody() {
        return body;
    }

    public boolean isSuccess() {
        return success;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Optional<Error> getError() {
        return error;
    }

    public static class Error{

        private ReasonCode reasonCode;

        private String errorMessage;


        public Error(ReasonCode reasonCode, String errorMessage) {
            this.reasonCode = reasonCode;
            this.errorMessage = errorMessage;
        }

        public ReasonCode getReasonCode() {
            return reasonCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
