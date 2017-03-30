package com.rambostudio.zojoz.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rambostudio.zojoz.recyclerview.CollectionIndexUtils;
import com.rambostudio.zojoz.recyclerview.R;
import com.rambostudio.zojoz.recyclerview.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SoftBaked on 3/30/2017 AD.
 */

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.ViewHolder> {

    private List<Person> mDatas = new ArrayList<>();

    public PersonRecyclerAdapter(List<Person> datas) {
        replaceDatas(datas);
    }

    public void replaceDatas(List<Person> datas) {
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public PersonRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_person_item, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonRecyclerAdapter.ViewHolder holder, int position) {
        if (CollectionIndexUtils.isAvailableData(mDatas, position)) {
            holder.bindData(mDatas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return CollectionIndexUtils.getSize(mDatas);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.textview_person_item_title);
        }

        public void bindData(Person data) {
            if (null != data) {
                tvTitle.setText(data.getName());
            }
        }
    }
}
