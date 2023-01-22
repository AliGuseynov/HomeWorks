package az.code.requests.requests.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="persons")
@NamedQuery(name = "all_persons", query = "select a from Person a")
@NamedQuery(name = "getPersonByID", query = "select a from Person a where a.person_id = ?1")
public class Person {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_person"
    )
    @SequenceGenerator(
            name = "seq_person",
            allocationSize = 1
    )
    private Long person_id;

    private String person_name;

    private String person_surname;

    public String PrintPersonWeb(){
        return "<BR>Person " + person_id +
                "<BR>Fullname: " + person_name + " " + person_surname
                + "<BR>============== ";
    }

}
