package com.safefoodtruck.sft.store.domain;

import com.safefoodtruck.sft.member.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "store")
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private long id;

    @OneToOne(mappedBy = "store")
    @JoinColumn(name = "email")
    private Member owner;

    @Column(name = "store_type")
    private String storeType;

    @Column(name = "off_day")
    private String offDay;

    @Column(name = "description")
    private String description;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "isClean")
    private boolean isClean;

    @Column(name = "isOpen")
    private boolean isOpen;
}
