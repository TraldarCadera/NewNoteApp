package com.example.newnoteapp.domain;

public interface Callback<T> {
    void onSuccess(T data);
}
