package com.example.boytsov.foodbasket2;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Boytsov on 09.08.2015.
 */

//Объектная модель. Класс "Продукт"
public class Product implements Serializable {
    String name_product;
    private UUID mId;
    Boolean isstrikeout=false;



    public Product(){
        mId = UUID.randomUUID();
    }
    public Product(String name_product){
        this.name_product=name_product;
        this.isstrikeout=false;
        mId = UUID.randomUUID();
    }
    public Product(Product my_product){
        this.name_product=my_product.getName_product();
        this.isstrikeout=my_product.IsStrikeout();
        mId = UUID.randomUUID();
    }

    public Product(UUID id,String name_product,Boolean strike) {
        this.name_product = name_product;
        this.isstrikeout = strike;
        mId = id;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getName_product() {
        return name_product;
    }
    public UUID getId() {
        return mId;
    }
    public void setId(UUID id) {
        this.mId=id;
    }

    public void setIsstrikeout(boolean isstrikeout){
        this.isstrikeout=isstrikeout;
    }
    public boolean IsStrikeout(){
        return isstrikeout;
    }



}

