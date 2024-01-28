package com.rick.desafioanotaai.domain.category;

import jakarta.validation.constraints.NotNull;

public record CategoryDTO(@NotNull String title, @NotNull String description, @NotNull String ownerId) {

}
