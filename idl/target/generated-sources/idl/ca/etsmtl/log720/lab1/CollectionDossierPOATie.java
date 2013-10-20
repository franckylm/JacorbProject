package ca.etsmtl.log720.lab1;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "CollectionDossier".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 7 oct. 2013 14:37:01
 */

public class CollectionDossierPOATie
	extends CollectionDossierPOA
{
	private CollectionDossierOperations _delegate;

	private POA _poa;
	public CollectionDossierPOATie(CollectionDossierOperations delegate)
	{
		_delegate = delegate;
	}
	public CollectionDossierPOATie(CollectionDossierOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public ca.etsmtl.log720.lab1.CollectionDossier _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		ca.etsmtl.log720.lab1.CollectionDossier __r = ca.etsmtl.log720.lab1.CollectionDossierHelper.narrow(__o);
		return __r;
	}
	public ca.etsmtl.log720.lab1.CollectionDossier _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		ca.etsmtl.log720.lab1.CollectionDossier __r = ca.etsmtl.log720.lab1.CollectionDossierHelper.narrow(__o);
		return __r;
	}
	public CollectionDossierOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(CollectionDossierOperations delegate)
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
	public ca.etsmtl.log720.lab1.Dossier getDossier(int index)
	{
		return _delegate.getDossier(index);
	}

	public int size()
	{
		return _delegate.size();
	}

}
