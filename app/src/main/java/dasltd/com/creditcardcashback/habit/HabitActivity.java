package dasltd.com.creditcardcashback.habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

import dasltd.com.creditcardcashback.action.ActionActivity;
import dasltd.com.creditcardcashback.datamanager.HabitObject;
import dasltd.com.creditcardcashback.R;
import dasltd.com.creditcardcashback.datamanager.DataObject;
import dasltd.com.creditcardcashback.datamanager.TargetData;
import dasltd.com.creditcardcashback.datamanager.TargetObject;


public class HabitActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    private int targetID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);
        targetID = getIntent().getIntExtra("targetID", /* defaltvalue */ 0);
        mRecyclerView = (RecyclerView) findViewById(R.id.habit_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HabitAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((HabitAdapter) mAdapter).setOnItemClickListener(new HabitAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
                Intent myIntent = new Intent(HabitActivity.this, ActionActivity.class);
                myIntent.putExtra("habitID", position);
                myIntent.putExtra("targetID", targetID); //Optional parameters
                HabitActivity.this.startActivity(myIntent);
            }
        });
    }

    private ArrayList<HabitObject> getDataSet() {
        ArrayList results = new ArrayList<HabitObject>();
        TargetObject target = TargetData.getInstance().getAllTargets().get(targetID);
        results = target.getAllHabits();
        return results;
    }
}





