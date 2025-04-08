package pe.example.springWeb.v01.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleItem {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
