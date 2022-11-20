package leave_group_screens;

import leave_group_use_case.LeaveGroupResponseModel;

import javax.swing.*;

public class LeaveGroupScreen extends JFrame {

    LeaveGroupController leaveGroupController;
    String username;
    String groupName;

    public LeaveGroupScreen(String username, String groupName,
                            LeaveGroupController leaveGroupController) {

        this.username = username;
        this.groupName = groupName;
        this.leaveGroupController = leaveGroupController;

        String[] options = {"Leave", "Stay"};

        int selectionChoice = JOptionPane.showOptionDialog(null, "Are you sure you" +
                " want to leave " + groupName + "?", "Leave Group",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        performSelectionChoice(selectionChoice);
        }

    private void performSelectionChoice(int selectionChoice) {
        if (selectionChoice == 0) {
            LeaveGroupResponseModel leftGroup = leaveGroupController.leaveGroup(username, groupName);

            String username = leftGroup.getUsername();
            String groupName = leftGroup.getGroupname();

            JOptionPane.showMessageDialog(null, username + " left group " +
                    groupName + ".");
        }
    }
}

