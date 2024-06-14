package com.example.pharmassist.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmassist.MainActivity;
import com.example.pharmassist.R;
import com.example.pharmassist.store.Adapter.CategoryAdapter;
import com.example.pharmassist.store.Adapter.DealsAdapter;
import com.example.pharmassist.store.Adapter.OfferAdapter;
import com.example.pharmassist.store.Model.CategoryModel;
import com.example.pharmassist.store.Model.DealsModel;
import com.example.pharmassist.store.Model.OfferModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    RecyclerView offers;
    RecyclerView rvCategories,rv_deals;
    private List<OfferModel> offerModelList = new ArrayList<>();
    private List<DealsModel> dealsModelList = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_page);

        //OnClicklistener for the view flipper
        ViewFlipper flipper = findViewById(R.id.flipper);
        flipper.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v) {
           Intent intent = new Intent(OrderPage.this, OrderActivity.class);
            startActivity(intent);
           }});



        //RecyclerView for offer starts here
        offerModelList.add(new OfferModel(R.drawable.convinience,"R50 CashBack","For any order above R500"));
        offerModelList.add(new OfferModel(R.drawable.ic_medicine,"Liquid Medicine","From as little as R50"));
        offerModelList.add(new OfferModel(R.drawable.ic_first_aid,"R500 first aid","Get it now as this is our limited edition offer"));

        offers =findViewById(R.id.offers);
        OfferAdapter offerAdapter = new OfferAdapter(this,offerModelList);
        offers.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(this,1,RecyclerView.HORIZONTAL,false);
        offers.setLayoutManager(manager);
        offers.setItemAnimator(new DefaultItemAnimator());
        offers.setAdapter(offerAdapter);

    //Categories products start here
       List<CategoryModel> categoryModelList= new ArrayList<>();
       categoryModelList.add(new CategoryModel(R.drawable.ic_medicine,"Medicine"));
       categoryModelList.add(new CategoryModel(R.drawable.ic_pills,"Tablets"));
       categoryModelList.add(new CategoryModel(R.drawable.ic_patch,"Patches"));
       categoryModelList.add(new CategoryModel(R.drawable.ic_first_aid,"Kits"));
       categoryModelList.add(new CategoryModel(R.drawable.ic_jar,"Combos"));


        rvCategories =findViewById(R.id.categories);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoryModelList);
        rvCategories.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1,RecyclerView.HORIZONTAL,false);
        rvCategories.setLayoutManager(layoutManager);
        rvCategories.setItemAnimator(new DefaultItemAnimator());
        rvCategories.setAdapter(categoryAdapter);

        //Set up the discounted deals
        dealsModelList.add(new DealsModel(R.drawable.ic_offer,"Healing Trio Offer","Premium","12 Months","R 200","R 279","-39,5%"));
        dealsModelList.add(new DealsModel(R.drawable.nurofen,"Cure the period pain ","Premium","12 Months","R 37,50","R 50","-25%"));
        dealsModelList.add(new DealsModel(R.drawable.offer2,"Pain Relief at best!","Premium","12 Months","R215,10","R239","-10%"));
        dealsModelList.add(new DealsModel(R.drawable.ic_offer,"Healing Trio Offer","Premium","12 Months","R200","R279","39,5%"));
        dealsModelList.add(new DealsModel(R.drawable.nurofen,"Cure the period pain ","Premium","12 Months","R 37,50","R 50","-25%"));
        dealsModelList.add(new DealsModel(R.drawable.offer2,"Pain Relief at best!","Premium","12 Months","R215,10","R239","-10%"));

        rv_deals =findViewById(R.id.rv_deals);
        DealsAdapter dealsAdapter = new DealsAdapter(this,dealsModelList);
        rv_deals.setHasFixedSize(true);
        GridLayoutManager Manager = new GridLayoutManager(this,1,RecyclerView.HORIZONTAL,false);
        rv_deals.setLayoutManager(Manager);
        rv_deals.setItemAnimator(new DefaultItemAnimator());
        rv_deals.setAdapter(dealsAdapter);

        //Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.back) {
                    startActivity(new Intent(OrderPage.this, MainActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.forward) {
                    startActivity(new Intent(OrderPage.this, OrderActivity.class));
                    return true;
                }
                return false;
            }
        });

        //Dropdown for searchbar


    }
}
