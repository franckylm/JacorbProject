package ca.etsmtl.log720.lab1;


/**
* ca/etsmtl/log720/lab1/Reaction.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Reaction.idl
* lundi 30 septembre 2013 12 h 16 EDT
*/

public interface Reaction extends ReactionOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity 
{
	
	public int id();
	public String description();
	public int niveau();
	public String toString();
	
} 