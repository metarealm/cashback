package dasltd.com.creditcardcashback;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import dasltd.com.creditcardcashback.datamanager.DBHelper;

/**
 * Created by bhabani on 10/31/2015.
 */
public class CategorySelectionActivity implements AdapterView.OnItemSelectedListener {

    ListView lstView = null;

    public CategorySelectionActivity(ListView lview){
        super();
        lstView = lview;
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        String inputShop = parent.getItemAtPosition(pos).toString();

        DBHelper shopDB = new DBHelper(parent.getContext());
        ArrayList array_list = shopDB.getDiscountInfo(inputShop);
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + array_list.get(0),
                Toast.LENGTH_SHORT).show();

        //ListView lstView = (ListView)findViewById(R.id.cccashbkList);
        ArrayAdapter arrayAdapter=new ArrayAdapter(parent.getContext(),android.R.layout.simple_list_item_1, array_list);
        lstView.setAdapter(arrayAdapter);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
