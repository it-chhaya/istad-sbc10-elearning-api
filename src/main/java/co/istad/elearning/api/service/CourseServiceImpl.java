package co.istad.elearning.api.service;

import co.istad.elearning.api.domain.Course;
import co.istad.elearning.api.dto.CourseCreateRequest;
import co.istad.elearning.api.dto.CourseResponse;
import co.istad.elearning.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponse createNewCourse(CourseCreateRequest courseCreateRequest) {
        // DTO Pattern
        Course newCourse = Course.builder()
                .id(courseRepository.getLastId() + 1)
                .title(courseCreateRequest.title())
                .description(courseCreateRequest.description())
                .price(courseCreateRequest.price())
                .status(true)
                .build();

        // Invoke repo to add new course
        courseRepository.getCourses()
                .add(newCourse);

        // DTO Pattern
        return CourseResponse.builder()
                .id(newCourse.getId())
                .title(newCourse.getTitle())
                .description(newCourse.getDescription())
                .price(newCourse.getPrice())
                .build();
    }

    @Override
    public List<CourseResponse> findCourses() {
        return courseRepository
                .getCourses()
                .stream()
                .map(course -> CourseResponse.builder()
                        .id(course.getId())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .price(course.getPrice())
                        .build())
                .toList();
    }

}
