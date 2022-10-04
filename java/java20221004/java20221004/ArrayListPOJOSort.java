package java20221004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListPOJOSort {
  public static void main(String[] args) {
    ArrayList<Product> productList = new ArrayList<>();
    Product product1 = new Product("Glasses", 30);
    Product product2 = new Product("Cups", 20);
    Product product3 = new Product("Plates", 10);
    productList.add(product1);
    productList.add(product2);
    productList.add(product3);

    // Java 8 Comparator comparing, comparingInt, comparingDouble
    Comparator<Product> priceComparator = Comparator.comparingDouble(Product::getPrice);
    Collections.sort(productList, priceComparator);
    // sorting by price in ascending order
    for (Product product : productList) {
      System.out.printf("%s $%.2f%n", product.getName(), product.getPrice());
    }
    // sorting by name
    Collections.sort(productList, new NameComparator());
    for (Product product : productList) {
      System.out.printf("%s $%.2f%n", product.getName(), product.getPrice());
    }

  }

}

/*
 * class PriceComparator implements Comparator<Product> {
 * 
 * @Override
 * public int compare(Product o1, Product o2) {
 * return Double.compare(o1.getPrice(), o2.getPrice());
 * }
 * }
 */
class NameComparator implements Comparator<Product> {
  @Override
  public int compare(Product o1, Product o2) {
    return o1.getName().compareToIgnoreCase(o2.getName());
  }
}
