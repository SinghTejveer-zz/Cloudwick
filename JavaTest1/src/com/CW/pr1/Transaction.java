package com.CW.pr1;

import java.sql.*;

/**
 * Created by Tejveer on 4/5/15.
 */
public class Transaction {

    public int Banking() {

//        try {
//            Class.forName("org.sqlite.JDBC");
//
//        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
//        }

        Connection connection = null;

        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:JDBCsample3.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists Banker");

            statement.executeUpdate("create table Banker (Id integer, name string, Balance float)");
            statement.executeUpdate("insert into Banker values(1,'Rachit', 30000)");
            statement.executeUpdate("insert into Banker values(2,'Tejveer', 40000)");
            statement.executeUpdate("insert into Banker values(3,'Samanvay', 20000)");
            statement.executeUpdate("insert into Banker values(4,'Karan', 10000)");

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return 0;
    }

    public int Banking1(int amount) throws InvalidTransactionException {

        try {
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:JDBCsample3.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            connection.setAutoCommit(false);

            ResultSet rs = statement.executeQuery("select * from Banker where name='Tejveer'");

            PreparedStatement ps = connection.prepareStatement(
                    "update banker set balance= ? where name='Tejveer'");

            // while (rs.next()) {
            try {
                int currb = rs.getInt("balance");
                int finalb = currb - amount;

                if (finalb < 0) {
                    throw new InvalidTransactionException();
                }

                ps.setInt(1, finalb);
                ps.execute();
                //   }
                connection.commit();
                System.out.println("Your Balance is " + finalb);
            } catch (InvalidTransactionException e) {
                e.printStackTrace();
                connection.rollback();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return 0;
    }

    public static void main(String[] args) throws InvalidTransactionException {

        Transaction B = new Transaction();

        B.Banking();
        //Negative Test
        //B.Banking1(32000);

        // Positive Test
        B.Banking1(2000);


    }

    public class InvalidTransactionException extends Exception {

        public InvalidTransactionException() {
            System.out.println("Transaction Failed.!: The Balance is in negative");
        }
    }


}
