
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import MultiUsecaseUtil.SerializeDataAccess;
import UserSignupLoginScreens.*;
import UserRegistrationUsecase.*;
import group_creation_screens.*;
import matching_algorithm_use_case.MatchingAlgorithmResponseModel;
import matching_algorithm_screens.HomeMatchesBoundary;
import matching_algorithm_screens.MatchingAlgorithmView;
import userloginusecase.LoginInputBoundary;
import userloginusecase.LoginInteractor;
import userloginusecase.LoginOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        HomeMatchesBoundary homepageTest = new HomePage(cardLayout, screens);

        List<String> groups = new ArrayList<>();
        groups.add("CSC207: Group 1");
        groups.add("CSC236: Group 2");
        groups.add("CSC258: Group 3");
        groups.add("CSC207: Group 4");
        groups.add("CSC236: Group 5");
        groups.add("CSC258: Group 6");
        MatchingAlgorithmResponseModel responseModel = new MatchingAlgorithmResponseModel(
                groups);


        MatchingAlgorithmView matchingAlgorithmView = new MatchingAlgorithmView(homepageTest);
        matchingAlgorithmView.displaySuccess(responseModel);

        screens.add((JPanel) homepageTest, "homepage");

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
//        GroupRegisterViewModel groupRegisterView = new GroupRegisterView(cardLayout, screens);
//        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterView);
//        GroupFactory groupFactory = new GroupFactory();
//        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(dataAccess, presenter, groupFactory);
//        GroupRegisterController groupRegisterController = new GroupRegisterController(
//                interactor);

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
//        GroupRegisterScreen groupRegisterScreen = new GroupRegisterScreen(groupRegisterController);
//        screens.add(homepageTest, "homepageScreen");
//        screens.add(groupRegisterScreen, "groupRegisterScreen");
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
