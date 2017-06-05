package eo.cn.yxwuliu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import eo.cn.yxwuliu.R;
import eo.cn.yxwuliu.bean.GoodsBean;
import eo.cn.yxwuliu.holder.TypeItemSearchGoodHolder;

/**
 * 这是查询货源的适配器
 * Created by kebi on 2017/5/30.
 */

public class SearchGoodsAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> data;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private OnGoodIcoClickListener onGoodIcoClickListener;
    private OnGoodItemClickListener onGoodItemClickListener;
    private OnGoodBookClickListener onGoodBookClickListener;

    public SearchGoodsAdapter(List<T> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TypeItemSearchGoodHolder(mLayoutInflater.inflate(R.layout.item_search_good,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.e("数据", "onBindViewHolder: "+data.get(position) );
        ((TypeItemSearchGoodHolder)holder).bindHolder(mContext,(GoodsBean.DataBean) data.get(position) );
        //调转到详情
        holder.itemView.findViewById(R.id.second_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoodItemClickListener.itemClick(v,position);
            }
        });
        //调转到接单
        holder.itemView.findViewById(R.id.tv_book).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoodBookClickListener.bookClick(v,position);
            }
        });
        //调转到货主
        holder.itemView.findViewById(R.id.face_im).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoodIcoClickListener.icoClick(v,position);
            }
        });
    }

    /**
     * 当点击头像时
     */
    public interface OnGoodIcoClickListener{
        void icoClick(View view,int position);
    }

    /**
     * 当点击简介时
     */
    public interface OnGoodItemClickListener{
        void itemClick(View view,int position);
    }

    /**
     * 当点击接单时
     */
    public interface OnGoodBookClickListener{
        void bookClick(View view,int position);
    }

    public void setOnClickListener(OnGoodIcoClickListener onGoodIcoClickListener){
        this.onGoodIcoClickListener = onGoodIcoClickListener;
    }

    public void setOnClickListener(OnGoodItemClickListener onGoodItemClickListener){
        this.onGoodItemClickListener = onGoodItemClickListener;
    }

    public void setOnClickListener(OnGoodBookClickListener onGoodBookClickListener){
        this.onGoodBookClickListener = onGoodBookClickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
