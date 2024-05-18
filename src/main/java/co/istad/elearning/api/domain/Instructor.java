package co.istad.elearning.api.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    private Integer id;
    private String name;
    private String gender;
    private String biography;

    private List<Course> courses;

}
