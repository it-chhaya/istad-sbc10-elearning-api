package co.istad.elearning.api.service;

import co.istad.elearning.api.dto.CourseCreateRequest;
import co.istad.elearning.api.dto.CourseResponse;
import co.istad.elearning.api.dto.CourseUpdateRequest;

import java.util.List;

public interface CourseService {

    CourseResponse updateCourse(Integer id, CourseUpdateRequest courseUpdateRequest);

    CourseResponse createNewCourse(CourseCreateRequest courseCreateRequest);

    List<CourseResponse> findCourses();

}
