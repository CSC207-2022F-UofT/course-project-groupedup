package pendinglistscreens;

import editpendinglist.EditPendingListResponseModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PendingListScreen extends JFrame implements ListSelectionListener {

    JList<String> memberRequests;
    EditPendingListController editPendingListController;
    ViewPendingListController viewPendingListController;
    DefaultListModel<String> memberRequestsModel;
    JButton acceptButton, rejectButton;
    String groupName;

    public PendingListScreen(EditPendingListController editPendingListController,
                             ViewPendingListController viewPendingListController) {

        super("Member Requests");
        setLayout(new FlowLayout());

        this.acceptButton = new JButton("✓");
        this.rejectButton = new JButton("✕");


        add(acceptButton);
        add(rejectButton);

        acceptButton.addActionListener(new AcceptOrReject());
        rejectButton.addActionListener(new AcceptOrReject());

        this.editPendingListController = editPendingListController;

        this.viewPendingListController = viewPendingListController;

        this.memberRequestsModel = new DefaultListModel<>();
        for (String username: viewPendingListController.getUsernames(groupName).getUsernamesList()) {
            memberRequestsModel.addElement(username);
        }

        this.memberRequests = new JList<>(memberRequestsModel);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // allows group leaders select the user they want to accept/reject, disables buttons when there is no selection
        if (!e.getValueIsAdjusting()) {
            if (memberRequests.getSelectedIndex() == -1) {
                acceptButton.setEnabled(false);
                rejectButton.setEnabled(false);
            } else {
                acceptButton.setEnabled(true);
                rejectButton.setEnabled(true);
            }
        }
    }

    private class AcceptOrReject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int index = memberRequests.getSelectedIndex();
            String username = memberRequests.getSelectedValue();
            // removes accepted member from the pending list UI
            memberRequestsModel.remove(index);
            int numRequests = memberRequestsModel.getSize();

            // changes the selected user to the last user on the pending list if the previously removed user was at
            // the end of the list
            if (numRequests == 0) {
                acceptButton.setEnabled(false);
                rejectButton.setEnabled(false);
            } else {
                if (index == numRequests) {
                    index--;
                }
            }
            memberRequests.setSelectedIndex(index);
            memberRequests.ensureIndexIsVisible(index);

            // triggers the editPendingList use case (not sure if this works)
            if (evt.getSource() == acceptButton) {
                EditPendingListResponseModel accepted = editPendingListController.rejectOrAcceptUser(username,
                        groupName, true);
                String user = accepted.getUsername();
                String group = accepted.getGroupName();
                JOptionPane.showMessageDialog(null, "Added " + user + " to " + group + ".");

            } else if (evt.getSource() == rejectButton) {
                EditPendingListResponseModel rejected = editPendingListController.rejectOrAcceptUser(username,
                        groupName, false);
                String user = rejected.getUsername();
                JOptionPane.showMessageDialog(null, "Removed " + user + ".");
            }
        }
    }

}
