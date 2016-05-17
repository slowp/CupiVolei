/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_cupiVoleibol
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiVoleibol.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiVoleibol.mundo.Jugador;

/**
 * Diálogo para agregar un jugador.
 */
public class DialogoAgregarJugador extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para aceptar.
     */
    public static final String ACEPTAR = "Aceptar";

    /**
     * Constante que representa el comando para cancelar.
     */
    public static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiVoleibol principal;

    /**
     * Nombre del equipo del jugador.
     */
    private String nombreEquipo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto del nombre del jugador.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto de la cédula del jugador.
     */
    private JTextField txtCedula;

    /**
     * Campo de texto de la estatura del jugador.
     */
    private JTextField txtEstatura;

    /**
     * Campo de texto del peso del jugador.
     */
    private JTextField txtPeso;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     */
    public DialogoAgregarJugador( InterfazCupiVoleibol pPrincipal, String pNombreEquipo )
    {
        principal = pPrincipal;
        nombreEquipo = pNombreEquipo;
        setTitle( "Agregar jugador" );

        JPanel panelIngreso = new JPanel( );
        panelIngreso.setBorder( new TitledBorder( "Datos jugador" ) );
        panelIngreso.setLayout( new GridLayout( 5, 2, 5, 5 ) );

        panelIngreso.add( new JLabel( "Nombre:" ) );
        txtNombre = new JTextField( );
        panelIngreso.add( txtNombre );

        panelIngreso.add( new JLabel( "Cédula:" ) );
        txtCedula = new JTextField( "" );
        panelIngreso.add( txtCedula );

        panelIngreso.add( new JLabel( "Estatura:" ) );
        txtEstatura = new JTextField( );
        panelIngreso.add( txtEstatura );

        panelIngreso.add( new JLabel( "Peso:" ) );
        txtPeso = new JTextField( );
        panelIngreso.add( txtPeso );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelIngreso.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelIngreso.add( btnCancelar );

        add( panelIngreso );

        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            String estaturaStr = txtEstatura.getText( );
            String cedula = txtCedula.getText( );
            String pesoStr = txtPeso.getText( );

            if( !nombre.equals( "" ) && !estaturaStr.equals( "" ) && !cedula.equals( "" ) && !pesoStr.equals( "" ) )
            {
                try
                {
                    double estatura = Double.parseDouble( estaturaStr );
                    double peso = Double.parseDouble( pesoStr );
                    if( estatura > 0 && peso != 0 )
                    {
                        if(estatura >= Jugador.ESTATURA_MIN && estatura <= Jugador.ESTATURA_MAX)
                        {
                            setVisible( false );
                            dispose( );
                            principal.agregarJugador( nombreEquipo, nombre, cedula, estatura, peso );
                        }
                        else
                        {
                            JOptionPane.showMessageDialog( this, "La estatura no está dentro del rango permitido.", "Agregar jugador", JOptionPane.ERROR_MESSAGE );
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "La estatura debe ser un número mayor a 0.", "Agregar jugador", JOptionPane.ERROR_MESSAGE );
                    }
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico para la estatura y el peso.", "Agregar jugador", JOptionPane.ERROR_MESSAGE );
                }

            }
            else
            {
                JOptionPane.showMessageDialog( this, "Debe llenar todos los campos.", "Agregar jugador", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pEvento.getActionCommand( ).equals( CANCELAR ) )
        {
            setVisible( false );
            dispose( );
        }
    }

}