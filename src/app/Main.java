package app;

import archivos.ControladorArchivos;
import clases.Aplicacion;
import clases.Mercaderia;
import interfacesGraficas.IG_Calcular;
import interfacesGraficas.IG_Inicio;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        Aplicacion app = new Aplicacion();
        Mercaderia mercaderia = new Mercaderia();
        ArrayList<Mercaderia> aux = app.getArrayList();

        aux = ControladorArchivos.leerArchivo("file.dat");

        ventanaInicio(mercaderia, aux);

    }

    public static void ventanaInicio(Mercaderia mercaderia, ArrayList<Mercaderia> aux)
    {
        IG_Inicio bienvenida = new IG_Inicio(mercaderia, aux);

        bienvenida.setBounds(0, 0, 370, 370);
        bienvenida.setVisible(true);
        bienvenida.setResizable(false);
        bienvenida.setLocationRelativeTo(null);
    }

    public static void ventanaPrincipal()
    {
        IG_Calcular calcular = new IG_Calcular();

        calcular.setBounds(0, 0, 900, 550);
        calcular.setVisible(true);
        calcular.setLocationRelativeTo(null);
    }
}
