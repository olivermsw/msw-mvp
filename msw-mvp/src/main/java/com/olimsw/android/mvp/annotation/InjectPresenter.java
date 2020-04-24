package com.olimsw.android.mvp.annotation;

import com.olimsw.android.mvp.MSWPresenter;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPresenter {
    Class<? extends MSWPresenter> value();
}
