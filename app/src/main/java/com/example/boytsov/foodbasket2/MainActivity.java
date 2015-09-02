package com.example.boytsov.foodbasket2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//Класс описывающий создание списка

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{
    ArrayList<Product> products;
    ListAdapter myListAdapter;
    Product product,newpr;
    EditText editText,editText2;
    Button push;
    ListView lvMain;

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products= new ArrayList<Product>();
        myListAdapter=new ListAdapter(this,products);
        lvMain=(ListView)findViewById(R.id.listView);
        lvMain.setAdapter(myListAdapter);
        lvMain.setOnItemClickListener(this);
        lvMain.setOnItemLongClickListener(this);
        push=(Button)findViewById(R.id.button2);

        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);


        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString().trim();
                if (value.length()<=0 || value.equals("")) {
                    Toast.makeText(MainActivity.this,"Укажите название товара",Toast.LENGTH_SHORT).show();
                } else {

                product = new Product(editText.getText().toString());
                products.add(product);
                myListAdapter.notifyDataSetChanged();
                editText.setText(" ");
            }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_save:

                String header = editText2.getText().toString().trim();
                if (header.length()<=0 || header.equals("")) {
                    Toast.makeText(MainActivity.this,"Укажите название списка",Toast.LENGTH_SHORT).show();
                } else {
                ProductItemList myitemlist= new ProductItemList(editText2.getText().toString(),product);
                Log.d(LOG_TAG, "Description: " + myitemlist.toString());
                //Здесь мы должны передать id productItemList в startActivity, чтобы создать карточку
                    String idproductlist=myitemlist.getName();
                Log.d(LOG_TAG,"idproductlist"+ idproductlist);
                //Заглушка
                Intent intent=new Intent();
                intent.putExtra("idproductlist",idproductlist);
                    setResult(RESULT_OK, intent);
                finish();}
                break;
            case R.id.action_settings:
                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        newpr=myListAdapter.getProduct(position);
        if (newpr.IsStrikeout()){
            newpr.setIsstrikeout(false);
            Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();}
        else {
            newpr.setIsstrikeout(true);
            Toast.makeText(this, "Куплено", Toast.LENGTH_SHORT).show();
        }

        myListAdapter.notifyDataSetChanged();


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        products.remove(position);
        myListAdapter.notifyDataSetChanged();
        return true;
    }
}
