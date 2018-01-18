package com.cqticket.myapplication;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

/**
 * Created by ruxing on 2018/1/11.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private List<Data> dataList;

    public MyAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        if (holder.et_name.getTag() != null && holder.et_name.getTag() instanceof TextWatcher) {
            holder.et_name.removeTextChangedListener((TextWatcher) holder.et_name.getTag());
        }
        holder.et_name.setText(dataList.get(position).getName());
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                dataList.get(position).setName(s.toString());
            }
        };
        holder.et_name.addTextChangedListener(textWatcher);
        holder.et_name.setTag(textWatcher);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        EditText et_name;

        public MyHolder(View itemView) {
            super(itemView);
            et_name = itemView.findViewById(R.id.et_name);
        }
    }

}
