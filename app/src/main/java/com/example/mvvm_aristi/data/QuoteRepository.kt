package com.example.mvvm_aristi.data

import com.example.mvvm_aristi.data.database.dao.QuoteDao
import com.example.mvvm_aristi.data.database.entities.QuoteEntity
import com.example.mvvm_aristi.data.model.QuoteModel
import com.example.mvvm_aristi.data.network.QuoteService
import com.example.mvvm_aristi.domain.model.Quote
import com.example.mvvm_aristi.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {


    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes() // Llamo al backend y recupero las quotes
        return response.map { it.toDomain() }

    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain()}
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun  clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}