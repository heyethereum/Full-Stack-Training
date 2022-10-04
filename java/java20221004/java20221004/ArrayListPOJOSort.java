package java20221004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListPOJOSort {
  public static void main(String[] args) {
    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new Product("Glasses", 30));
    productList.add(new Product("Cups", 20));
    productList.add(new Product("Plates", 10));

    // Java 8 Comparator comparing, comparingInt, comparingDouble, comparingLong
    // sorting by price in ascending order
    Comparator<Product> priceComparator = Comparator.comparingDouble(Product::getPrice);
    productList.sort(priceComparator);
    System.out.println(productList);

    // sorting by price in decending order with direct static method
    productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    System.out.println(productList);

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
