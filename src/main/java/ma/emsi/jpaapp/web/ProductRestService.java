package ma.emsi.jpaapp.web;

import ma.emsi.jpaapp.First.Products;
import ma.emsi.jpaapp.repository.productsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    private productsRepository productrepository ;

    @GetMapping("/products")
    public List<Products> products(){
return productrepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Products findproducts(@PathVariable Long id){
        Products product = productrepository.findById(id).orElse(null);
        return product;
    }

}
