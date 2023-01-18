package com.github.murilonerdx.service

import com.github.murilonerdx.dto.ProductReq
import com.github.murilonerdx.dto.ProductRes
import io.micronaut.grpc.annotation.GrpcService

interface ProductService {
    fun create(req: ProductReq): ProductRes
}