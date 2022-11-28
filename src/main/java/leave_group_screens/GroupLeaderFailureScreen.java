/*
package leave_group_screens;

import leave_group_use_case.LeaveGroupResponseModel;

import javax.swing.*;

*/
/**
 * OptionDialog JOptionPane shown when the current user tries leaving a group that
 * they are a Group Leader for, or a group that only contains one member.
 *
 * Currently, this failure of the leave group use case is just shown as an error message
 * in a MessageDialog pane (error message with an "OK" button).
 * IDEALLY, want this failure to be shown in THIS screen, also containing a button for
 * "Edit Group", which would enact the edit group profile use case if pressed.
 * A transition screen.
 *
 * I'll need to modify the leave group use case output boundary, interactor, and
 * presenter, as well as coordinate with the edit group use case controller, to
 * make this change. This file is currently empty.
 *//*

public class GroupLeaderFailureScreen extends JFrame {
    EditGroupProfileController editGroupController;
    String username;
    String groupName;

    public GroupLeaderFailureScreen(String username, String groupName,
                                    EditGroupProfileController editGroupController) {
        String[] options = {"Edit Group", "Close"};

        int selectionChoice = JOptionPane.showOptionDialog(null, "Oops! You're " +
                        "Group Leader for this group. Please transfer leadership before leaving.", "Leave Group",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        performSelectionChoice(selectionChoice);
    }

    private void performSelectionChoice(int selectionChoice) {
        if (selectionChoice == 0) {
            LeaveGroupResponseModel leftGroup = editGroupController.editGroup(...);
        }
    }
}
*/
