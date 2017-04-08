package com.example.shitalbharatlondhe.relamprojectdemo.adapters;

import android.content.Context;
import  com.example.shitalbharatlondhe.relamprojectdemo.model.Book;
import io.realm.RealmResults;

public class RealmBooksAdapter extends RealmModelAdapter<Book> {
    public RealmBooksAdapter(Context context, RealmResults<Book> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
