package com.github.murilonerdx.service

import com.github.murilonerdx.dto.ProductReq
import io.micronaut.grpc.annotation.GrpcService

interface ProductService {
    fun create(req: ProductReq): ProductReq
}