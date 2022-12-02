package group_creation_screens;
import group_creation_use_case.GroupRegisterOutputBoundary;
import group_creation_use_case.GroupRegisterResponseModel;

import javax.swing.*;
import java.awt.*;

public class GroupRegisterPresenter implements GroupRegisterOutputBoundary{
    GroupRegisterViewModel groupRegisterViewModel;


    public GroupRegisterPresenter(GroupRegisterViewModel groupRegisterViewModel){
        this.groupRegisterViewModel = groupRegisterViewModel;

    }
    /**
     *
     * @param groupResponseModel takes the response model data and presents it in the UI upon success
     *
     */
    @Override
    public void prepareSuccessView(GroupRegisterResponseModel groupResponseModel) {
        groupRegisterViewModel.displaySuccess(groupResponseModel);

    }

    /**
     *
     * @param error takes an error message and presents a failure screen/message in the UI upon failure
     * @return
     */
    @Override
    public void prepareFailView(String error) {
        groupRegisterViewModel.displayFailure(error);
    }
}
