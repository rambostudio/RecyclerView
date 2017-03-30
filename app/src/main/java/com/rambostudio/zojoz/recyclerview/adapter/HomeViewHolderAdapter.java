package com.rambostudio.zojoz.recyclerview.adapter;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rambostudio.zojoz.recyclerview.CollectionIndexUtils;
import com.rambostudio.zojoz.recyclerview.R;
import com.rambostudio.zojoz.recyclerview.listener.HomeRecyclerItemClickListener;
import com.rambostudio.zojoz.recyclerview.model.Home;

import java.util.List;

/**
 * Created by rambo on 30/3/2560.
 */

public class HomeViewHolderAdapter extends RecyclerView.Adapter<HomeViewHolderAdapter.HomeViewHolder> {
    List<Home> mDatas;

    public HomeViewHolderAdapter(List<Home> homeList) {
        this.mDatas = homeList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
//Bind Data from onCreateViewHolder
        if (CollectionIndexUtils.isAvailableData(mDatas, position)) {
            holder.setHomeTitle(mDatas.get(position).getTitle());
            holder.bindData(mDatas.get(position));


            holder.setOnClickListener(new HomeRecyclerItemClickListener() {
                @Override
                public void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent) {
                    if (view.getId() == R.id.button_item_home_add_person) {
//                    List<Person> personList = new ArrayList<Person>();
//                    personList.add(new Person("Person 1"));
//                    Home home = new Home("Home " + (mDatas.size() + 1), personList);
//                    insert(mDatas.size(), home);
                        Log.d("Home position", "Home position =" + position);
                    } else {

                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void insert(int position, Home home) {
        mDatas.add(home);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

        RecyclerView recyclerViewPerson;
        TextView tvTitle;
        Button btnAddPerson;
        private HomeRecyclerItemClickListener homeRecyclerItemClickListener;

        public HomeViewHolder(View itemView) {
            super(itemView);

            //FindViewById
            tvTitle = (TextView) itemView.findViewById(R.id.textview_item_home_title);
            btnAddPerson = (Button) itemView.findViewById(R.id.button_item_home_add_person);
            recyclerViewPerson = (RecyclerView) itemView.findViewById(R.id.recyclerview_item_home_person);


            btnAddPerson.setOnClickListener(this);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


            recyclerViewPerson.setLayoutManager(new LinearLayoutManager(itemView.getContext()){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            recyclerViewPerson.addItemDecoration(new DividerItemDecoration(itemView.getContext(), DividerItemDecoration.VERTICAL));
        }

        public void setOnClickListener(HomeRecyclerItemClickListener itemClickListener) {
            this.homeRecyclerItemClickListener = itemClickListener;
        }

        public void setHomeTitle(String name) {
            tvTitle.setText(name);
        }

        public void bindData(Home home) {
            if (null != home) {
                tvTitle.setText(home.getTitle());
                if (null != home.getPersonList()) {
                    recyclerViewPerson.setAdapter(new PersonRecyclerAdapter(home.getPersonList()));
                }
            }
        }

        @Override
        public void onClick(View view) {
            homeRecyclerItemClickListener.onClick(view, getAdapterPosition(), false, null);
//        if (view.getId() == R.id.btnAddPerson) {
//            Toast.makeText(view.getContext(), "Press Home = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
//            HomeViewHolderAdapter adapter = new HomeViewHolderAdapter();
//        }
        }

        @Override
        public boolean onLongClick(View view) {
            homeRecyclerItemClickListener.onClick(view, getAdapterPosition(), true, null);
            return true;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            homeRecyclerItemClickListener.onClick(view, getAdapterPosition(), false, motionEvent);
            return true;
        }
    }

}
