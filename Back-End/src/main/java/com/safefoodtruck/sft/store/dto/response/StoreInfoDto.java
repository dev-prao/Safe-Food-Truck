package com.safefoodtruck.sft.store.dto.response;

import com.safefoodtruck.sft.menu.domain.Menu;
import com.safefoodtruck.sft.store.domain.Store;
import java.util.List;
import lombok.Builder;

@Builder
public record StoreInfoDto(String name, String storeType, List<Menu> menus, String offDay, String description, String latitude, String longitude, boolean isClean, boolean isOpen) {
    public static StoreInfoDto fromEntity(Store store) {
        return StoreInfoDto.builder()
            .name(store.getName())
            .storeType(store.getStoreType())
            .menus(store.getMenuList())
            .offDay(store.getOffDay())
            .description(store.getDescription())
            .latitude(store.getLatitude())
            .longitude(store.getLongitude())
            .isClean(store.isClean())
            .isOpen(store.isOpen())
            .build();
    }
}