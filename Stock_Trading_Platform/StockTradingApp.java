package stock_trading;

import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingApp {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Stock> availableStocks =
            new ArrayList<Stock>();

    static Portfolio portfolio =
            new Portfolio(100000);

    public static void main(String[] args) {

        loadStocks();

        int choice;

        do {

            showMenu();

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showAvailableStocks();
                    break;

                case 2:
                    buyStock();
                    break;

                case 3:
                    sellStock();
                    break;

                case 4:
                    portfolio.showPortfolio();
                    break;

                case 5:
                    portfolio.showBalance();
                    break;

                case 6:
                    portfolio.showTransactions();
                    break;

                case 7:
                    System.out.println();
                    System.out.println("Thank you for using");
                    System.out.println("Stock Trading Platform.");
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice.");
                    System.out.println("Please select 1 to 7.");
            }

        } while (choice != 7);

        sc.close();
    }

    static void loadStocks() {

        availableStocks.add(
                new Stock("TCS", "Tata Consultancy Services", 3500));

        availableStocks.add(
                new Stock("INFY", "Infosys", 1700));

        availableStocks.add(
                new Stock("HDFC", "HDFC Bank", 1650));

        availableStocks.add(
                new Stock("RELIANCE", "Reliance Industries", 2900));

        availableStocks.add(
                new Stock("WIPRO", "Wipro", 550));

        availableStocks.add(
                new Stock("ITC", "ITC Limited", 500));
    }

    static void showMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       STOCK TRADING PLATFORM");
        System.out.println("========================================");
        System.out.println("1. View Available Stocks");
        System.out.println("2. Buy Stock");
        System.out.println("3. Sell Stock");
        System.out.println("4. View Portfolio");
        System.out.println("5. Check Balance");
        System.out.println("6. Transaction History");
        System.out.println("7. Exit");
        System.out.println("========================================");
    }

    static void showAvailableStocks() {

        System.out.println();
        System.out.println("========== AVAILABLE STOCKS ==========");

        System.out.printf("%-10s %-30s %s%n",
                "Symbol", "Company", "Price");

        System.out.println("------------------------------------------------");

        for (Stock stock : availableStocks) {

            stock.displayStock();
        }
    }

    static void buyStock() {

        showAvailableStocks();

        System.out.println();

        System.out.print("Enter stock symbol: ");

        String symbol = sc.next();

        Stock stock = findStock(symbol);

        if (stock == null) {

            System.out.println("Stock not found.");
            return;
        }

        System.out.print("Enter quantity: ");

        int quantity = sc.nextInt();

        portfolio.buyStock(stock, quantity);
    }

    static void sellStock() {

        portfolio.showPortfolio();

        System.out.println();

        System.out.print("Enter stock symbol: ");

        String symbol = sc.next();

        Stock stock = findStock(symbol);

        if (stock == null) {

            System.out.println("Stock not found.");
            return;
        }

        System.out.print("Enter quantity: ");

        int quantity = sc.nextInt();

        portfolio.sellStock(stock, quantity);
    }

    static Stock findStock(String symbol) {

        for (Stock stock : availableStocks) {

            if (stock.symbol.equalsIgnoreCase(symbol)) {

                return stock;
            }
        }

        return null;
    }
}
