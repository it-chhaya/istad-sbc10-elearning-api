package co.istad.elearning.api.controller;

import co.istad.elearning.api.dto.CourseCreateRequest;
import co.istad.elearning.api.dto.CourseResponse;
import co.istad.elearning.api.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CourseResponse createNewCourse(@RequestBody CourseCreateRequest courseCreateRequest) {
        return courseService.createNewCourse(courseCreateRequest);
    }

    @GetMapping
    List<CourseResponse> findCourses() {
        return courseService.findCourses();
    }

}