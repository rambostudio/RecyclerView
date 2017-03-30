package com.rambostudio.zojoz.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rambostudio.zojoz.recyclerview.R;
import com.rambostudio.zojoz.recyclerview.listener.HomeRecyclerItemClickListener;
import com.rambostudio.zojoz.recyclerview.model.Home;
import com.rambostudio.zojoz.recyclerview.model.Person;
import com.rambostudio.zojoz.recyclerview.view.HomeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rambo on 30/3/2560.
 */

public class HomeViewHolderAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    List<Home> homeList;
    public HomeViewHolderAdapter(List<Home> homeList) {
        this.homeList = homeList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_home, parent, false);

        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
//Bind Data from onCreateViewHolder
        holder.setHomeTitle(homeList.get(position).getTitle());

        holder.setOnClickListener(new HomeRecyclerItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent) {
                if (view.getId() == R.id.btnAddPerson) {
//                    List<Person> personList = new ArrayList<Person>();
//                    personList.add(new Person("Person 1"));
//                    Home home = new Home("Home " + (homeList.size() + 1), personList);
//                    insert(homeList.size(), home);
                    Log.d("Home position", "Home position =" + position);
//                    Toast.makeText(view.getContext(), position, Toast.LENGTH_LONG).show();
                } else {
//                    remove(position);
//                    Log.d("remove position", "remove position =" + position);
                }
            }
        });
//
//        View personView =  LayoutInflater.from()
//                .inflate(R.layout.list_item_person, parent, false);
//
//        LinearLayout ll = (LinearLayout) view.findViewById(R.id.person_area);
//        if (homeList.get()) {
//        }
//        ll.addView(personView);
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public void insert(int position, Home home) {
        homeList.add(home);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        homeList.remove(position);
        notifyItemRemoved(position);
    }

}
