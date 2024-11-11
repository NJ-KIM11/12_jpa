package com.ohgiraffers.chap05springdata.menu.controller;

import com.ohgiraffers.chap05springdata.menu.dto.MenuDTO;
import com.ohgiraffers.chap05springdata.menu.entity.Menu;
import com.ohgiraffers.chap05springdata.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("selectAll")
    public ResponseEntity selectAll() {
        List<Menu> menuList = menuService.selectAll();
        if(menuList != null){
            return ResponseEntity.ok(menuList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("메뉴 리스트가 존재하지 않습니다.");
        }
    }

    @PostMapping("insert")
    private ResponseEntity insertMenu(@RequestBody MenuDTO menuDTO) {
        Object result = menuService.insertMenu(menuDTO);

        if(result instanceof Menu){
            Menu response =  (Menu) result;
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(404).body(result);
    }

}
