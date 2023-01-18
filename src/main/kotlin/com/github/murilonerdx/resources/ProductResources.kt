package com.github.murilonerdx.resources

import com.github.murilonerdx.ProductsServiceReply
import com.github.murilonerdx.ProductsServiceRequest
import com.github.murilonerdx.ProductsServiceServiceGrpc
import io.grpc.stub.StreamObserver

class ProductResources: ProductsServiceServiceGrpc.ProductsServiceServiceImplBase(){
    override fun create(request: ProductsServiceRequest?, responseObserver: StreamObserver<ProductsServiceReply>?) {
        super.create(request, responseObserver)
    }
}