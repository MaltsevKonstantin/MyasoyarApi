package ru.maltsevkonstantin.myasoyarapi.dto;

public class ErrorResponse {
    private String message;
    private long timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

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
