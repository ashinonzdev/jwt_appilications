package jwt.example.jwtApplication.Service;

import jwt.example.jwtApplication.Entity.Product;
import jwt.example.jwtApplication.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        List<Product> productList=productRepository.findAll();
        return productList;
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

}
