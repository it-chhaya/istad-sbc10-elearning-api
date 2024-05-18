package co.istad.elearning.api.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    private Integer id;
    private String title;
    private String description;
    private BigDecimal price;
    private Boolean status;

    // Course is taught by an instructor
    private Instructor instructor;

    // Course has many categories
    private List<Category> categories;

}
