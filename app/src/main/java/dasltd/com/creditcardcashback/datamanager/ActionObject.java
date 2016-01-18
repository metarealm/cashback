package dasltd.com.creditcardcashback.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ba on 1/9/2016.
 */
public class ActionObject implements Serializable {

    private String actionName;
    private String actionExplanation;
    private ArrayList<TrackerObject> trackers = new ArrayList<TrackerObject>();
    private int completionPct ;

    public ActionObject(String name, int pct){
        this.actionName = name;
        this.completionPct = pct;

    }

    public void setExplanation(String explation){
        this.actionExplanation = explation;
    }

    public String getActionName(){
        return this.actionName;
    }

    public void updatePct(int pct){
        this.completionPct = pct;
    }

    public void addTracker(TrackerObject trackerObject){
        trackers.add(trackerObject);
    }

    public ArrayList<TrackerObject> getAllTrackers(){
        return trackers;
    }

    @Override
    public String toString(){
        return actionName+ " is " + completionPct + " complete !! Keep up the good work";
    }

}
