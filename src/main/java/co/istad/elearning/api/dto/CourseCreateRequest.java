package co.istad.elearning.api.dto;

import java.math.BigDecimal;

public record CourseCreateRequest(
        String title,
        String description,
        BigDecimal price
) {
}
