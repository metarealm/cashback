package dasltd.com.creditcardcashback.datamanager;

/**
 * Created by ba on 1/16/2016.
 */
public class TrackerObject {
    private String sTracker="";
    private TrackSchedule schedule = TrackSchedule.perDay;

    public TrackerObject(String tracker,TrackSchedule schedule){
        sTracker=tracker;
        this.schedule = schedule;
    }
    @Override
    public String toString(){
        return  sTracker;
    }
    public void setTracker(String tracker){
        sTracker = tracker;
    }

    public void setSchedule(TrackSchedule schedule){
        this.schedule = schedule;
    }

}
