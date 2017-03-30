package com.rambostudio.zojoz.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rambostudio.zojoz.recyclerview.adapter.HomeViewHolderAdapter;
import com.rambostudio.zojoz.recyclerview.model.Home;
import com.rambostudio.zojoz.recyclerview.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    HomeViewHolderAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<Home> homeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HomeViewHolderAdapter(homeList);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void initData() {
        homeList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Person 1"));
        homeList.add(new Home("Home 1", personList));
        homeList.add(new Home("Home 2", personList));
        homeList.add(new Home("Home 3", personList));
        homeList.add(new Home("Home 4", personList));
        homeList.add(new Home("Home 5", personList));
        homeList.add(new Home("Home 6", personList));
    }
}
