package interface_adapters.apply_to_group_adapters;

import view_and_data_access.screens.apply_to_group_screens.ApplyToGroupFailed;
import use_cases.apply_to_group_use_case.ApplyToGroupOutputBoundary;
import use_cases.apply_to_group_use_case.ApplyToGroupResponseModel;

import javax.swing.*;

/**
 * Presenter class for the Apply to Group Use Case.
 */
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

    /**
     * @param error error message containing the reason for use case failure
     */
    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }

}
