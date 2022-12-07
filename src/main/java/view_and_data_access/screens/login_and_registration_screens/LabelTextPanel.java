package view_and_data_access.screens.login_and_registration_screens;

import javax.swing.*;
/**
 * class of a bundle of java swing elements to help implement screens
 */
public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
