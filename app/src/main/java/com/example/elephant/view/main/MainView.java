package com.example.elephant.view.main;

import java.util.List;

/**
 * MainView
 */
public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}
