package com.jaydon.listenbooks.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jaydon.listenbooks.R;
import com.jaydon.listenbooks.activity.DetailActivity;
import com.jaydon.listenbooks.bean.DataBean;
import com.jaydon.listenbooks.utils.Tools;
import com.skydoves.transformationlayout.TransformationCompat;
import com.skydoves.transformationlayout.TransformationLayout;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<DataBean> mDatas;
    Intent intent;

    public RecyclerAdapter(Context context, List<DataBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position).title);
        Glide.with(mContext).load(mDatas.get(position).imageUrl).into(holder.img);
        holder.item_poster_line_transformationLayout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onClick(View view) {
//        Tools.setToastShow(view.getContext(), "被点击");
        intent = new Intent(view.getContext(), DetailActivity.class);
        TransformationCompat.startActivity((TransformationLayout) new MyViewHolder(view).item_poster_line_transformationLayout, intent);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public View item_poster_line_transformationLayout;
        public AppCompatTextView tv;
        public AppCompatImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.item_poster_title);
            item_poster_line_transformationLayout = view.findViewById(R.id.item_poster_line_transformationLayout);
            img = view.findViewById(R.id.item_poster_img);
        }
    }
}