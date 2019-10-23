import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;



public class Compte 
{
	
	// Atributs
	private static final AtomicInteger count = new AtomicInteger(0);  	// Permet d'incr�menter le num�ro de compte
	private final int numm;												// Num�ro du compte en entier, incr�mentable
	private String numero = "0"; 										// Num�ro d'un compte bancaire
	private double solde; 												// Solde du compte, ne peut pas �tre n�gatif
	private LocalDate dateCreation; 									// Date de la cr�ation du compte
	Personne proprietaire;
	
	// Constructeur
	public Compte(double sol, Personne proprio)
	{
		// DateTimeFormatter permet d'obtenir en format String la date d'aujourd'hui(du syst�me qui lance le programme)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
		numm = count.incrementAndGet();
		numero = ""+numm+"";
		solde = sol;
		dateCreation = LocalDate.now();
		proprietaire = proprio;
	}
	
	// Constructeur par d�faut
	public Compte()
	{
		numm = count.incrementAndGet();
		dateCreation = LocalDate.now();
		numero =""+numm+"";
		solde = 0;
	}
	
	// M�thodes
	
	// Cr�diter un compte, ajouter de l'argent
	public void crediter(double argent)
	{
		this.solde += argent;
	}
	
	// D�biter un compte, retirer des sours. Condition : Solde > argent
	public void debiter(double argent)
	{
		if((this.solde > argent) && (this.solde > 0))
		{
			this.solde -= argent;
		} else {
			System.out.println("Impossible de d�biter, votre solde est trop bas");
		}
	}
	
	// M�thode toString permettant d'afficher le l'objet
	public String toString()
	{
		return "Num�ro : "+ this.numero +" Solde : "+ this.solde +" Date de Cr�ation : "+ this.dateCreation;
	}
	
	// Retourne le solde du compte
	public double getSolde()
	{
		return this.solde;
	}
	
	// Retourne le num�ro du compte
	public String getNumero()
	{
		return this.numero;
	}
	
	// Retourne la date de la cr�ation du compte
	public LocalDate getDateCreation()
	{
		return this.dateCreation;
	}
	public Personne getProprio()
	{
		return this.proprietaire;
	}
	
	
}
