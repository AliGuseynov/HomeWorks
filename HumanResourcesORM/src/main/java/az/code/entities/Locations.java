package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "state_province")
    private String stateProvince;

    @ManyToOne
//    @JoinColumn(name = "country_id", referencedColumnName = "location_id")
    private Countries countriesList;
}
