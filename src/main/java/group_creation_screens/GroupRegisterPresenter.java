package group_creation_screens;
import group_creation_use_case.GroupRegisterOutputBoundary;
import group_creation_use_case.GroupRegisterResponseModel;

import javax.swing.*;
import java.awt.*;

public class GroupRegisterPresenter implements GroupRegisterOutputBoundary{
    GroupCreationScreenBoundary groupRegisterScreenBoundary;


    public GroupRegisterPresenter(GroupCreationScreenBoundary groupRegisterScreenBoundary ){
        this.groupRegisterScreenBoundary = groupRegisterScreenBoundary;

    }
    public GroupRegisterPresenter(){};
    /**
     * Takes the response model data and calls the view model interface to display success
     * with the data from the response model. Since groupRegisterViewModel is an interface,
     * the presenter is not dependent on the view/UI.
     * @param groupResponseModel
     *
     */
    @Override
    public void prepareSuccessView(GroupRegisterResponseModel groupResponseModel) {
        this.groupRegisterScreenBoundary.switchScreen(groupResponseModel.getGroupName());

    }

    /**
     * Takes the response model data and calls the view model interface to display failure
     * with the data from the response model. Since groupRegisterViewModel is an interface,
     * the presenter is not dependent on the view/UI.
     * @param error
     */
    @Override
    public void prepareFailView(String error) {
        groupRegisterScreenBoundary.prepareFailView(error);
    }
}
