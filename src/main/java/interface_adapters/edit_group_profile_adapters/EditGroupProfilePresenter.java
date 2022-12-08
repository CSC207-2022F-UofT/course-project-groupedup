package interface_adapters.edit_group_profile_adapters;

import use_cases.edit_group_profile_use_case.EditGroupProfileOutputBoundary;
import use_cases.edit_group_profile_use_case.EditGroupProfileResponseModel;

import javax.swing.*;

public class EditGroupProfilePresenter implements EditGroupProfileOutputBoundary {
    EditGroupProfileScreenBoundary editGroupProfileScreenBoundary;

    public EditGroupProfilePresenter(EditGroupProfileScreenBoundary editGroupProfileScreenBoundary) {
        this.editGroupProfileScreenBoundary = editGroupProfileScreenBoundary;
    }

    /**
     *
     * Shows a message confirming that the group profile was successfully edited.
     * @param editedChanges an edit group profile response model
     */
    @Override
    public void prepareSuccessView(EditGroupProfileResponseModel editedChanges) {
        JOptionPane.showMessageDialog(null, "Successfully Edited Group Profile!");
    }

    /**
     * @param error the error message explaining why the error occurred
     */
    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);}
}