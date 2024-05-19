package co.istad.elearning.api.controller;

import co.istad.elearning.api.dto.CourseCreateRequest;
import co.istad.elearning.api.dto.CourseResponse;
import co.istad.elearning.api.dto.CourseUpdateRequest;
import co.istad.elearning.api.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    CourseResponse updateCourse(@PathVariable Integer id,
                                @Valid @RequestBody CourseUpdateRequest courseUpdateRequest) {
        return courseService.updateCourse(id, courseUpdateRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CourseResponse createNewCourse(@Valid @RequestBody CourseCreateRequest courseCreateRequest) {
        return courseService.createNewCourse(courseCreateRequest);
    }

    @GetMapping("/{id}")
    CourseResponse findCourseById(@PathVariable Integer id) {
        return courseService.findCourseById(id);
    }

    @GetMapping
    List<CourseResponse> findCourses() {
        return courseService.findCourses();
    }

}
