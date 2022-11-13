package matching_algorithm_use_case;

import java.util.List;

public class MatchingAlgorithmResponseModel {
    String updateMessage;
    List<String> groupToStringList;

    public MatchingAlgorithmResponseModel(String uM, List<String> g){
        this.updateMessage = uM;
        this.groupToStringList = g;
    }

    public List<String> getGroups(){
        return this.groupToStringList;
    }

    public void setGroups(List<String> g){
        this.groupToStringList = g;
    }
}
