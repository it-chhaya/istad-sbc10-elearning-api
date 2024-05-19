package co.istad.elearning.api.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private BigDecimal price;
    private Boolean status;

    // Course is taught by an instructor
    @ManyToOne
    private Instructor instructor;

    // Course has many categories
    @ManyToMany
    private List<Category> categories;

}
