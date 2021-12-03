package com.geekbrains.tests.presenter

import android.view.View
import com.geekbrains.tests.view.ViewContract
import com.geekbrains.tests.view.details.ViewDetailsContract

internal interface PresenterContract<T:ViewContract> {
    fun onAttach(viewContract: T)
    fun onDetach()
}
