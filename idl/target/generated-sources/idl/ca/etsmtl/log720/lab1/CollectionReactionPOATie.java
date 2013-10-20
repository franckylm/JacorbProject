package ca.etsmtl.log720.lab1;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "CollectionReaction".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:45:42
 */

public class CollectionReactionPOATie
	extends CollectionReactionPOA
{
	private CollectionReactionOperations _delegate;

	private POA _poa;
	public CollectionReactionPOATie(CollectionReactionOperations delegate)
	{
		_delegate = delegate;
	}
	public CollectionReactionPOATie(CollectionReactionOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public CollectionReactionOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(CollectionReactionOperations delegate)
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
	public ca.etsmtl.log720.lab1.Reaction getReaction(int index)
	{
		return _delegate.getReaction(index);
	}

	public int size()
	{
		return _delegate.size();
	}

}
