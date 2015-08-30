package com.example.boytsov.foodbasket2;

import java.util.Date;

/**
 * Created by Boytsov on 30.08.2015.
 */

//Класс описывающий покупку
public class ProductItemList extends Product {
    String product_item_list_name;
    Date product_item_list_date;
    Product product_item;

    public ProductItemList(String product_item_list_name,String name_product) {
        super(name_product);
        this.product_item_list_name=product_item_list_name;
        this.product_item_list_date = new Date();
    }
    public ProductItemList(String product_item_list_name,Product product_item) {
        super(product_item);
        this.product_item_list_name=product_item_list_name;
        this.product_item_list_date = new Date();
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
}
