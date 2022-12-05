import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
public class Recipe {
    public final static Set<Recipe> allRecipes = new HashSet<>();
    private final Map<Product, Integer> productsSet = new HashMap<>();
    private final String recipeName;

    public Recipe(String recipeName, Product... products) {
        this.recipeName = recipeName;
        addProduct(products);
        allRecipes.add(this);
    }

    // public void addProductList(ProductList productList) {
    //  productsSet.addAll(productList.getProductsSet());
    // }

    public void addProduct(Product... products) {
        this.addProduct(1, products);
    }

    public void addProduct(int count, Product... products) {
        for (Product product : products) {
            this.productsSet.put(product, count);
        }
    }
    public int getTotalPrice() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : productsSet.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getProductsSet() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : this.productsSet.entrySet()) {
            builder.append(entry.getKey()).append(" --> ").append(entry.getValue()).append(",\n");
        }
        builder.append("TotalPrice = " + getTotalPrice() + " ,");
        return String.valueOf(builder);
    }

    @Override
    public String toString() {
        return recipeName +
                ", totalPrice=" + getTotalPrice() +
                productsSet +
                '}';
    }
}

