package com.oasis.onlinestore.contract;

import lombok.Data;

@Data
public class SimpleResponse {
    boolean success;
    String message;

    Object data;

    public SimpleResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public SimpleResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
