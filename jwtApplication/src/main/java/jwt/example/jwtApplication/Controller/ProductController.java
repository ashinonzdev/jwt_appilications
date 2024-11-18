package jwt.example.jwtApplication.Controller;

import jwt.example.jwtApplication.Entity.Product;
import jwt.example.jwtApplication.Repository.ProductRepository;
import jwt.example.jwtApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public String Welcome() {
        return "Welcome this endpoint is not secure";
    }


    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        try {
            Product saveProduct = productService.saveProduct(product);
            return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/get")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Product>> getAllProduct() {
        try {
            List<Product> product = productService.getAllProduct();
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        try {
            Optional<Product> product = productService.getProductById(id);
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
