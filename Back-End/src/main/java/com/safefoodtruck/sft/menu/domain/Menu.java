package com.safefoodtruck.sft.menu.domain;

import static jakarta.persistence.FetchType.LAZY;

import com.safefoodtruck.sft.store.domain.Store;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

@Table(name = "menu")
@Entity
@Getter
@Builder
@ToString
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    public Menu(String name, long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private int id;

    @Column(name = "menu_name")
    private String name;

    @Column(name = "price")
    private long price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToOne(fetch = LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private MenuImage menuImage;

    public void addStore(Store store) {
        this.store = store;
    }

    private void addMenuImage(MenuImage menuImage) {
        this.menuImage = menuImage;
        menuImage.addMenu(this);
    }

    public static Menu of(String name, long price, String description) {
        return new Menu(name, price, description);
    }
}
