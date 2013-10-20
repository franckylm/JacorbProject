package ca.etsmtl.log720.lab1;


/**
 * Generated from IDL interface "BanqueReactions".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:45:42
 */

public abstract class BanqueReactionsPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ca.etsmtl.log720.lab1.BanqueReactionsOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "_get_reactions", Integer.valueOf(0));
		m_opsHash.put ( "ajouterReaction", Integer.valueOf(1));
		m_opsHash.put ( "trouverReactionParId", Integer.valueOf(2));
		m_opsHash.put ( "trouverReactionsParDossier", Integer.valueOf(3));
	}
	private String[] ids = {"IDL:ca/etsmtl/log720/lab1/BanqueReactions:1.0"};
	public ca.etsmtl.log720.lab1.BanqueReactions _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ca.etsmtl.log720.lab1.BanqueReactions __r = ca.etsmtl.log720.lab1.BanqueReactionsHelper.narrow(__o);
		return __r;
	}
	public ca.etsmtl.log720.lab1.BanqueReactions _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ca.etsmtl.log720.lab1.BanqueReactions __r = ca.etsmtl.log720.lab1.BanqueReactionsHelper.narrow(__o);
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
			case 0: // _get_reactions
			{
			_out = handler.createReply();
			ca.etsmtl.log720.lab1.CollectionReactionHelper.write(_out,reactions());
				break;
			}
			case 1: // ajouterReaction
			{
				java.lang.String _arg0=_input.read_string();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				ajouterReaction(_arg0,_arg1);
				break;
			}
			case 2: // trouverReactionParId
			{
				int _arg0=_input.read_long();
				_out = handler.createReply();
				ca.etsmtl.log720.lab1.ReactionHelper.write(_out,trouverReactionParId(_arg0));
				break;
			}
			case 3: // trouverReactionsParDossier
			{
				ca.etsmtl.log720.lab1.Dossier _arg0=ca.etsmtl.log720.lab1.DossierHelper.read(_input);
				_out = handler.createReply();
				ca.etsmtl.log720.lab1.CollectionReactionHelper.write(_out,trouverReactionsParDossier(_arg0));
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
