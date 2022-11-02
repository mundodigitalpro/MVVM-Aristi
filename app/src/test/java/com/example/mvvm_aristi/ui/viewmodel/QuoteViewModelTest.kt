package com.example.mvvm_aristi.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mvvm_aristi.QuoteViewModel
import com.example.mvvm_aristi.domain.GetQuotesUseCase
import com.example.mvvm_aristi.domain.GetRandomQuoteUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class QuoteViewModelTest {

    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase
    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        //Dispatchers.Unconfined
    }

    @After
    fun onAfter() {
        //Dispatchers.shutdown()
    }

/*    @Test
    fun `when viewmodel is created at the first time, get all quotes and set the first value`() = runTest{

    }*/
}