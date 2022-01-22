package kodlamaio.northwind.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
//Entity yazdık -> sen bir veri tabanı nesnesisin demek
@Entity
//Hangi tabloya karşılık geldiğini yazıyoruz
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    private int id;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    public Product() {

    }
    public Product(int id, int categoryId, String productName, double unitPrice, short unitsInStock, String quantityPerUnit) {
        this.id = id;
        this.categoryId = categoryId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.quantityPerUnit = quantityPerUnit;
    }


}
