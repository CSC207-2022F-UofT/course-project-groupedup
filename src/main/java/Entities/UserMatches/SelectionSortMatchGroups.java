package Entities.UserMatches;

import Entities.Group;

import java.util.HashMap;
import java.util.List;

public class SelectionSortMatchGroups implements Sorter{
    private HashMap<Group, Double> map;
    public SelectionSortMatchGroups(HashMap<Group, Double> map){
        this.map = map;
    }

    //Sorts the groups based on their mapped values
    public void sort(List<Object> groups) {
        for (int i = 0; i < groups.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < groups.size(); j++) {
                if (map.get(groups.get(j)) > map.get(groups.get(index))) {
                    index = j;//searching for largest index
                }
            }

            Group smallerNumber = (Group) groups.get(index);

            groups.set(index, groups.get(i));

            groups.set(i,smallerNumber);
        }
    }
}
