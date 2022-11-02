package com.example.mvvm_aristi.domain

import com.example.mvvm_aristi.data.QuoteRepository
import com.example.mvvm_aristi.data.model.QuoteModel
import com.example.mvvm_aristi.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}