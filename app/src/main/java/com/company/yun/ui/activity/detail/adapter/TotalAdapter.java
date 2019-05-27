package com.company.yun.ui.activity.detail.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.bean.account.TotalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 * DetailTotalBean.DataEntity data
 */
public class TotalAdapter extends RecyclerView.Adapter<TotalAdapter.ViewHolder> {
    public void setData(ArrayList<TotalBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    //类型,shows:展现,consume:消费,click:点击量,click_rate:点击率,click_price:
    private String type = "click";

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(ArrayList<TotalBean> type, int position);
    }

    public ArrayList<TotalBean> datas = null;
    private ItemClickCallBack clickCallBack;

    private FragmentActivity activity;

    public TotalAdapter(ArrayList<TotalBean> datas, FragmentActivity activity) {
        this.datas = datas;
        this.activity = activity;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail_top, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        Log.e("viewHolder", "=====position======" + position);
        Log.e("viewHolder", "===========" + datas.get(position));
        final TotalBean totalBean = datas.get(position);
        String data = totalBean.getData();
        boolean selected = totalBean.isSelected();
        String text = totalBean.getText();

        viewHolder.item_tv_top.setText(text);
        viewHolder.item_tv_under.setText(data);
        if (selected) {
            viewHolder.mLinearLayout.setSelected(true);
        }

//        String s1 = datas.get(position);
//        switch (position+1) {
//            case 1:
//                this.type = "consume";
//                viewHolder.item_tv_top.setText("总消费");
//                viewHolder.item_tv_under.setText(s1+"");
//                break;
//            case 2:
//                this.type = "shows";
//                viewHolder.item_tv_top.setText("总展现");
//                viewHolder.item_tv_under.setText(s1+"");
//                break;
//            case 3:
//                this.type = "click";
//                viewHolder.item_tv_top.setText("总点击");
//                viewHolder.item_tv_under.setText(s1+"");
//                break;
//            case 4:
//                this.type = "click_rate";
//                viewHolder.item_tv_top.setText("总点击率");
//                viewHolder.item_tv_under.setText(s1+"");
//                break;
//            case 5:
//                this.type = "click_price";
//                viewHolder.item_tv_top.setText("总平均点击价格");
//                viewHolder.item_tv_under.setText(s1+"");
//                break;
//
//        }
        viewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallBack.onItemClick(datas,position);
            }
        });


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
        public TextView item_tv_top;
        public TextView item_tv_under;
        public LinearLayout mLinearLayout;

        public ViewHolder(View view) {
            super(view);
            item_tv_top = (TextView) view.findViewById(R.id.item_tv_top);
            item_tv_under = (TextView) view.findViewById(R.id.item_tv_under);
//            //图片
            mLinearLayout = (LinearLayout) view.findViewById(R.id.item_detail_top);
        }
    }
}





















