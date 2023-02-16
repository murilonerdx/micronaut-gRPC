package com.github.murilonerdx.repository

import com.github.murilonerdx.domain.Product
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import jakarta.inject.Singleton

@Repository
interface ProductRepository : JpaRepository<Product, Long>{}
