package matching_algorithm_use_case;
// Is this even necessary? since when the button is pressed we will instead call the interactor automatically
// ya know?? ***Ask TA
public class MatchingAlgorithmRequestModel {
    private Boolean refresh;
    private Boolean findGroups;

    public MatchingAlgorithmRequestModel(Boolean r, Boolean fG){
        this.refresh = r;
        this.findGroups = fG;
    }

    public Boolean getRefresh() {
        return this.refresh;}

    public Boolean getFindGroups() {
        return this.findGroups;
    }

    void setRefresh(Boolean r){
        this.refresh = r;
    }

    void setFindGroups(Boolean fG){
        this.findGroups = fG;
    }
}
