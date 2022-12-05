package apply_to_group_screens;

import apply_to_group_use_case.ApplyToGroupOutputBoundary;
import apply_to_group_use_case.ApplyToGroupResponseModel;

import javax.swing.*;
public class ApplyToGroupPresenter implements ApplyToGroupOutputBoundary {
    /**
     * Shows a message confirming the user successfully applied to group
     * @param userApplication a response model containing the user and group's information
     */
    @Override
    public void prepareSuccessView(ApplyToGroupResponseModel userApplication) {
        String user = userApplication.getUsername();
        String group = userApplication.getGroupName();
        JOptionPane.showMessageDialog(null, user + "applied to " + group + ".");
    }

    @Override
    public void prepareFailView(String error) {
        throw new ApplyToGroupFailed(error);
    }

}
