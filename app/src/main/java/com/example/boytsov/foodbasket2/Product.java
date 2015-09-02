package com.example.boytsov.foodbasket2;

import java.util.UUID;

/**
 * Created by Boytsov on 09.08.2015.
 */

//Объектная модель. Класс "Продукт"
public class Product {
    String name_product;
    private UUID mId;
    Boolean isstrikeout=false;



    public Product(String name_product){
        this.name_product=name_product;
        this.isstrikeout=false;
        mId = UUID.randomUUID();
    }
    public Product(Product my_product){
        this.name_product=my_product.getName_product();
        this.isstrikeout=false;
        mId = UUID.randomUUID();
    }
    public Product(int id,String name_product){
        this.name_product=name_product;
        mId = UUID.randomUUID();
        this.isstrikeout=false;
    }
    public Product(int id,String name_product,Boolean isstrikeout){
        this.name_product=name_product;
        mId = UUID.randomUUID();
        this.isstrikeout=isstrikeout;
    }

    public String getName_product() {
        return name_product;
    }
    public UUID getId() {
        return mId;
    }

    public void setID_product(UUID id) {
        mId=id;
    }
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }
    public void setIsstrikeout(boolean isstrikeout){
        this.isstrikeout=isstrikeout;
    }
    public boolean IsStrikeout(){
        return isstrikeout;
    }
    public boolean IsStrikeoutByName(String name_product){

        return isstrikeout;
    }
}

