package dasltd.com.creditcardcashback.habit;

/**
 * Created by bhabani on 1/3/2016.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import dasltd.com.creditcardcashback.R;
import dasltd.com.creditcardcashback.datamanager.DataObject;
import dasltd.com.creditcardcashback.datamanager.HabitObject;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<HabitObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView habitlabel;
        TextView habitDesciption;
        TextView habitActivity1;
        TextView habitActivity2;
        TextView habitActivity3;

        public DataObjectHolder(View itemView) {
            super(itemView);
            habitlabel = (TextView) itemView.findViewById(R.id.habitHeader);
            habitDesciption = (TextView) itemView.findViewById(R.id.habitDetail);
            habitActivity1 = (TextView) itemView.findViewById(R.id.habit_activity1);
            habitActivity2 = (TextView) itemView.findViewById(R.id.habit_activity2);
            habitActivity3 = (TextView) itemView.findViewById(R.id.habit_activity3);
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

    public HabitAdapter(ArrayList<HabitObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_cardview, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.habitlabel.setText(mDataset.get(position).getmText1());
        holder.habitDesciption.setText(mDataset.get(position).getmText2());
        holder.habitActivity1.setText("     " +mDataset.get(position).getAcvity(0).toString());
        //holder.habitActivity2.setText("     " +mDataset.get(position).getAcvity(1).toString());
        //holder.habitActivity3.setText("     " +mDataset.get(position).getAcvity(2).toString());
    }

    public void addItem(HabitObject dataObj, int index) {
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