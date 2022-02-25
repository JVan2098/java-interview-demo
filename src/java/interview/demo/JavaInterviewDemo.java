package java.interview.demo;

import java.interview.demo.utilities.CommonUtilities;
import java.interview.demo.utilities.IOUtility;

public class JavaInterviewDemo {

    public static void main(String[] args) {
        CoffeeShopRepository repository = new CoffeeShopRepository();
        CoffeeShop[] coffeeShops = repository.getCoffeeShops();

        String userInput = IOUtility.getValidUserInput();
        int[] parsedData = CommonUtilities.parseOrderedPair(userInput);
        CoffeeShop closestShop = calculateClosestShop(parsedData, coffeeShops);
        IOUtility.informCustomer(closestShop.shopName);
    }

    private static CoffeeShop calculateClosestShop(int[] userCoordinates, CoffeeShop[] shopCoordinates) {
        double minDistance = 10 * Math.sqrt(2);
        CoffeeShop closest = new CoffeeShop(0, 0, "Hello World Coffee Shop");
        for (CoffeeShop shopCoordinate : shopCoordinates) {
            double currDistance = Math.sqrt(Math.pow(shopCoordinate.X - userCoordinates[0], 2) + Math.pow(shopCoordinate.Y - userCoordinates[1], 2));
            if (currDistance < minDistance) {
                closest = shopCoordinate;
                minDistance = currDistance;
            }
        }
        return closest;
    }
}
