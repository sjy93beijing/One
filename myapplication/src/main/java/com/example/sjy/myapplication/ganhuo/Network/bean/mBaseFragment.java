package com.example.sjy.myapplication.ganhuo.Network.bean;

import android.app.AlertDialog;
import android.support.v4.app.Fragment;

import com.example.sjy.myapplication.R;

import butterknife.OnClick;
import rx.Subscription;

/**
 * Created by sjy_1993 on 2017/3/11.
 */
public abstract class mBaseFragment extends Fragment{
    protected Subscription subscription;

    @OnClick(R.id.tipBt)
    void tip() {
        new AlertDialog.Builder(getActivity())
                .setTitle(getTitleRes())
                .setView(getActivity().getLayoutInflater().inflate(getDialogRes(), null))
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected abstract int getDialogRes();

    protected abstract int getTitleRes();
}
