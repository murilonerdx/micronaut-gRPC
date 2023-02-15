package com.github.murilonerdx.resources

import com.github.murilonerdx.ProductServiceRequest
import com.github.murilonerdx.ProductServiceResponse
import com.github.murilonerdx.ProductsServiceGrpc
import com.github.murilonerdx.dto.ProductReq
import com.github.murilonerdx.service.ProductService
import com.github.murilonerdx.util.ValidationUtil
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResources(private val productService: ProductService) : ProductsServiceGrpc.ProductsServiceImplBase() {
    override fun create(request: ProductServiceRequest?, responseObserver: StreamObserver<ProductServiceResponse>?) {
        val payload = ValidationUtil.validatePayload(request)
        val productReq =
            ProductReq(name = payload.name, price = payload.price, quantityInStock = payload.quantityInStock)
        val productRes = productService.create(productReq)

        val productResponse = ProductServiceResponse.newBuilder()
            .setId(productRes.id)
            .setName(productRes.name)
            .setPrice(productRes.price)
            .setQuantityInStock(productRes.quantityInStock)
            .build()

        responseObserver?.onNext(productResponse)
        responseObserver?.onCompleted()
    }
}