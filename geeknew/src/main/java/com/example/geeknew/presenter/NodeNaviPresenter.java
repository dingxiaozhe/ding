package com.example.geeknew.presenter;

import com.example.geeknew.base.BasePresenter;
import com.example.geeknew.bean.V2ExBean;
import com.example.geeknew.model.NodeNaviModel;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.util.ToastUtil;
import com.example.geeknew.view.NodeNaviView;

public class NodeNaviPresenter extends BasePresenter<NodeNaviView>{
    private NodeNaviModel nodeNaviModel;
    @Override
    protected void initModel() {
        nodeNaviModel=new NodeNaviModel();
        mModels.add(nodeNaviModel);
    }
    public void getNode() {
        nodeNaviModel.getNode(new ResultCallBack<V2ExBean>() {
            @Override
            public void onSuccess(V2ExBean bean) {
                if (bean!=null&&bean.getData().size()>0){
                    mMvpView.updateNode(bean.getData());
                }
            }

            @Override
            public void onFail(String msg) {

                ToastUtil.showLong(msg);
            }
        });
    }
}
