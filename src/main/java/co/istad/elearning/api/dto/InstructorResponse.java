package co.istad.elearning.api.dto;

import lombok.Builder;

@Builder
public record InstructorResponse(
        Integer id,
        String name,
        String gender,
        String biography
) {
}
