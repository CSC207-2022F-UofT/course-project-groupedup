
import Entities.CurrentUser;
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import Entities.AllControllers;
import MultiUsecaseUtil.SerializeDataAccess;
import Screens.*;
import UserSignupLoginScreens.*;
import UserRegistrationUsecase.*;
import UserSignupLoginScreens.UserRegistrationController;
import UserSignupLoginScreens.UserRegistrationPresenter;
import group_creation_screens.*;
import group_creation_use_case.*;
import userloginusecase.LoginDSGateway;
import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;
import Edit_Group_Profile_Screens.EditGroupProfileScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("Grouped Up");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);


//            SerializeDataAccess dataAccess = new SerializeDataAccess();
//            UserRegistrationOutputBoundary userRegistrationPresenter = new UserRegistrationPresenter();
//            UserFactory normalUserFactory = new NormalUserFactory();
//            UserRegistrationInputBoundary userRegistrationInteractor = new UserRegistrationInteractor(
//                    normalUserFactory, dataAccess, userRegistrationPresenter);
//            UserRegistrationController userRegistrationController = new UserRegistrationController(
//                    userRegistrationInteractor);
        NewGroupDSGateway dataAccess = new InMemoryFileGroup();

        GroupRegisterViewModel groupRegisterView = new GroupRegisterView(cardLayout, screens);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterView);
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(dataAccess, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor);

//
//
//        LoginOutputBoundary loginPresenter = new LoginPresenter();
//        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
//        LoginController loginController = new LoginController(loginInteractor);

        // this part is just to activate the group creation use case, can remove later
        // setting up a fake 'logged in' user
        CurrentUser currentUser1 = CurrentUser.getInstance();
        UserPublicProfile testProfile = new UserPublicProfile();
        User testUser = new NormalUser("testUser", "testUser", "testUser", "testUser",
                testProfile);
        currentUser1.setUser(testUser);

        HomePage homepageTest = new HomePage(cardLayout, screens);

        GroupRegisterScreen groupRegisterScreen = new GroupRegisterScreen(groupRegisterController);
        screens.add(homepageTest, "homepageScreen");
        screens.add(groupRegisterScreen, "groupRegisterScreen");
        cardLayout.show(screens, "hompageScreen");
        application.pack();
        application.setVisible(true);



//        AllControllers allControllers = AllControllers.getInstance();
//        allControllers.setLoginController(loginController);
//        allControllers.setUserRegistrationController(userRegistrationController);
        // just commented out Leo's login screen because it hasn't been connected to homepage yet
        //new LoginScreen();


    }
}
