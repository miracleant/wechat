package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class testJDBC {
	public static void main(String[] args) {
		Connection c=null;
		Statement s=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
			/**
			 * 建立数据库连接，需要提供
			 * 数据库所处于的ip:127.0.0.1(本机)
			 * 数据库端口号:3306
			 * 数据库名称:hutu
			 * 编码方式:UTF-8
			 * 账号:root 
			 * 密码：hcf1443497165..
			 */
			//连接方式一
			c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tmall?characterEncoding=UTF-8","root","hcf1443497615..");
			System.out.println("连接成功，获取连接对象: "+c);
			s=c.createStatement();
			System.out.println("获取Statement对象: "+s+"1");

			
//			String sql="insert into product values("+5+","+"'台灯'"+","+50+")";
//			s.execute(sql);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			//先关闭Statement
			if(s!=null)
				try {
					s.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			//关闭Connection
			if(c!=null)
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
	} 
}
