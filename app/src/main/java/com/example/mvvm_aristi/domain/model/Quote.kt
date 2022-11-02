package com.example.mvvm_aristi.domain.model

import com.example.mvvm_aristi.data.database.entities.QuoteEntity
import com.example.mvvm_aristi.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)

