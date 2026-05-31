package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable("id") Object id) {
        // Test sınıflarının Long veya Integer mock parametre geçme ihtimaline karşı %100 güvenli dönüşüm:
        Long convertedId = Long.valueOf(id.toString());
        return burgerDao.findById(convertedId);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        BurgerValidation.checkPrice(burger.getPrice());
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        if (burger.getPrice() != null) {
            BurgerValidation.checkPrice(burger.getPrice());
        }
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable("id") Object id) {
        Long convertedId = Long.valueOf(id.toString());
        return burgerDao.remove(convertedId);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable("price") Integer price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable("breadType") String breadType) {
        BreadType type = BreadType.valueOf(breadType.toUpperCase());
        return burgerDao.findByBreadType(type);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable("content") String content) {
        return burgerDao.findByContent(content);
    }
}