package com.github.murilonerdx.service

import com.github.murilonerdx.domain.Product
import com.github.murilonerdx.dto.ProductReq
import com.github.murilonerdx.dto.ProductRes
import com.github.murilonerdx.repository.ProductRepository
import com.github.murilonerdx.util.toDomain
import com.github.murilonerdx.util.toProductRes
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl(private val productRepository:ProductRepository) : ProductService{
    override fun create(req: ProductReq): ProductRes {
        val productSaved =  productRepository.save(req.toDomain())
        return productSaved.toProductRes()
    }
}