package pe.example.springWeb.v01.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
//@Getter @Setter @EqualsAndHashCode @ToString @RequiredArgsConstructor
//@Value
//@Getter @EqualsAndHashCode @ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductItem {

    Integer id;

    @NotBlank
    String name;

    @NotBlank
    String description;

    @NotNull
    @Positive
    Double price;

    @NotNull
    @PositiveOrZero
    Integer storage;


}
