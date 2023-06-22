package org.yearup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Application implements CommandLineRunner {

    private ProductDao dao;

    @Autowired
    public Application(ProductDao dao){
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {

       List<Product> listOfAll = dao.getAll();
       for (Product p : listOfAll) {
           System.out.println(p);
       }


    }
}
