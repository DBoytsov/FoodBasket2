package com.example.boytsov.foodbasket2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import java.util.ArrayList;
import java.util.UUID;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.IconSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;

/**
 * Created by Boytsov on 28.08.2015.
 */
public class StartActivity extends ActionBarActivity {
    private Drawer.Result drawerResult = null;
    MaterialLargeImageCard card;
    ArrayList<Card> cards;
    ArrayList<BaseSupplementalAction> actions;
    CardArrayRecyclerViewAdapter mCardArrayAdapter;
    ProductItemList myProductItemList;
    CharSequence productListName;
    UUID myUUID;
    Product myProduct;
    final String LOG_TAG = "myLogs";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startactivity);
        init_navigation();
        init_card();
        mCardArrayAdapter.notifyDataSetChanged();
    }

    //Описание navigation draw
    private void init_navigation(){
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
                            startActivityForResult(intent, 1);
                        }

                    }
                })
                .build();
    }

    private void init_card(){
        // Set supplemental actions as icon
        cards = new ArrayList<Card>();
        actions = new ArrayList<BaseSupplementalAction>();

        IconSupplementalAction t1 = new IconSupplementalAction(this, R.id.ic1);
        t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(StartActivity.this, " Click on Text SHARE ", Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(t1);

        IconSupplementalAction t2 = new IconSupplementalAction(this, R.id.ic2);
        t2.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(StartActivity.this, " Click on Text LEARN ", Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(t2);

        card =
                MaterialLargeImageCard.with(this)
                        .setTextOverImage("Italian Beaches")
                        .useDrawableId(R.drawable.im_beach)
                        .setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon,actions )
                        .build();

        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(StartActivity.this, " Click on ActionArea ", Toast.LENGTH_SHORT).show();
                cards.add(card);
                mCardArrayAdapter.notifyDataSetChanged();
            }
        });

        cards.add(card);

        mCardArrayAdapter = new CardArrayRecyclerViewAdapter(this, cards);

        //оставить здесь
        CardRecyclerView mRecyclerView = (CardRecyclerView) this.findViewById(R.id.carddemo_recyclerview);

        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Оставить здесь.Set the empty view
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mCardArrayAdapter);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data==null){return;
    }
        productListName= (CharSequence) data.getStringExtra("header");
        myUUID=(UUID)data.getSerializableExtra("id");
        Log.d(LOG_TAG, "productListName+myUUID" +" "+ productListName+ " " +myUUID);
        cardCreate();

}
    public void cardCreate(){
        //ProductItemListArray.getProductItemList(idlist);
        //String my="ggg";

        card =
                MaterialLargeImageCard.with(this)
                        .setTextOverImage(productListName)
                        .useDrawableId(R.drawable.header)
                        .setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                        .build();
        cards.add(card);
        mCardArrayAdapter.notifyDataSetChanged();

    }
}
