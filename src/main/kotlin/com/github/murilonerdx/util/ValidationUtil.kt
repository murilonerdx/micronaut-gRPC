package com.github.murilonerdx.util

import com.github.murilonerdx.ProductServiceRequest
import com.github.murilonerdx.ProductServiceUpdateRequest
import com.github.murilonerdx.exception.InvalidArgumentException


class ValidationUtil {
    companion object {
        fun validatePayload(payload: ProductServiceRequest?): ProductServiceRequest {
            payload?.let {
                if (it.name.isNullOrBlank())
                    throw InvalidArgumentException("nome")

                if (it.price.isNaN() || it.price < 0)
                    throw InvalidArgumentException("preço")
                return it
            }
            throw InvalidArgumentException("payload")
        }

        fun validateUpdatePayload(payload: ProductServiceUpdateRequest?): ProductServiceUpdateRequest {
            payload?.let {
                if (it.id <= 0L)
                    throw InvalidArgumentException("ID")

                if (it.name.isNullOrBlank())
                    throw InvalidArgumentException("nome")

                if (it.price.isNaN() || it.price < 0)
                    throw InvalidArgumentException("preço")
                return it
            }
            throw InvalidArgumentException("payload")
        }
    }
}