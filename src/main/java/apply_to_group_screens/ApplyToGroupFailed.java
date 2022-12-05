package apply_to_group_screens;

public class ApplyToGroupFailed extends RuntimeException{
    public ApplyToGroupFailed(String error){
        super(error);
    }

}
