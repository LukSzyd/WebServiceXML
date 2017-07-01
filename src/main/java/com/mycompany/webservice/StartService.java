/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webservice;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Lukasz
 */
public class StartService {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/classicmodels";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   static Connection conn = null;
   static Statement stmt = null;
    public static void main(String[] args) throws InterruptedException, SQLException {
        String mode = args[0];
        if ("start".equals(mode)){
            readXML read = new readXML();
            Endpoint.publish("http://localhost:9099/readXML", read);
            readDB();
        }
        if ("stop".equals(mode)){
            System.exit(0);
        }
        
    }
    
    public static void readDB() throws SQLException{
        Connection conn = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");
           
           //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = (Statement) conn.createStatement();

            String sql = "SELECT * from customers";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }
       //Handle errors for JDBC
       finally{
            //finally block used to close resources
            if (conn!=null) {
                conn.close();
            } //end finally try
        }//end try
        System.out.println("Goodbye!");
     }
}
