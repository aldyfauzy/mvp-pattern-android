package com.aldy.mvp.base

import androidx.fragment.app.Fragment

class BaseFragment : Fragment() {

    fun hideKeyboard(){
        return (activity as BaseActivity).hideKeyboard()
    }
}