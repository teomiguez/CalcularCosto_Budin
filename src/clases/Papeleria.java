package clases;

import java.io.Serializable;

public class Papeleria implements Serializable
{
    // ATRIBUTOS

    private float precioBudineras;
    private float precioBolsitas;
    private float precioEtiquetas;

    // CONSTRUCTOR

    public Papeleria ()
    {
        this.precioBudineras = 0.00F;
        this.precioBolsitas = 0.00F;
        this.precioEtiquetas = 0.00F;
    }

    public Papeleria (float precioBudineras, float precioBolsitas, float precioEtiquetas)
    {
        this.precioBudineras = precioBudineras;
        this.precioBolsitas = precioBolsitas;
        this.precioEtiquetas = precioEtiquetas;
    }

    // GETTERS

    public float getPrecioBudinera() {  return precioBudineras;  }
    public float getPrecioBolsitas() {  return precioBolsitas;  }
    public float getPrecioEtiquetas() {  return precioEtiquetas;  }

    // SETTERS

    public void setPrecioBolsitas(float precioBolsitas) {  this.precioBolsitas = precioBolsitas;  }
    public void setPrecioBudinera(float precioBudinera) {  this.precioBudineras = precioBudinera;  }
    public void setPrecioEtiquetas(float precioEtiquetas) {  this.precioEtiquetas = precioEtiquetas;  }
}
