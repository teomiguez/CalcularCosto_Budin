package clases;

import java.util.ArrayList;

public class Aplicacion
{
    // ATRIBUTOS
    private ArrayList<Mercaderia> arrayList;

    // CONSTRUCTOR
    public Aplicacion()
    {
        this.arrayList = new ArrayList<>();
    }

    // GETTERS
    public ArrayList<Mercaderia> getArrayList() {  return arrayList;  }

    // SETTERS
    public void setArrayList(ArrayList<Mercaderia> arrayList) {  this.arrayList = arrayList;  }

    // METODOS
    public void agregarUnaMercaderia (Mercaderia mercaderia)
    {
        ArrayList<Mercaderia> aux = this.getArrayList();
        aux.add(mercaderia);
        setArrayList(aux);
    }
}
