package dasltd.com.creditcardcashback.datamanager;

import android.content.ContentValues;

import java.util.ArrayList;

/**
 * Created by bhabani on 11/1/2015.
 */
public class DBInitialValues {

    public static ArrayList<ContentValues> getInitialCardValues(){

        ArrayList<ContentValues> carValues = new ArrayList<ContentValues>();

        ContentValues initialValues = new ContentValues();
        initialValues.put("card_id", 1);
        initialValues.put("card_name", "freedom");
        initialValues.put("card_provider", "chase");
        initialValues.put("card_Type", "visa");
        initialValues.put("cash_Back", 1);
        carValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("card_id", 2);
        initialValues.put("card_name", "discover-it");
        initialValues.put("card_provider", "discover");
        initialValues.put("card_Type", "discover");
        initialValues.put("cash_Back", 1);
        carValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("card_id", 3);
        initialValues.put("card_name", "sapphire preferred");
        initialValues.put("card_provider", "chase");
        initialValues.put("card_Type", "visa");
        initialValues.put("cash_Back", 1);
        carValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("card_id", 4);
        initialValues.put("card_name", "slate");
        initialValues.put("card_provider", "chase");
        initialValues.put("card_Type", "visa");
        initialValues.put("cash_Back", 0);
        carValues.add(initialValues);


        initialValues = new ContentValues();
        initialValues.put("card_id", 5);
        initialValues.put("card_name", "amazon");
        initialValues.put("card_provider", "chase");
        initialValues.put("card_Type", "visa");
        initialValues.put("cash_Back", 1);
        carValues.add(initialValues);


        initialValues = new ContentValues();
        initialValues.put("card_id", 6);
        initialValues.put("card_name", "rewards card");
        initialValues.put("card_provider", "bank of america");
        initialValues.put("card_Type", "visa");
        initialValues.put("cash_Back", 1);
        carValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("card_id", 7);
        initialValues.put("card_name", "dividend");
        initialValues.put("card_provider", "citi");
        initialValues.put("card_Type", "master card");
        initialValues.put("cash_Back", 1);
        carValues.add(initialValues);

        return carValues;
    }


    public static ArrayList<ContentValues> getShopValues(){

        ArrayList<ContentValues> shopValues = new ArrayList<ContentValues>();

        ContentValues initialValues = new ContentValues();
        initialValues = new ContentValues();
        initialValues.put("shopping_id", 1);
        initialValues.put("store_name", "amazon.com");
        initialValues.put("category_name", "amazon");
        shopValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("shopping_id", 2);
        initialValues.put("store_name", "");
        initialValues.put("category_name", "Clothing Stores");
        shopValues.add(initialValues);


        initialValues = new ContentValues();
        initialValues.put("shopping_id", 3);
        initialValues.put("store_name", "");
        initialValues.put("category_name", "gas stations");
        shopValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("shopping_id", 4);
        initialValues.put("store_name", "");
        initialValues.put("category_name", "restaurants");
        shopValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("shopping_id", 5);
        initialValues.put("store_name", "");
        initialValues.put("category_name", "office supply");
        shopValues.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("shopping_id", 6);
        initialValues.put("store_name", "");
        initialValues.put("category_name", "grocery");
        shopValues.add(initialValues);

        return shopValues;
    }


    public static ArrayList<ContentValues> getDiscountValues() {

        ArrayList<ContentValues> discountValue = new ArrayList<ContentValues>();

        ContentValues initialValues = new ContentValues();
        initialValues = new ContentValues();
        initialValues.put("discount_id", 1);
        initialValues.put("shopping_id", 1);
        initialValues.put("card_id", 1);
        initialValues.put("discount_amount", 5);
        discountValue.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("discount_id", 2);
        initialValues.put("shopping_id", 2);
        initialValues.put("card_id", 2);
        initialValues.put("discount_amount", 5);
        discountValue.add(initialValues);


        initialValues = new ContentValues();
        initialValues.put("discount_id", 3);
        initialValues.put("shopping_id", 3);
        initialValues.put("card_id", 6);
        initialValues.put("discount_amount", 3);
        discountValue.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("discount_id", 4);
        initialValues.put("shopping_id", 5);
        initialValues.put("card_id", 5);
        initialValues.put("discount_amount", 2);
        discountValue.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("discount_id", 5);
        initialValues.put("shopping_id", 4);
        initialValues.put("card_id", 3);
        initialValues.put("discount_amount", 2);
        discountValue.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("discount_id", 6);
        initialValues.put("shopping_id", 4);
        initialValues.put("card_id", 6);
        initialValues.put("discount_amount", 2);
        discountValue.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("discount_id", 7);
        initialValues.put("shopping_id", 6);
        initialValues.put("card_id", 6);
        initialValues.put("discount_amount", 2);
        discountValue.add(initialValues);

        initialValues = new ContentValues();
        initialValues.put("discount_id", 8);
        initialValues.put("shopping_id", 1);
        initialValues.put("card_id", 2);
        initialValues.put("discount_amount", 5);
        discountValue.add(initialValues);

        return discountValue;

    }
}
