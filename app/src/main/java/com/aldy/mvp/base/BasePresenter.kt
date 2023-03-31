package com.aldy.mvp.base

import androidx.annotation.NonNull

abstract class BasePresenter<V> {
    protected var mView: V? = null

    fun attachView(@NonNull view: V) {
        mView = view
    }

    fun detachView() {
        mView = null
    }

    /**
     * Check if the view is attached.
     * This checking is only necessary when returning from an asynchronous call
     */
    protected fun isViewAttached(): Boolean {
        return mView != null
    }
}