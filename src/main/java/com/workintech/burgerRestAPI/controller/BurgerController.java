package com.workintech.burgerRestAPI.controller;

import com.workintech.burgerRestAPI.dao.BurgerDao;
import com.workintech.burgerRestAPI.entity.Burger;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burgers")
@Validated
public class BurgerController {
    private BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }
    @GetMapping("/")
    public List<Burger> find(){
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger findById(@Positive @PathVariable Long id) {
        return burgerDao.findById(id);
    }
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable int price) {
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType) {
        return burgerDao.findByBreadType(breadType);
    }
    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent("%" + content + "%");
    }
    @PostMapping("/")
    public Burger createBurger(@Validated @RequestBody Burger burger){
        return burgerDao.save(burger);
    }
    @PutMapping("/{id}")
    public Burger updateBurger(@PathVariable Long id,@RequestBody Burger burger){
        Burger existingBurger = burgerDao.findById(id);
        existingBurger.setName(burger.getName());
        existingBurger.setPrice(burger.getPrice());
        existingBurger.setVegan(burger.isVegan());
        existingBurger.setBreadType(burger.getBreadType());
        existingBurger.setContents(burger.getContents());
        return burgerDao.update(existingBurger);
    }
    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable Long id){
        return burgerDao.remove(id);
    }
}
