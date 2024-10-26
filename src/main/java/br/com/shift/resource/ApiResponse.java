package br.com.shift.resource;

public class ApiResponse {

    public String code;
    public String type;
    public String message;

    public ApiResponse(String code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

}
