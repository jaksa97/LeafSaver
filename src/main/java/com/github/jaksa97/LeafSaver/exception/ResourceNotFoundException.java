package com.github.jaksa97.LeafSaver.exception;

public class ResourceNotFoundException extends ResourceException{

    public ResourceNotFoundException(ErrorInfo.ResourceType resourceType) {
        super(resourceType, "Resource '" + resourceType + "' not found");
    }

    public ResourceNotFoundException(ErrorInfo.ResourceType resourceType, String message) {
        super(resourceType, message);
    }
}
