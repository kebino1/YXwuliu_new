package eo.cn.yxwuliu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import eo.cn.yxwuliu.R;


/**
 * 这个是首页时的头广告栏
 * Created by mk on 2017/4/1.
 */

public class ImagePagerAdapter extends RecyclingPagerAdapter {

    private Context       context;
    private List<Object> imageIdList;

    private int           size;
    private boolean       isInfiniteLoop;

    public ImagePagerAdapter(Context context, List<Object> imageIdList) {
        this.context = context;
        this.imageIdList = imageIdList;
        this.size = getSize(imageIdList);
        isInfiniteLoop = false;
    }

//    public ImagePagerAdapter(Context context, ArrayList<String> bannerViewList) {
//        this.context = context;
//        this.bannerViewList = bannerViewList;
//        this.size = getSize(bannerViewList);
//        isInfiniteLoop = false;
//    }

    @Override
    public int getCount() {
        // Infinite loop
        return isInfiniteLoop ? Integer.MAX_VALUE : getSize(imageIdList);
    }
    /**
     * get really position
     *
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return isInfiniteLoop ? position % size : position;
    }

    @Override
    public View getView(int position, View view, ViewGroup container) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = holder.imageView = new ImageView(context);
            holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context)
                .load(imageIdList.get(getPosition(position)))
                .placeholder(R.drawable.ic_launcher)
                .into(holder.imageView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        //holder.imageView.setImageResource((Integer) imageIdList.get(getPosition(position)));
        return view;
    }

    private static class ViewHolder {
        ImageView imageView;
    }

    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * @param isInfiniteLoop the isInfiniteLoop to set
     */
    public ImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }

    public static <V> int getSize(List<V> sourceList) {
        return sourceList == null ? 0 : sourceList.size();
    }
}
