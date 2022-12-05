package UserSignupLoginScreens;

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
