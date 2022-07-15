package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;

    @Column
    private String phone_number;

    @ManyToOne(optional = false)
    private City city;
}
