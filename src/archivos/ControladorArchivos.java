package archivos;

import clases.Mercaderia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ControladorArchivos
{
    public static boolean guardarArchivo(String file, Mercaderia mercaderia)
    {
        boolean seGuardo = false;

        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(mercaderia);

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

    public static Mercaderia leerArchivo(String file)
    {
        Mercaderia aux = new Mercaderia();

        try
        {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            aux = (Mercaderia) objectInputStream.readObject();

            objectInputStream.close();

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
