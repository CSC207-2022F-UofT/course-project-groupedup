package use_cases.edit_group_profile_use_case;

/**
 * This is a class which contains the error messages that the
 * GroupRegisterInteractor uses to get rid of hard coded error messages.
 * The messages are accessible by getter methods.
 */
public class EditGroupProfileErrorMessages {
    private String invalidCourseCode = "Invalid Course Code Entered.";
    private String groupNotFound = "Group does not exist.";


    public String getInvalidCourseCodeFailureMessage(){
        return invalidCourseCode;
    }
    public String getGroupNotFoundFailureMessage(){
        return groupNotFound;
    }
}