package UserRegistrationUsecase;

/**
 * Input data package for the user registration use case.
 * Collection of data acquired from user input and used for registration.
 */

public class UserRegistrationInputPackage {
    private String name;
    private String username;
    private String password;
    private String repeatPassword;
    private String email;

    public UserRegistrationInputPackage(String name, String username,
                                        String password, String repeatPassword, String email){
        this.name = name;
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }
}
