package clases;

import java.io.Serializable;
import java.util.Date;

public class Mercaderia implements Serializable
{
    // ATRIBUTOS

    private Date fecha;
    private float precioMaple;
    private float precioHarina_Kg;
    private float precioAzucar_Kg;
    private float precioAceite_Lt;
    private float precioLeche_Lt;
    private Papeleria papeleria;

    // CONSTRUCTOR

    public Mercaderia ()
    {
        this.fecha = new Date();
        this.precioMaple = 0.00F;
        this.precioHarina_Kg = 0.00F;
        this.precioAzucar_Kg = 0.00F;
        this.precioAceite_Lt = 0.00F;
        this.precioLeche_Lt = 0.00F;
        papeleria = new Papeleria();
    }

    // GETTERS

    public Date getFecha() {  return fecha;  }
    public float getPrecioMaple() {  return precioMaple;  }
    public float getPrecioHarina_Kg() {  return precioHarina_Kg;  }
    public float getPrecioAzucar_Kg() {  return precioAzucar_Kg;  }
    public float getPrecioAceite_Lt() {  return precioAceite_Lt;  }
    public float getPrecioLeche_Lt() {  return precioLeche_Lt;  }
    public Papeleria getPapeleria() {  return papeleria;  }

    // SETTERS

    public void setPrecioMaple(float precioMaple) {  this.precioMaple = precioMaple;  }
    public void setPrecioHarina_Kg(float precioHarina_Kg) {  this.precioHarina_Kg = precioHarina_Kg;  }
    public void setPrecioAzucar_Kg(float precioAzucar_Kg) {  this.precioAzucar_Kg = precioAzucar_Kg;  }
    public void setPrecioAceite_Lt(float precioAceite_Lt) {  this.precioAceite_Lt = precioAceite_Lt;  }
    public void setPrecioLeche_Lt(float precioLeche_Lt) {  this.precioLeche_Lt = precioLeche_Lt;  }
    public void setPapeleria(Papeleria papeleria) {  this.papeleria = papeleria;  }
}
