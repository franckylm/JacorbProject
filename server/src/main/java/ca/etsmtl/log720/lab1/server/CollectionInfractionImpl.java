package ca.etsmtl.log720.lab1.server;

import java.util.ArrayList;
import  java.io.Serializable;

import org.omg.PortableServer.POA;

import ca.etsmtl.log720.lab1.CollectionInfractionPOA;
import ca.etsmtl.log720.lab1.Infraction;
import ca.etsmtl.log720.lab1.InfractionHelper;

public class CollectionInfractionImpl extends CollectionInfractionPOA implements Serializable{

private ArrayList<InfractionImpl> _listeInfractions;
	
	public CollectionInfractionImpl(){
		this._listeInfractions = new ArrayList<InfractionImpl>();
	}
	public Infraction getInfraction(int index) {
		try {
			// Trouver l'infraction correspondant au paramètre index
			InfractionImpl infraction = _listeInfractions.get(index);

			// Recuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourne l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(infraction);

			// Retourner une Infraction
			return InfractionHelper.narrow(obj);
		} catch (Exception e) {
			System.out.println("Erreur retour de l'objet Infraction : " + e);
			return null;
		}
	}

	public int size() {
		return _listeInfractions.size();
	}
	
	public Infraction getInfractionById(int id){
		InfractionImpl infractionToReturn = new InfractionImpl();
		for(InfractionImpl infraction : _listeInfractions){
			int idInf = infraction.id();
			if(id == idInf){
				infractionToReturn = infraction;
				try {
					// Recuperer le POA cree dans le serveur
					POA rootpoa = Server._poa;

					// Activer l'objet et retourne l'objet CORBA
					org.omg.CORBA.Object obj = rootpoa.servant_to_reference(infractionToReturn);

					// Retourner une Infraction
					return InfractionHelper.narrow(obj);
				} catch (Exception e) {
					System.out.println("Erreur retour de l'objet Infraction : " + e);
					return null;
				}
			}
		}
		return null;
	}
	
	public ArrayList<InfractionImpl> getInfractionByNiveau (int niveau){
		return null;
	}
	
	protected ArrayList<InfractionImpl> getListeEtudiants() {
		return _listeInfractions;
	}

}
