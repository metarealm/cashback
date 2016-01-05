package dasltd.com.creditcardcashback;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import dasltd.com.creditcardcashback.datamanager.DBHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCardDetails();
        addCategorySpinner();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // add items into spinner dynamically
    public void addCategorySpinner() {

        Spinner spinner = (Spinner) findViewById(R.id.CategorySpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.store_category, android.R.layout.simple_spinner_item);
        DBHelper shopDB = new DBHelper(this);
        ArrayList array_list = shopDB.getAllCcategory();
        Log.d("add category spinner ",Integer.toString(array_list.size()));
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        CategorySelectionActivity selectionact = new CategorySelectionActivity((ListView)findViewById(R.id.cccashbkList));
        spinner.setOnItemSelectedListener(selectionact);
    }

    public void showCardDetails() {
        ListView lstView = (ListView)findViewById(R.id.cccashbkList);
        DBHelper carddb = new DBHelper(this);
        ArrayList array_list = carddb.getAllCards();

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        lstView.setAdapter(arrayAdapter);

    }

}
