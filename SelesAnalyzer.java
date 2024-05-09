
package Seles;
import java.util.Arrays;

 public class SelesAnalyzer {
	private double[] sales;
    private int salesCount;
    
    

    
    public void addSale(double saleAmount) {
        if (saleAmount < 0) {
            throw new IllegalArgumentException("Sale amount cannot be negative.");
        }
        if (sales == null) {
            sales = new double[1];
        } else {
            sales = Arrays.copyOf(sales, sales.length + 1);
        }
        sales[salesCount++] = saleAmount;
    }

    
    public double calculateTotalSales() {
        if (sales == null || salesCount == 0) {
            throw new IllegalStateException("No sales recorded.");
        }
        double totalSales = 0;
        for (double sale : sales) {
            totalSales += sale;
        }
        return totalSales;
    }

  
    public double calculateAverageDailySales() {
        if (sales == null || salesCount == 0) {
            throw new IllegalStateException("No sales recorded.");
        }
        return calculateTotalSales() / salesCount;
    }

  
    public int findBestSalesDay() {
        if (sales == null || salesCount == 0) {
            throw new IllegalStateException("No sales recorded.");
        }
        int bestDay = 0;
        double bestSale = sales[0];
        for (int i = 1; i < salesCount; i++) {
            if (sales[i] > bestSale) {
                bestDay = i;
                bestSale = sales[i];
            }
        }
        return bestDay;
    }


    public int findWorstSalesDay() {
        if (sales == null || salesCount == 0) {
            throw new IllegalStateException("No sales recorded.");
        }
        int worstDay = 0;
        double worstSale = sales[0];
        for (int i = 1; i < salesCount; i++) {
            if (sales[i] < worstSale) {
                worstDay = i;
                worstSale = sales[i];
            }
        }
        return worstDay;
    }
    public void displaySalesReport() {
        if (sales == null || salesCount == 0) {
            throw new IllegalStateException("No sales recorded.");
        }
        System.out.println("Sales Report:");
        System.out.println("Total Sales: $" + calculateTotalSales());
        System.out.println("Average Daily Sales: $" + calculateAverageDailySales());
        System.out.println("Best Sales Day: Day " + (findBestSalesDay() + 1));
        System.out.println("Worst Sales Day: Day " + (findWorstSalesDay() + 1));
    }
    
    public static void main(String[] args) {
    	SelesAnalyzer salesAnalyzer=new SelesAnalyzer();
        salesAnalyzer.addSale(150.75);
        salesAnalyzer.addSale(200.25);
        salesAnalyzer.addSale(180.30);
           
        salesAnalyzer.displaySalesReport();
    }

    }


