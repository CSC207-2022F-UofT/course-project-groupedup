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

        GroupRegisterOutputBoundary presenter = new GroupRegisterPresenter();
        GroupFactory groupFactory = new GroupFactory();
        GroupRegisterInputBoundary interactor = new GroupRegisterInteractor(newGroup, presenter, groupFactory);
        GroupRegisterController groupRegisterController = new GroupRegisterController(
                interactor
        );

         HomePage test = new HomePage(groupRegisterController);



//        registerScreen.pack();
//        registerScreen.setVisible(true);
//        JFrame application = new JFrame("GroupedUp");
//        application.pack();
//        application.setVisible(true);


        // Build the GUI, plugging in the parts
//        GroupRegisterScreen registerScreen = new GroupRegisterScreen(userRegisterController);
//        screens.add(registerScreen, "Register Group");
//        cardLayout.show(screens, "Register Group");
//        application.pack();
//        application.setVisible(true);
//
//        NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen();
//        screens.add(newGroupPageScreen, "New Group Page");
    }
}
