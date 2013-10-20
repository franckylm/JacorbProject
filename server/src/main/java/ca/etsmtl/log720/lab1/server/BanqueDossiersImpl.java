package ca.etsmtl.log720.lab1.server;

import java.io.Serializable;
import java.util.List;

import org.omg.PortableServer.POA;

import ca.etsmtl.log720.lab1.BanqueDossiersPOA;
import ca.etsmtl.log720.lab1.CollectionDossier;
import ca.etsmtl.log720.lab1.CollectionDossierHelper;
import ca.etsmtl.log720.lab1.Dossier;
import ca.etsmtl.log720.lab1.DossierHelper;
import ca.etsmtl.log720.lab1.InvalidIdException;
import ca.etsmtl.log720.lab1.NoPermisExisteDejaException;



public class BanqueDossiersImpl extends BanqueDossiersPOA implements Serializable{
	
	private CollectionDossierImpl m_dossiers = null;
	
	public BanqueDossiersImpl() {
		m_dossiers = new CollectionDossierImpl();
	}
	
	public CollectionDossier dossiers() {
		
		try {
			// Recuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourne l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa
					.servant_to_reference(m_dossiers);

			// Retourner une Collection d'etudiant
			return CollectionDossierHelper.narrow(obj);
			
		} catch (Exception e) {
			System.out.println("Erreur retour de l'objet CollectionEtudiant : "	+ e);
			return null;
		}
	}

	public CollectionDossier trouverDossiersParPlaque(String plaque) {
		try{
			CollectionDossierImpl dossiers = new CollectionDossierImpl();
			for(DossierImpl dossier : m_dossiers.getListeDossier()){
				if(plaque == dossier.noPlaque()){
					dossiers.add(dossier);
				}
			}
			// Recuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourne l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(dossiers);

			return CollectionDossierHelper.narrow(obj);
		}catch(Exception e){
			System.out.println("Erreur retour de l'objet CollectionDossier : "	+ e);
			return null;
		}
	}

	public CollectionDossier trouverDossiersParNom(String nom, String prenom) {
		try{
			CollectionDossierImpl dossiers = new CollectionDossierImpl();
			for(DossierImpl dossier : m_dossiers.getListeDossier()){
				if(nom == dossier.nom() && prenom == dossier.prenom()){
					dossiers.add(dossier);
				}
			}
			// Recuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourne l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(dossiers);

			return CollectionDossierHelper.narrow(obj);
		}catch(Exception e){
			System.out.println("Erreur retour de l'objet CollectionDossier : "	+ e);
			return null;
		}
	}

	public Dossier trouverDossierParPermis(String noPermis) {
		try{
			for(DossierImpl dossier : m_dossiers.getListeDossier()){
				if(noPermis == dossier.noPermis()){
					// Recuperer le POA cree dans le serveur
					POA rootpoa = Server._poa;

					// Activer l'objet et retourne l'objet CORBA
					org.omg.CORBA.Object obj = rootpoa.servant_to_reference(dossier);
					return DossierHelper.narrow(obj);
				}
			}
			return null;
		}catch(Exception e){
			System.out.println("Erreur retour de l'objet CollectionDossier : "	+ e);
			return null;
		}
	}

	public Dossier trouverDossierParId(int idDossier) {
		try{
			for(DossierImpl dossier : m_dossiers.getListeDossier()){
				if(idDossier == dossier.id()){
					// Recuperer le POA cree dans le serveur
					POA rootpoa = Server._poa;

					// Activer l'objet et retourne l'objet CORBA
					org.omg.CORBA.Object obj = rootpoa.servant_to_reference(dossier);
					return DossierHelper.narrow(obj);
				}
			}
			return null;
		}catch(Exception e){
			System.out.println("Erreur retour de l'objet CollectionDossier : "	+ e);
			return null;
		}
	}

	public void ajouterDossier(String nom, String prenom, String noPermis,
			String noPlaque) throws NoPermisExisteDejaException {
		int id = m_dossiers.getListeDossier().size();
		DossierImpl dossier = new DossierImpl();
		dossier.setId(id);
		dossier.setNom(nom);
		dossier.setPrenom(prenom);
		dossier.setNoPlaque(noPlaque);
		dossier.setNoPermis(noPermis);
		m_dossiers.getListeDossier().add(dossier);
		save();
	}

	public void ajouterInfractionAuDossier(int idDossier, int idInfraction)
			throws InvalidIdException {
		Dossier dossier = this.trouverDossierParId(idDossier);
		dossier.ajouterInfractionAListe(idInfraction);
		save();
	}

	public void ajouterReactionAuDossier(int idDossier, int idReaction)
			throws InvalidIdException {
		Dossier dossier = this.trouverDossierParId(idDossier);
		dossier.ajouterReactionAListe(idReaction);
		save();
	}
	
	private void save(){
		// Save the collection
		try {
			SerializationTools.encodeToFile(this, "../../persist/banquedossiers.ser");
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	

}
