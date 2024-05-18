package co.istad.elearning.api.domain;

import lombok.*;

import java.math.BigDecimal;

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
}
