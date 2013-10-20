package ca.etsmtl.log720.lab1.voiture;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ca.etsmtl.log720.lab1.BanqueDossiers;
import ca.etsmtl.log720.lab1.BanqueDossiersHelper;
import ca.etsmtl.log720.lab1.BanqueInfractions;
import ca.etsmtl.log720.lab1.BanqueInfractionsHelper;
import ca.etsmtl.log720.lab1.BanqueReactions;
import ca.etsmtl.log720.lab1.BanqueReactionsHelper;
import ca.etsmtl.log720.lab1.Dossier;
import ca.etsmtl.log720.lab1.Infraction;
import ca.etsmtl.log720.lab1.Reaction;


public class Client {
	
	//protected static org.omg.PortableServer.POA _poa;

	public static void main(String[] args) {
		/*
    	 * Liste des taches 
    	 *  - obtenir la liste de réactions possibles; 
    	 *  - sélectionner une réaction pour l’ajouter au dossier sélectionné; 
    	 *  - ajouter des réactions dans la banque de réactions;
    	 *  - obtenir une liste de dossiers selon le nom et prénom, numéro de plaque, ou numéro de 
permis; 
			- sélectionner un dossier et visualiser son contenu;
			- obtenir la liste d’infractions possibles; 
			- de sélectionner une infraction pour l’ajouter au dossier sélectionné
    	 */
		
		try{
			
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
			
			// get hold of the naming service
			NamingContextExt nc = NamingContextExtHelper.narrow(orb .resolve_initial_references("NameService"));
			
			while(true){
				
				System.out.println("Choisissez la méthode");
				System.out.println("1 : Afficher les reactions");
				System.out.println("2 : Ajouter une réaction au dossier");
				System.out.println("3 : Ajouter une réaction à la banque");
				System.out.println("4 : Afficher liste des dossiers");
				System.out.println("5 : Afficher un dossier");
				System.out.println("6 : Afficher la liste des infractions");
				System.out.println("7 : Arrêt du programme");
				String s = System.console().readLine();
				if(s.equals("1")){
					
					try{
							NameComponent[] name = new NameComponent[] { new NameComponent("BanqueReactions", "service") };
							
							// resolve name to get a reference to our server
							BanqueReactions banque= BanqueReactionsHelper.narrow(nc.resolve(name));
							for(int i=0;i<banque.reactions().size();i++){
								String out = banque.reactions().getReaction(i)._toString();
								System.out.println("Liste des Reactions : "+out);
							}
						}catch(Exception e){
							e.printStackTrace();
						}
				}else if(s.equals("2")){
					
					System.out.println("Entrer le numéro du dossier où ajouter la réaction");
					s = System.console().readLine();
					
					System.out.println("Entrer le numéro de la réaction");
					String z = System.console().readLine();
					
						try{
								NameComponent[] name1 = new NameComponent[] { new NameComponent("BanqueReactions", "service") };
								NameComponent[] name2 = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
								
								// resolve name to get a reference to our server
								BanqueReactions banqueReaction= BanqueReactionsHelper.narrow(nc.resolve(name1));
								BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name2));
								
								// sélection dossier par index
								int index= banqueDossier.dossiers().size()-1;
								Dossier dossier =  banqueDossier.dossiers().getDossier(Integer.parseInt(s));
								//sélection réaction par index
								//Reaction reaction = banqueReaction.reactions().getReaction(Integer.parseInt(z));
								//ajour réaction au dossier
								dossier.ajouterReactionAListe(Integer.parseInt(z));
								
							}catch(Exception e){
								e.printStackTrace();
							}
				
					
				
				
				}else if(s.equals("3")){
					
					System.out.println("Description de la reaction à ajouter");
					s = System.console().readLine();
					System.out.println("Niveau de la reaction à ajouter");
					String a = System.console().readLine();
					
					
					int intid = 0;
					try{
						intid = Integer.parseInt(a);
					} catch(Exception e){
						System.out.println("Entier non valide");
						continue;
					}
					
					
					try{
						NameComponent[] name = new NameComponent[] { new NameComponent("BanqueReactions", "service") };
						
						// resolve name to get a reference to our server
						BanqueReactions banque= BanqueReactionsHelper.narrow(nc.resolve(name));
						banque.ajouterReaction(s, intid);

					}catch(Exception e){
						e.printStackTrace();
					}
				
				
				}else if(s.equals("4")){
					
					afficherListeDossiers(orb, nc);
				
				
				}else if(s.equals("5")){
					
					
					try{
						NameComponent[] name = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
						
						// resolve name to get a reference to our server
						BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name));
						// sélection dossier par index
				    	int index= banqueDossier.dossiers().size()-1;
				    	String out =  banqueDossier.dossiers().getDossier(index)._toString();
				    	System.out.println("Dossier "+index+" : "+out);

					}catch(Exception e){
						e.printStackTrace();
					}
				
				}else if(s.equals("6")){
					
					
					listeDesInfractions(orb, nc);
				
				}else if(s.equals("7")){
					break;
				}
				
//				ajouterReactionAuDossier(orb, nc);
//				ajouterReactionsBanqueReactions(orb, nc);
//				afficherListeDossiers(orb, nc);
//				selectionEtVisualisationDossier(orb,nc);
//				listeDesInfractions(orb,nc);
//				selectionerInfractionEtAjouterAuDossier(orb,nc);
		
			}
			} catch(Exception e){
			e.printStackTrace();
		}
		

	}
	
	public static void listeDesReactions(org.omg.CORBA.ORB orb, NamingContextExt nc){
		try{
			NameComponent[] name = new NameComponent[] { new NameComponent("BanqueReactions", "service") };
	    	
	    	// resolve name to get a reference to our server
	    	BanqueReactions banque= BanqueReactionsHelper.narrow(nc.resolve(name));
	    	for(int i=0;i<banque.reactions().size();i++){
	    		String out = banque.reactions().getReaction(i)._toString();
	    		System.out.println("Liste des Reactions : "+out);
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void ajouterReactionAuDossier(org.omg.CORBA.ORB orb, NamingContextExt nc){
		try{
			NameComponent[] name1 = new NameComponent[] { new NameComponent("BanqueReactions", "service") };
			NameComponent[] name2 = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
			
	    	// resolve name to get a reference to our server
	    	BanqueReactions banqueReaction= BanqueReactionsHelper.narrow(nc.resolve(name1));
	    	BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name2));
	    	
	    	// sélection dossier par index
	    	int index= banqueDossier.dossiers().size()-1;
	    	Dossier dossier =  banqueDossier.dossiers().getDossier(index);
	    	//sélection réaction par index
	    	Reaction reaction = banqueReaction.reactions().getReaction(1);
	    	//ajour réaction au dossier
	    	dossier.ajouterReactionAListe(reaction.id());
	    	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void afficherListeDossiers(org.omg.CORBA.ORB orb, NamingContextExt nc){
    	try{
    	NameComponent[] name = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
    	
    	BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name));

    	for(int i=0;i<banqueDossier.dossiers().size();i++){
    		String out = banqueDossier.dossiers().getDossier(i)._toString();
    		System.out.println("Dossier "+i+" : "+out);
    	}
		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	
	public static void ajouterReactionsBanqueReactions(org.omg.CORBA.ORB orb, NamingContextExt nc){
		try{
			NameComponent[] name = new NameComponent[] { new NameComponent("BanqueReactions", "service") };
			
			// resolve name to get a reference to our server
			BanqueReactions banque= BanqueReactionsHelper.narrow(nc.resolve(name));
			banque.ajouterReaction("description", 10);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void selectionEtVisualisationDossier(org.omg.CORBA.ORB orb, NamingContextExt nc){
		try{
			NameComponent[] name = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
			
			// resolve name to get a reference to our server
			BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name));
			// sélection dossier par index
	    	int index= banqueDossier.dossiers().size()-1;
	    	String out =  banqueDossier.dossiers().getDossier(index)._toString();
	    	System.out.println("Dossier "+index+" : "+out);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void listeDesInfractions(org.omg.CORBA.ORB orb, NamingContextExt nc){
		try{
			NameComponent[] name = new NameComponent[] { new NameComponent("BanqueInfractions", "service") };
	    	
	    	// resolve name to get a reference to our server
	    	BanqueInfractions banque= BanqueInfractionsHelper.narrow(nc.resolve(name));
	    	for(int i=0;i<banque.infractions().size();i++){
	    		String out = banque.infractions().getInfraction(i)._toString();
	    		System.out.println("Liste des infractions : "+out);
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void selectionerInfractionEtAjouterAuDossier(org.omg.CORBA.ORB orb, NamingContextExt nc){
		try{
			NameComponent[] name1 = new NameComponent[] { new NameComponent("BanqueInfractions", "service") };
			NameComponent[] name2 = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
			
	    	// resolve name to get a reference to our server
	    	BanqueInfractions banqueInfractions= BanqueInfractionsHelper.narrow(nc.resolve(name1));
	    	BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name2));
	    	
	    	// sélection dossier par index
	    	int index= banqueDossier.dossiers().size()-1;
	    	Dossier dossier =  banqueDossier.dossiers().getDossier(index);
	    	//sélection Infraction par index
	    	Infraction infraction = banqueInfractions.infractions().getInfraction(1);
	    	//ajour réaction au dossier
	    	dossier.ajouterReactionAListe(infraction.id());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
