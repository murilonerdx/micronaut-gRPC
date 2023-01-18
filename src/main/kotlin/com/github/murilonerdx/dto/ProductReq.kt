package com.github.murilonerdx.dto

data class ProductReq(
    val id: Long?,
    val name: String,
    val price: Double,
    val quantityInStock: Int
)
