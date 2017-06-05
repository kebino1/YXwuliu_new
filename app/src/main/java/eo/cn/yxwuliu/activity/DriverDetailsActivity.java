package eo.cn.yxwuliu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eo.cn.yxwuliu.R;
import eo.cn.yxwuliu.base.BaseMvpActivity;
import eo.cn.yxwuliu.bean.GoodsBean;
import eo.cn.yxwuliu.presenter.DriverDetailPresenter;
import eo.cn.yxwuliu.view.IDriverDetailActivityView;

/**
 * 这个是车主详情界面
 * 根据简介界面的传入发布人的信息来获取更多的信息并且显示出来
 * Created by Administrator on 2017/6/2.
 */

public class DriverDetailsActivity extends BaseMvpActivity<IDriverDetailActivityView, DriverDetailPresenter> implements IDriverDetailActivityView {

    @BindView(R.id.ll_back)
    LinearLayout mLlBack;
    @BindView(R.id.JoinTheBlacklist)
    Button mJoinTheBlacklist;
    @BindView(R.id.addFriends)
    Button mAddFriends;
    private String driverId;

    /**
     * 通过此方法跳转此页面
     *
     * @param context
     * @param driverId 这个是被点击到的发布者信息的ID
     */
    public static void actionStart(Context context, String driverId) {
        Intent intent = new Intent(context, DriverDetailsActivity.class);
        intent.putExtra("driverId", driverId);//车主信息id
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_driver_detail;
    }

    @Override
    public DriverDetailPresenter initPresenter() {
        return new DriverDetailPresenter(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        driverId = intent.getStringExtra("driverId");
        presenter.getDriverDetail();
    }

    @Override
    public void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public String getDriverID() {
        return driverId;
    }

    @Override
    public void getSuccessData(GoodsBean goodsBean) {
        //数据显示,暂时使用goodbean测试
    }

    @Override
    public void getDataFail(Object smg) {

    }

    @OnClick({R.id.ll_back, R.id.JoinTheBlacklist, R.id.addFriends})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.JoinTheBlacklist:
                Toast.makeText(this, "拉黑了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addFriends:
                Toast.makeText(this, "我宣你", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
