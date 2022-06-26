package com.github.jaksa97.LeafSaver.exception;

public class UniqueViolationException extends ResourceException{

    public UniqueViolationException(ErrorInfo.ResourceType resourceType, String message) {
        super(resourceType, message);
    }
}
