package pending_list_screens;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The pending list screen.
 */

public class PendingListScreen extends JFrame implements PendingListScreenBoundary, ListSelectionListener {

    JList<String> memberRequests;
    EditPendingListController editPendingListController;
    ViewPendingListController viewPendingListController;
    DefaultListModel<String> memberRequestsModel;
    JButton acceptButton, rejectButton;
    String groupName;

    public PendingListScreen() {
        setTitle("Member Requests");
        setSize(300, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
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

    @Override
    public void setGroupName(String groupName) { this.groupName = groupName; }

    @Override
    public void setMemberRequests(JList<String> memberRequestsList) {
        this.memberRequests = memberRequestsList;
    }

    @Override
    public void setMemberRequestsModel(DefaultListModel<String> memberRequestsModel) {
        this.memberRequestsModel = memberRequestsModel;
    }

    public void setEditPendingListController(EditPendingListController editPendingListController) {
        this.editPendingListController = editPendingListController;
    }

    @Override
    public void setViewPendingListController(ViewPendingListController viewPendingListController) {
        this.viewPendingListController = viewPendingListController;
    }

    @Override
    public void view() {
        this.buildButtons();
        this.buildScrollPane();
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void buildButtons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        this.acceptButton = new JButton("Accept");
        this.rejectButton = new JButton("Reject");

        this.acceptButton.addActionListener(new AcceptOrReject());
        this.rejectButton.addActionListener(new AcceptOrReject());

        buttons.add(acceptButton);
        buttons.add(new JSeparator(SwingConstants.VERTICAL));
        buttons.add(Box.createHorizontalStrut(5));
        buttons.add(rejectButton);
        buttons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttons, BorderLayout.PAGE_END);

        if (memberRequestsModel.size() == 0) {
            acceptButton.setEnabled(false);
            rejectButton.setEnabled(false);
        }
    }

    @Override
    public void buildScrollPane() {
        JScrollPane requestsScrollPane = new JScrollPane(memberRequests);
        this.add(requestsScrollPane, BorderLayout.CENTER);
    }

    private class AcceptOrReject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int index = memberRequests.getSelectedIndex();
            String username = memberRequests.getSelectedValue();

            memberRequestsModel.remove(index);
            int numRequests = memberRequestsModel.size();

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

            if (evt.getSource() == acceptButton) {
                editPendingListController.rejectOrAcceptUser(username, groupName, true);

            } else if (evt.getSource() == rejectButton) {
                editPendingListController.rejectOrAcceptUser(username, groupName, false);
            }
        }
    }
}