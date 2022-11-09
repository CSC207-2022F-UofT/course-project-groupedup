import Entities.Group;
import group_creation_screens.*;
import group_creation_use_case.GroupFactory;
import group_creation_use_case.GroupRegisterInputBoundary;
import group_creation_use_case.GroupRegisterInteractor;
import group_creation_use_case.GroupRegisterPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window
        JFrame application = new JFrame("Group Creation Screen");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        GroupChecker groupChecker = new GroupChecker();
        GroupSaver groupSaver = new GroupSaver();

        GroupRegisterPresenter presenter = new GroupRegisterResponseFormatter();
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(
                groupChecker, groupSaver, presenter, groupFactory);
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
