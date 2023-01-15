package az.code.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Entity
@Table(name = "countries")
public class Countries {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private String countryId;
    @Column(name = "country_name")
    private String countryName;

    @ManyToMany(mappedBy = "countriesList")
    private List<Regions> regionsList;

    @OneToMany(mappedBy = "countriesList")
    private List<Locations> locationsList;
}
