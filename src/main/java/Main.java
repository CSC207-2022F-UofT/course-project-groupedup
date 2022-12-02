import Entities.CurrentUser;
import Entities.NormalUser;
import Entities.User;
import Entities.UserPublicProfile;
import MultiUsecaseUtil.SerializeDataAccess;
import UserRegistrationUsecase.NewUserDSGateway;
import group_creation_use_case.NewGroupDSGateway;
import group_creation_screens.*;
import group_creation_use_case.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Grouped Up");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // SerializeDataAccess doesn't seem to be working right now
        // so im using InMemoryFileGroup right now temporarily

//
//        SerializeDataAccess dataAccess = null;
//        try {
//            dataAccess = new SerializeDataAccess();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        NewGroupDSGateway newGroup = new InMemoryFileGroup();

        GroupRegisterViewModel groupRegisterView = new GroupRegisterView(cardLayout, screens);
        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter(groupRegisterView);
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(newGroup, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor
        );

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


    }
}
