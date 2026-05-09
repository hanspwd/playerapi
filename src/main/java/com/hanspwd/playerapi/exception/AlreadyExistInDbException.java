package com.hanspwd.playerapi.exception;

public class AlreadyExistInDbException extends RuntimeException{

    public AlreadyExistInDbException(String message) {
        super(message);
    }
    
}
