package dasltd.com.creditcardcashback.action;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import dasltd.com.creditcardcashback.R;
import dasltd.com.creditcardcashback.datamanager.ActionObject;
import dasltd.com.creditcardcashback.datamanager.HabitObject;
import dasltd.com.creditcardcashback.datamanager.TargetData;
import dasltd.com.creditcardcashback.datamanager.TargetObject;
import dasltd.com.creditcardcashback.habit.HabitAdapter;

public class ActionActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    private int targetID =0;
    private int habitID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        targetID = getIntent().getIntExtra("targetID", /* defaltvalue */ 0);
        habitID = getIntent().getIntExtra("habitID", /* defaltvalue */ 0);
        mRecyclerView = (RecyclerView) findViewById(R.id.action_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ActionAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<ActionObject> getDataSet() {
        ArrayList results = new ArrayList<ActionObject>();
        HabitObject habit = TargetData.getInstance().getAllTargets().get(targetID).getHabit(habitID);
        results = habit.getAllActions();
        return results;
    }

    public void ontcr1CkbxClkd(){

    }

    public void ontcr2CkbxClkd(){

    }
}
