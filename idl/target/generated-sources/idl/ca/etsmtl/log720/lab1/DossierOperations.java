package ca.etsmtl.log720.lab1;


/**
* ca/etsmtl/log720/lab1/DossierOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Dossier.idl
* lundi 30 septembre 2013 12 h 14 EDT
*/

public interface DossierOperations 
{
  int id ();
  String nom ();
  String noPermis ();
  String noPlaque ();
  String prenom ();
  int niveau ();
  int[] getListeInfraction ();
  int[] getListeReaction ();
  void ajouterReactionAListe (int idReaction);
  void ajouterInfractionAListe (int idInfraction);
  String _toString ();
} // interface DossierOperations
