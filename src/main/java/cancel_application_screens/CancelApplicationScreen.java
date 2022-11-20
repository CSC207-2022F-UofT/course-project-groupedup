package cancel_application_screens;

import cancel_application_use_case.CancelApplicationResponseModel;

import javax.swing.*;

public class CancelApplicationScreen extends JFrame {

    CancelApplicationController cancelApplicationController;
    String username;
    String groupName;

    public CancelApplicationScreen(String username, String groupName,
                                   CancelApplicationController cancelApplicationController) {

        this.username = username;
        this.groupName = groupName;
        this.cancelApplicationController = cancelApplicationController;

        String[] options = {"Yes, Cancel", "No"};

        int selectionChoice = JOptionPane.showOptionDialog(null, "Are you sure you" +
                        " want to cancel your application for " + groupName + "?",
                "Cancel Application", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        performSelectionChoice(selectionChoice);
    }

    private void performSelectionChoice(int selectionChoice) {
        if (selectionChoice == 0) {
            CancelApplicationResponseModel cancelledApplication = cancelApplicationController.cancelApplication(username,
                    groupName);

            String username = cancelledApplication.getUsername();
            String groupName = cancelledApplication.getGroupname();

            JOptionPane.showMessageDialog(null, username + " cancelled application for " +
                     groupName + ".");
        }
    }
}
