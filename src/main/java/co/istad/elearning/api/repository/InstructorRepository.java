package co.istad.elearning.api.repository;

import co.istad.elearning.api.domain.Instructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class InstructorRepository {

    private List<Instructor> instructors;

    public Integer getLastId() {
        return instructors.getLast().getId();
    }

    public InstructorRepository() {
        instructors = new ArrayList<>();
        instructors.add(Instructor.builder()
                        .id(1)
                        .name("Chan Chhaya")
                        .gender("Male")
                        .biography("Spring Instructor since 2019")
                .build());
        instructors.add(Instructor.builder()
                .id(2)
                .name("Phan Mai")
                .gender("Female")
                .biography("Java Instructor since 2023")
                .build());
    }

}
