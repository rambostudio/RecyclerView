package com.rambostudio.zojoz.recyclerview.view;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rambostudio.zojoz.recyclerview.R;
import com.rambostudio.zojoz.recyclerview.adapter.HomeViewHolderAdapter;
import com.rambostudio.zojoz.recyclerview.listener.HomeRecyclerItemClickListener;

/**
 * Created by rambo on 30/3/2560.
 */

public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener,View.OnTouchListener {

    TextView tvTitle;
    Button btnAddPerson;
    private HomeRecyclerItemClickListener homeRecyclerItemClickListener;
    public HomeViewHolder(View itemView) {
        super(itemView);

        //FindViewById
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        btnAddPerson = (Button) itemView.findViewById(R.id.btnAddPerson);
        btnAddPerson.setOnClickListener(this);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setOnClickListener(HomeRecyclerItemClickListener itemClickListener) {
        this.homeRecyclerItemClickListener = itemClickListener;
    }

    public void setHomeTitle(String name) {
        tvTitle.setText(name);
    }

    @Override
    public void onClick(View view) {
        homeRecyclerItemClickListener.onClick(view,getAdapterPosition(),false,null);
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
