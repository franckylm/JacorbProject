package ca.etsmtl.log720.lab1.server;

import java.io.Serializable;

import ca.etsmtl.log720.lab1.ReactionPOA;

public class ReactionImpl extends ReactionPOA implements Serializable{

	int _id;
	int _niveau;
	String _description;
	
	public ReactionImpl(){
		
	}
	public ReactionImpl(int id, int niveau){
		this._id = id;
		this._niveau = niveau;
		this._description = "";
	}
	
	public ReactionImpl(int id, int niveau, String desc){
		this._id = id;
		this._niveau = niveau;
		this._description = desc;
	}
	
	public int id() {
		return _id;
	}

	public String description() {
		return _description;
	}

	public int niveau() {
		return _niveau;
	}

	public String _toString() {
		String s = "Infraction Id : "+ _id + ", Niveau : " + _niveau + " , Description : " + _description ;
		return s;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public void set_niveau(int _niveau) {
		this._niveau = _niveau;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

}
