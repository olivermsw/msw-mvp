package com.olimsw.android.mvp.reflect;

import com.olimsw.android.mvp.MSWPresenter;
import com.olimsw.android.mvp.MSWView;
import com.olimsw.android.mvp.annotation.InjectPresenter;

public final class PresenterBuilder {
    public static <V extends MSWView, P extends MSWPresenter<?>> P buildPresenterByReflect(Class<V> viewClass) {
        InjectPresenter annotation = viewClass.getAnnotation(InjectPresenter.class);
        try {
            //noinspection unchecked
            Class<P> value = (Class<P>) annotation.value();
            return value.newInstance();
        } catch (IllegalAccessException | InstantiationException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
