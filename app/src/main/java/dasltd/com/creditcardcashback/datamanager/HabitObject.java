package dasltd.com.creditcardcashback.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ba on 1/9/2016.
 */
public class HabitObject implements Serializable {

    private String habitHeader;
    private String habitDescription;
    private ArrayList<ActionObject> actions = new ArrayList<ActionObject>();

    public HabitObject (String sHabit) {
        habitHeader = sHabit;
        habitDescription = "This Habit will help you in your Target XYZ";
    }

    public void addAction(ActionObject obj){

        actions.add(obj);
    }

    public String getmText1() {
        return habitHeader;
    }

    public void setmText1(String mText1) {
        this.habitHeader = mText1;
    }

    public String getmText2() {
        return habitDescription;
    }

    public void setmText2(String mText2) {
        this.habitDescription = mText2;
    }

    public ActionObject getAcvity(int i) {
        return actions.get(i);
    }

    public ArrayList<ActionObject> getAllActions() {
        return actions;
    }

    @Override
    public String toString(){
        return habitHeader + " - " + habitDescription ;
    }

}
