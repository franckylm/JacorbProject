package ca.etsmtl.log720.lab1.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.POA;

import ca.etsmtl.log720.lab1.CollectionDossierPOA;
import ca.etsmtl.log720.lab1.Dossier;
import ca.etsmtl.log720.lab1.DossierHelper;
import ca.etsmtl.log720.lab1.Infraction;
import ca.etsmtl.log720.lab1.InfractionHelper;

public class CollectionDossierImpl extends CollectionDossierPOA implements Serializable{

	private List<DossierImpl> listeDossier;
	
	public CollectionDossierImpl(){
		listeDossier = new ArrayList<DossierImpl>();
	}
	
	
	public Dossier getDossier(int index) {
		try {
			// Trouver le cours correspondant au parametre "index"
			DossierImpl dossier = listeDossier.get(index);

			// REcuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourner l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(dossier);

			// Retourner un Cours
			return DossierHelper.narrow(obj);
		} catch (Exception e) {
			System.out.println("Erreur retour de l'objet Cours : " + e);
			return null;
		}
	}
	
	public int size() {
		return listeDossier.size();
	}
	
	public List<DossierImpl> getListeDossier(){
		return listeDossier;
	}
	
	public Dossier getDossierById(int id){
		DossierImpl dossierToReturn = new DossierImpl();
		for(DossierImpl dossier : listeDossier){
			int idDossier = dossier.id();
			if(id == idDossier){
				dossierToReturn = dossier;
				try {
					// Recuperer le POA cree dans le serveur
					POA rootpoa = Server._poa;

					// Activer l'objet et retourne l'objet CORBA
					org.omg.CORBA.Object obj = rootpoa.servant_to_reference(dossierToReturn);

					// Retourner une Infraction
					return DossierHelper.narrow(obj);
				} catch (Exception e) {
					System.out.println("Erreur retour de l'objet Dossier : " + e);
					return null;
				}
			}
		}
		return null;
	}
	
	public void add(DossierImpl dossier){
		listeDossier.add(dossier);
	}

}
