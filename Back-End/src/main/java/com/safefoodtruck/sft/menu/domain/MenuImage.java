package com.safefoodtruck.sft.menu.domain;

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

@Table(name = "menu_image")
@Entity
@Getter
@ToString
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class MenuImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_image_id")
    private long id;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "saved_name")
    private String savedName;

    @Column(name = "saved_path")
    private String savedPath;

    @OneToOne(mappedBy = "menuImage")
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public void addMenu(Menu menu) {
        this.menu = menu;
    }
}