package use_cases.user_registration_use_case;

import entities.InteractorMessages;
import entities.User;
import entities.UserPublicProfile;

/**
 * use case interactor for creating new user
 */

public class UserRegistrationInteractor implements UserRegistrationInputBoundary{
    final UserFactory userFactory;
    final NewUserDSGateway newUserDSGateway;
    final UserRegistrationOutputBoundary userRegistrationOutputBoundary;

    public UserRegistrationInteractor(
            UserFactory userFactory, NewUserDSGateway newUserDSGateway,
            UserRegistrationOutputBoundary userRegistrationOutputBoundary){
        this.userFactory = userFactory;
        this.newUserDSGateway = newUserDSGateway;
        this.userRegistrationOutputBoundary = userRegistrationOutputBoundary;
    }
    @Override
    public void create(UserRegistrationInputPackage userInput) {
        if (newUserDSGateway.userIdentifierExists(userInput.getUsername())){
            userRegistrationOutputBoundary.prepareFailView(InteractorMessages.USER_EXISTS);
        } else if (!userInput.getPassword().equals(userInput.getRepeatPassword())){
            userRegistrationOutputBoundary.prepareFailView(InteractorMessages.PASSWORDS_DONT_MATCH);
        } else if (!userFactory.checkValidPassword(userInput.getPassword())){
            userRegistrationOutputBoundary.prepareFailView(InteractorMessages.PASSWORD_TOO_SHORT);
        } else {
            UserPublicProfile publicProfile = new UserPublicProfile();
            User newUser = userFactory.create(userInput.getUsername(), userInput.getPassword(),
                    userInput.getName(), userInput.getEmail(), publicProfile);
            newUserDSGateway.saveNewUser(new UserRegistrationDSRequestPackage(newUser, newUser.getUsername()));
            userRegistrationOutputBoundary.prepareSuccessView(new UserRegistrationOutputPackage(newUser.getUsername()));
        }
    }
}
