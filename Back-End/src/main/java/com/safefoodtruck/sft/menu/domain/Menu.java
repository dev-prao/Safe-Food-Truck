package com.safefoodtruck.sft.menu.domain;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.CascadeType;
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
@Table(name = "menu")
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private long id;

    @Column(name = "menu_name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "menu_image_id")
    private MenuImage menuImage;

    private void addMenuImage(MenuImage menuImage) {
        this.menuImage = menuImage;
        menuImage.addMenu(this);
    }
}
