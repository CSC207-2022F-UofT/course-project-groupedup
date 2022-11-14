import group_creation_screens.*;
import group_creation_use_case.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Group Creation Screen");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        GroupDSGateway group = new FileGroup();

        GroupRegisterPresenter presenter = new GroupRegisterResponseFormatter();
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(group, presenter, groupFactory);
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
