package com.example.boytsov.foodbasket2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Boytsov on 04.09.2015.
 */
public class ReadyListActivity extends AppCompatActivity {
    TextView header_readylist;
    ListView listView_readylist;
    EditText editMoney_readylist;
    Button moneyOk_readylist;
    ListAdapter myListAdapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readylist);
        header_readylist=(TextView)findViewById(R.id.header_readylist);
        listView_readylist=(ListView)findViewById(R.id.listview_readylist);
        editMoney_readylist=(EditText)findViewById(R.id.editMoney_readylist);
        moneyOk_readylist=(Button)findViewById(R.id.moneyOk_readylist);


        moneyOk_readylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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


                    finish();
                break;
            case R.id.action_settings:
                return true;

        }


        return super.onOptionsItemSelected(item);
    }
}
