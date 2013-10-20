package ca.etsmtl.log720.lab1;


/**
 * Generated from IDL interface "CollectionReaction".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:45:42
 */

public abstract class CollectionReactionPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ca.etsmtl.log720.lab1.CollectionReactionOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "getReaction", Integer.valueOf(0));
		m_opsHash.put ( "_get_size", Integer.valueOf(1));
	}
	private String[] ids = {"IDL:ca/etsmtl/log720/lab1/CollectionReaction:1.0"};
	public ca.etsmtl.log720.lab1.CollectionReaction _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ca.etsmtl.log720.lab1.CollectionReaction __r = ca.etsmtl.log720.lab1.CollectionReactionHelper.narrow(__o);
		return __r;
	}
	public ca.etsmtl.log720.lab1.CollectionReaction _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ca.etsmtl.log720.lab1.CollectionReaction __r = ca.etsmtl.log720.lab1.CollectionReactionHelper.narrow(__o);
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
			case 0: // getReaction
			{
				int _arg0=_input.read_long();
				_out = handler.createReply();
				ca.etsmtl.log720.lab1.ReactionHelper.write(_out,getReaction(_arg0));
				break;
			}
			case 1: // _get_size
			{
			_out = handler.createReply();
			_out.write_long(size());
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
