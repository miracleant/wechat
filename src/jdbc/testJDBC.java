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
			System.out.println("���ݿ��������سɹ�");
			/**
			 * �������ݿ����ӣ���Ҫ�ṩ
			 * ���ݿ������ڵ�ip:127.0.0.1(����)
			 * ���ݿ�˿ں�:3306
			 * ���ݿ�����:hutu
			 * ���뷽ʽ:UTF-8
			 * �˺�:root 
			 * ���룺hcf1443497165..
			 */
			//���ӷ�ʽһ
			c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tmall?characterEncoding=UTF-8","root","hcf1443497615..");
			System.out.println("���ӳɹ�����ȡ���Ӷ���: "+c);
			s=c.createStatement();
			System.out.println("��ȡStatement����: "+s+"1");

			
//			String sql="insert into product values("+5+","+"'̨��'"+","+50+")";
//			s.execute(sql);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر����ݿ�����
			//�ȹر�Statement
			if(s!=null)
				try {
					s.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			//�ر�Connection
			if(c!=null)
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
	} 
}
