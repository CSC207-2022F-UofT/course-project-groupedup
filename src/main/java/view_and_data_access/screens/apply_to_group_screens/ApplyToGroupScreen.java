package view_and_data_access.screens.apply_to_group_screens;

import interface_adapters.apply_to_group_adapters.ApplyToGroupController;

import javax.swing.*;

public class ApplyToGroupScreen extends JFrame {
    ApplyToGroupController applyToGroupController;
    String username;
    String groupName;

    public ApplyToGroupScreen(String username, String groupName,
                            ApplyToGroupController applyToGroupController) {
        this.username = username;
        this.groupName = groupName;
        this.applyToGroupController = applyToGroupController;

        String[] options = {"Apply", "Cancel"};

        int selectionChoice = JOptionPane.showOptionDialog(null, "Are you sure you" +
                        " want to apply to " + groupName + "?", "Apply to Group",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        performSelectionChoice(selectionChoice);
    }

    private void performSelectionChoice(int selectionChoice) {
        if (selectionChoice == 0) {
            this.applyToGroupController.applyToGroup(username, groupName);
        }
    }
}
