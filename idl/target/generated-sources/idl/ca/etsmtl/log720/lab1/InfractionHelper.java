package ca.etsmtl.log720.lab1;


/**
* ca/etsmtl/log720/lab1/InfractionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Infraction.idl
* lundi 30 septembre 2013 12 h 16 EDT
*/

abstract public class InfractionHelper
{
  private static String  _id = "IDL:ca/etsmtl/log720/lab1/Infraction:1.0";

  public static void insert (org.omg.CORBA.Any a, ca.etsmtl.log720.lab1.Infraction that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ca.etsmtl.log720.lab1.Infraction extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ca.etsmtl.log720.lab1.InfractionHelper.id (), "Infraction");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ca.etsmtl.log720.lab1.Infraction read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_InfractionStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ca.etsmtl.log720.lab1.Infraction value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ca.etsmtl.log720.lab1.Infraction narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ca.etsmtl.log720.lab1.Infraction)
      return (ca.etsmtl.log720.lab1.Infraction)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ca.etsmtl.log720.lab1._InfractionStub stub = new ca.etsmtl.log720.lab1._InfractionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ca.etsmtl.log720.lab1.Infraction unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ca.etsmtl.log720.lab1.Infraction)
      return (ca.etsmtl.log720.lab1.Infraction)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ca.etsmtl.log720.lab1._InfractionStub stub = new ca.etsmtl.log720.lab1._InfractionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
