package com.kudziadawid.advancedapplication.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME) //will be retained in the final APK
public @interface ActivityScope {
}
