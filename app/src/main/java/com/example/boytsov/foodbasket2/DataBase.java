package com.example.boytsov.foodbasket2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Boytsov on 09.08.2015.
 */
public class DataBase extends SQLiteOpenHelper{
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "foodBasket";

    // Contacts table name
    private static final String TABLE_PRODUCTS = "products";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_PRODUCT_NAME = "name_product";
    private static final String KEY_UUID_PRODUCT_NAME = "id_name_product";
    private static final String IS_STRIKE_OUT = "isstrikeout";
    private static final String LOG_TAG_ERROR ="myLogs";


    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables

    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_UUID_PRODUCT_NAME + " UUID, "
                + KEY_PRODUCT_NAME + " TEXT, "
                + IS_STRIKE_OUT + " BOOLEAN );";
        db.execSQL(CREATE_PRODUCTS_TABLE);
        Log.d(LOG_TAG_ERROR, "create table ok");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    public void addProduct(Product product){
        // Adding new contact
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, product.getName_product());
        values.put(IS_STRIKE_OUT, product.IsStrikeout());
        values.put(KEY_UUID_PRODUCT_NAME, String.valueOf(product.getId()));


        // Inserting Row
        db.insert(TABLE_PRODUCTS, null, values);
        Log.d(LOG_TAG_ERROR, "addProduct OK " + " " + product.getName_product() + " " + product.getId());

        db.close(); // Closing database connection
    }

    // Getting single product где-то ошибка здесь
    Product getProduct(UUID id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] { KEY_ID,KEY_UUID_PRODUCT_NAME,
                        KEY_PRODUCT_NAME,IS_STRIKE_OUT  }, KEY_UUID_PRODUCT_NAME + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product();
        product.setId(UUID.fromString(cursor.getString(1)));
        product.setName_product(cursor.getString(2));
        product.setIsstrikeout(Boolean.getBoolean(cursor.getString(3)));

        // return contact
        Log.d(LOG_TAG_ERROR, "getProduct OK " + " " + product.getName_product()+" "+product.getId());
        return product;

    }

    /*Product getStrikeStatusByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] { KEY_ID,
                        KEY_PRODUCT_NAME,IS_STRIKE_OUT }, KEY_PRODUCT_NAME + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product(Integer.parseInt(cursor.getString(0)),cursor.getString(1),Boolean.getBoolean(cursor.getString(2)));
        Log.d(LOG_TAG_ERROR, "getStrikeStatusByName OK " +product.getName_product() + product.IsStrikeout() );
        return product;
    }*/

    // Getting All Products
    public List<Product> getAllProducts() {
        List<Product> productsList = new ArrayList<Product>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(UUID.fromString(cursor.getString(1)));
                product.setName_product(cursor.getString(2));
                product.setIsstrikeout(Boolean.getBoolean(cursor.getString(3)));

                // Adding contact to list
                productsList.add(product);
            } while (cursor.moveToNext());
        }

        // return contact list
        return productsList;
    }

    // Updating single product
    public int updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, product.getName_product());
        values.put(IS_STRIKE_OUT,product.IsStrikeout());
        values.put(KEY_UUID_PRODUCT_NAME, String.valueOf(product.getId()));


        // updating row
        return db.update(TABLE_PRODUCTS, values, KEY_UUID_PRODUCT_NAME + " = ?",
                new String[] { String.valueOf(product.getId()) });
    }

    // Deleting single product
    public void deleteProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, KEY_UUID_PRODUCT_NAME + " = ?",
                new String[] { String.valueOf(product.getId()) });
        db.close();
    }


    // Getting products Count
    public int getProductsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
