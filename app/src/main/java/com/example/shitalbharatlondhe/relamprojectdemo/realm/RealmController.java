package com.example.shitalbharatlondhe.relamprojectdemo.realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import  com.example.shitalbharatlondhe.relamprojectdemo.model.Book;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmController {
    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        this.realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {
        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {
        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {
        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return this.realm;
    }

    public void refresh() {
        this.realm.refresh();
    }

    public void clearAll() {
        this.realm.beginTransaction();
        this.realm.clear(Book.class);
        this.realm.commitTransaction();
    }

    public RealmResults<Book> getBooks() {
        return this.realm.where(Book.class).findAll();
    }

    public Book getBook(String id) {
        return (Book) this.realm.where(Book.class).equalTo("id", id).findFirst();
    }

    public boolean hasBooks() {
        return !this.realm.allObjects(Book.class).isEmpty();
    }

    public RealmResults<Book> queryedBooks() {
        return this.realm.where(Book.class).contains("author", "Author 0").or().contains("title", "Realm").findAll();
    }
}
