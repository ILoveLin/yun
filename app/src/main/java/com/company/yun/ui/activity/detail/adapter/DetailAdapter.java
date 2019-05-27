package com.company.yun.ui.activity.detail.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.yun.R;
import com.company.yun.bean.account.DetailListBean;
import com.company.yun.bean.account.DetailTotalBean;
import com.company.yun.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 * DetailTotalBean.DataEntity data
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {
    public void setData(ArrayList<DetailListBean.DataEntity.TableEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    //类型,shows:展现,consume:消费,click:点击量,click_rate:点击率,click_price:
    private String type = "click";

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(String type);
    }

    public ArrayList<DetailListBean.DataEntity.TableEntity> datas = null;
    private ItemClickCallBack clickCallBack;

    private FragmentActivity activity;

    public DetailAdapter(ArrayList<DetailListBean.DataEntity.TableEntity> datas, FragmentActivity activity) {
        this.datas = datas;
        this.activity = activity;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_account_detail_top, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        DetailListBean.DataEntity.TableEntity tableEntity = datas.get(position);

        viewHolder.tv_item_time.setText(tableEntity.getDdate());
        viewHolder.tv_item_show.setText(tableEntity.getShows());
        viewHolder.tv_item_click.setText(tableEntity.getClick());
        viewHolder.tv_item_xiaofei.setText(tableEntity.getConsume());
        viewHolder.tv_item_click_rare.setText(tableEntity.getClick_rate());
        viewHolder.tv_item_click_price.setText(tableEntity.getClick_price());

        viewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        public TextView tv_item_time;
        public TextView tv_item_show;
        public TextView tv_item_click;
        public TextView tv_item_xiaofei;
        public TextView tv_item_click_rare;
        public TextView tv_item_click_price;
        public LinearLayout mLinearLayout;

        public ViewHolder(View view) {
            super(view);
            tv_item_time = (TextView) view.findViewById(R.id.tv_item_time);
            tv_item_show = (TextView) view.findViewById(R.id.tv_item_show);
            tv_item_click = (TextView) view.findViewById(R.id.tv_item_click);
            tv_item_xiaofei = (TextView) view.findViewById(R.id.tv_item_xiaofei);
            tv_item_click_rare = (TextView) view.findViewById(R.id.tv_item_click_rare);
            tv_item_click_price = (TextView) view.findViewById(R.id.tv_item_click_price);
//            //图片
            mLinearLayout = (LinearLayout) view.findViewById(R.id.linear_total);
        }
    }
}





















