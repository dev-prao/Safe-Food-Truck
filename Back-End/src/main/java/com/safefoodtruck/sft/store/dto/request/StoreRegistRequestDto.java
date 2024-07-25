package com.safefoodtruck.sft.store.dto.request;

import com.safefoodtruck.sft.menu.domain.Menu;
import java.util.List;

public record StoreRegistRequestDto(String name, String category, List<Menu> menus, String offDay, String description, String latitude, String longitude, boolean isClean, boolean isOpen) {
}
