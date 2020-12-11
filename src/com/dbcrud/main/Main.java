package com.dbcrud.main;
import com.dbcrud.controller.ControllerEtudiant;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Boolean outBoolean = true;
		while(outBoolean) {
			System.out.println("+-------------------------------+");
			System.out.println("|    WELCOME TO YOUCODE CRUD    |");
			System.out.println("+-------------------------------+");
			System.out.println("1\t  Voir tous les etudiant");
			System.out.println("2\t  Ajouter un etudiant");
			System.out.println("3\t  modifier un etudiant");
			System.out.println("4\t  supprimer un etudiant");
			System.out.println("5\t  quiter");
			
			System.out.println("\nVeuillez entrer votre choix :");
			int input = scanner.nextInt();
			switch (input) {
			case 1:
				try {
					ControllerEtudiant etudiant = new ControllerEtudiant();
					etudiant.selectAll("etudiant");
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();

				}
				break;
			case 2:
				try {
					
					ControllerEtudiant ajoutEtudiant = new ControllerEtudiant();
					ajoutEtudiant.create("etudiant");
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					ControllerEtudiant updateEtudiant = new ControllerEtudiant();
					updateEtudiant.update("etudiant");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			break;
			case 4:
				try {
					ControllerEtudiant deleteEtudiant = new ControllerEtudiant();
					deleteEtudiant.delete("etudiant");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				
				}
				break;
			default:
				System.out.println("Oups une erreur est trouvé");
				break;
			}
		}
		
	}

}
