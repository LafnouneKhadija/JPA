package ma.emsi.jpaapp;

import ma.emsi.jpaapp.First.Products;
import ma.emsi.jpaapp.repository.productsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {
    @Autowired
private productsRepository productrepository;
    public static void main(String[] args)  {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productrepository.save(new Products(null,"computer",4300,3));
        productrepository.save(new Products(null,"phone",1200,10));
        productrepository.save(new Products(null,"mousse",4000,4));
        List<Products> products = productrepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Products product=productrepository.findById(Long.valueOf(1)).get();
        System.out.println("**********************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("**********************");
      List<Products> productList=  productrepository.findByNameContains("c");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("**********************");
        List<Products> productList2=  productrepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);


        });
        System.out.println("**********************");
        List<Products> productList3=  productrepository.findByPriceGreaterThan(4000);
        productList3.forEach(p->{
            System.out.println(p);

        });

    }
        }

    


