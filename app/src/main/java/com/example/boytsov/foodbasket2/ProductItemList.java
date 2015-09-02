package com.example.boytsov.foodbasket2;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Boytsov on 30.08.2015.
 */

//Класс описывающий покупку
public class ProductItemList extends Product {
    UUID mId;
    String product_item_list_name;
    Date product_item_list_date;
    private ArrayList<Product> mProducts;
    private static ProductItemList sProductItemList;
    private Context mContext;

    public ProductItemList(String product_item_list_name,String name_product) {
        super(name_product);
        this.product_item_list_name=product_item_list_name;
        this.product_item_list_date = new Date();
        mId = UUID.randomUUID();
    }
    public ProductItemList(String product_item_list_name,Product product_item) {
        super(product_item);
        this.product_item_list_name=product_item_list_name;
        this.product_item_list_date = new Date();
        mId = UUID.randomUUID();
    }

    public Date getDate() {
        return product_item_list_date;
    }

    public void setDate(Date date) {
        product_item_list_date = date;
    }

    @Override
    public String toString() {
        String about=product_item_list_name+" "+product_item_list_date+" "+super.getName_product()+" "+super.IsStrikeout();
        return about;
    }


    public UUID getId() {
        return mId;
    }
    public String getName(){

        return product_item_list_name;
    }
    public Date getDateById(){
        return product_item_list_date;
    }
    public Product getProducts (UUID id){
        for (Product c : mProducts) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

}
