package co.istad.elearning.api.service;

import co.istad.elearning.api.dto.CourseCreateRequest;
import co.istad.elearning.api.dto.CourseResponse;
import co.istad.elearning.api.dto.CourseUpdateRequest;

import java.util.List;

public interface CourseService {

    void deleteCourse(Integer id);

    CourseResponse updateCourse(Integer id, CourseUpdateRequest courseUpdateRequest);

    CourseResponse createNewCourse(CourseCreateRequest courseCreateRequest);

    CourseResponse findCourseById(Integer id);

    List<CourseResponse> findCourses();

}
