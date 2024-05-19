package co.istad.elearning.api.exception;

import lombok.Builder;

@Builder
public record FieldError(
        String field,
        String detail
) {
}
