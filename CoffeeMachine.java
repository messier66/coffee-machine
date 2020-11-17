package machine;

public class CoffeeMachine {

private static int money = 550;
    private static int disposableCups = 9;
    private static int waterAmount = 400;
    private static int milkAmount = 540;
    private static int coffeeBeansAmount = 120;
    public static String action = "";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            action = scanner.next();
            switch (action) {
                case "buy" :
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    switch(scanner.next()) {
                        case "1" :
                            makingEspresso();
                            break;
                        case "2" :
                            makingLatte();
                            break;
                        case "3" :
                            makingCappucino();
                            break;
                        case "back" :
                            break;
                    }
                    break;

                case "fill" :
                    System.out.println("Write how many ml of water do you want to add:");
                    fillWater(scanner.nextInt());

                    System.out.println("Write how many ml of milk do you want to add:");
                    fillMilk(scanner.nextInt());

                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    fillCoffeeBeans(scanner.nextInt());

                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    fillCups(scanner.nextInt());
                    break;

                case "take" :
                    System.out.println("I gave you $" + takeMoney());
                    break;
                case "remaining" :
                    state();
                    break;
                case "exit" :
                    break;
            }
        } while (!action.equals("exit"));

    }
    //METHOD THAT PRINTS CURRENT SUPPLY OF THE COFFEE MACHINE
    public static void state() {
        System.out.println("The coffee machine has:\n" +
                        waterAmount + " of water\n" +
                        milkAmount + " of milk\n" +
                        coffeeBeansAmount + " of coffee beans\n" +
                        disposableCups + " of disposable cups\n" +
                        money + " of money");
    }
    //METHOD FOR MAKING ESPRESSO
    public static void makingEspresso() {
        if (waterAmount >= 250 && coffeeBeansAmount >= 16 && milkAmount >= 50 && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            waterAmount -= 250;
            coffeeBeansAmount -= 16;
            disposableCups -= 1;
            money += 4;
        } else if (waterAmount < 250){
            System.out.println("Sorry, not enough water!");
        } else if (milkAmount < 50) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeansAmount < 16) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    //METHOD FOR MAKING LATTE
    public static void makingLatte() {
        if (waterAmount >= 350 && milkAmount >= 75 && coffeeBeansAmount >= 20 && disposableCups >= 1) {
            System.out.println("Yes, I have enough resources, making you a coffee!");
            waterAmount -= 350;
            milkAmount -= 75;
            coffeeBeansAmount -=20;
            disposableCups -= 1;
            money += 7;
        } else if (waterAmount < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (milkAmount < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeansAmount < 20) {
            System.out.println("SOrry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    //METHOD FOR MAKIG CAPPUCCINO
    public static void makingCappucino() {
        if (waterAmount >= 200 && milkAmount >= 100 && coffeeBeansAmount >= 12 && disposableCups >= 1) {
            System.out.println("Yes, I have enough resources, making you a coffee!");
            waterAmount -= 200;
            milkAmount -= 100;
            coffeeBeansAmount -= 12;
            disposableCups -= 1;
            money += 6;
        } else if (waterAmount < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (milkAmount < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeansAmount < 12) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    //METHOD FOR FILLING WATER
    public static void fillWater(int amount) {
        waterAmount += amount;
    }
    //METHOD FOR FILLING MILK
    public static void fillMilk(int amount) {
        milkAmount += amount;
    }
    //METHOD FOR FILLING COFFE BEANS
    public static void fillCoffeeBeans(int amount) {
        coffeeBeansAmount += amount;
    }
    //METHOD FOR FILLING DISPOSABLE CUPS
    public static void fillCups(int amount) {
        disposableCups += amount;
    }
    //METHOD FOE TAKING MONEY
    public static int takeMoney() {
        int cash = money;
        money = 0;
        return cash;
    }
}
