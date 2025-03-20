package jdbc_pro1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Project1 {
	Scanner sc = new Scanner(System.in);
	public static void createDB(String dbName) throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:2004/","postgres","********");
		String query="create database "+dbName;
		Statement stmt = con.createStatement();
		stmt.execute(query);
		System.out.println("---------DB successfully created.------------");
		stmt.close();
		con.close();
	}
	
	public static void createTbl(String dbName, String tblName) throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:2004/"+dbName,"postgres","********");
		Statement stmt = con.createStatement();
		ResultSet rs = con.getMetaData().getTables(null, null, tblName, null);
	    if (rs.next()) {
	        System.out.println("Table '" + tblName + "' already exists!");
	    } else {
	        String query = "CREATE TABLE " + tblName + " (id INT PRIMARY KEY, name VARCHAR(255) NOT NULL, amount DECIMAL(10,2) NOT NULL);";
	        stmt.execute(query);
	        System.out.println("------------ Event '" + tblName + "' successfully created. --------------");
	    }

	    rs.close();
		con.close();
	}
	
	public static void insertTbl(String dbName, String tblName,int id,String name,double amount)throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:2004/"+dbName,"postgres","********");
		String query="INSERT INTO "+tblName+" VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setDouble(3, amount);
		pstmt.executeUpdate();
		System.out.println("-------------The new Entry is succefully Inserted---------");
		pstmt.close();
		con.close();		
	}
	
	public static void updateTbl(String dbName, String tblName,int id,String name,double amount)throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:2004/"+dbName,"postgres","********");
		String query1="SELECT amount FROM "+tblName+" WHERE id="+id;
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery(query1);
		double prevAmount=0;
		while(rs.next()) {
			prevAmount=rs.getDouble("amount");
		}
		String query="UPDATE "+tblName+" SET amount=? WHERE id=? AND name=? ";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(2, id);
		pstmt.setString(3, name);
		pstmt.setDouble(1, prevAmount+amount);
		System.out.println("--------------New Amount succesfully updated-----------");
		pstmt.executeUpdate();
		pstmt.close();
		con.close();		
	}
	
	public static void retriveTbl(String dbName, String tblName)throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:2004/"+dbName,"postgres","********");
		String query="SELECT * FROM "+tblName;
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery(query);
		System.out.println("\n\nThe Event entries of event:"+tblName+"\n");
		while(rs.next()) {
			System.out.println("||Donor id: "+rs.getInt("id")+"|| Donor Name: "+rs.getString("name")+"|| Donation amuont : "+rs.getDouble("amount")+"||");
		}
		stmt.close();
		con.close();		
	}
	
	public static void dropTbl(String dbName, String tblName) throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:2004/"+dbName,"postgres","********");
		String query="drop table "+tblName;
		Statement stmt = con.createStatement();
		stmt.execute(query);
		System.err.println("---------------The Event succesfully deleted.--------------");
		stmt.close();
		con.close();
	}
	
	public void ui(String tblname) {
		String dbName="donation";
		int choice=0;
		while(choice!=7) {
			System.out.println("Enter the choice: \n 1. create DB\n 2. New Type of Event\n 3. New Entry \n 4. Add new amount to existing \n 5. Show all donations\n 6. Delete Event\n 7. Exit");
			choice=sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter the database name(preffered: donation)");
					String tblName = sc.nextLine();
					tblName=tblName.replaceAll(" ", "_");
					createDB(dbName);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("Enter the donation type Event name(like: ganesh_chaturthi, holi, republic_day)");
					tblname = sc.nextLine().replaceAll(" ", "_");
					createTbl(dbName,tblname);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("Enter Donor id:");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter donor name:");
					String name=sc.nextLine();
					System.out.println("Enter donoation amount:");
					double amount=sc.nextDouble();
					insertTbl(dbName,tblname, id, name, amount);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println("Enter Donor id:");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter new Donor name:");
					String name=sc.nextLine();
					System.out.println("Enter new Donation Amount:");
					double amount =sc.nextDouble();
					updateTbl(dbName,tblname, id, name, amount);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;	
			case 5:
				try {
					retriveTbl(dbName,tblname);
				} catch (SQLException e) {
					System.out.println("table is not existing");
					e.printStackTrace();
				}
				break;
			case 6:
				try {
					System.out.println("Enter the donation type Event name(like: ganesh_chaturthi, holi, republic_day)");
					tblname = sc.nextLine().replaceAll(" ", "_");
					dropTbl(dbName,tblname);
				} catch (SQLException e) {
					System.out.println("The Event does not Exists");
					e.printStackTrace();
				}
				break;
			case 7:
				break;
		
			default:
				break;
			}
		}
	}
	
	public void userType() {
		System.out.println("Welcome to the donation portal");
		System.out.println("Are you new or existing user:\n 1. New\n 2. Existing");
		int ch1=sc.nextInt();
		sc.nextLine();
		if(ch1==1) {
			try {
				System.out.println("Enter the donation type name(like: ganesh_chaturthi, holi, republic_day)");
				String tblName = sc.nextLine().replaceAll(" ", "_");
				String dbName="donation";
				createTbl(dbName,tblName);
				System.out.println("Enter Donor id:");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter donor name:");
				String name=sc.nextLine();
				System.out.println("Enter donoation amount:");
				double amount=sc.nextDouble();
				insertTbl(dbName, tblName, id, name, amount);
				ui(tblName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else if(ch1==2){
			System.out.println("Enter the donation type name(like: ganesh_chaturthi, holi, republic_day)");
			String tblName = sc.nextLine();
			tblName=tblName.replaceAll(" ", "_");
			ui(tblName);
		}else {
			System.out.println("Invalid Input.");
		}
	}

	public static void main(String[] args) {
			JDBC_Project1 ob1=new JDBC_Project1();
			Scanner sc = new Scanner(System.in);
			int ch=0;
			do {
				ob1.userType();
				System.out.println("Do you wish to continue? \n 1. yes \n 2. no");
				ch=sc.nextInt();
				sc.nextLine();
			} while (ch==1);
			System.out.println("-----------------Thank you.----------------------");		
			
			sc.close();
	}
}
