package userloginusecase;

/**
 * Input data package for the user login use case.
 */
public class LoginInputPackage {
    private final String username;
    private final String password;

    public LoginInputPackage(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
