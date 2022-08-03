package zubreev.col_mat.model;


import javax.script.SimpleBindings;
import java.util.*;
import java.util.jar.Attributes;

public class Group implements Cloneable{
    private Integer maxValue = -1;
    private HashMap<Integer, List<Integer>> group = new HashMap<>();

    public Group(){};

    private Group(HashMap<Integer, List<Integer>> group, Integer maxValue){
        this.group = group;
        this.maxValue = maxValue;
    }

    /** oldVal - которое возможно уже есть в группе, newVal - которое надо добавить*/
    public void addValue( int oldVal, int newVal){
        checkMaxValue(oldVal, newVal);
        Integer nameGroup = checkGroup(oldVal);
        if (nameGroup != null){
            addInGroup(nameGroup, newVal);
        }else {
            addGroup(oldVal, newVal);
        }
    }

    public void addValue( int value){

    }

    private Integer addGroup(Integer... values){
        List<Integer> valuesList = new ArrayList<Integer>();
        for(Integer curVal : values){
            valuesList.add(curVal);
        }
        Integer nameValue = null;
        //if( group.isEmpty() ){
            group.put(valuesList.get(0), valuesList);
            nameValue = valuesList.get(0);
        //}else {
//            int maxGroup = group.keySet().stream().max(Integer::compare).get();
//            group.put( maxGroup + 1, valuesList );
//            nameValue = maxGroup + 1;
//        }
        return nameValue;
    }

    private void addInGroup(Integer nameGroup, Integer value){
        List<Integer> curGroup = group.get(nameGroup);
        curGroup.add(value);
    }

    private void deleteFromGroup(Integer nameGroup, Integer value){
        List<Integer> values = group.get(nameGroup);
        values.remove(value);
        if(values.size() == 1 || values.size() == 0){
            group.remove(nameGroup);
        }
    }

    public Integer checkGroup( int value ){
        if( group.isEmpty() ) return null;
        Integer result = null;
        for (Integer nameGroup : group.keySet()){
            List<Integer> values = group.get(nameGroup);
            if (values.contains(value)){
                result = nameGroup;
                break;
            }
        }
        return result;
    }

    public Set<Integer> getAllNameGroup(){
        return group.keySet();
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    private void checkMaxValue(Integer... values){
        Arrays.stream(values).forEach((val)-> {if(maxValue<val) maxValue=val;});
    }

    @Override
    public String toString() {
        return "" + group;
    }

    @Override
    public Object clone(){
        return new Group((HashMap<Integer, List<Integer>>)group.clone(), maxValue);
    }
}
