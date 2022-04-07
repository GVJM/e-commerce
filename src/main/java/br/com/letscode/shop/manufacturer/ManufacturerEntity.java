package br.com.letscode.shop.manufacturer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.ZonedDateTime;

@Entity(name = "MANUFACTURER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_seq")
    @SequenceGenerator(name = "manufacturer_seq", sequenceName = "manufacturer_seq")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATION_DATA")
    private ZonedDateTime creationData;

    @Column(name = "LATEST_UPDATE")
    private ZonedDateTime latestUpdate;
}
