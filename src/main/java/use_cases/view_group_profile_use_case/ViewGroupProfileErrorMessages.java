package use_cases.view_group_profile_use_case;

/**
 * This is a class which contains the error messages that the
 * ViewGroupProfileInteractor uses to get rid of hard coded error messages.
 * The messages are accessible by getter methods.
 */
public class ViewGroupProfileErrorMessages {
    private final String groupDoesNotExist = "This group does not exist";

    public String getGroupDoesNotExist() {
        return groupDoesNotExist;
    }
}
