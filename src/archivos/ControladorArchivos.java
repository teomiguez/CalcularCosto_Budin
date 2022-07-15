package archivos;

import clases.Mercaderia;

import java.io.*;
import java.util.ArrayList;

public class ControladorArchivos
{
    public static boolean guardarArchivo(String file, ArrayList<Mercaderia> mercaderia)
    {
        boolean seGuardo = false;

        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (int i = 0; i < mercaderia.size(); i++)
            {
                objectOutputStream.writeObject(mercaderia.get(i));
            }

            objectOutputStream.close();

            seGuardo = true;
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        if (seGuardo == true)
            return true;
        else
            return false;
    }

    public static ArrayList<Mercaderia> leerArchivo(String file)
    {
        ArrayList<Mercaderia> aux = new ArrayList<>();

        try
        {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (true)
            {
                aux.add((Mercaderia) objectInputStream.readObject());
            }

        }
        catch(EOFException e)
        {
            // Fin del Archivo
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return aux;
    }
}
