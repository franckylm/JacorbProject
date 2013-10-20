package ca.etsmtl.log720.lab1;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "CollectionInfraction".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:45:42
 */

public class CollectionInfractionPOATie
	extends CollectionInfractionPOA
{
	private CollectionInfractionOperations _delegate;

	private POA _poa;
	public CollectionInfractionPOATie(CollectionInfractionOperations delegate)
	{
		_delegate = delegate;
	}
	public CollectionInfractionPOATie(CollectionInfractionOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public ca.etsmtl.log720.lab1.CollectionInfraction _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ca.etsmtl.log720.lab1.CollectionInfraction __r = ca.etsmtl.log720.lab1.CollectionInfractionHelper.narrow(__o);
		return __r;
	}
	public ca.etsmtl.log720.lab1.CollectionInfraction _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ca.etsmtl.log720.lab1.CollectionInfraction __r = ca.etsmtl.log720.lab1.CollectionInfractionHelper.narrow(__o);
		return __r;
	}
	public CollectionInfractionOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(CollectionInfractionOperations delegate)
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
	public ca.etsmtl.log720.lab1.Infraction getInfraction(int index)
	{
		return _delegate.getInfraction(index);
	}

	public int size()
	{
		return _delegate.size();
	}

}
