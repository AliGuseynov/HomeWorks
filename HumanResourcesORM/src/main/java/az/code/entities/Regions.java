package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "regions")

public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int regionId;
    @Column(name = "region_name")
    private String regionName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "region_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Countries> countriesList;

    @Override
    public String toString() {
        return "Regions{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
