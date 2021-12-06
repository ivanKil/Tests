package com.geekbrains.tests

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.presenter.search.SearchPresenter
import com.geekbrains.tests.repository.GitHubRepository
import com.geekbrains.tests.view.details.DetailsActivity
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.geekbrains.tests.view.search.ViewSearchContract
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun onAttach_Test() {
        assertTrue(presenter.isViewAttached())
    }

    @Test
    fun onDetach_Test() {
        presenter.onDetach()
        assertFalse(presenter.isViewAttached())
    }

    @Test
    fun setCounter_Test() {
        presenter.setCounter(20)
        presenter.onIncrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(21)
    }

    @Test
    fun onIncrement_Test() {
        presenter.setCounter(20)
        presenter.onIncrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(21)
    }

    @Test
    fun onDecrement_Test() {
        presenter.setCounter(20)
        presenter.onDecrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(19)
    }
}