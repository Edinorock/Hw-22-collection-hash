import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class Recipe {
    public final static Set<Recipe> allRecipes = new HashSet<>();
    private final Set<Product> productsSet = new HashSet<>();
    private final String recipeName;

    public Recipe(String recipeName, Product... products) {
        this.recipeName = recipeName;
        addProduct(products);
        allRecipes.add(this);
    }

    public void addProductList(ProductList productList) {
        productsSet.addAll(productList.getProductsSet());
    }

    public void addProduct(Product... products) {
        Collections.addAll(productsSet, products);

    }

    public Set<Product> getProductsSet() {
        return productsSet;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product product : productsSet) {
            sum += product.getPrice();
        }
        return sum;
    }

    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipe recipe = (Recipe) o;
        if (Objects.equals(recipeName, recipe.recipeName)) {
            throw new RuntimeException("Такой рецепт уже существует");
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName);
    }

    @Override
    public String toString() {
        return recipeName +
                ", totalPrice=" + getTotalPrice() +
                productsSet +
                '}';
    }
}