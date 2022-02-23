package java.interview.demo;

import java.util.Scanner;

public class JavaInterviewDemo {
	
	public static void main(String[] args) {
		String userInput = getValidUserInput();
		int[] translatedData = alterUserData(userInput);
		Coordinates[] coffeeShopCoordinates = createCoffeeShopList();
		Coordinates closestShop = calculateClosestShop(translatedData, coffeeShopCoordinates);
		System.out.println("The closest shop to you is " + closestShop.shopName);
	}
	
	private static String getValidUserInput() {
		String temporaryUserInput = "";
		boolean validInput = false;
		do {
			temporaryUserInput = getKeyboardInput();
			validInput = validateInput(temporaryUserInput);
			
			if (!validInput) {
				System.out.println("That's not the correct type of input!");
			}
		} while(!validInput);
		return temporaryUserInput;
	}
	
	private static Coordinates[] createCoffeeShopList() {
		return new Coordinates[] {new Coordinates(5, 3, "Starbucks"),
			new Coordinates(10, 1, "Tim Hortons"),
			new Coordinates(3, 3, "Dunkin' Donuts"),
			new Coordinates(2, 7, "Land of a Thousand Hills"),
			new Coordinates(7, 8, "Caribou Coffee"),
			new Coordinates(9, 1, "Town Square"),
			new Coordinates(5, 5, "Butler's"),
			new Coordinates(5, 6, "Pop's Coffee Co."),
			new Coordinates(6, 8, "Crazy Love Coffee Shop"),
			new Coordinates(1, 4, "Biggby Coffee"),
			new Coordinates(7, 2, "Brad's Breads")
		};
	}
	
	private static String getKeyboardInput() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter an ordered coordinate pair, with both numbers between 0 and 10, inclusive.");
		String userInput = kb.nextLine();
		return userInput;
	}
	
	private static boolean validateInput(String input) {
		if (!isCorrectInputFormat(input)) return false;
		String[] numberStrings = input.split(",");
		numberStrings[0] = numberStrings[0].trim();
		numberStrings[1] = numberStrings[1].trim();
		if (!isCorrectInputType(numberStrings)) return false;
		if (!isCorrectInputRange(numberStrings)) return false;
		return true;
	}
	
	private static boolean isCorrectInputFormat(String input) {
		if (input.indexOf(',') == -1) return false;
		if (input.indexOf(',') != input.lastIndexOf(',')) return false;
		return true;
	}
	
	private static boolean isCorrectInputType(String[] numberStrings) {
		try {
			for (String numberString: numberStrings) {
				if (Integer.parseInt(numberString) < 0) return false;
				//if (isInteger(numberString)) return false; // See isInteger() method below
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private static boolean isCorrectInputRange(String[] numberStrings) {
		try {
			for (String numberString: numberStrings) {
				if (Integer.parseInt(numberString) < 0) return false;
				if (Integer.parseInt(numberString) > 10) return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private static int[] alterUserData(String input) {
		int[] tempCoords = new int[2];
		String[] splitInput = input.split(",");
		splitInput[0] = splitInput[0].trim();
		splitInput[1] = splitInput[1].trim();
		tempCoords[0] = Integer.parseInt(splitInput[0]);
		tempCoords[1] = Integer.parseInt(splitInput[1]);
		return tempCoords;
	}
	
	private static Coordinates calculateClosestShop(int[] userCoordinates, Coordinates[] shopCoordinates) {
		double minDistance = 10 * Math.sqrt(2);
		Coordinates closest = new Coordinates(0, 0, "Hello World Coffee Shop");
		for (int i = 0; i < shopCoordinates.length; i++) {
			double currDistance = Math.sqrt(Math.pow(shopCoordinates[i].X - userCoordinates[0], 2) + Math.pow(shopCoordinates[i].Y - userCoordinates[1], 2));
			if (currDistance < minDistance) {
				closest = shopCoordinates[i];
				minDistance = currDistance;
			}
		}
		return closest;
	}
	
	// Taken from StackOverflow, so I decided not to use someone else's code.
	// This code apparently runs 20-30x faster than using Integer.parseInt(), 
	// but I wanted to use my own code for an interview.
	private static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

}

class Coordinates {
	int X;
	int Y;
	String shopName;
	
	public Coordinates(int x, int y, String name) {
		X = x;
		Y = y;
		shopName = name;
	}
}
