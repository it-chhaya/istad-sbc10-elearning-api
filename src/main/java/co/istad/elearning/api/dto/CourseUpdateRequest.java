package co.istad.elearning.api.dto;

public record CourseUpdateRequest(
        String title,
        String description
) {
}
