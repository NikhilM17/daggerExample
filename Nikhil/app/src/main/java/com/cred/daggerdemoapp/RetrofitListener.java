package com.cred.daggerdemoapp;

public interface RetrofitListener<T> {
    void response(T response, String error);
}
