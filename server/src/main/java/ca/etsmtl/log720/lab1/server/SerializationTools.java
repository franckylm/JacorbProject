package ca.etsmtl.log720.lab1.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTools {
	
	private SerializationTools(){}
	
	/**
     * Serialisation d'un objet dans un fichier
     * @param object objet a serialiser
     * @param filename chemin du fichier
     */
	public static void encodeToFile (Object object, String fileName){
		
		try {
            // serialisation de l'objet
			
			FileOutputStream fileOut = new FileOutputStream(fileName);
			 ObjectOutputStream out = new ObjectOutputStream(fileOut);
			 out.writeObject(object);
			 out.close();
			 fileOut.close();
			 System.out.printf("Serialized de l'objet dans "+fileName);;
        } catch(IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
     * Deserialisation d'un objet depuis un fichier
     * @param filename chemin du fichier
     */
    public static Object decodeFromFile(String fileName){
    	
    	Object objectToReturn = null;
    	
    	try
        {
           FileInputStream fileIn = new FileInputStream(fileName);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           objectToReturn = in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i)
        {
           i.printStackTrace();
           return null;
        }catch(ClassNotFoundException c)
        {
           System.out.println("Class not found");
           c.printStackTrace();
           return null;
        }
    	return objectToReturn;
    }

}
