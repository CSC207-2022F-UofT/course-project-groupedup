
import Entities.CurrentUser;
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import MultiUsecaseUtil.SerializeDataAccess;
import UserSignupLoginScreens.*;
import UserRegistrationUsecase.*;
import edit_group_profile_screens.EditGroupProfileController;
import edit_group_profile_screens.EditGroupProfilePresenter;
import edit_group_profile_screens.EditGroupProfileScreen;
import edit_group_profile_screens.EditGroupProfileScreenBoundary;
import edit_group_profile_use_case.EditGroupProfileInputBoundary;
import edit_group_profile_use_case.EditGroupProfileInteractor;
import edit_group_profile_use_case.EditGroupProfileOutputBoundary;
import group_creation_screens.*;
import group_creation_use_case.GroupFactory;
import group_creation_use_case.GroupRegisterInputBoundary;
import group_creation_use_case.GroupRegisterInteractor;
import group_creation_use_case.GroupRegisterOutputBoundary;
import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("Grouped Up");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);

        SerializeDataAccess dataAccess = new SerializeDataAccess();
        User user1 = new NormalUser("test", "test", "test", "test", new UserPublicProfile());
        dataAccess.saveNewUser(new UserRegistrationDSRequestPackage(user1, user1.getUsername()));
        HomePage homepageTest = new HomePage(cardLayout, screens);
        screens.add(homepageTest, "homepage");

        LoginScreenInterface loginScreen = new LoginScreen(screens, cardLayout);
        LoginOutputBoundary loginPresenter = new LoginPresenter(loginScreen);
        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);
        loginScreen.setView(loginController);
        cardLayout.show(screens, "login page");

        UserRegistrationScreenInterface registrationScreen = new UserRegistrationScreen(screens, cardLayout);
        UserRegistrationOutputBoundary registrationPresenter = new UserRegistrationPresenter(registrationScreen);
        UserFactory normalUserFactory = new NormalUserFactory();
        UserRegistrationInteractor registrationInteractor =
                new UserRegistrationInteractor(normalUserFactory, dataAccess, registrationPresenter);
        UserRegistrationController registrationController = new UserRegistrationController(registrationInteractor);
        registrationScreen.setView(registrationController);

        GroupFactory groupFactory = new GroupFactory();


        EditGroupProfileScreenBoundary editGroupScreen = new EditGroupProfileScreen(cardLayout, screens);
        EditGroupProfileOutputBoundary presenter2 = new EditGroupProfilePresenter(editGroupScreen);
        EditGroupProfileInputBoundary interactor2 = new EditGroupProfileInteractor(dataAccess, presenter2);
        EditGroupProfileController editGroupController = new EditGroupProfileController(interactor2);
        editGroupScreen.setView(editGroupController);
        screens.add((Component) editGroupScreen, "editGroupScreen");


        NewGroupScreenBoundary newGroupPageScreen = new NewGroupPageScreen(editGroupScreen, cardLayout, screens);

        GroupCreationScreenBoundary groupRegisterScreen = new GroupRegisterScreen(newGroupPageScreen, cardLayout, screens);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterScreen);
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(dataAccess, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor);
        groupRegisterScreen.setView(groupRegisterController);


        newGroupPageScreen.setView(groupRegisterController);



        //cardLayout.show(screens, "editGroupProfile");


        application.pack();
        application.setVisible(true);



//            SerializeDataAccess dataAccess = new SerializeDataAccess();
//            UserRegistrationOutputBoundary userRegistrationPresenter = new UserRegistrationPresenter();
//            UserFactory normalUserFactory = new NormalUserFactory();
//            UserRegistrationInputBoundary userRegistrationInteractor = new UserRegistrationInteractor(
//                    normalUserFactory, dataAccess, userRegistrationPresenter);
//            UserRegistrationController userRegistrationController = new UserRegistrationController(
//                    userRegistrationInteractor);
//        NewGroupDSGateway dataAccess = new InMemoryFileGroup();
//


//
//
//        LoginOutputBoundary loginPresenter = new LoginPresenter();
//        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
//        LoginController loginController = new LoginController(loginInteractor);

        // this part is just to activate the group creation use case, can remove later
        // setting up a fake 'logged in' user
//        CurrentUser currentUser1 = CurrentUser.getInstance();
//        UserPublicProfile testProfile = new UserPublicProfile();
//        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
//                testProfile);
//        currentUser1.setUser(testUser);
//
//        HomePage homepageTest = new HomePage(cardLayout, screens);
//

//        cardLayout.show(screens, "hompageScreen");
//        application.pack();
//        application.setVisible(true);



//        AllControllers allControllers = AllControllers.getInstance();
//        allControllers.setLoginController(loginController);
//        allControllers.setUserRegistrationController(userRegistrationController);
        // just commented out Leo's login screen because it hasn't been connected to homepage yet
        //new LoginScreen();


    }

}
