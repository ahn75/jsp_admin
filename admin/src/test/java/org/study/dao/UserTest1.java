package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserTest1 {

	/**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("드라이버 로딩 성공...");

        String url="jdbc:oracle:thin:@localhost:1521:xe";  
        String user="HR";
        String pwd="1111";
          
        Connection con=DriverManager.getConnection(url,user,pwd);
        System.out.println("DB 연결 성공!");
          
        Statement st=con.createStatement();
        String sql="select * from hd_application";
        ResultSet rs=st.executeQuery(sql);
          
        while(rs.next()){
            String id=rs.getString(1);
            String passwd=rs.getString(2);
            String dept=rs.getString(3);
            System.out.println(id+"\t"+passwd+"\t"+dept);
        }//while---------
          
        rs.close();
        st.close();
        con.close();
    }

	
}
