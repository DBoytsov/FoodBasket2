package com.example.boytsov.foodbasket2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

/**
 * Created by Boytsov on 28.08.2015.
 */
public class StartActivity extends ActionBarActivity {
    private Drawer.Result drawerResult = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerResult =  new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_create).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),

                        //new SectionDrawerItem().withName(R.string.drawer_item_settings),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_cog),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_question).setEnabled(false),
                        //new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_android).withIdentifier(2)

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    // Обработка клика
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier()==1) {
                            Toast.makeText(StartActivity.this, StartActivity.this.getString(((Nameable) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(StartActivity.this,MainActivity.class);
                            startActivity(intent);
                        }

                    }
                })
                .build();
    }
}
