package ca.etsmtl.log720.lab1.server;

import java.io.Serializable;
import java.util.ArrayList;

import org.omg.PortableServer.POA;

import ca.etsmtl.log720.lab1.CollectionReactionPOA;
import ca.etsmtl.log720.lab1.Reaction;
import ca.etsmtl.log720.lab1.ReactionHelper;

public class CollectionReactionImpl extends CollectionReactionPOA implements Serializable{

private ArrayList<ReactionImpl> _listeReactions;
	
	public CollectionReactionImpl(){
		this._listeReactions = new ArrayList<ReactionImpl>();
	}
	public Reaction getReaction(int index) {
		try {
			// Trouver la reaction correspondant au paramètre index
			ReactionImpl Reaction = _listeReactions.get(index);

			// Recuperer le POA cree dans le serveur
			POA rootpoa = Server._poa;

			// Activer l'objet et retourne l'objet CORBA
			org.omg.CORBA.Object obj = rootpoa.servant_to_reference(Reaction);

			// Retourner une Reaction
			return ReactionHelper.narrow(obj);
		} catch (Exception e) {
			System.out.println("Erreur retour de l'objet Reaction : " + e);
			return null;
		}
	}

	public int size() {
		return _listeReactions.size();
	}
	
	public Reaction getReactionById(int id){
		ReactionImpl reactionToReturn = new ReactionImpl();
		for(ReactionImpl reaction : _listeReactions){
			int idReac = reaction.id();
			if(id == idReac){
				reactionToReturn = reaction;
				try {
					// Recuperer le POA cree dans le serveur
					POA rootpoa = Server._poa;

					// Activer l'objet et retourne l'objet CORBA
					org.omg.CORBA.Object obj = rootpoa.servant_to_reference(reactionToReturn);

					// Retourner une Reaction
					return ReactionHelper.narrow(obj);
				} catch (Exception e) {
					System.out.println("Erreur retour de l'objet Reaction : " + e);
					return null;
				}
			}
		}
		return null;
	}
	
	public ArrayList<ReactionImpl> getReactionByNiveau (int niveau){
		return null;
	}
	
	protected ArrayList<ReactionImpl> getListeEtudiants() {
		return _listeReactions;
	}

}
