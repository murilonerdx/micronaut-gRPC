package com.github.murilonerdx.resources

import com.github.murilonerdx.ProductsServiceReply
import com.github.murilonerdx.ProductsServiceRequest
import com.github.murilonerdx.ProductsServiceServiceGrpc
import io.grpc.stub.StreamObserver

class ProductResources: ProductsServiceServiceGrpc.ProductsServiceServiceImplBase(){
    override fun send(request: ProductsServiceRequest?, responseObserver: StreamObserver<ProductsServiceReply>?) {
        val toSend = "Hello, ${request?.name}"


        val reply = ProductsServiceReply.newBuilder()
            .setMessage(toSend)
            .build()

        responseObserver?.onNext(reply);
        responseObserver?.onCompleted();
    }
}