package UserRegistrationUsecase;

public class UserRegistrationOutputPackage {
    private final String username;

    public UserRegistrationOutputPackage(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
