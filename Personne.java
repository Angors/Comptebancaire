
public class Personne {
	private String nom;				// nom de la personne
	private String prenom;			// prénom de la personne
	private String dateNaissance;	// date de naissance de la personne
	private String email;	 		// email de la personne

	public Personne(String no, String pre, String date, String mail)
	{
		nom = no;
		prenom = pre;
		dateNaissance = date;
		email = mail;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public String getPrenom()
	{
		return this.prenom;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getDateNaissance()
	{
		return this.dateNaissance;
	}
}
