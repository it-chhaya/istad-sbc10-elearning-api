package co.istad.elearning.api.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CourseResponse(
        Integer id,
        String title,
        String description,
        BigDecimal price
) {
}
