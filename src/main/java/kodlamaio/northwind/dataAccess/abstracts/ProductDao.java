package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    //select - from products where product_name=bisey and categoryId=bisey
    @Query("FROM Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);
    //select * from products where product_name=abc and category_id=1
    //select * from products where category_id in(1,2,3,4)

    @Query("SELECT new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) FROM Category c INNER join c.products p")
    List<ProductWithCategoryDto> getProductWitchCategoryDetails();

    //select p.productId,p.productName,c.CategoryName from Category c inner join Product p
    //on c.categoryId=p.categoryId
}
