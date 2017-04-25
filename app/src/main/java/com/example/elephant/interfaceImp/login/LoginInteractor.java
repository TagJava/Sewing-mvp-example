package com.example.elephant.interfaceImp.login;

/**
 * LoginInteractor
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String userName, String password, OnLoginFinishedListener listener);
}
