package co.istad.elearning.api.service;

import co.istad.elearning.api.domain.Course;
import co.istad.elearning.api.dto.CourseCreateRequest;
import co.istad.elearning.api.dto.CourseResponse;
import co.istad.elearning.api.dto.CourseUpdateRequest;
import co.istad.elearning.api.dto.InstructorResponse;
import co.istad.elearning.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public void deleteCourse(Integer id) {
        Course deletedCourse = courseRepository
                .getCourses()
                .stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Course with ID = %d has not found", id)));
        courseRepository.getCourses().remove(deletedCourse);
    }

    @Override
    public CourseResponse updateCourse(Integer id, CourseUpdateRequest courseUpdateRequest) {

        // validate course ID
        Course updatedCourse = courseRepository
                .getCourses()
                .stream()
                .filter(course -> course.getId().equals(id))
                .peek(course -> { // Update course if exists
                    course.setTitle(courseUpdateRequest.title());
                    course.setDescription(courseUpdateRequest.description());
                })
                .findFirst() // Retrieve course
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Course with ID = %d has not found", id))); // Throw exception if a course not found

        // DTO Pattern
        return CourseResponse.builder()
                .id(updatedCourse.getId())
                .title(updatedCourse.getTitle())
                .description(updatedCourse.getDescription())
                .price(updatedCourse.getPrice())
                .build();
    }

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
    public CourseResponse findCourseById(Integer id) {
        return courseRepository
                .getCourses()
                .stream()
                .filter(course -> course.getId().equals(id))
                .map(course -> CourseResponse.builder()
                        .id(course.getId())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .price(course.getPrice())
                        .instructor(InstructorResponse.builder()
                                .id(course.getInstructor().getId())
                                .name(course.getInstructor().getName())
                                .gender(course.getInstructor().getGender())
                                .biography(course.getInstructor().getBiography())
                                .build())
                        .build())
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Course with ID = %d has not found", id)));
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
                        .instructor(InstructorResponse.builder()
                                .id(course.getInstructor().getId())
                                .name(course.getInstructor().getName())
                                .gender(course.getInstructor().getGender())
                                .biography(course.getInstructor().getBiography())
                                .build())
                        .build())
                .toList();
    }

}
