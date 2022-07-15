package interfacesGraficas;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import clases.Mercaderia;



public class IG_Inicio extends JFrame implements ActionListener {

    // ATRIBUTOS

    public static Mercaderia mercaderia;
    public static ArrayList<Mercaderia> aux;

    private String user;
    private String password;

    private JLabel labelTitulo;
    private JLabel labelUser;
    private JLabel labelPassword;

    private JTextField textField1;
    private JPasswordField passwordField;

    private JButton botonInicio;

    // CONSTRUCTOR

    public IG_Inicio (Mercaderia mercaderia, ArrayList<Mercaderia> aux)
    {
        this.mercaderia = mercaderia;
        this.aux = aux;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenida - login");
        getContentPane().setBackground(new Color(230, 178, 99));

        // ETIQUETAS ...

        labelTitulo = new JLabel("Los Budines de Teo");
        labelUser = new JLabel("Usuario");
        labelPassword = new JLabel("Contraseña");

        labelTitulo.setBounds(20,10,350,100);
        labelTitulo.setFont(new Font("Sweet Purple", 0, 54));
        labelTitulo.setForeground(new Color(0,0,0));
        add(labelTitulo);

        labelUser.setBounds(30,80,200,100);
        labelUser.setFont(new Font("Andale Mono", 3, 20));
        labelUser.setForeground(new Color(0,0,0));
        add(labelUser);

        labelPassword.setBounds(15,100,300,200);
        labelPassword.setFont(new Font("Andale Mono", 3, 20));
        labelPassword.setForeground(new Color(0,0,0));
        add(labelPassword);

        // CUADROS DE TEXTO ...

        textField1 = new JTextField();
        textField1.setBounds(150,115,150,30);
        textField1.setBackground(new Color(254,254,254));
        textField1.setFont(new Font("Comic Sans ms", 1, 16));
        add(textField1);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,185,150,30);
        passwordField.setBackground(new Color(254,254,254));
        passwordField.setFont(new Font("Comic Sans ms", 1, 22));
        add(passwordField);

        // BOTONES ...

        botonInicio = new JButton("INGRESAR");
        botonInicio.setBackground(new Color(254,254,254));
        botonInicio.setFont(new Font("Sweet Purple", 1, 20));
        botonInicio.setBounds(100,255,120,40);
        botonInicio.addActionListener(this);
        add(botonInicio);

    }

    // FUNCIONALIDADES

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == botonInicio)
        {
            if ((textField1.getText().trim().length() != 0) && (passwordField.getPassword().length != 0)) {
                this.user = textField1.getText().trim();
                this.password = String.valueOf(passwordField.getPassword());

                if ((user.equals("TEO")) && (password.equals("TEO")))
                {
                    IG_Calcular calcular = new IG_Calcular();
                    calcular.setBounds(0, 0, 900, 550);
                    calcular.setVisible(true);
                    calcular.setLocationRelativeTo(null);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "ERROR - El usuario y/o contraseña no coinciden");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ERROR - Debe llenar todos los campos");
            }
        }
    }
}
