package dasltd.com.creditcardcashback.datamanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


/**
 * Created by bhabani on 11/1/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CashBackManager.db";

    public static final String CARD_TABLE_NAME = "carddetails";
    public static final String CARD_ID = "card_id";
    public static final String CARD_NAME = "card_name";
    public static final String CARD_PROVIDER = "card_provider";
    public static final String CARD_TYPE = "card_Type";
    public static final String CARD_DEFAULT_CASHBACK = "cash_Back";
    public static final String CARD_DETAIL = "card_detail";

    public static final String SHOPPING_TABLE_NAME = "shoppingdetails";
    public static final String SHOPPING_ID = "shopping_id";
    public static final String SHOPPING_STORE_NAME = "store_name";
    public static final String SHOPPING_CATEGORY_NAME = "category_name";
    public static final String SHOPPING_DETAIL = "shop_detail";

    public static final String DISCOUNT_TABLE_NAME = "discountdetails";
    public static final String DISCOUNT_ID = "discount_id";
    public static final String DISCOUNT_SHOPPING_ID = "shopping_id";
    public static final String DISCOUNT_CARD_ID = "card_id";
    public static final String DISCOUNT_AMOUNT = "discount_amount";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table carddetails " +
                        "(card_id integer primary key, card_name text,card_provider text,card_Type text,cash_Back integer)"
        );
        db.execSQL(
                "create table shoppingdetails " +
                        "(shopping_id integer primary key, store_name text,category_name text)"
        );
        db.execSQL(
                "create table discountdetails " +
                        "(discount_id integer primary key, shopping_id integer,card_id integer,discount_amount integer)"
        );


        ArrayList<ContentValues> cardValues = DBInitialValues.getInitialCardValues();
        for(int i=0;i<cardValues.size() ; i++){
            db.insert(CARD_TABLE_NAME, null, cardValues.get(i));
        }

        ArrayList<ContentValues> shopValues = DBInitialValues.getShopValues();
        for(int i=0;i<shopValues.size() ; i++){
            db.insert(SHOPPING_TABLE_NAME, null, shopValues.get(i));
        }

        ArrayList<ContentValues> dsicountValues = DBInitialValues.getDiscountValues();
        for(int i=0;i<dsicountValues.size() ; i++){
            db.insert(DISCOUNT_TABLE_NAME, null, dsicountValues.get(i));
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS carddetails");
        db.execSQL("DROP TABLE IF EXISTS shoppingdetails");
        db.execSQL("DROP TABLE IF EXISTS discountdetails");
        onCreate(db);
    }

    public ArrayList<String> getAllCards()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from carddetails", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CARD_PROVIDER)) + "-" + res.getString(res.getColumnIndex(CARD_NAME))
            +"(" + res.getString(res.getColumnIndex(CARD_TYPE)) + ")");
            res.moveToNext();
        }
        db.close();
        res.close();
        return array_list;
    }

    public ArrayList<String> getAllCcategory()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from shoppingdetails", null );

        res.moveToFirst();
        Log.d(" before while loop " , "\n");
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(SHOPPING_CATEGORY_NAME)));
            res.moveToNext();

        }
        Log.d("array_list.size = " + array_list.size(), "\n");
        db.close();
        res.close();
        return array_list;
    }

    public ArrayList<String> getDiscountInfo(String categoryName)
    {
        ArrayList<String> array_list = new ArrayList<String>();
        String query = "select cd.card_id,cd.card_provider,cd.card_name,d.discount_amount from shoppingdetails sh," +
                "carddetails cd,discountdetails d where cd.card_id = d.card_id and d.shopping_id=sh.shopping_id "
                + " and sh.category_name ='"+categoryName +"'";

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( query  , null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CARD_PROVIDER)) + "-" +
                    res.getString(res.getColumnIndex(CARD_NAME)) + "----" + res.getString(res.getColumnIndex(DISCOUNT_AMOUNT)));

            res.moveToNext();
        }
        db.close();
        res.close();



        return array_list;
    }
    public ArrayList<String> getDefaultDiscount(){

        ArrayList<String> array_list = new ArrayList<String>();

        String query = "select card_provider,card_name,cash_Back from carddetails " ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( query  , null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CARD_PROVIDER)) + "-" +
                    res.getString(res.getColumnIndex(CARD_NAME)) + "----" + res.getString(res.getColumnIndex(CARD_DEFAULT_CASHBACK)));
            res.moveToNext();
        }
        db.close();
        res.close();

        return array_list;
    }


}
