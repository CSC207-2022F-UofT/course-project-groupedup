package group_creation_use_case;

/**
 * This is a class which contains the error messages that the
 * GroupRegisterInteractor uses to get rid of hard coded error messages.
 * The messages are accessible by getter methods.
 */
public class GroupRegisterErrorMessages {
    private String emptyStringFailureMessage = "Invalid group name.";
    private String groupExistsFailureMessage = "Group already exists.";

    public String getEmptyStringFailureMessage(){
        return emptyStringFailureMessage;
    }
    public String getGroupExistsFailureMessage(){
        return groupExistsFailureMessage;
    }
}
