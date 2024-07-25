package com.safefoodtruck.sft.menu.service;

import com.safefoodtruck.sft.menu.dto.request.MenuListRegistRequestDto;

public interface MenuService {
    void registMenu(int storeId, MenuListRegistRequestDto menuListRegistRequestDto);
}
