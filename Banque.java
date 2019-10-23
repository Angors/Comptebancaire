import java.util.Vector;

public class Banque {
	private Vector<Compte> bank; 	// Vecteur de comptes
	private int tailleBank; 		// Taille de la banque
	
	public Banque()
	{
		bank = new Vector<Compte>();
		tailleBank = 0;
	}
	
	public void ajouterBanque(Banque bank, Compte c)
	{
		bank.bank.add(c);
		bank.tailleBank++;
	}
	
	public Compte elementAtBanque(Banque bank, int i)
	{
		return bank.bank.elementAt(i);
	}
	
	public int getTailleBanque(Banque bank)
	{
		return bank.tailleBank;
	}
}
