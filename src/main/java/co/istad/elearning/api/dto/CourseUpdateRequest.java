package co.istad.elearning.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseUpdateRequest(

        @NotBlank(message = "Title is required")
        String title,

        String description

) {
}
