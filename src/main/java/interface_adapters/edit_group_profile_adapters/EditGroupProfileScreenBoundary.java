package interface_adapters.edit_group_profile_adapters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public interface EditGroupProfileScreenBoundary extends ActionListener {
    void actionPerformed(ActionEvent evt);
    void build();

    void setGroupName(String groupName);

    void setView(EditGroupProfileController editGroupProfileController);
}