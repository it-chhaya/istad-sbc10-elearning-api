package co.istad.elearning.api.repository;

import co.istad.elearning.api.domain.Course;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class CourseRepository {

    private final InstructorRepository instructorRepository;

    private List<Course> courses;

    public Integer getLastId() {
        return courses.getLast().getId();
    }

    public CourseRepository(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
        courses = new ArrayList<>();
        courses.add(Course.builder()
                .id(1)
                .title("Java Programming")
                .description("Object Oriented Programming")
                .price(BigDecimal.valueOf(100.00))
                .status(true)
                .instructor(instructorRepository.getInstructors().get(1))
                .build());
        courses.add(Course.builder()
                .id(2)
                .title("C++ Programming")
                .description("Fundamental Programming")
                .price(BigDecimal.valueOf(90.00))
                .status(true)
                .instructor(instructorRepository.getInstructors().get(0))
                .build());
        courses.add(Course.builder()
                .id(3)
                .title("HTML")
                .description("HyperText Markup Language")
                .price(BigDecimal.valueOf(80.00))
                .status(false)
                .instructor(instructorRepository.getInstructors().get(0))
                .build());
    }
}
