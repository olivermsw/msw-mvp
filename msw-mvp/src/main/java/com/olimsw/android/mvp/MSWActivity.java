package com.olimsw.android.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.olimsw.android.mvp.reflect.PresenterBuilder;

public class MSWActivity<P extends MSWPresenter<? extends MSWView>> extends AppCompatActivity implements MSWView {
    private P mPresenterCache = null;

    public P getPresenter() {
        if (mPresenterCache == null) {
            mPresenterCache = PresenterBuilder.buildPresenterByReflect(this.getClass());
        }
        return mPresenterCache;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().attach(this);
        getPresenter().onAttached();
    }

    @Override
    protected void onDestroy() {
        getPresenter().onDetached();
        super.onDestroy();
    }
}
