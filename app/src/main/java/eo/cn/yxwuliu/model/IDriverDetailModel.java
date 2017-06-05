package eo.cn.yxwuliu.model;

import eo.cn.yxwuliu.bean.GoodsBean;

/**
 * 这个获取车主详情的接口
 * Created by Administrator on 2017/6/5.
 */

public interface IDriverDetailModel {
    /**
     * 根据id来获取更多数据
     * @param id
     * @param mOnGetDriverDetailData
     */
    void setOnGetDriverDetailData(String id, OnGetDriverDetailData mOnGetDriverDetailData);

    /**
     * 获取到数据后的操作
     */
    interface OnGetDriverDetailData{
//        void getDataSuccess(CarsBean carsBean);//获取数据后，需要把数据作为参数存入，以被使用
        void getDataSuccess(GoodsBean goodsBean);//暂时使用goodbean来测试
        void getDataFail(Object smg);
    }
}
