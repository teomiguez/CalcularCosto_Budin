package interfacesGraficas;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import archivos.ControladorArchivos;
import clases.Mercaderia;
import clases.Papeleria;

public class IG_Calcular extends JFrame implements ActionListener
{
    // ATRIBUTOS

    private Mercaderia mercaderia;
    private ArrayList<Mercaderia> auxiliar;

    private float precioMaple;
    private float precioHarina;
    private float precioAzucar;
    private float precioAceite;
    private float precioLeche;
    private float precioBudineras;
    private float precioBolsitas;
    private float precioEtiquetas;
    private float precioBudin;

    private JMenuBar menuBar; // creo la barra
    private JMenu menuOpciones; // cada campo que hay en la barra
    private JMenuItem miVer, miNuevo, miSalir; // cada opcion dentro de menuOpciones

    private JLabel labelMercaderia; // titulo
    private JLabel labelMaple;
    private JLabel labelHarina;
    private JLabel labelAzucar;
    private JLabel labelAceite;
    private JLabel labelLeche;

    private JLabel labelPapeleria; // titulo
    private JLabel labelBudineras;
    private JLabel labelBolsitas;
    private JLabel labelEtiquetas;

    private static JTextField textMaple;
    private static JTextField textHarina;
    private static JTextField textAzucar;
    private static JTextField textAceite;
    private static JTextField textLeche;
    private static JTextField textBudineras;
    private static JTextField textBolsitas;
    private static JTextField textEtiquetas;

    private JButton botonCalcular;

    private JScrollPane scrollPane;
    private static JTextArea textArea;

    // CONSTRUCTOR

    public IG_Calcular()
    {
        this.mercaderia = IG_Inicio.mercaderia;
        this.auxiliar = IG_Inicio.aux; // para miVer (copia con lo guardado viejo)

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Los Budines de Teo");
        getContentPane().setBackground(new Color(230, 178, 99));

        // LA BARRA ...

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(230, 178, 99));
        menuBar.setForeground(new Color(0,0,0));
        setJMenuBar(menuBar);

        // LOS MENUS DE LA BARRA ...

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setBackground(new Color(230, 178, 99));
        menuOpciones.setFont(new Font("Andale Mono", 1, 14));
        menuOpciones.setForeground(new Color(0,0,0));
        menuBar.add(menuOpciones);

        // LAS OPCIONIES DENTRO DEL MENU OPCIONES ...

        miVer = new JMenuItem("Ver Guardados");
        miVer.setFont(new Font("Andale Mono", 1, 14));
        miVer.setForeground(new Color(0,0,0));
        menuOpciones.add(miVer);
        miVer.addActionListener(this);

        miNuevo = new JMenuItem("Limpiar");
        miNuevo.setFont(new Font("Andale Mono", 1, 14));
        miNuevo.setForeground(new Color(0,0,0));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);

        miSalir = new JMenuItem("Guardar y Salir");
        miSalir.setFont(new Font("Andale Mono", 1, 14));
        miSalir.setForeground(new Color(0,0,0));
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);

        // ETIQUETAS ...

        labelMercaderia = new JLabel("- Mercaderia -");
        labelMercaderia.setBounds(90,-20,250,100);
        labelMercaderia.setFont(new Font("Sweet Purple", 1, 32));
        labelMercaderia.setForeground(new Color(0,0,0));
        add(labelMercaderia);

        labelMaple = new JLabel("Precio x Maple");
        labelMaple.setBounds(20,20,200,100);
        labelMaple.setFont(new Font("Andale Mono", 3, 18));
        labelMaple.setForeground(new Color(0,0,0));
        add(labelMaple);

        labelHarina = new JLabel("Precio x Kg Harina");
        labelHarina.setBounds(20,50,200,100);
        labelHarina.setFont(new Font("Andale Mono", 3, 18));
        labelHarina.setForeground(new Color(0,0,0));
        add(labelHarina);

        labelAzucar = new JLabel("Precio x Kg Azucar");
        labelAzucar.setBounds(20,80,200,100);
        labelAzucar.setFont(new Font("Andale Mono", 3, 18));
        labelAzucar.setForeground(new Color(0,0,0));
        add(labelAzucar);

        labelAceite = new JLabel("Precio x Lt Aceite");
        labelAceite.setBounds(20,110,200,100);
        labelAceite.setFont(new Font("Andale Mono", 3, 18));
        labelAceite.setForeground(new Color(0,0,0));
        add(labelAceite);

        labelLeche = new JLabel("Precio x Lt Leche");
        labelLeche.setBounds(20,140,200,100);
        labelLeche.setFont(new Font("Andale Mono", 3, 18));
        labelLeche.setForeground(new Color(0,0,0));
        add(labelLeche);

        labelPapeleria = new JLabel("- Papeleria -");
        labelPapeleria.setBounds(90,180,200,100);
        labelPapeleria.setFont(new Font("Sweet Purple", 1, 32));
        labelPapeleria.setForeground(new Color(0,0,0));
        add(labelPapeleria);

        labelBudineras = new JLabel("Precio x Budineras");
        labelBudineras.setBounds(20,215,200,100);
        labelBudineras.setFont(new Font("Andale Mono", 3, 18));
        labelBudineras.setForeground(new Color(0,0,0));
        add(labelBudineras);

        labelBolsitas = new JLabel("Precio x Bolsitas");
        labelBolsitas.setBounds(20,245,200,100);
        labelBolsitas.setFont(new Font("Andale Mono", 3, 18));
        labelBolsitas.setForeground(new Color(0,0,0));
        add(labelBolsitas);

        labelEtiquetas = new JLabel("Precio x Etiquetas");
        labelEtiquetas.setBounds(20,275,200,100);
        labelEtiquetas.setFont(new Font("Andale Mono", 3, 18));
        labelEtiquetas.setForeground(new Color(0,0,0));
        add(labelEtiquetas);

        // CUADROS DE TEXTO ...

        textMaple = new JTextField();
        textMaple.setBounds(200,55,100,25);
        textMaple.setBackground(new Color(254,254,254));
        textMaple.setFont(new Font("Comic Sans ms", 1, 16));
        add(textMaple);

        textHarina = new JTextField();
        textHarina.setBounds(200,85,100,25);
        textHarina.setBackground(new Color(254,254,254));
        textHarina.setFont(new Font("Comic Sans ms", 1, 16));
        add(textHarina);

        textAzucar = new JTextField();
        textAzucar.setBounds(200,115,100,25);
        textAzucar.setBackground(new Color(254,254,254));
        textAzucar.setFont(new Font("Comic Sans ms", 1, 16));
        add(textAzucar);

        textAceite = new JTextField();
        textAceite.setBounds(200,145,100,25);
        textAceite.setBackground(new Color(254,254,254));
        textAceite.setFont(new Font("Comic Sans ms", 1, 16));
        add(textAceite);

        textLeche = new JTextField();
        textLeche.setBounds(200,175,100,25);
        textLeche.setBackground(new Color(254,254,254));
        textLeche.setFont(new Font("Comic Sans ms", 1, 16));
        add(textLeche);

        textBudineras = new JTextField();
        textBudineras.setBounds(200,255,100,25);
        textBudineras.setBackground(new Color(254,254,254));
        textBudineras.setFont(new Font("Comic Sans ms", 1, 16));
        add(textBudineras);

        textBolsitas = new JTextField();
        textBolsitas.setBounds(200,285,100,25);
        textBolsitas.setBackground(new Color(254,254,254));
        textBolsitas.setFont(new Font("Comic Sans ms", 1, 16));
        add(textBolsitas);

        textEtiquetas = new JTextField();
        textEtiquetas.setBounds(200,315,100,25);
        textEtiquetas.setBackground(new Color(254,254,254));
        textEtiquetas.setFont(new Font("Comic Sans ms", 1, 16));
        add(textEtiquetas);

        // BOTONES ...

        botonCalcular = new JButton("CALCULAR");
        botonCalcular.setBackground(new Color(254,254,254));
        botonCalcular.setFont(new Font("Sweet Purple", 1, 20));
        botonCalcular.setBounds(100,380,120,40);
        botonCalcular.addActionListener(this);
        add(botonCalcular);

        // TEXTAREA Y SCROLLPANE ...

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Comic Sans ms", 3, 18));
        textArea.setText("\n          - ACA APARECERAN LOS RESULTADOS -" +
                "\n\n   CONSIDERACIONES: " +
                "\n       - Llenar todos los campos antes de calcular" +
                "\n       - Usar comas (.) de ser necesario" +
                "\n       - El precio de budineras es x 100 unidades" +
                "\n       - El precio de bolsitas es x 100 unidades" +
                "\n       - El precio de etiquetas es x plancha" +
                "\n\n                                     Los Budines de Teo.-");
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(320,15,550,460);
        add(scrollPane);

    }

    // FUNCIONALIDADES

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == botonCalcular)
        {
            if (verificarCamposCargados(textMaple, textHarina, textAzucar, textAceite, textLeche, textBudineras, textBolsitas, textEtiquetas)) {
                precioMaple = Float.parseFloat(textMaple.getText().trim());
                precioHarina = Float.parseFloat(textHarina.getText().trim());
                precioAzucar = Float.parseFloat(textAzucar.getText().trim());
                precioAceite = Float.parseFloat(textAceite.getText().trim());
                precioLeche = Float.parseFloat(textLeche.getText().trim());
                precioBudineras = Float.parseFloat(textBudineras.getText().trim());
                precioBolsitas = Float.parseFloat(textBolsitas.getText().trim());
                precioEtiquetas = Float.parseFloat(textEtiquetas.getText().trim());

                mercaderia.setPrecioMaple(precioMaple);
                mercaderia.setPrecioHarina_Kg(precioHarina);
                mercaderia.setPrecioAzucar_Kg(precioAzucar);
                mercaderia.setPrecioAceite_Lt(precioAceite);
                mercaderia.setPrecioLeche_Lt(precioLeche);
                Papeleria papeleria = new Papeleria(precioBudineras, precioBolsitas, precioEtiquetas);
                mercaderia.setPapeleria(papeleria);

                precioBudin = calcularPrecio_Budin(precioMaple, precioHarina, precioAzucar, precioAceite, precioLeche, precioBudineras, precioBolsitas, precioEtiquetas);

                textArea.setText(" FECHA: " + new SimpleDateFormat("dd-MM-yyyy").format(mercaderia.getFecha()) +
                        "\n\n          - MERCADERIA -" +
                        "\n     MAPLE: $" + mercaderia.getPrecioMaple() +
                        "\n     HARINA x KG: $" + mercaderia.getPrecioHarina_Kg() +
                        "\n     AZUCAR x KG: $" + mercaderia.getPrecioAzucar_Kg() +
                        "\n     ACEITE x LT: $" + mercaderia.getPrecioAceite_Lt() +
                        "\n     LECHE x LT: $" + mercaderia.getPrecioLeche_Lt() +
                        "\n\n          - PAPELERIA -" +
                        "\n     BUDINERAS: $" + mercaderia.getPapeleria().getPrecioBudinera() +
                        "\n     BOLSITAS: $" + mercaderia.getPapeleria().getPrecioBolsitas() +
                        "\n     ETIQUETAS: $" + mercaderia.getPapeleria().getPrecioEtiquetas() +
                        "\n\n                 PRECIO UNITARIO BUDIN: $" + String.format("%.2f", precioBudin));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ERROR - Debe llenar todos los campos");
            }
        }
        if (e.getSource() == miVer)
        {
            textArea.setText(""); // limpio el campo

            for (int i = 0; i < auxiliar.size(); i++)
            {
                Mercaderia aux = auxiliar.get(i);

                float precioAux = calcularPrecio_Budin(aux.getPrecioMaple(), aux.getPrecioHarina_Kg(), aux.getPrecioAzucar_Kg(), aux.getPrecioAceite_Lt(), aux.getPrecioLeche_Lt(), aux.getPapeleria().getPrecioBudinera(), aux.getPapeleria().getPrecioBolsitas(), aux.getPapeleria().getPrecioEtiquetas());

                textArea.append(" FECHA: " + new SimpleDateFormat("dd-MM-yyyy").format(aux.getFecha()));
                textArea.append(        "\n\n          - MERCADERIA -" +
                        "\n     MAPLE: $" + aux.getPrecioMaple() +
                        "\n     HARINA x KG: $" + aux.getPrecioHarina_Kg() +
                        "\n     AZUCAR x KG: $" + aux.getPrecioAzucar_Kg() +
                        "\n     ACEITE x LT: $" + aux.getPrecioAceite_Lt() +
                        "\n     LECHE x LT: $" + aux.getPrecioLeche_Lt() +
                        "\n\n          - PAPELERIA -" +
                        "\n     BUDINERAS: $" + aux.getPapeleria().getPrecioBudinera() +
                        "\n     BOLSITAS: $" + aux.getPapeleria().getPrecioBolsitas() +
                        "\n     ETIQUETAS: $" + aux.getPapeleria().getPrecioEtiquetas() +
                        "\n\n               PRECIO UNITARIO BUDIN: $" + String.format("%.2f", precioAux));
                if (i < (auxiliar.size()-1))
                {
                    textArea.append("\n\n          -------------------------            \n\n");
                }
            }
        }
        if (e.getSource() == miNuevo)
        {
            miNuevo();
        }
        if (e.getSource() == miSalir)
        {
            if (verificarCamposCargados(textMaple, textHarina, textAzucar, textAceite, textLeche, textBudineras, textBolsitas, textEtiquetas))
            {
                auxiliar.add(mercaderia);
                ControladorArchivos.guardarArchivo("file.dat", auxiliar);
            }

            IG_Inicio bienvenida = new IG_Inicio(mercaderia, auxiliar);
            bienvenida.setBounds(0, 0, 370, 370);
            bienvenida.setVisible(true);
            bienvenida.setResizable(false);
            bienvenida.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

    public static boolean verificarCamposCargados(JTextField textMaple, JTextField textHarina, JTextField textAzucar, JTextField textAceite, JTextField textLeche, JTextField textBudineras, JTextField textBolsitas, JTextField textEtiquetas)
    {
        if ((textMaple.getText().trim().length() != 0) && (textHarina.getText().trim().length() != 0) && (textAzucar.getText().trim().length() != 0) && (textAceite.getText().trim().length() != 0) && (textLeche.getText().trim().length() != 0) && (textBudineras.getText().trim().length() != 0) &&  (textBolsitas.getText().trim().length() != 0) && (textEtiquetas.getText().trim().length() != 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void miNuevo()
    {
        textMaple.setText("");
        textHarina.setText("");
        textAzucar.setText("");
        textAceite.setText("");
        textLeche.setText("");
        textBudineras.setText("");
        textBolsitas.setText("");
        textEtiquetas.setText("");
        textArea.setText("\n          - ACA APARECERAN LOS RESULTADOS -" +
                "\n\n   CONSIDERACIONES: " +
                "\n       - Llenar todos los campos antes de calcular" +
                "\n       - Usar comas (.) de ser necesario" +
                "\n       - El precio de budineras es x 100 unidades" +
                "\n       - El precio de bolsitas es x 100 unidades" +
                "\n       - El precio de etiquetas es x plancha" +
                "\n\n                                      Los Budines de Teo.-");
    }

    public static float calcularPrecio_Budin(float precioMaple, float precioHerina, float precioAzucar, float precioAceite, float precioLeche, float precioBudineras, float precioBolsitas, float precioEtiquetas)
    {
        float precioFinal = 0.00F;

        float maple = (precioMaple/30)*11;
        float harina = (precioHerina/1000)*1170;
        float azucar = (precioAzucar/1000)*1200;
        float aceite = (precioAceite/1000)*500;
        float leche = (precioLeche/1000)*500;
        float budinera = precioBudineras/100;
        float bolsita = precioBolsitas/100;
        float etiqueta = precioEtiquetas/99;

        precioFinal = (maple + harina + azucar + aceite + aceite + leche) /13;
        precioFinal += (budinera + bolsita + etiqueta);

        return precioFinal;
    }
}
