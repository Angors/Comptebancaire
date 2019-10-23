import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
	public static void main (String args[])
	{
		boolean menu = true;
		Scanner sc = new Scanner(System.in);
		Personne user = new Personne("TEST", "Eur", "10/10/2018", "test@test.com");
		
		// Création des comtpes bancaires, instances de la classe Compte
		Compte compta = new Compte(100,user);
		Compte comptab = new Compte (100,user);
		Compte comptabl = new Compte();
		Banque bank = new Banque();
		// Initialisation de la banque
		bank.ajouterBanque(bank,compta);
		bank.ajouterBanque(bank,comptab);
		bank.ajouterBanque(bank,comptabl);
		
		// utilisation des méthodes de Compte
		compta.crediter(100);
		comptab.debiter(10);
		System.out.println(comptabl.getSolde());
		System.out.println(comptabl.getDateCreation());
		System.out.println(compta);
		System.out.println(comptab);
		System.out.println(compta.getProprio().getNom() +" "+ compta.getProprio().getPrenom());
		
		// Menu //
		
		while(menu)
		{
			System.out.println("Bienvenue sur la plateforme de votre banque. Veuillez rentrer votre numéro de compte.");
		
			String numeroLog = sc.nextLine();
			
			// Login //
			for(int i = 0; i < bank.getTailleBanque(bank); i++)
			{
				if(numeroLog.equals(bank.elementAtBanque(bank, i).getNumero())) 
				{ 
					// Menu switch //
					
					
					System.out.println("Choississez le service souhaité :");
					System.out.println("(1) pour regarder votre compte.");
					System.out.println("(2) pour ajouter de l'argent sur votre compte.");
					System.out.println("(3) pour retirer de l'argent de votre compte.");
					int choix = sc.nextInt();
					switch(choix)
					{
					case 1: // Checker le compte
						if(numeroLog.equals(compta.getNumero())) { System.out.println(compta); }
						if(numeroLog.equals(comptab.getNumero())) { System.out.println(comptab); }
						break;
					case 2: // Ajout d'argent
						if(numeroLog.equals(compta.getNumero())) 
						{
							System.out.println("Choississez le montant à ajouter :");
							choix = sc.nextInt();
							compta.crediter(choix);
						}
						if (numeroLog.equals(comptab.getNumero()))
						{
							System.out.println("Choississez le montant à ajouter :");
							choix = sc.nextInt();
							comptab.crediter(choix);
						}
						break;
					case 3:
						if(numeroLog.equals(compta.getNumero())) 
						{
							System.out.println("Choississez le montant à retirer :");
							choix = sc.nextInt();
							compta.debiter(choix);
						}
						if (numeroLog.equals(comptab.getNumero()))
						{
							System.out.println("Choississez le montant à retirer :");
							choix = sc.nextInt();
							comptab.debiter(choix);
						}
						break;
					}
				}
			}
			System.out.println("Voulez-vous continuer à utiliser nos services? Oui : 0  /  Non : 1 ");
			int choix = sc.nextInt();
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
