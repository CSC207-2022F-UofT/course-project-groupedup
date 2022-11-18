package editpendinglist;

public class EditPendingListResponseModel {
    // TODO: figure out what parameters are required to create relevant screens
    // My response model might actually not have to do anything besides send a string saying success? Or nothing at all
    private String successMessage;

    public EditPendingListResponseModel(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return this.successMessage;
    }
}