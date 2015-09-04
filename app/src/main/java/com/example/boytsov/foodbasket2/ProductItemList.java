package com.example.boytsov.foodbasket2;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Boytsov on 30.08.2015.
 */

//Класс описывающий покупку, содержит массив класса "продукт"
public class ProductItemList {
    UUID mId;
    String product_item_list_name;
    Date product_item_list_date;
    ArrayList<Product> mProducts;

    public ProductItemList(String product_item_list_name) {

        this.product_item_list_name=product_item_list_name;
        this.product_item_list_date = new Date();
        mId = UUID.randomUUID();
        mProducts=new ArrayList<Product>();
    }
    public ProductItemList(String product_item_list_name,Product product_item) {
        this.product_item_list_name=product_item_list_name;
        this.product_item_list_date = new Date();
        mId = UUID.randomUUID();
        mProducts=new ArrayList<Product>();
        mProducts.add(product_item);
    }

    public ProductItemList(String product_item_list_name,ArrayList<Product> arrayProducts) {
        this.product_item_list_name=product_item_list_name;
        this.product_item_list_date = new Date();
        mId = UUID.randomUUID();
        mProducts=arrayProducts;

    }

    public Date getDate() {
        return product_item_list_date;
    }

    public void setDate(Date date) {
        product_item_list_date = date;
    }

    @Override
    public String toString() {
        String about=product_item_list_name+" "+product_item_list_date;
        return about;
    }


    public UUID getId() {
        return mId;
    }
    public String getName(){

        return product_item_list_name;
    }

    public Product getProducts (UUID id){
        for (Product c : mProducts) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

    public void addProduct(Product c) {
        mProducts.add(c);
    }

}
