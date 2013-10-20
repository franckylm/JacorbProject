package ca.etsmtl.log720.lab1;


/**
* ca/etsmtl/log720/lab1/_BanqueReactionsStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Reaction.idl
* lundi 30 septembre 2013 12 h 16 EDT
*/

public class _BanqueReactionsStub extends org.omg.CORBA.portable.ObjectImpl implements ca.etsmtl.log720.lab1.BanqueReactions
{

  public ca.etsmtl.log720.lab1.CollectionReaction reactions ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_reactions", true);
                $in = _invoke ($out);
                ca.etsmtl.log720.lab1.CollectionReaction $result = ca.etsmtl.log720.lab1.CollectionReactionHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return reactions (        );
            } finally {
                _releaseReply ($in);
            }
  } // reactions

  public void ajouterReaction (String reaction, int gravite)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ajouterReaction", true);
                $out.write_string (reaction);
                $out.write_long (gravite);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                ajouterReaction (reaction, gravite        );
            } finally {
                _releaseReply ($in);
            }
  } // ajouterReaction

  public ca.etsmtl.log720.lab1.CollectionReaction trouverReactionsParDossier (ca.etsmtl.log720.lab1.Dossier myDossier)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("trouverReactionsParDossier", true);
                ca.etsmtl.log720.lab1.DossierHelper.write ($out, myDossier);
                $in = _invoke ($out);
                ca.etsmtl.log720.lab1.CollectionReaction $result = ca.etsmtl.log720.lab1.CollectionReactionHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return trouverReactionsParDossier (myDossier        );
            } finally {
                _releaseReply ($in);
            }
  } // trouverReactionsParDossier

  public ca.etsmtl.log720.lab1.Reaction trouverReactionParId (int idReaction)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("trouverReactionParId", true);
                $out.write_long (idReaction);
                $in = _invoke ($out);
                ca.etsmtl.log720.lab1.Reaction $result = ca.etsmtl.log720.lab1.ReactionHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return trouverReactionParId (idReaction        );
            } finally {
                _releaseReply ($in);
            }
  } // trouverReactionParId

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ca/etsmtl/log720/lab1/BanqueReactions:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }

public CollectionReaction trouverReactionsParDossierSDossier(Dossier pDossier) {
	// TODO Auto-generated method stub
	return null;
}
} // class _BanqueReactionsStub