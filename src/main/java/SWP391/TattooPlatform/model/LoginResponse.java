package SWP391.TattooPlatform.model;

public class LoginResponse {
    private Object data;
    private String message;

    public LoginResponse(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}
