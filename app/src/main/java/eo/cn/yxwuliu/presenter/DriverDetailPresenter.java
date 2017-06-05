package eo.cn.yxwuliu.presenter;

import eo.cn.yxwuliu.base.BasePresenter;
import eo.cn.yxwuliu.bean.GoodsBean;
import eo.cn.yxwuliu.model.CarDetailModelImpl;
import eo.cn.yxwuliu.model.DriverDetailModelImpl;
import eo.cn.yxwuliu.model.ICarDetailModel;
import eo.cn.yxwuliu.model.IDriverDetailModel;
import eo.cn.yxwuliu.view.ICarDetailActivityView;
import eo.cn.yxwuliu.view.IDriverDetailActivityView;

/**
 * 这个是连接model和view的逻辑处理
 * Created by Administrator on 2017/6/5.
 */

public class DriverDetailPresenter extends BasePresenter<IDriverDetailActivityView>{

    public IDriverDetailActivityView mIDriverDetailActivityView;
    public IDriverDetailModel mIDriverDetailModel = new DriverDetailModelImpl(false);

    public DriverDetailPresenter(IDriverDetailActivityView mIDriverDetailActivityView) {
        this.mIDriverDetailActivityView = mIDriverDetailActivityView;
    }

    public void getDriverDetail(){
        if (mIDriverDetailModel != null) {
            mIDriverDetailModel.setOnGetDriverDetailData(mIDriverDetailActivityView.getDriverID()
                    , new IDriverDetailModel.OnGetDriverDetailData() {
                        @Override
                        public void getDataSuccess(GoodsBean goodsBean) {
                            mIDriverDetailActivityView.getSuccessData(goodsBean);
                        }

                        @Override
                        public void getDataFail(Object smg) {
                            mIDriverDetailActivityView.getDataFail(smg);
                        }
                    });
        }
    }

}
