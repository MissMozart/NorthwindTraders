package org.yearup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class JdbcProductDao implements ProductDao {

    DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Long add(Product product) throws BadKeyException {
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product p = new Product(result.getLong("ProductID"), result.getString("ProductName"),
                        result.getString("CategoryID"), result.getDouble("UnitPrice"));
                productList.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return productList;
    }

    @Override
    public Product findByProductId(Long productId) throws BadKeyException {
        return null;
    }


}
