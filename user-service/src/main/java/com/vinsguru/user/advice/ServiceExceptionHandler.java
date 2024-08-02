package com.vinsguru.user.advice;

import com.vinsguru.user.exceptions.InsufficientBalanceException;
import com.vinsguru.user.exceptions.InsufficientSharesException;
import com.vinsguru.user.exceptions.UnknownTickerException;
import com.vinsguru.user.exceptions.UnknownUserException;
import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ServiceExceptionHandler {

    @GrpcExceptionHandler(UnknownUserException.class)
    public Status handleException(UnknownUserException e){
        return Status.NOT_FOUND.withDescription(e.getMessage());
    }

    @GrpcExceptionHandler(UnknownTickerException.class)
    public Status handleException(UnknownTickerException e){
        return Status.INVALID_ARGUMENT.withDescription(e.getMessage());
    }

    @GrpcExceptionHandler({
            InsufficientBalanceException.class,
            InsufficientSharesException.class})
    public Status handleException(Exception e){
        return Status.FAILED_PRECONDITION.withDescription(e.getMessage());
    }
}
