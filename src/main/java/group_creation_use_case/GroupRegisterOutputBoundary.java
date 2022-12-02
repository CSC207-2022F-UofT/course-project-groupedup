package group_creation_use_case;

import javax.swing.*;
import java.awt.*;

public interface GroupRegisterOutputBoundary {
    void prepareSuccessView(GroupRegisterResponseModel groupResponseModel);

    void prepareFailView(String error);

}
