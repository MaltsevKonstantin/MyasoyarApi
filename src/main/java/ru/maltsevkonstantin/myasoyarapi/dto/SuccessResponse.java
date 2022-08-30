package ru.maltsevkonstantin.myasoyarapi.dto;

public class SuccessResponse {

    public SuccessResponse() {
    }
    public SuccessResponse(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    private String message;
    private long timestamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
