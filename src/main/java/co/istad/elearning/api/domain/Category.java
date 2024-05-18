package co.istad.elearning.api.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    private Integer id;
    private String name;
}
