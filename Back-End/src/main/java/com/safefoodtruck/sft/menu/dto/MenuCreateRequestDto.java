package com.safefoodtruck.sft.menu.dto;

public record MenuCreateRequestDto(long storeId, String name, int price, String description) {
}
