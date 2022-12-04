import Entities.AllControllers;
import MultiUsecaseUtil.SerializeDataAccess;
import UserSignupLoginScreens.*;
import UserRegistrationUsecase.*;
import UserSignupLoginScreens.UserRegistrationController;
import UserSignupLoginScreens.UserRegistrationPresenter;
import edit_group_profile_screens.EditGroupProfileController;
import edit_group_profile_screens.EditGroupProfileScreen;
import edit_group_profile_use_case.EditGroupProfileInputBoundary;
import edit_group_profile_use_case.EditGroupProfileRequestModel;
import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;
import view_group_profile_screens.ViewGroupProfileScreen;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


       /* SerializeDataAccess dataAccess = new SerializeDataAccess();
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

*/

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
        HashMap <String, String> c = new HashMap<>();
        c.put("Location", "Online");
        c.put("Meeting Time", "Monday");
        c.put("Time Commitment", "0-2 hours");
        ViewGroupProfileScreen n = new ViewGroupProfileScreen("efwrg", c, "wqfeqf", "CSC258");
    }
}
