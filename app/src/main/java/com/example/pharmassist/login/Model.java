package com.example.pharmassist.login;

public class Model {
    private String success;
    private String message;

    // Constructor
    public Model(String success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters
    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    // Setters
    public void setSuccess(String success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
