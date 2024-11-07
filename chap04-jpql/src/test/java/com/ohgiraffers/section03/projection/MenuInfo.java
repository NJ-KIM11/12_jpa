package com.ohgiraffers.section03.projection;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MenuInfo {

    /*
    * 임베디드 타입의 복합키는 id(pk)가 아니여도 가능하다.
    * 다만, 복합키들이 중복되는 항목이 있으면 안된다.(조합이 유일해야 한다.)
    * */

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    public MenuInfo() {
    }

    public MenuInfo(String menuName, int menuPrice) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                '}';
    }
}
