package com.example.elephant.interfaceImp.main;

import com.example.elephant.view.main.MainView;

import java.util.List;

/**
 * MainPresenterImpl
 */

public class MainPresenterImpl implements MainPresenter,FindItemsInteractor.OnFinishedListener{
    private MainView mainView;
    private FindItemsInteractor findItemsInteractor;

    public MainPresenterImpl(MainView mainView,FindItemsInteractorImpl findItemsInteractorImpl){
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractorImpl;
    }

    @Override
    public void onResume() {
        if(mainView != null){
            mainView.showProgress();
        }
        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if(mainView != null){
            mainView.showMessage(String.format("%d",position+1  ));
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<String> items) {
        if(mainView != null){
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView(){
        return mainView;
    }
}
