package dasltd.com.creditcardcashback.target;

/**
 * Created by bhabani on 1/3/2016.
 */
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import java.util.ArrayList;

import dasltd.com.creditcardcashback.DividerItemDecoration;
import dasltd.com.creditcardcashback.LoginActivity;
import dasltd.com.creditcardcashback.R;
import dasltd.com.creditcardcashback.SignInActivity;
import dasltd.com.creditcardcashback.TransitionSecondActivity;
import dasltd.com.creditcardcashback.datamanager.DataObject;
import dasltd.com.creditcardcashback.datamanager.TargetData;
import dasltd.com.creditcardcashback.datamanager.TargetObject;
import dasltd.com.creditcardcashback.habit.HabitActivity;

public class RecyclerViewActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";
    private View mFabButton;
    private View mHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mFabButton = findViewById(R.id.fab_button);
        mHeader = findViewById(R.id.activity_transition_header);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
        Slide slideExitTransition = new Slide(Gravity.BOTTOM);
        slideExitTransition.excludeTarget(android.R.id.navigationBarBackground, true);
        slideExitTransition.excludeTarget(android.R.id.statusBarBackground, true);
        slideExitTransition.excludeTarget(R.id.activity_transition_header, true);
        getWindow().setExitTransition(slideExitTransition);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener
                (new  MyRecyclerViewAdapter.MyClickListener() {
                      @Override
                      public void onItemClick(int position, View v) {
                          Intent myIntent = new Intent(RecyclerViewActivity.this, HabitActivity.class);
                          myIntent.putExtra("targetID", position); //Optional parameters
                          RecyclerViewActivity.this.startActivity(myIntent);
                          Log.i(LOG_TAG, " Clicked on Item " + position);
                      }
                  });
    }

    private ArrayList<TargetObject> getDataSet() {
        TargetData userData = TargetData.getInstance();

        ArrayList<TargetObject> results = userData.getAllTargets();
        return results;
    }

    public void onGoogleLoginPressed(View view){
        Intent myIntent = new Intent(RecyclerViewActivity.this, SignInActivity.class);
        RecyclerViewActivity.this.startActivity(myIntent);
        Log.i(LOG_TAG, " Clicked on google login " );
    }

    public void onLoginPressed(View view){
        Intent myIntent = new Intent(RecyclerViewActivity.this, LoginActivity.class);
        RecyclerViewActivity.this.startActivity(myIntent);
    }

    public void onFabPressed(View view) {

        Intent i  = new Intent (RecyclerViewActivity.this,
                TransitionSecondActivity.class);
        if(mFabButton!= null)
        {
            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    RecyclerViewActivity.this, Pair.create(mFabButton, "fab"));
            startActivity(i, transitionActivityOptions.toBundle());
        }else{
            if(mFabButton== null)Log.i(LOG_TAG, " mFabButton is null ");
        }


    }
}