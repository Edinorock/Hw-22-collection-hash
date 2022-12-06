import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Objects;

public class ProductList {
    private final Set<Product> productsSet = new HashSet<>();
    private final String name;

    public ProductList(String name) {
        this.name = name;
    }

    public void addProduct(Product... products) {
        for (Product product : products) {
            if (this.productsSet.contains(product)) {
                throw new RuntimeException("Этот продукт уже есть в списке");
            } else {
                this.productsSet.add(product);
            }
        }
    }

    public void checkProduct(String name) {
        for (Product product : this.productsSet) {
            if (product.getName().equals(name)) {
                product.setChecked();
            }
        }
    }

    public void removeProduct(Product product) {
        productsSet.remove(product);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductList that = (ProductList) o;
        return Objects.equals(productsSet, that.productsSet);
    }

    public int hashCode() {
        return Objects.hash(productsSet);
    }

    public Set<Product> getProductsSet() {
        return productsSet;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name +
                productsSet;
    }
}