package pending_list_screens;

import edit_pending_list.EditPendingListResponseModel;
import edit_pending_list.EditPendingListOutputBoundary;

import javax.swing.*;

/**
 * The presenter for the edit pending list use case.
 */

public class EditPendingListPresenter implements EditPendingListOutputBoundary {

    @Override
    public void prepareAcceptedView(EditPendingListResponseModel success) {
        String user = success.getUsername();
        String group = success.getGroupName();
        JOptionPane.showMessageDialog(null, "Added " + user + " to " + group + ".");
    }

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
        throw new EditPendingListFailed(error);
    }
}
