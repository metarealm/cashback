package dasltd.com.creditcardcashback.datamanager;

import java.util.ArrayList;

/**
 * Created by bhabani on 1/3/2016.
 */
public class DataObject {

    private static ArrayList<TargetObject> targets = new ArrayList<TargetObject>();

    public DataObject (){

    }

    public void addTargetObject(TargetObject obj){
        targets.add(obj);
    }

    public static ArrayList<TargetObject> getAllTargets(){
        return targets;
    }
    public TargetObject get(int i) {
        return targets.get(i - 1);
    }
}
