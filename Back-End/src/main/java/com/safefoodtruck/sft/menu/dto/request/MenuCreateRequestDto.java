package com.safefoodtruck.sft.menu.dto.request;

public record MenuCreateRequestDto(long storeId, String name, int price, String description) {
}
