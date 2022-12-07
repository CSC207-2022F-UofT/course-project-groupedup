package use_cases.user_registration_use_case;

/**
 * Input data package for the user registration use case.
 * Collection of data acquired from user input and used for registration.
 */

public class UserRegistrationInputPackage {
    private final String name;
    private final String username;
    private final String password;
    private final String repeatPassword;
    private final String email;

    public UserRegistrationInputPackage(String name, String username,
                                        String password, String repeatPassword, String email){
        this.name = name;
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }
}
