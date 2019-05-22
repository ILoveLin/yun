package com.company.yun.ui.activity.ppt.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.company.yun.R;
import com.company.yun.bean.account.AccountBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 */
public class PPTAdapter extends RecyclerView.Adapter<PPTAdapter.ViewHolder> {


    public void setData(ArrayList<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int bean);
    }

    public ArrayList<String> datas = null;
    private ItemClickCallBack clickCallBack;

    private FragmentActivity activity;

    public PPTAdapter(ArrayList<String> datas, FragmentActivity activity) {
        this.datas = datas;
        this.activity = activity;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ppt, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        String url = datas.get(position);
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.bg_girl);
        options.error(R.mipmap.bg_girl);
        options.centerCrop();
        Glide.with(activity)
                .load(url)
                .apply(options)
                .into(viewHolder.iv_ppt_pic);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_ppt_pic;

        public ViewHolder(View view) {
            super(view);
            iv_ppt_pic = (ImageView) view.findViewById(R.id.iv_ppt_pic);
        }
    }
}





















