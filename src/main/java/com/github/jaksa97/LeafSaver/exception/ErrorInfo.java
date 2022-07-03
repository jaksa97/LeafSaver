package com.github.jaksa97.LeafSaver.exception;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorInfo {

    ErrorType errorType;
    ResourceType resourceType;
    String message;

    public enum ErrorType {
        BAD_REQUEST,
        NOT_FOUND,
        UNIQUE_VIOLATION,
        UNKNOWN,
    }

    public enum ResourceType {
        DRUG,
        DISEASE,
        PRODUCER,
        CURE,
    }
}
