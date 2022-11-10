package com.student.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class School_management {
public static void main(String[] args) throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String  url="jdbc:mysql://localhost:3306/School?characterEncoding=utf8";
		String username="root";
		String password="root";
		Connection con =DriverManager.getConnection(url,username,password);
 
		java.sql.Statement stmt =con.createStatement();
		ResultSet rs;
		PreparedStatement st;
 
		String qry="";
		int id = 0 ,std,rollnumber,choice,standard,commerce,economics;
		String name = null,city = null,result;
		
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
 
		while(true)
		{
			System.out.println("School Management System");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. STUDENT Data");
			System.out.println("5. view result");
			System.out.println("6. Exit");
			System.out.print("Enter a choice: ");
			choice = in.nextInt();
			System.out.println("-----------------------------------------");
			switch(choice){
			case 1:
				System.out.println("1. Insert New Data");
				
				System.out.println("Enter ID : ");
				id=in.nextInt();
 
				System.out.println("Enter Name : ");
				name=str.nextLine();
				System.out.println("Enter City : ");
				city=str.nextLine();
				System.out.println("Enter Standard : ");
				standard=in.nextInt();
				qry="insert into student2 (ID,NAME,CITY,STANDARD) values(?,?,?,?)";
				st= con.prepareStatement(qry);
				st.setInt(1, id);
				st.setString(2, name);
				
				st.setString(3,city);
				st.setInt(4, standard);
				st.executeUpdate();
				System.out.println("Data Inserted SuccessFully");
 
				break;
			case 2:
				System.out.println("2. Updating a Data");
 
				System.out.println("Enter Existing ID : ");
				id=in.nextInt();
				System.out.println("Enter Name : ");
				name=str.nextLine();
				System.out.println("Enter City : ");
				city=str.nextLine();
				System.out.println("Enter Standard : ");
				standard=in.nextInt();
                qry="update student2 set NAME=?,CITY=?,STANDARD=? where ID=?";
				st= con.prepareStatement(qry);
                st.setString(1, name);
				st.setString(2,city);
				st.setInt(3, standard);
				st.setInt(4, id);
				
				
				st.executeUpdate();
				System.out.println("Data Updated SuccessFully");
 
				break;
			case 3:
				System.out.println("3. Deleting a Data");
				System.out.println("Enter ID : ");
				id=in.nextInt();
 
				qry="delete from student2 where ID=?";
				st= con.prepareStatement(qry);
				st.setInt(1, id);
 
				st.executeUpdate();
				System.out.println("Data Deleted Success");
 
				break;
			case 4:
				System.out.println("4. Print all Records");
				qry="SELECT ID,NAME,CITY,STANDARD from student2";
				rs=stmt.executeQuery(qry);
				while(rs.next())
				{
					id=rs.getInt("ID");
					name=rs.getString("NAME");
					city=rs.getString("CITY");
					standard=rs.getInt("STANDARD");
		            System.out.print(id+" ");
					System.out.print(name+" ");
					System.out.print(city+" ");
					System.out.println(standard+" ");
					
					
					
 
				}
				break;
				case 5:
					System.out.println("4. Print all Records");
					qry="SELECT ID,NAME,STD,COMMERCE,ECONOMICS,ROLLNUMBER,RESULT from AssessmentResult1";
					rs=stmt.executeQuery(qry);
					while(rs.next())
					{
						id=rs.getInt("ID");
						name=rs.getString("NAME");
						std=rs.getInt("STD");
						commerce=rs.getInt("COMMERCE");
		                economics=rs.getInt("ECONOMICS");
						rollnumber=rs.getInt("ROLLNUMBER");
						result=rs.getString("RESULT");
						
	 
						System.out.println(id+" ");
						System.out.println(name+" ");
						System.out.println(std+" ");
						System.out.println(commerce+" ");
						System.out.println(economics+" ");
						System.out.println(rollnumber+" ");
						System.out.println(result+" ");
						System.out.println(" ");
						
					}
				
			case 6:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
			
			System.out.println("-----------------------------------------");
		}
	

}
}

