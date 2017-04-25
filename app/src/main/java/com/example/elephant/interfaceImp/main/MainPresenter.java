package com.example.elephant.interfaceImp.main;

/**
 * Created by elephant on 2017/4/25.
 */


public interface MainPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}