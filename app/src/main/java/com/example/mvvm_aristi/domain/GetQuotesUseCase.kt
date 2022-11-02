package com.example.mvvm_aristi.domain

import com.example.mvvm_aristi.data.QuoteRepository
import com.example.mvvm_aristi.data.database.entities.toDatabase
import com.example.mvvm_aristi.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()) { // Si no está vacío retorna la última linea
            repository.clearQuotes() // Antes de insertar hay que borrar
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}