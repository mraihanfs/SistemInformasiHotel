/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;
import java.sql.*;
 
public class Database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hotel";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public String user;
    public String pass;
    public void manggil() {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
             String sql = "SELECT * FROM resepsionis AND";
             rs = stmt.executeQuery(sql);
             while(rs.next()){
                System.out.println("NIK: " + rs.getString("NIK"));
                System.out.println("Nama: " + rs.getString("Nama"));
                System.out.println("username: " + rs.getString("username"));
            }
            
             stmt.close();
             conn.close();
        }catch(Exception e){
           e.printStackTrace(); 
        }
    }
    
    public boolean verifR(){
       try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
             String sql = "SELECT * FROM resepsionis WHERE username ='"+this.user+"' AND password ='"+this.pass+"'";
             rs = stmt.executeQuery(sql);
             if(rs.next()){
                
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
           e.printStackTrace(); 
        } 
        return false;
    }
    public boolean veriA(){
       try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
             String sql = "SELECT * FROM admin WHERE User ='"+this.user+"' AND Password ='"+this.pass+"'";
             rs = stmt.executeQuery(sql);
             
             if(rs.next()){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
           e.printStackTrace(); 
        } 
        return false;
    }
    public void koneksi(){
        try{
           Class.forName(JDBC_DRIVER);
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           stmt = conn.createStatement();
           
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
    
}