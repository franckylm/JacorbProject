package ca.etsmtl.log720.lab1;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Infraction".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:45:42
 */

public class InfractionPOATie
	extends InfractionPOA
{
	private InfractionOperations _delegate;

	private POA _poa;
	public InfractionPOATie(InfractionOperations delegate)
	{
		_delegate = delegate;
	}
	public InfractionPOATie(InfractionOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public ca.etsmtl.log720.lab1.Infraction _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ca.etsmtl.log720.lab1.Infraction __r = ca.etsmtl.log720.lab1.InfractionHelper.narrow(__o);
		return __r;
	}
	public ca.etsmtl.log720.lab1.Infraction _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ca.etsmtl.log720.lab1.Infraction __r = ca.etsmtl.log720.lab1.InfractionHelper.narrow(__o);
		return __r;
	}
	public InfractionOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(InfractionOperations delegate)
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
