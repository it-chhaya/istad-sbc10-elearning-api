package co.istad.elearning.api.service;

import co.istad.elearning.api.dto.CourseCreateRequest;
import co.istad.elearning.api.dto.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createNewCourse(CourseCreateRequest courseCreateRequest);

    List<CourseResponse> findCourses();

}
