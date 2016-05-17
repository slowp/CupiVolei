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

/**
 * Diálogo para asignar un patrocinador a un equipo.
 */
public class DialogoAsignarPatrocinador extends JDialog implements ActionListener
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
     * Nombre del equipo del patrocinador.
     */
    private String nombreEquipo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto del nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto de los años de contrato del patrocinador.
     */
    private JTextField txtAnhosContrato;

    /**
     * Campo de texto del dinero aportado por el patrocinador.
     */
    private JTextField txtDineroAportado;

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
    public DialogoAsignarPatrocinador( InterfazCupiVoleibol pPrincipal, String pNombreEquipo )
    {
        principal = pPrincipal;
        nombreEquipo = pNombreEquipo;
        setTitle( "Asignar patrocinador" );

        JPanel panelIngreso = new JPanel( );
        panelIngreso.setBorder( new TitledBorder( "Datos patrocinador" ) );
        panelIngreso.setLayout( new GridLayout( 4, 2, 5, 5 ) );

        panelIngreso.add( new JLabel( "Nombre:" ) );
        txtNombre = new JTextField( );
        panelIngreso.add( txtNombre );

        panelIngreso.add( new JLabel( "Años de contrato:" ) );
        txtAnhosContrato = new JTextField( );
        panelIngreso.add( txtAnhosContrato );

        panelIngreso.add( new JLabel( "Dinero aportado:" ) );
        txtDineroAportado = new JTextField( );
        panelIngreso.add( txtDineroAportado );

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
            String anhosContratoStr = txtAnhosContrato.getText( );
            String dineroAportadoStr = txtDineroAportado.getText( );

            if( !nombre.equals( "" ) && !anhosContratoStr.equals( "" ) && !dineroAportadoStr.equals( "" ) )
            {
                try
                {
                    int anhosContrato = Integer.parseInt( anhosContratoStr );
                    double dineroAportado = Double.parseDouble( dineroAportadoStr );

                    if( anhosContrato > 0 && dineroAportado > 0 )
                    {
                        principal.asignarPatrocinador( nombreEquipo, nombre, anhosContrato, dineroAportado );
                        setVisible( false );
                        dispose( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El dinero aportado y los años de contrato deben ser mayores a 0.", "Asignar patrocinador", JOptionPane.ERROR_MESSAGE );

                    }
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar valores numéricos para los años de contrato y el dinero aportado.", "Asignar patrocinador", JOptionPane.ERROR_MESSAGE );
                }
            }

            else
            {
                JOptionPane.showMessageDialog( this, "Debe llenar todos los campos.", "Asignar patrocinador", JOptionPane.ERROR_MESSAGE );
            }

        }
        else if( pEvento.getActionCommand( ).equals( CANCELAR ) )
        {
            setVisible( false );
            dispose( );
        }

    }

}