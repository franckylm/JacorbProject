package ca.etsmtl.log720.lab1;

/**
* ca/etsmtl/log720/lab1/BanqueDossiersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Dossier.idl
* lundi 30 septembre 2013 12 h 14 EDT
*/

public final class BanqueDossiersHolder implements org.omg.CORBA.portable.Streamable
{
  public ca.etsmtl.log720.lab1.BanqueDossiers value = null;

  public BanqueDossiersHolder ()
  {
  }

  public BanqueDossiersHolder (ca.etsmtl.log720.lab1.BanqueDossiers initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ca.etsmtl.log720.lab1.BanqueDossiersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ca.etsmtl.log720.lab1.BanqueDossiersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ca.etsmtl.log720.lab1.BanqueDossiersHelper.type ();
  }

}
