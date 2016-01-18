package dasltd.com.creditcardcashback.action;

/**
 * Created by bhabani on 1/3/2016.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.Iterator;

import dasltd.com.creditcardcashback.R;
import dasltd.com.creditcardcashback.datamanager.ActionObject;
import dasltd.com.creditcardcashback.datamanager.HabitObject;
import dasltd.com.creditcardcashback.datamanager.TrackerObject;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<ActionObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView actionlabel;
        ArrayList<CheckBox> trackerList = new ArrayList<CheckBox>();

        public DataObjectHolder(View itemView) {
            super(itemView);
            actionlabel = (TextView) itemView.findViewById(R.id.actionHeader);
            trackerList.add((CheckBox) itemView.findViewById(R.id.checkbox_tracker1));
            trackerList.add((CheckBox) itemView.findViewById(R.id.checkbox_tracker2));
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public ActionAdapter(ArrayList<ActionObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.action_cardview, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        if(holder.actionlabel == null){
            Log.i(LOG_TAG, "action lebel is null");
        }
        if(mDataset == null){
            Log.i(LOG_TAG, "mDataset is null");
        }
        String actionName = mDataset.get(position).getActionName();
        holder.actionlabel.setText(actionName);
        ArrayList<TrackerObject> tckr= mDataset.get(position).getAllTrackers();
        Log.i(LOG_TAG,tckr.size() + " trackers for " + actionName);
        for(int i=0 ; i < tckr.size() ; i++) {
            holder.trackerList.get(i).setText(tckr.get(i).toString());
        }
    }

    public void addItem(ActionObject dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}