package ca.etsmtl.log720.lab1.server;

import  java.io.Serializable;
import org.omg.PortableServer.POA;

import ca.etsmtl.log720.lab1.BanqueInfractionsPOA;
import ca.etsmtl.log720.lab1.CollectionInfraction;
import ca.etsmtl.log720.lab1.CollectionInfractionHelper;
import ca.etsmtl.log720.lab1.Dossier;
import ca.etsmtl.log720.lab1.Infraction;
import ca.etsmtl.log720.lab1.NiveauHorsBornesException;


public class BanqueInfractionsImpl extends BanqueInfractionsPOA implements Serializable{

	private CollectionInfractionImpl _collectionInfractions;
	
	public BanqueInfractionsImpl(){
		_collectionInfractions = new CollectionInfractionImpl();
	}
	
	
	public CollectionInfractionImpl getCollectionInfractions(){
		return _collectionInfractions;
	}
	
	public void setCollectionInfractions(CollectionInfractionImpl collection){
		_collectionInfractions = collection;
	}

	public CollectionInfraction infractions() {
		try {

			// Recuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourne l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(this._collectionInfractions);

			// Retourner une Infraction
			return CollectionInfractionHelper.narrow(obj);
		} catch (Exception e) {
			System.out.println("Erreur retour de l'objet CollectionInfraction : " + e);
			return null;
		}
	}

	public CollectionInfraction trouverInfractionsParDossier(Dossier mydossier) {
		// TODO Auto-generated method stub
		return null;
	}

	public Infraction trouverInfractionParId(int idInfraction) {
		return this._collectionInfractions.getInfractionById(idInfraction);
	}

	public void ajouterInfraction(String description, int niveau)
			throws NiveauHorsBornesException {
		InfractionImpl inf = new InfractionImpl();
		int generatedId = this.getAvailableId();
		inf.set_id(generatedId);
		inf.set_niveau(niveau);
		inf.set_description(description);
		this._collectionInfractions.getListeEtudiants().add(inf);
		save();
	}
	
	public int getAvailableId(){
		return this._collectionInfractions.size();
	}
	
	private void save(){
		// Save the collection
		try {
			SerializationTools.encodeToFile(this, "../../persist/banqueinfractions.ser");
        } catch(Exception e) {
            e.printStackTrace();
        }
	}

}
