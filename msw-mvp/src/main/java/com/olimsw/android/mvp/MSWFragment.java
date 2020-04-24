package com.olimsw.android.mvp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.olimsw.android.mvp.reflect.PresenterBuilder;

public class MSWFragment<P extends MSWPresenter<? extends MSWView>> extends Fragment implements MSWView {
    private P mPresenterCache = null;

    public P getPresenter() {
        if (mPresenterCache == null) {
            mPresenterCache = PresenterBuilder.buildPresenterByReflect(this.getClass());
        }
        return mPresenterCache;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().attach(this);
        getPresenter().onAttached();
    }

    @Override
    public void onDestroyView() {
        getPresenter().onDetached();
        super.onDestroyView();
    }
}
