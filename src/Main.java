
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product banana = new Product("Бананы", 120, 1);
        Product fish = new Product("Рыба", 500, 2);
        Product salt = new Product("Соль", 50, 1);

        ProductList productList1 = new ProductList("Список продуктов №1");
        productList1.addProduct(salt, fish);
        productList1.checkProduct("Соль");
        productList1.removeProduct(fish);
        System.out.println(productList1);

        Recipe recipe1 = new Recipe("Запеченная рыба", salt);
        recipe1.addProductList(productList1);
        System.out.println(recipe1);

        numberSetRemoveEven();
    }

    private static void numberSetRemoveEven() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(0));
        }

        System.out.println(numbers);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 != 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }
}