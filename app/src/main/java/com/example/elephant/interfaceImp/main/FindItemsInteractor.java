package com.example.elephant.interfaceImp.main;

import java.util.List;

/**
 * FindItemsInteractor
 */

public interface FindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
}
