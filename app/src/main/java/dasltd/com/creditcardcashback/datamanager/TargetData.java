package dasltd.com.creditcardcashback.datamanager;

import java.util.ArrayList;

/**
 * Created by ba on 1/10/2016.
 */
public class TargetData {
    private static TargetData ourInstance = new TargetData();
    private ArrayList<TargetObject> targets;


    public static TargetData getInstance() {
        return ourInstance;
    }

    private TargetData() {
        targets = new ArrayList<TargetObject>();
        TargetObject target1 = new TargetObject("Health Improvement");

        HabitObject fitHabit = new HabitObject("staying fit");
        ActionObject walkAction = new ActionObject("walking in 30 mins a day", 10);
        walkAction.addTracker(new TrackerObject("morning walking",TrackSchedule.perDay));
        walkAction.addTracker(new TrackerObject("Evening Walking", TrackSchedule.perDay));

        ActionObject playAction = new ActionObject("playing ", 10);
        playAction.addTracker(new TrackerObject("playing tennis",TrackSchedule.perMonth));

        fitHabit.addAction(walkAction);
        fitHabit.addAction(playAction);

        HabitObject habit2 = new HabitObject("body building");
        ActionObject gymAction = new ActionObject("gym", 10);
        habit2.addAction(gymAction);

        HabitObject habit3 = new HabitObject("Manage colestrol");
        habit3.addAction(walkAction);

        HabitObject habit4 = new HabitObject("Manage sugar");
        habit4.addAction(walkAction);

        HabitObject habit5 = new HabitObject("quit cigarate");
        ActionObject actObj5 = new ActionObject("No smoking today", 50);
        habit5.addAction(actObj5);

        target1.addHabit(fitHabit);
        target1.addHabit(habit2);
        target1.addHabit(habit3);
        target1.addHabit(habit4);
        target1.addHabit(habit5);

        TargetObject target2 = new TargetObject("Technical skill improvement");
        HabitObject habit6 = new HabitObject("Reading more");
        ActionObject actObj6 =new ActionObject("reading 50 page of novel", 10);
        habit6.addAction(actObj6);



        HabitObject habit7 = new HabitObject("Programming kill improvement");
        ActionObject actObj7 = new ActionObject("write 100 line of code",5);
        habit7.addAction(actObj7);

        target2.addHabit(habit6);
        target2.addHabit(habit7);

        targets.add(target1);
        targets.add(target2);
    }

    public void addTargetObject(TargetObject obj){
        targets.add(obj);
    }

    public ArrayList<TargetObject> getAllTargets(){
        return targets;
    }
    public TargetObject get(int i) {
        return targets.get(i - 1);
    }
}
