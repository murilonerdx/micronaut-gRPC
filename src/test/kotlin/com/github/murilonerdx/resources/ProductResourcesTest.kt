package com.github.murilonerdx.resources

import com.github.murilonerdx.ProductServiceRequest
import com.github.murilonerdx.ProductsServiceGrpc
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@MicronautTest
internal class ProductResourcesTest(
    private val flyway: Flyway,
    private val productsServiceBlockingStub: ProductsServiceGrpc.ProductsServiceBlockingStub
) {

    @BeforeEach
    fun setUp() {
        flyway.clean()
        flyway.migrate()
    }

    @Test
    fun `when ProductsServiceGrpc create method is call with valid data a success is returned`() {
        val request = ProductServiceRequest.newBuilder()
            .setName("product name")
            .setPrice(20.99)
            .setQuantityInStock(10)
            .build()

        val response = productsServiceBlockingStub.create(request)

        assertEquals(3, response.id)
        assertEquals("product name", response.name)
    }

    @Test
    fun `when ProductsServiceGrpc create method is call with invalid data a AlreadyExistsException is returned`() {
        val request = ProductServiceRequest.newBuilder()
            .setName("Product A")
            .setPrice(20.99)
            .setQuantityInStock(10)
            .build()

        val description = "Produto ${request.name} já cadastrado no sistema."

        val response = assertThrows(StatusRuntimeException::class.java) {
            productsServiceBlockingStub.create(request)
        }

        assertEquals(Status.ALREADY_EXISTS.code, response.status.code)
        assertEquals(description, response.status.description)
    }
}