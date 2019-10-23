import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;



public class Compte 
{
	
	// Atributs
	private static final AtomicInteger count = new AtomicInteger(0);  	// Permet d'incrémenter le numéro de compte
	private final int numm;												// Numéro du compte en entier, incrémentable
	private String numero = "0"; 										// Numéro d'un compte bancaire
	private double solde; 												// Solde du compte, ne peut pas être négatif
	private LocalDate dateCreation; 									// Date de la création du compte
	Personne proprietaire;
	
	// Constructeur
	public Compte(double sol, Personne proprio)
	{
		// DateTimeFormatter permet d'obtenir en format String la date d'aujourd'hui(du système qui lance le programme)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
		numm = count.incrementAndGet();
		numero = ""+numm+"";
		solde = sol;
		dateCreation = LocalDate.now();
		proprietaire = proprio;
	}
	
	// Constructeur par défaut
	public Compte()
	{
		numm = count.incrementAndGet();
		dateCreation = LocalDate.now();
		numero =""+numm+"";
		solde = 0;
	}
	
	// Méthodes
	
	// Créditer un compte, ajouter de l'argent
	public void crediter(double argent)
	{
		this.solde += argent;
	}
	
	// Débiter un compte, retirer des sours. Condition : Solde > argent
	public void debiter(double argent)
	{
		if((this.solde > argent) && (this.solde > 0))
		{
			this.solde -= argent;
		} else {
			System.out.println("Impossible de débiter, votre solde est trop bas");
		}
	}
	
	// Méthode toString permettant d'afficher le l'objet
	public String toString()
	{
		return "Numéro : "+ this.numero +" Solde : "+ this.solde +" Date de Création : "+ this.dateCreation;
	}
	
	// Retourne le solde du compte
	public double getSolde()
	{
		return this.solde;
	}
	
	// Retourne le numéro du compte
	public String getNumero()
	{
		return this.numero;
	}
	
	// Retourne la date de la création du compte
	public LocalDate getDateCreation()
	{
		return this.dateCreation;
	}
	public Personne getProprio()
	{
		return this.proprietaire;
	}
	
	
}
