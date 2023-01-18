package com.github.murilonerdx.util

import com.github.murilonerdx.domain.Product
import com.github.murilonerdx.dto.ProductReq
import com.github.murilonerdx.dto.ProductRes

fun Product.toProductRes(): ProductRes {
    return ProductRes(
        id = id!!,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun ProductReq.toDomain(): Product {
    return Product(
        id = null,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}