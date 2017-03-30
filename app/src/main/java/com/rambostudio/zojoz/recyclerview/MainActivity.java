package com.rambostudio.zojoz.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rambostudio.zojoz.recyclerview.adapter.HomeViewHolderAdapter;
import com.rambostudio.zojoz.recyclerview.model.Home;
import com.rambostudio.zojoz.recyclerview.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HomeViewHolderAdapter mAdapter;
    private List<Home> mMockUpHomeDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMockUpData();
        findView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mAdapter = new HomeViewHolderAdapter(mMockUpHomeDatas);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void findView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    }

    private void initMockUpData() {
        mMockUpHomeDatas = getMockupData();
    }


    public List<Home> getMockupData() {
        List<Home> homeList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<Person> personList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                personList.add(new Person("Person " + j));
            }
            homeList.add(new Home("Home no. : " + i, personList));
        }
        return homeList;
    }
}
