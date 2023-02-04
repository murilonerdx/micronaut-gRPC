package com.github.murilonerdx

import com.github.murilonerdx.domain.Product
import com.github.murilonerdx.dto.ProductReq
import com.github.murilonerdx.repository.ProductRepository
import com.github.murilonerdx.service.ProductServiceImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class ProductServiceImplTest {
    private val productRepository = Mockito.mock(ProductRepository::class.java)
    private val productService = ProductServiceImpl(productRepository)


    @Test
    fun `when create method is call with valid data a ProductRes is returned`(){
        val product = Product(id=null, name="product name", price = 10.00, quantityInStock=5)
        val productOutput = Product(id=1, name="product name", price = 10.00, quantityInStock=5)

        Mockito.`when`(productRepository.save(product)).thenReturn(productOutput)

        val productReq = ProductReq(name="product name", price = 10.00, quantityInStock = 5)
        val productRes = productService.create(productReq)

        assertEquals(productRes.name, productReq.name)
    }
}