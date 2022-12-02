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


        SerializeDataAccess dataAccess = new SerializeDataAccess();
        UserRegistrationOutputBoundary userRegistrationPresenter = new UserRegistrationPresenter();
        UserFactory normalUserFactory = new NormalUserFactory();
        UserRegistrationInputBoundary userRegistrationInteractor = new UserRegistrationInteractor(
                normalUserFactory, dataAccess, userRegistrationPresenter);
        UserRegistrationController userRegistrationController = new UserRegistrationController(
                userRegistrationInteractor
        );
        LoginOutputBoundary loginPresenter = new LoginPresenter();
        LoginInputBoundary loginInteractor = new LoginInteractor(dataAccess, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);

        AllControllers allControllers = AllControllers.getInstance();
        allControllers.setLoginController(loginController);
        allControllers.setUserRegistrationController(userRegistrationController);
        new LoginScreen();



//        JFrame application = new JFrame("Group Creation Screen");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//
//        SerializeDataAccess dataAccess = new SerializeDataAccess();
//        NewGroupDSGateway newGroup = dataAccess;
//
//        GroupRegisterPresenter presenter = new GroupRegisterResponseFormatter();
//        GroupFactory groupFactory = new GroupFactory();
//        GroupRegisterInputBoundary userRegistrationInteracter = new GroupRegisterInteractor(newGroup, presenter, groupFactory);
//        GroupRegisterController userRegisterController = new GroupRegisterController(
//                userRegistrationInteracter
//        );
//
//        // Build the GUI, plugging in the parts
//        GroupRegisterScreen registerScreen = new GroupRegisterScreen(userRegisterController);
//        screens.add(registerScreen, "welcome");
//        cardLayout.show(screens, "register");
//        application.pack();
//        application.setVisible(true);
//
//        NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen();
//        screens.add(newGroupPageScreen, "register");
    }
}
