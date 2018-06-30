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
public class UpdatePersonDTO {

    @NotNull
    private Integer id;

    private String lastName;

    private String firstName;

    private String middleName;

    private Date birthDate;

}
