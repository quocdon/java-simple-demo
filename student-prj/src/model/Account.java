package model;

public class Account {
    private int code;
    private String username;
    private String password;

    public Account() {
    }

    public Account(int code, String username, String password) {
        this.code = code;
        this.username = username;
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
