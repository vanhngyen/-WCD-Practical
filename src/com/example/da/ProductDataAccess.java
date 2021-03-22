package com.example.da;



import com.example.entity.Product;
import com.example.entity.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDataAccess {
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM tbproducts";
    private static final String SELECT_USER = "SELECT * FROM users WHERE username = ? and password = ?";
    public PreparedStatement getAllStatement() throws SQLException, ClassNotFoundException {
        if(preparedStatement == null){
            Connection connection = new DBconnection().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
        }
        return preparedStatement;
    }
    public PreparedStatement getUser() throws SQLException, ClassNotFoundException {
        if(preparedStatement == null){
            Connection connection = new DBconnection().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_USER);
        }
        return preparedStatement;
    }
    public List<Product> selectProduct() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getAllStatement();
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> productList = new LinkedList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String price = resultSet.getString("price");
            String amount = resultSet.getString("amount");
            String details = resultSet.getString("details");
            productList.add(new Product(id,name,price,amount,details));
        }
        return productList;
    }
    public User getUser(String username, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getUser();
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        User user = new User();
        while (resultSet.next()){

            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }

        return user;
    }

}