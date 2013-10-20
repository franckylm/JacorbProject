package ca.etsmtl.log720.lab1.server;

import java.io.Serializable;

import org.omg.PortableServer.POA;

import ca.etsmtl.log720.lab1.BanqueReactionsPOA;
import ca.etsmtl.log720.lab1.CollectionReaction;
import ca.etsmtl.log720.lab1.CollectionReactionHelper;
import ca.etsmtl.log720.lab1.Dossier;
import ca.etsmtl.log720.lab1.Reaction;

public class BanqueReactionsImpl extends BanqueReactionsPOA implements Serializable
{

    private CollectionReactionImpl _collectionReactions;
	
	public BanqueReactionsImpl()
	{
		_collectionReactions = new CollectionReactionImpl();
	}

	public CollectionReaction reactions() {
		try {

			// Recuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourne l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(this._collectionReactions);

			// Retourner une Reaction
			return CollectionReactionHelper.narrow(obj);
		} catch (Exception e) {
			System.out.println("Erreur retour de l'objet CollectionReaction : " + e);
			return null;
		}
	}

	public CollectionReaction trouverReactionsParDossier(Dossier mydossier) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reaction trouverReactionParId(int idReaction) {
		return this._collectionReactions.getReactionById(idReaction);
	}

	public void ajouterReaction (String description, int niveau) {
		ReactionImpl inf = new ReactionImpl();
		int generatedId = this.getAvailableId();
		inf.set_id(generatedId);
		inf.set_niveau(niveau);
		inf.set_description(description);
		this._collectionReactions.getListeEtudiants().add(inf);
		save();
	}
	
	public int getAvailableId(){
		return this._collectionReactions.size();
	}
	
	private void save(){
		// Save the collection
		try {
			SerializationTools.encodeToFile(this, "../../persist/banquereactions.ser");
        } catch(Exception e) {
            e.printStackTrace();
        }
	}

}
