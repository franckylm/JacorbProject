package ca.etsmtl.log720.lab1;


/**
* ca/etsmtl/log720/lab1/CollectionReaction.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Reaction.idl
* lundi 30 septembre 2013 12 h 16 EDT
*/

public interface CollectionReaction extends CollectionReactionOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity 
{
	public Reaction getReaction(int pIndex);
	
	public int size();
	
} // interface CollectionReaction