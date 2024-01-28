package com.rick.desafioanotaai.domain.product;

import jakarta.validation.constraints.NotNull;

public record ProductDTO(
        @NotNull String title,
        @NotNull String description,
        @NotNull String ownerId,
        @NotNull Integer price,
        @NotNull String categoryId) {
}
