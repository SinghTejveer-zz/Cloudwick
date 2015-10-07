package com.CW.pr1;

import java.sql.*;

/**
 * Created by Tejveer on 02/04/2015.
 */
public class JDBCSample {
    public int Sample() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try{
            // Create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:JDBCSample.db");
            Statement statement = connection.createStatement();
             //set timeout to 30 sec
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string, salary integer)");
            statement.executeUpdate("insert into person values(2112623, 'Tejveer', 32000)");
            statement.executeUpdate("insert into person values(2163592, 'Rachit', 36000)");
            statement.executeUpdate("insert into person values(110011, 'Parth', 00000)");

            ResultSet result = statement.executeQuery("select * from person where salary> 31000");

            while(result.next()){
                //read the result set
                System.out.println("id = " + result.getInt("id"));
                System.out.println("name = " + result.getString("name"));
                System.out.println("salary = " + result.getInt("salary"));

            }


        } catch (SQLException e){
            // if the error message is out of memory
            // if no database file is found
            System.err.println(e.getMessage());
        }finally {
            try {
                if (connection != null)
                    connection.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
        return 0;
    }



    public static void main(String[] args) throws ClassNotFoundException {
     JDBCSample object1 = new JDBCSample();
        object1.Sample();
    }
}
