package ca.etsmtl.log720.lab1;


/**
* ca/etsmtl/log720/lab1/BanqueInfractionsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Infraction.idl
* lundi 30 septembre 2013 12 h 16 EDT
*/

abstract public class BanqueInfractionsHelper
{
  private static String  _id = "IDL:ca/etsmtl/log720/lab1/BanqueInfractions:1.0";

  public static void insert (org.omg.CORBA.Any a, ca.etsmtl.log720.lab1.BanqueInfractions that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ca.etsmtl.log720.lab1.BanqueInfractions extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ca.etsmtl.log720.lab1.BanqueInfractionsHelper.id (), "BanqueInfractions");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ca.etsmtl.log720.lab1.BanqueInfractions read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BanqueInfractionsStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ca.etsmtl.log720.lab1.BanqueInfractions value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ca.etsmtl.log720.lab1.BanqueInfractions narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ca.etsmtl.log720.lab1.BanqueInfractions)
      return (ca.etsmtl.log720.lab1.BanqueInfractions)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ca.etsmtl.log720.lab1._BanqueInfractionsStub stub = new ca.etsmtl.log720.lab1._BanqueInfractionsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ca.etsmtl.log720.lab1.BanqueInfractions unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ca.etsmtl.log720.lab1.BanqueInfractions)
      return (ca.etsmtl.log720.lab1.BanqueInfractions)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ca.etsmtl.log720.lab1._BanqueInfractionsStub stub = new ca.etsmtl.log720.lab1._BanqueInfractionsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
