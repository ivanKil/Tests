package com.geekbrains.tests

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.details.DetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
@ExperimentalCoroutinesApi
class DetailsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var detailsViewModel: DetailsViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        detailsViewModel = DetailsViewModel()
    }

    @Test
    fun testMinus() {
        val observer = Observer<Int> {}
        val liveData = detailsViewModel.subscribeToLiveData()
        try {
            liveData.observeForever(observer)
            detailsViewModel.onDecrement()
            Assert.assertEquals(-1, liveData.value)
        } finally {
            liveData.removeObserver(observer)
        }
    }

    @Test
    fun testPlus() {
        val observer = Observer<Int> {}
        val liveData = detailsViewModel.subscribeToLiveData()
        try {
            liveData.observeForever(observer)
            detailsViewModel.onIncrement()
            Assert.assertEquals(1, liveData.value)
        } finally {
            liveData.removeObserver(observer)
        }
    }

    @Test
    fun testSetCount() {
        val observer = Observer<Int> {}
        val liveData = detailsViewModel.subscribeToLiveData()
        try {
            liveData.observeForever(observer)
            detailsViewModel.setCounter(12)
            Assert.assertEquals(12, liveData.value)
        } finally {
            liveData.removeObserver(observer)
        }
    }
}
