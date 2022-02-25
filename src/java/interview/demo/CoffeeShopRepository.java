/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.interview.demo;

/**
 *
 * @author Jason Van Dyke
 */
public class CoffeeShopRepository {
    private final CoffeeShop[] coffeeShopList;
    
    public CoffeeShopRepository(){
        this.coffeeShopList = new CoffeeShop[]{
            new CoffeeShop(5, 3, "Starbucks"),
            new CoffeeShop(10, 1, "Tim Hortons"),
            new CoffeeShop(3, 3, "Dunkin' Donuts"),
            new CoffeeShop(2, 7, "Land of a Thousand Hills"),
            new CoffeeShop(7, 8, "Caribou Coffee"),
            new CoffeeShop(9, 1, "Corner Cafe"),
            new CoffeeShop(5, 5, "Gloria Jean's"),
            new CoffeeShop(5, 6, "Pop's Coffee Co."),
            new CoffeeShop(6, 8, "Lavazza"),
            new CoffeeShop(1, 4, "Biggby Coffee"),
            new CoffeeShop(7, 2, "Peet's Coffee Co.")
        };
    }
    
    public CoffeeShop[] getCoffeeShops() {
        return this.coffeeShopList;
    }
}
