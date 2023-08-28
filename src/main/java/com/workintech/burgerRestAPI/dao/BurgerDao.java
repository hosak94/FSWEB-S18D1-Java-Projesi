package com.workintech.burgerRestAPI.dao;

import com.workintech.burgerRestAPI.entity.BreadType;
import com.workintech.burgerRestAPI.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    Burger findById(Long id);
    List<Burger> findAll();
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(String  breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(Long id);
}
