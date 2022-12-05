package edit_group_profile_screens;
import edit_group_profile_use_case.EditGroupProfileResponseModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public interface EditGroupProfileScreenBoundary extends ActionListener {
    void actionPerformed(ActionEvent evt);
    void build();

    void setGroupName(String groupName);

    void setView(EditGroupProfileController editGroupProfileController);
}
