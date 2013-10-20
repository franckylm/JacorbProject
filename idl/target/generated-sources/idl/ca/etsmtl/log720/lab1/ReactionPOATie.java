package ca.etsmtl.log720.lab1;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Reaction".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:45:42
 */

public class ReactionPOATie
	extends ReactionPOA
{
	private ReactionOperations _delegate;

	private POA _poa;
	public ReactionPOATie(ReactionOperations delegate)
	{
		_delegate = delegate;
	}
	public ReactionPOATie(ReactionOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public ReactionOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(ReactionOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public int niveau()
	{
		return _delegate.niveau();
	}

	public java.lang.String description()
	{
		return _delegate.description();
	}

	public int id()
	{
		return _delegate.id();
	}

	public java.lang.String _toString()
	{
		return _delegate._toString();
	}

}
