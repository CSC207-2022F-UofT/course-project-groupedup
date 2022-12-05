package pending_list_screens;

import edit_pending_list.EditPendingListResponseModel;
import edit_pending_list.EditPendingListOutputBoundary;

import javax.swing.*;

/**
 * The presenter for the edit pending list use case.
 */

public class EditPendingListPresenter implements EditPendingListOutputBoundary {

    /**
     * Shows a message confirming that the user was successfully accepted
     * @param success a response model containing the group's and accepted user's information
     */
    @Override
    public void prepareAcceptedView(EditPendingListResponseModel success) {
        String user = success.getUsername();
        String group = success.getGroupName();
        JOptionPane.showMessageDialog(null, "Added " + user + " to " + group + ".");
    }

    /**
     * Shows a message confirming that the user was successfully rejected
     * @param success a response model containing the group's and rejected user's information
     */
    @Override
    public void prepareRejectedView(EditPendingListResponseModel success) {
        String user = success.getUsername();
        JOptionPane.showMessageDialog(null, "Removed " + user + ".");
    }

    /**
     * @param error the error message explaining why the error occurred
     */
    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
