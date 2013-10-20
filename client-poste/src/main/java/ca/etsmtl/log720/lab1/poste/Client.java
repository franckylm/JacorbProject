package ca.etsmtl.log720.lab1.poste;


import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ca.etsmtl.log720.lab1.BanqueDossiers;
import ca.etsmtl.log720.lab1.BanqueDossiersHelper;
import ca.etsmtl.log720.lab1.BanqueInfractions;
import ca.etsmtl.log720.lab1.BanqueInfractionsHelper;
import ca.etsmtl.log720.lab1.BanqueReactions;
import ca.etsmtl.log720.lab1.BanqueReactionsHelper;
import ca.etsmtl.log720.lab1.CollectionDossier;
import ca.etsmtl.log720.lab1.Dossier;
import ca.etsmtl.log720.lab1.Infraction;

public class Client 
{
    public static void main( String[] args )
    {
    	
    	/*
    	 * Liste des taches 
    	 *  - ajouter des dossiers dans la banque de dossiers;
    	 *  - ajouter des infractions dans la banque d'infractions;
    	 *  - visualiser une liste des dossiers compris dans la banque de dossiers;
    	 *  - visualiser une liste des infractions comprises dans la banque d'infractions. 
    	 */
    	try {
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);


			// get hold of the naming service
			NamingContextExt nc = NamingContextExtHelper.narrow(orb .resolve_initial_references("NameService"));
			
			
			
			
			while(true){
				System.out.println("Menu Poste");
				System.out.println("1. ajouter un dossier");
				System.out.println("2. afficher les dossiers");
				System.out.println("3. ajouter une infraction");
				System.out.println("4. afficher les infractions");
				System.out.println("5. chercher un dossier");
				System.out.println("6. chercher une infraction");
				System.out.println("7. ajouter une infraction au dossier");
				System.out.println("0. quitter");
				
				String r = System.console().readLine();
				
				if(r.equals("1")){
					
					System.out.println("Entrez le nom");
					String nom = System.console().readLine();
					
					System.out.println("Entrez le prénom");
					String prenom = System.console().readLine();
					
					System.out.println("Entrez le permis");
					String permis = System.console().readLine();
					
					System.out.println("Entrez la plaque");
					String plaque = System.console().readLine();
					
					NameComponent[] name = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
					
					
					BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name));
		    		banqueDossier.ajouterDossier(nom, prenom, permis, plaque);
		    		
		    		
				} else if(r.equals("2")){
					
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
				} else if(r.equals("3")){
					
					System.out.println("Entrez la description");
					String description = System.console().readLine();
					
					System.out.println("Entrez un entier");
					String id = System.console().readLine();
					
					int intid = 0;
					try{
						intid = Integer.parseInt(id);
					} catch(Exception e){
						System.out.println("Entier non valide");
						continue;
					}
					
					
					NameComponent[] name = new NameComponent[] { new NameComponent("BanqueInfractions", "service") };
					
					// resolve name to get a reference to our server
					BanqueInfractions banque= BanqueInfractionsHelper.narrow(nc.resolve(name));
					banque.ajouterInfraction(description, intid);
		    		
		    		
				} else if(r.equals("4")){
					
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
				} else if(r.equals("5")){
					
					try{
			    	NameComponent[] name = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
			    	
			    	
			    	System.out.println("Entrez un entier");
					String id = System.console().readLine();
					
					int intid = 0;
					try{
						intid = Integer.parseInt(id);
					} catch(Exception e){
						System.out.println("Entier non valide");
						continue;
					}
			    	
			    	// resolve name to get a reference to our server
			    	BanqueDossiers banque= BanqueDossiersHelper.narrow(nc.resolve(name));
			    	Dossier d = banque.trouverDossierParId(intid);
			    	
			    	if(d != null){
			    		System.out.println(d._toString());
			    	} else {
			    		System.out.println("Dossier non trouvé");
			    	}
			    	
					
			    	}catch(Exception e){
			    		e.printStackTrace();
			    	}
				} else if(r.equals("6")){
					
					try{
			    	System.out.println("Entrez un entier");
					String id = System.console().readLine();
					
					int intid = 0;
					try{
						intid = Integer.parseInt(id);
					} catch(Exception e){
						System.out.println("Entier non valide");
						continue;
					}
			    	
			    	// resolve name to get a reference to our server
					NameComponent[] name = new NameComponent[] { new NameComponent("BanqueInfractions", "service") };
			    	
			    	// resolve name to get a reference to our server
			    	BanqueInfractions infraction= BanqueInfractionsHelper.narrow(nc.resolve(name));
			    	Infraction d = infraction.infractions().getInfraction(intid);
			    	
			    	if(d == null){
			    		System.out.println("infraction introuvable");
			    	} else {
			    		System.out.println(d._toString());
			    	}
			    	
			    	
			    	
					
			    	}catch(Exception e){
			    		e.printStackTrace();
			    	}
				} else if(r.equals("7")){
					

					System.out.println("Entrer le numéro du dossier où ajouter l'infraction");
					String s = System.console().readLine();
					
					System.out.println("Entrer le numéro de l'infraction");
					String z = System.console().readLine();
					
						try{
								NameComponent[] name1 = new NameComponent[] { new NameComponent("BanqueInfractions", "service") };
								NameComponent[] name2 = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
								
								// resolve name to get a reference to our server
								BanqueInfractions banqueReaction= BanqueInfractionsHelper.narrow(nc.resolve(name1));
								BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name2));
								
								// sélection dossier par index
								int index= banqueDossier.dossiers().size()-1;
								Dossier dossier =  banqueDossier.dossiers().getDossier(Integer.parseInt(s));
								//sélection réaction par index
								//Reaction reaction = banqueReaction.reactions().getReaction(Integer.parseInt(z));
								//ajour réaction au dossier
								dossier.ajouterInfractionAListe(Integer.parseInt(z));
								
							}catch(Exception e){
								e.printStackTrace();
							}
					
					
					
				} else if(r.equals("0")){
				  break;
				} else {
					continue;
				}
			}
			
			/*
			testAjoutInfraction(orb, nc);
			
			testAjoutDossier(orb, nc);
			
			testVisualisationListeDossiers(orb, nc);

			testVisualisationListeInfractions(orb, nc);
			*/
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void testAjoutInfraction(org.omg.CORBA.ORB orb, NamingContextExt nc){
    	try{
			NameComponent[] name = new NameComponent[] { new NameComponent("BanqueInfractions", "service") };
			
			// resolve name to get a reference to our server
			BanqueInfractions banque= BanqueInfractionsHelper.narrow(nc.resolve(name));
			banque.ajouterInfraction("bruller le feu rouge", 3);
			banque.ajouterInfraction("Uriner sur la voie publique", 2);
			banque.ajouterInfraction("Injure a un officier de police", 4);
			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public static void testAjoutDossier(org.omg.CORBA.ORB orb, NamingContextExt nc){
    	try{
    		NameComponent[] name = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
    		
    		// resolve name to get a reference to our server
    		BanqueDossiers banqueDossier = BanqueDossiersHelper.narrow(nc.resolve(name));
    		banqueDossier.ajouterDossier("Guilpain", "Vincent", "Permis 1","Plaque 1");
    		banqueDossier.ajouterDossier("Jean", "Bon", "Permis 2","Plaque 2");
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public static void testVisualisationListeDossiers(org.omg.CORBA.ORB orb, NamingContextExt nc){
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
    
    public static void testVisualisationListeInfractions(org.omg.CORBA.ORB orb, NamingContextExt nc){
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
}
