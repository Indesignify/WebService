package ru.spb.iac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonDTO {

    private Integer id;

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    @NotNull
    private String middleName;

    @NotNull
    private Date birthDate;

}
