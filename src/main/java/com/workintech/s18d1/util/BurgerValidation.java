package com.workintech.s18d1.util;

import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void checkName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new BurgerException("Burger name cannot be null or empty!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkPrice(Double price) {
        if (price == null || price <= 0) {
            throw new BurgerException("Burger price must be greater than 0!", HttpStatus.BAD_REQUEST);
        }
    }
}