package leave_group_screens;

import leave_group_use_case.LeaveGroupOutputBoundary;
import leave_group_use_case.LeaveGroupResponseModel;

import javax.swing.*;
import java.awt.*;

/**
 * The presenter class for leave group use case.
 */

public class LeaveGroupPresenter implements LeaveGroupOutputBoundary {
    JPanel screens;
    CardLayout cardLayout;

    public LeaveGroupPresenter(CardLayout cardLayout, JPanel screens) {
        this.cardLayout = cardLayout;
        this.screens = screens;
    }

    /**
     * @param userAndGroup response model with current user's username and the group name of the group they left
     */
    @Override
    public void prepareSuccessView(LeaveGroupResponseModel userAndGroup) {
        String username = userAndGroup.getUsername();
        String groupName = userAndGroup.getGroupname();
    }

    /**
     * @param error error message containing the reason for leave group use case failure
     */
    @Override
    public void prepareFailureView(String error) {
        throw new LeaveGroupFailed(error);
    }
}
