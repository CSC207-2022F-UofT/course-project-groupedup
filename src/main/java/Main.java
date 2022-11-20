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
        JFrame application = new JFrame("Group Creation Screen");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        SerializeDataAccess dataAccess = null;
        try {
            dataAccess = new SerializeDataAccess();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        NewGroupDSGateway newGroup = dataAccess;

        GroupRegisterPresenter presenter = new GroupRegisterResponseFormatter();
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(newGroup, presenter, groupFactory);
        GroupRegisterController userRegisterController = new GroupRegisterController(
                interactor
        );

        // Build the GUI, plugging in the parts
        GroupRegisterScreen registerScreen = new GroupRegisterScreen(userRegisterController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);

        NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen();
        screens.add(newGroupPageScreen, "register");
    }
}
