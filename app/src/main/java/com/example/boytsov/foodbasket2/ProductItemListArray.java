package com.example.boytsov.foodbasket2;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Boytsov on 02.09.2015.
 */
public class ProductItemListArray  {
    private ArrayList<ProductItemList> mProductItemList;
    private static ProductItemListArray sProductItemListArray;
    private Context mContext;

    private ProductItemListArray(Context appContext) {
        mContext = appContext;
        mProductItemList = new ArrayList<ProductItemList>();

         }

    public static ProductItemListArray get(Context c) {
        if (sProductItemListArray == null) {
            sProductItemListArray = new ProductItemListArray(c.getApplicationContext());
        }
        return sProductItemListArray;
    }

    public ArrayList<ProductItemList> getProductItemLists() {
        return mProductItemList;
    }

    public ProductItemList getProductItemList(UUID id) {
        for (ProductItemList c : mProductItemList) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
}
