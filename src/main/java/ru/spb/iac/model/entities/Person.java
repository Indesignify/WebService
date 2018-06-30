package ru.spb.iac.model.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "person", schema = "test", catalog = "web_service_db")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements EntityWithId<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "IdOrGenerated")
    @GenericGenerator(name = "IdOrGenerated", strategy = "ru.spb.iac.repository.hibernate.UseIdOrGenerate")
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "update_date")
    private Timestamp updateDate;

}
