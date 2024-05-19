package co.istad.elearning.api.exception;

import lombok.Builder;

@Builder
public record FieldErrorResponse(
        String field,
        String detail
) {
}
