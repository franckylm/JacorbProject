package ca.etsmtl.log720.lab1.server;

import java.io.Serializable;

import ca.etsmtl.log720.lab1.InfractionPOA;

public class InfractionImpl extends InfractionPOA implements Serializable{

	public int _id;
	public int _niveau;
	public String _description;
	
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
