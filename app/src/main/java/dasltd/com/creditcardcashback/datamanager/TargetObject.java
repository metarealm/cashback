package dasltd.com.creditcardcashback.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ba on 1/9/2016.
 */
public class TargetObject implements Serializable {

    private String targetHeader;
    private String targetDescription;
    private ArrayList<HabitObject> habits = new ArrayList<HabitObject>();

    public TargetObject (String sTarget){
        targetHeader = sTarget;
        targetDescription = "Lets talk about your" + targetHeader;

    }

    public void addHabit(HabitObject obj){
        habits.add(obj);
    }


    public String getmText1() {
        return targetHeader;
    }

    public void setmText1(String mText1) {
        this.targetHeader = mText1;
    }

    public String getmText2() {
        return targetDescription;
    }

    public void setmText2(String mText2) {
        this.targetDescription = mText2;
    }

    public ArrayList<HabitObject> getAllHabits(){
        return habits;
    }

    public HabitObject getHabit(int i) {
        return habits.get(i);
    }
}
