package com.github.murilonerdx.service

import com.github.murilonerdx.dto.ProductReq
import com.github.murilonerdx.dto.ProductRes
import com.github.murilonerdx.dto.ProductUpdateReq
import io.micronaut.grpc.annotation.GrpcService

interface ProductService {
    fun create(req: ProductReq): ProductRes
    fun findById(id: Long): ProductRes
    fun update(req: ProductUpdateReq): ProductRes
    fun delete(id: Long)
    fun findAll(): List<ProductRes>
}