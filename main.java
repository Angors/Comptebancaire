import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
	public static void main (String args[])
	{
		boolean menu = true;
		Scanner sc = new Scanner(System.in);
		
		// Création des comtpes bancaires, instances de la classe Compte
		Compte compta = new Compte(100);
		Compte comptab = new Compte (100);
		Compte comptabl = new Compte();
		
		// utilisation des méthodes de Compte
		compta.crediter(100);
		comptab.debiter(10);
		System.out.println(comptabl.getSolde());
		System.out.println(comptabl.getDateCreation());
		System.out.println(compta);
		System.out.println(comptab);
		
		// Menu //
		
		while(menu)
		{
			System.out.println("Bienvenue sur la plateforme de votre banque. Veuillez rentrer votre numéro de compte.");
			
		
			String numeroLog = sc.nextLine();
			
			// Login //
			while(!(numeroLog.equals(compta.getNumero())))
			{
				
				System.out.println("Bienvenue sur la plateforme de votre banque. Veuillez rentrer votre numéro de compte.");
			
				numeroLog = sc.nextLine();
			}
			// Menu switch //
			
			
			System.out.println("Choississez le service souhaité :");
			System.out.println("(1) pour regarder votre compte.");
			System.out.println("(2) pour ajouter de l'argent sur votre compte.");
			System.out.println("(3) pour retirer de l'argent de votre compte.");
			int choix = sc.nextInt();
			switch(choix)
			{
			case 1: // Checker le compte
				System.out.println(compta);
				break;
			case 2: // Ajout d'argent
				
				System.out.println("Choississez le montant à ajouter :");
				choix = sc.nextInt();
				compta.crediter(choix);
				break;
			case 3:
				
				System.out.println("Choississez le montant que vous souhaitez retirer :");
				choix = sc.nextInt();
				compta.debiter(choix);
				break;
			}
			
			System.out.println("Voulez-vous continuer à utiliser nos services? Oui : 0  /  Non : 1 ");
			choix = sc.nextInt();
			if(choix == 1)
			{
				menu = false;
				System.out.println("Aurevoir.");
			} else {
				menu = true;
			}
		}
		
	}
}
