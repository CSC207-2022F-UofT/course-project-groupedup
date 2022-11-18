package pendinglistscreens;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: I just realized the existence of the pending list shouldn't rely on my use case happening (i.e., someone
//  accepts/rejects a member). So, the person who is doing the group UI might need to add a pending list button
//  onto their screen and send the group's pending list information to the PendingListScreen class because I don't
//  think I can do that with my use case since my use case only gets triggered when someone is interacting with a
//  pre-existing pending list(?). I also need the ApplyToGroup use case's presenter to add users to the pending list
//  UI whenever someone applies to a group. EDIT: it might be sufficient to have ApplyToGroup's use case have a get
//  group's member request information method in their response model

public class PendingListScreen extends JPanel implements ListSelectionListener {

    JList<String> memberRequests;
    EditPendingListController editPendingListController;
    ViewPendingListController viewPendingListController;
    DefaultListModel<String> memberRequestsModel;
    JButton acceptButton, rejectButton;
    String groupName;

    public PendingListScreen(EditPendingListController editPendingListController,
                             ViewPendingListController viewPendingListController) {
        this.editPendingListController = editPendingListController;

        this.viewPendingListController = viewPendingListController;



        this.memberRequestsModel = new DefaultListModel<String>();
        for (String username: viewPendingListController.getUsernames.getUsernamesLis(groupName)) {
            memberRequestsModel.addElement(username);
        }

        this.memberRequests = new JList<String>(memberRequestsModel);

        this.acceptButton = new JButton("✓");
        acceptButton.addActionListener(new AcceptListener());
        this.rejectButton = new JButton("✕");
        rejectButton.addActionListener(new RejectListener());

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

    // implements the function of the accept button
    class AcceptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = memberRequests.getSelectedIndex();
            String username = memberRequests.getSelectedValue();
            String groupName = getPendingListPresenter.getGroupName(); //applyToGroupResponseModel?
            // removes accepted member from the pending list UI
            memberRequestsModel.remove(index);
            int numRequests = memberRequestsModel.getSize();

            // changes the selected user to the last user on the pending list if the previously removed user was at
            // the end of the list
            if (numRequests == 0) {
                acceptButton.setEnabled(false);
            } else {
                if (index == numRequests) {
                    index--;
                }
            }
            memberRequests.setSelectedIndex(index);
            memberRequests.ensureIndexIsVisible(index);

            // triggers the editPendingList use case (not sure if this works)
            editPendingListController.rejectOrAcceptUser(userID, groupID, true);
        }
    }

    // reject button with the same core functions as the accept button
    // not sure if there's a way to get rid of the duplicate code between the two buttons
    class RejectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
