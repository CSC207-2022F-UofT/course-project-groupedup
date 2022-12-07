package view_and_data_access.screens.edit_group_profile_screens;

public class EditGroupProfileFailed extends RuntimeException {
    /**
     * This is a runtime exception that will be thrown by EditGroupProfileScreen if
     * the group can't be edited.
     * @param error
     */
    public EditGroupProfileFailed(String error) {
        super(error);
    }
}
