package ca.etsmtl.log720.lab1.server;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Server {
	protected static org.omg.PortableServer.POA _poa;
	
	public static void main(String[] args) {
		// Initialize ORB
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
		
		try {
			org.omg.PortableServer.Servant servant1;
			org.omg.PortableServer.Servant servant2;
			org.omg.PortableServer.Servant servant3;
			org.omg.CORBA.Object o1;
			org.omg.CORBA.Object o2;
			org.omg.CORBA.Object o3;

			// Initialize POA
			_poa = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			_poa.the_POAManager().activate();

			// Initialize servant (Remote Object), convert to CORBA reference
			try {
		        servant1 = (BanqueInfractionsImpl) SerializationTools.decodeFromFile("../../persist/banqueinfractions.ser");
				servant2 = (BanqueDossiersImpl) SerializationTools.decodeFromFile("../../persist/banquedossiers.ser");
				servant3 = (BanqueReactionsImpl) SerializationTools.decodeFromFile("../../persist/banquereactions.ser");
				
			} catch(Exception e) {
		    	// File does not exists or other errors
		    	servant1 = new BanqueInfractionsImpl();
				servant2 = new BanqueDossiersImpl();
				servant3 = new BanqueReactionsImpl();
		    }
			o1 = _poa.servant_to_reference(servant1);
			o2 = _poa.servant_to_reference(servant2);
			o3 = _poa.servant_to_reference(servant3);
			
			// Register Rermote Object with naming context
			NamingContextExt nc = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
			NameComponent[] name1 = new NameComponent[] { new NameComponent("BanqueInfractions", "service") };
			NameComponent[] name2 = new NameComponent[] { new NameComponent("BanqueDossier", "service") };
			NameComponent[] name3 = new NameComponent[] { new NameComponent("BanqueReactions", "service") };
			nc.rebind(name1, o1);
			nc.rebind(name2, o2 );
			nc.rebind(name3, o3);
			
			initialisationBanqueInfractions();
			initialisationBanqueReactions();
	        
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Start the ORB main thread
		orb.run();

	}
	
	public static void initialisationBanqueInfractions(){
		try{
			
			BanqueInfractionsImpl b1 = new BanqueInfractionsImpl();
			b1.ajouterInfraction("Injures a un officier de police ", 4);
			b1.ajouterInfraction("Uriner sur la voie publique ", 1);
			SerializationTools.encodeToFile(b1, "../../persist/banqueinfractions.ser");
	        System.out.println("sérialisation terminée");
	        

	        BanqueInfractionsImpl b2 = null;
	        b2 = (BanqueInfractionsImpl) SerializationTools.decodeFromFile("../../persist/banqueinfractions.ser");
	        System.out.println("Deserialized BankInfractions...");
	        System.out.println("Description infraction : "+ b2.infractions().getInfraction(0).description());
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		
        
	}
	
	public static void initialisationBanqueReactions(){

        BanqueReactionsImpl b1 = new BanqueReactionsImpl();
        b1.ajouterReaction("verbalisation", 1);
        b1.ajouterReaction("arrestation", 6);
        b1.ajouterReaction("avertissement", 3);
        b1.ajouterReaction("poursuite", 5);
        b1.ajouterReaction("ignorer", 0);
        SerializationTools.encodeToFile(b1, "../../persist/banquereactions.ser");
        System.out.println("sérialisation terminée");
        

        BanqueReactionsImpl b2 = null;
        b2 = (BanqueReactionsImpl) SerializationTools.decodeFromFile("../../persist/banquereactions.ser");
        System.out.println("Deserialized BankReactions...");
        System.out.println("Description infraction : "+ b2.reactions().getReaction(0).description());
        
	}

}
