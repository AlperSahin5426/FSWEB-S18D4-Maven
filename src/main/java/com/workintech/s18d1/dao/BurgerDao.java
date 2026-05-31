package com.workintech.s18d1.dao;
import java.util.List;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;

public interface BurgerDao {
    Burger save(Burger burger);
    Burger findById(Long id);
    List<Burger> findAll();
    List<Burger> findByPrice(Integer price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(Long id);
}
