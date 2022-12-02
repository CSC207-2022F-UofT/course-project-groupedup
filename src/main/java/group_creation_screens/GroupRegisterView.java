package group_creation_screens;

import group_creation_use_case.GroupRegisterResponseModel;

import javax.swing.*;
import java.awt.*;

public class GroupRegisterView implements GroupRegisterViewModel{
    CardLayout cardLayout;
    JPanel screens;
    public GroupRegisterView(CardLayout cardLayout, JPanel screens){
        this.cardLayout = cardLayout;
        this.screens = screens;

    }
    @Override
    public void displaySuccess(GroupRegisterResponseModel groupResponseModel) {
        NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen(groupResponseModel.getGroupName());
        screens.add(newGroupPageScreen, "newGroupPageScreen");
        cardLayout.show(screens, "newGroupPageScreen");

    }

    @Override
    public void displayFailure(String error) {
        throw new GroupCreationFailed(error);

    }
}
