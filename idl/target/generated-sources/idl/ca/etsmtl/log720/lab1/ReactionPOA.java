package ca.etsmtl.log720.lab1;


/**
 * Generated from IDL interface "Reaction".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:45:42
 */

public abstract class ReactionPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ca.etsmtl.log720.lab1.ReactionOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "_get_niveau", Integer.valueOf(0));
		m_opsHash.put ( "_get_description", Integer.valueOf(1));
		m_opsHash.put ( "_get_id", Integer.valueOf(2));
		m_opsHash.put ( "toString", Integer.valueOf(3));
	}
	private String[] ids = {"IDL:ca/etsmtl/log720/lab1/Reaction:1.0"};
	public ca.etsmtl.log720.lab1.Reaction _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ca.etsmtl.log720.lab1.Reaction __r = ca.etsmtl.log720.lab1.ReactionHelper.narrow(__o);
		return __r;
	}
	public ca.etsmtl.log720.lab1.Reaction _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ca.etsmtl.log720.lab1.Reaction __r = ca.etsmtl.log720.lab1.ReactionHelper.narrow(__o);
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
			case 0: // _get_niveau
			{
			_out = handler.createReply();
			_out.write_long(niveau());
				break;
			}
			case 1: // _get_description
			{
			_out = handler.createReply();
			java.lang.String tmpResult0 = description();
_out.write_string( tmpResult0 );
				break;
			}
			case 2: // _get_id
			{
			_out = handler.createReply();
			_out.write_long(id());
				break;
			}
			case 3: // toString
			{
				_out = handler.createReply();
				java.lang.String tmpResult1 = _toString();
_out.write_string( tmpResult1 );
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
