package com.safefoodtruck.sft.menu.exception;

public class StoreNotFoundException extends RuntimeException {

    public StoreNotFoundException() {
        super(StoreErrorMessage.STORE_NOT_FOUND);
    }
}
