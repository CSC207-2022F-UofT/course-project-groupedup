package group_creation_screens;

import group_creation_use_case.GroupRegisterResponseModel;

import javax.swing.*;
import java.awt.*;

/**
 * This class implements the GroupRegisterViewModel interface and is called
 * by the presenter to modify the UI depending on a group being successfully
 * or unsuccessfully made.
 */
public class GroupRegisterView implements GroupRegisterViewModel{
    CardLayout cardLayout;
    JPanel screens;
    public GroupRegisterView(CardLayout cardLayout, JPanel screens){
        this.cardLayout = cardLayout;
        this.screens = screens;


    }

    /**
     * After a group is successfully made, the UI will create a new instance of the next screen
     * which will display the group's information and then switch to that new screen.
     * @param groupResponseModel
     */
    @Override
    public void displaySuccess(GroupRegisterResponseModel groupResponseModel) {

        NewGroupPageScreen newGroupPageScreen = new NewGroupPageScreen(groupResponseModel.getGroupName(), cardLayout, screens);
        screens.add(newGroupPageScreen, "newGroupPageScreen");
        cardLayout.show(screens, "newGroupPageScreen");

    }

    /**
     * If the group was unsuccessfully made, a group creation failed error
     * will be displayed.
     * @param error
     */
    @Override
    public void displayFailure(String error) {
        throw new GroupCreationFailed(error);

    }
}
