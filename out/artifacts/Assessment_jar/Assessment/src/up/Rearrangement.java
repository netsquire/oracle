package up;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class Rearrangement {

    private static List<Product> products = new LinkedList<>();
    private static List<String> keyList = new LinkedList<>();

    public static void main(String[] args){
        products.add(new Product("GREEN"));
        products.add(new Product("RED"));
        products.add(new Product("BLACK"));
        products.add(new Product("WHITE"));
        products.add(new Product("GRAY"));
        products.add(new Product("BLUE"));

        keyList.add("RED");
        keyList.add("BLUE");
        keyList.add("WHITE");
        keyList.add("GREEN");

        dump("Given: ", products);
        dump("After re-arrangement: ",  arrangeProducts(keyList, products));
    }

    private static List<Product> arrangeProducts(List<String> keyList, List<Product> products){
        List<Product> output = new LinkedList<>();
        Map<String, Integer> innerOrder = findInnerStructure(products);
        for(String key : keyList) {
            output.add(products.get(innerOrder.get(key)));
        }
        return output;
    }

    private static Map<String, Integer> findInnerStructure(List<Product> products) {
        int index = 0;
        Map<String, Integer> order = new HashMap<>();
        for (Product product : products){
            order.put(product.getKey(), index++);
        }
        return order;
    }

    private static void dump(String message, List<Product> toBeDumped){
        out.println(message);
        for (Product product : toBeDumped){
            out.println(product);
        }
    }
}
