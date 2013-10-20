package ca.etsmtl.log720.lab1.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.etsmtl.log720.lab1.DossierPOA;

public class DossierImpl extends DossierPOA implements Serializable{
	private int id;
	private String nom;
	private String noPermis;
	private String noPlaque;
	private String prenom;
	private int niveau;
	private ArrayList<Integer> listeInfraction;
    private ArrayList<Integer> listeReaction;
	
    public DossierImpl(){
    	this.nom = null;
		this.noPermis = null;
		this.noPlaque = null;
		this.prenom = null;
		this.niveau = 0;
		listeInfraction = new ArrayList<Integer>();
		listeReaction = new ArrayList<Integer>();		
    }

	public int id() {
		return id;
	}

	public String nom() {
		return nom;
	}

	public String noPermis() {
		return noPermis;
	}

	public String noPlaque() {
		return noPlaque;
	}

	public String prenom() {
		return prenom;
	}

	public int niveau() {
		return niveau;
	}

	public int[] getListeInfraction() {
		return integerListToIntArray(listeInfraction);		
	}

	public int[] getListeReaction() {
		return integerListToIntArray(listeReaction);
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNoPermis(String noPermis) {
		this.noPermis = noPermis;
	}

	public void setNoPlaque(String noPlaque) {
		this.noPlaque = noPlaque;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setListeInfraction(ArrayList<Integer> listeInfraction) {
		this.listeInfraction = listeInfraction;
	}

	public void setListeReaction(ArrayList<Integer> listeReaction) {
		this.listeReaction = listeReaction;
	}

	public void ajouterReactionAListe(int idReaction) {
		listeReaction.add(idReaction);
	}

	public void ajouterInfractionAListe(int idInfraction) {
		this.updateNiveauGravite(idInfraction);
		listeInfraction.add(idInfraction);
	}
	
	public String _toString() {
		String s = "Dossier Id : "+ id + ", Nom : " + nom + " , Prenom : " + prenom + ", Numero de permis : " + noPermis + ", Numero de plaque : " + noPlaque + ", Niveau : " + niveau +", ";
		s += "liste des infractions : "+ listeInfraction + ", liste des reactions : "+ listeReaction;
		
		return s;
	}
	
	public static int[] integerListToIntArray(List<Integer> l){
		int[] result = new int[l.size()];
		
		for(int i = 0; i < l.size(); i++){
			result[i] = l.get(i);
		}
		
		return result;		
	}
	
	private void updateNiveauGravite(int idInfraction){
		//On récupère la banque d'infraction
		BanqueInfractionsImpl banqueInfractions = 
	    (BanqueInfractionsImpl) SerializationTools.decodeFromFile("../../persist/banqueInfractions.ser");
		int niveauInfraction =  banqueInfractions.getCollectionInfractions()
				                .getInfractionById(idInfraction)
				                .niveau();
		if(this.niveau < niveauInfraction){
			this.niveau = niveauInfraction;
		}
	}
}
