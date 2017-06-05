package eo.cn.yxwuliu.view;

import eo.cn.yxwuliu.bean.GoodsBean;

/**
 * 这个是车主详情
 * Created by Administrator on 2017/6/1.
 */

public interface IDriverDetailActivityView {
    /**
     * 获取id
     * @return
     */
    String getDriverID();

//    void getSuccessData(CarsBean carsBean);//获取数据成功时的回调
    void getSuccessData(GoodsBean goodsBean);//暂时使用goodbean测试

    void getDataFail(Object smg);//获取数据失败
}
