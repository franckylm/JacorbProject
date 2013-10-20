package ca.etsmtl.log720.lab1;


/**
 * Generated from IDL interface "Dossier".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:37:01
 */

public abstract class DossierPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ca.etsmtl.log720.lab1.DossierOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "ajouterInfractionAListe", Integer.valueOf(0));
		m_opsHash.put ( "_get_niveau", Integer.valueOf(1));
		m_opsHash.put ( "_get_noPlaque", Integer.valueOf(2));
		m_opsHash.put ( "_get_prenom", Integer.valueOf(3));
		m_opsHash.put ( "getListeInfraction", Integer.valueOf(4));
		m_opsHash.put ( "_get_nom", Integer.valueOf(5));
		m_opsHash.put ( "ajouterReactionAListe", Integer.valueOf(6));
		m_opsHash.put ( "_get_id", Integer.valueOf(7));
		m_opsHash.put ( "getListeReaction", Integer.valueOf(8));
		m_opsHash.put ( "toString", Integer.valueOf(9));
		m_opsHash.put ( "_get_noPermis", Integer.valueOf(10));
	}
	private String[] ids = {"IDL:ca/etsmtl/log720/lab1/Dossier:1.0"};
	public ca.etsmtl.log720.lab1.Dossier _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ca.etsmtl.log720.lab1.Dossier __r = ca.etsmtl.log720.lab1.DossierHelper.narrow(__o);
		return __r;
	}
	public ca.etsmtl.log720.lab1.Dossier _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ca.etsmtl.log720.lab1.Dossier __r = ca.etsmtl.log720.lab1.DossierHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // ajouterInfractionAListe
			{
				int _arg0=_input.read_long();
				_out = handler.createReply();
				ajouterInfractionAListe(_arg0);
				break;
			}
			case 1: // _get_niveau
			{
			_out = handler.createReply();
			_out.write_long(niveau());
				break;
			}
			case 2: // _get_noPlaque
			{
			_out = handler.createReply();
			java.lang.String tmpResult0 = noPlaque();
_out.write_string( tmpResult0 );
				break;
			}
			case 3: // _get_prenom
			{
			_out = handler.createReply();
			java.lang.String tmpResult1 = prenom();
_out.write_string( tmpResult1 );
				break;
			}
			case 4: // getListeInfraction
			{
				_out = handler.createReply();
				ca.etsmtl.log720.lab1.ListeInfractionHelper.write(_out,getListeInfraction());
				break;
			}
			case 5: // _get_nom
			{
			_out = handler.createReply();
			java.lang.String tmpResult2 = nom();
_out.write_string( tmpResult2 );
				break;
			}
			case 6: // ajouterReactionAListe
			{
				int _arg0=_input.read_long();
				_out = handler.createReply();
				ajouterReactionAListe(_arg0);
				break;
			}
			case 7: // _get_id
			{
			_out = handler.createReply();
			_out.write_long(id());
				break;
			}
			case 8: // getListeReaction
			{
				_out = handler.createReply();
				ca.etsmtl.log720.lab1.ListeReactionHelper.write(_out,getListeReaction());
				break;
			}
			case 9: // toString
			{
				_out = handler.createReply();
				java.lang.String tmpResult3 = _toString();
_out.write_string( tmpResult3 );
				break;
			}
			case 10: // _get_noPermis
			{
			_out = handler.createReply();
			java.lang.String tmpResult4 = noPermis();
_out.write_string( tmpResult4 );
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
