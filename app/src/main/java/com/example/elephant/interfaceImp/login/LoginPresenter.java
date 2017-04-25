package com.example.elephant.interfaceImp.login;

/**
 * LoginPresenter
 */
public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();

}
