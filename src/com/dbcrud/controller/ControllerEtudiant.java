package com.dbcrud.controller;
import com.dbcrud.config.Config;
import com.dbcrud.models.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ControllerEtudiant extends Etudiant {
	Config configuration = new Config("jdbc:mysql://localhost/youcode", "root", "");

	public ControllerEtudiant(int id, String name, String des, String cin, Config configuration) {
		super(id, name, des, cin);
		this.configuration = configuration; // new config from com.dbcrud.config

	}
	public ControllerEtudiant() {
		
	}

	
	 public void selectAll(String table) throws SQLException {
		 String sqlString = "SELECT * FROM "+table; // create the Sql query 
		 Statement stmt = configuration.connected().createStatement(); //prepare statement 
		 ResultSet res = stmt.executeQuery(sqlString);//excute the query after be prepared
		 
		 //now we while the data 
		 String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s |%n";

		 System.out.format("+-----------------+-----------------------------------------------------+%n");
		 System.out.format("|      id         |      Name       |   Description   |      CIN        |%n");
		 System.out.format("+-----------------+-----------------------------------------------------+%n");
		 while(res.next()) {

			 System.out.format(leftAlignFormat, res.getString("id"), res.getString("name"), res.getString("des"), res.getString("cin"));
		 }
		 System.out.format("+-----------------+-----------------------------------------------------+%n");
	 }
	 
	 public void create(String table) throws SQLException {
		Scanner scanneIt = new Scanner(System.in);
		System.out.println("Entrer le nom :");
		name = scanneIt.next();
		System.out.println("Entrer une description :");
		des = scanneIt.next();
		System.out.println("Entrer le C.I.N d'etudiant :");
		cin = scanneIt.next();
		 String sqlString = "INSERT INTO "+table+"(name,des,cin) " + "VALUES(?,?,?)"; // create the Sql query
		 java.sql.PreparedStatement stmt = configuration.connected().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
		 stmt.setString(1, name);
		 stmt.setString(2, des);
		 stmt.setString(3, cin);
		 stmt.executeUpdate();
		 System.out.println("Etudiant : "+name+" ajouter avec succés");
	 }
	 public void update(String table) throws SQLException {
			Scanner scanneIt = new Scanner(System.in);
			System.out.println("Entrer id:");
			id = scanneIt.nextInt();
			System.out.println("Entrer le nom :");
			name = scanneIt.next();
			System.out.println("Entrer une description :");
			des = scanneIt.next();
			System.out.println("Entrer le C.I.N d'etudiant :");
			cin = scanneIt.next();
			 String sqlString = "UPDATE "+table+" SET name=?, des=?, cin=?" + "WHERE id=?"; // create the Sql query
			 java.sql.PreparedStatement stmt = configuration.connected().prepareStatement(sqlString);
			 stmt.setString(1, name);
			 stmt.setString(2, des);
			 stmt.setString(3, cin);
			 stmt.setInt(4, id);
			 stmt.executeUpdate();
			 System.out.println("Etudiant : "+name+" modifier avec succés");
		 }
	 public void delete(String table) throws SQLException{
		 Scanner scanneIt = new Scanner(System.in);
			System.out.println("Entrer id d'etudiant:");
			id = scanneIt.nextInt();
			String sqlString = "DELETE FROM "+ table + " WHERE id = ?";; // create the Sql query
			java.sql.PreparedStatement stmt = configuration.connected().prepareStatement(sqlString);
			stmt.setInt(1, id);
			 stmt.executeUpdate();

			 System.out.println("Etudiant supprimé avec succés");

	 }
		
}
	


