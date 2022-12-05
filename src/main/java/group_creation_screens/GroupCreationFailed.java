package group_creation_screens;

public class GroupCreationFailed extends RuntimeException{
    /**
     * This is a runtime exception which will be thrown by GroupCreationScreen in
     * displayFailure() if
     * the group can't be created because the group's name is empty or the group
     * already exists.
     * @param error
     */
    public GroupCreationFailed(String error){super(error);}
}
