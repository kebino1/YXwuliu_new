package eo.cn.yxwuliu.model;

import java.util.ArrayList;
import java.util.List;

import eo.cn.yxwuliu.base.BaseModel;
import eo.cn.yxwuliu.bean.GoodsBean;
import eo.cn.yxwuliu.http.FilterSubscriber;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/5.
 */

public class DriverDetailModelImpl extends BaseModel implements IDriverDetailModel {


    public DriverDetailModelImpl(boolean isCache) {
        super(isCache);
    }

    /**
     * 请求车主的详细信息
     * @param id
     * @param mOnGetDriverDetailData
     */
    @Override
    public void setOnGetDriverDetailData(String id, final OnGetDriverDetailData mOnGetDriverDetailData) {
        Observable<GoodsBean> getDriver = iHttpInterface.getDriver("1", "1");
        getDriver.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FilterSubscriber<GoodsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mOnGetDriverDetailData.getDataFail(error);
                    }

                    @Override
                    public void onNext(GoodsBean goodsBean) {
                        if (goodsBean.getData() != null) {
                            mOnGetDriverDetailData.getDataSuccess(goodsBean);
                        } else {
                            mOnGetDriverDetailData.getDataFail(goodsBean.getInfo()+"服务器");
                        }
                    }
                });
    }
}
