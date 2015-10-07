package com.CW.pr1;

import java.sql.*;

/**
 * Created by Tejveer on 02/04/2015.
 */
public class Records {
    public int Sample2() throws ClassNotFoundException {
        long oTime = System.currentTimeMillis();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            // Create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:JDBCSample3.db");
            Statement statement = connection.createStatement();
            //set timeout to 30 sec
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists records");
            statement.executeUpdate("create table Records (id integer, salary integer)");

//            for (int i = 0; i < 100; i++) {
//                statement.executeUpdate("insert into Records values(101,2000)");
//
//            }
//            for (String query : queries) {
//                statement.addBatch(query);
//            }
//            statement.executeBatch();
//            statement.close();
//            connection.close();
            int i = 1;
            int myVar2 = 2001;
            PreparedStatement ps = connection.prepareStatement("insert into Records values(?,?)");
            connection.setAutoCommit(false);
            do {

                ps.setInt(1, i);
                ps.setInt(2, myVar2++);
                ps.addBatch();
                //String myVar = "insert into Records values(" +i + ",2000)";
                //    statement.addBatch("insert into Records values(" + i + "," + myVar2++ + ")");
                // statement.executeUpdate("insert into Records values(101,2000)");
                i++;
            } while (i <= 1000000);

            ps.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
            ps.close();
            //statement.executeBatch();
        } catch (SQLException e) {
            // if the error message is out of memory
            // if no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
            long cTime = System.currentTimeMillis();
            long pTime = cTime - oTime;
            System.out.println(pTime);
        }
        return 0;

    }


    public static void main(String[] args) throws ClassNotFoundException {
        Records object2 = new Records();
        object2.Sample2();
    }
}