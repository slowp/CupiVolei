/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel para el manejo de opciones.
 */
public class PanelOpciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando equipos con patrocinador
     */
    private static final String EQUIPOS_PATROCINADOR = "Equipos patrocinador";

    /**
     * Constante que representa el comando equipos de una categor�a.
     */
    private static final String EQUIPOS_CATEGORIA = "Equipos categor�a";

    /**
     * Constante que representa el comando mayor promedio de estatura.
     */
    private static final String MAYOR_PROMEDIO = "Mayor promedio de estatura";

    /**
     * Constante que representa el comando misma cantidad de aficionados.
     */
    private static final String MISMA_CANTIDAD = "Misma cantidad de aficionados";

    /**
     * Constante que representa el comando jugadores con sobrepeso.
     */
    private static final String SOBREPESO = "Cantidad jugadores sobrepeso";

    /**
     * Constante que representa el comando opci�n 1.
     */
    private static final String OPCION_1 = "Opci�n 1";

    /**
     * Constante que representa el comando opci�n 2.
     */
    private static final String OPCION_2 = "Opci�n 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazCupiVoleibol principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para buscar la cantidad de equipos con patrocinador.
     */
    private JButton btnEquiposPatrocinador;

    /**
     * Bot�n para buscar la cantidad de equipos que pertenecen a una categor�a.
     */
    private JButton btnEquiposCategoria;

    /**
     * Bot�n para buscar el equipo con el mayor promedio de estatura.
     */
    private JButton btnMayorPromedioEstatura;

    /**
     * Bot�n para buscar dos equipos con la misma cantidad de aficionados.
     */
    private JButton btnMismaCantidadAficionados;

    /**
     * Bot�n para buscar la cantidad de jugadores con sobrepeso.
     */
    private JButton btnJugadoresSobrepeso;

    /**
     * Bot�n para la opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n para la opci�n 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelOpciones( InterfazCupiVoleibol ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 3, 1 ) );

        JPanel panel1 = new JPanel( );
        JPanel panel2 = new JPanel( );
        JPanel panel3 = new JPanel( );

        panel1.setLayout( new GridLayout( 1, 3 ) );
        panel2.setLayout( new GridLayout( 1, 2 ) );
        panel3.setLayout( new GridLayout( 1, 2 ) );

        btnEquiposPatrocinador = new JButton( "Cantidad equipos patrocinador" );
        btnEquiposPatrocinador.setActionCommand( EQUIPOS_PATROCINADOR );
        btnEquiposPatrocinador.addActionListener( this );
        panel1.add( btnEquiposPatrocinador );

        btnEquiposCategoria = new JButton( "Cantidad equipos categor�a" );
        btnEquiposCategoria.setActionCommand( EQUIPOS_CATEGORIA );
        btnEquiposCategoria.addActionListener( this );
        panel1.add( btnEquiposCategoria );

        btnMayorPromedioEstatura = new JButton( "Mayor promedio estatura" );
        btnMayorPromedioEstatura.setActionCommand( MAYOR_PROMEDIO );
        btnMayorPromedioEstatura.addActionListener( this );
        panel1.add( btnMayorPromedioEstatura );

        btnMismaCantidadAficionados = new JButton( "Misma cantidad aficionados" );
        btnMismaCantidadAficionados.setActionCommand( MISMA_CANTIDAD );
        btnMismaCantidadAficionados.addActionListener( this );
        panel2.add( btnMismaCantidadAficionados );

        btnJugadoresSobrepeso = new JButton( "Jugadores con sobrepeso" );
        btnJugadoresSobrepeso.setActionCommand( SOBREPESO );
        btnJugadoresSobrepeso.addActionListener( this );
        panel2.add( btnJugadoresSobrepeso );

        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        panel3.add( btnOpcion1 );

        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        panel3.add( btnOpcion2 );

        add( panel1 );
        add( panel2 );
        add( panel3 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( EQUIPOS_PATROCINADOR.equals( comando ) )
        {
            principal.cantidadEquiposPatrocinador( );
        }
        else if( EQUIPOS_CATEGORIA.equals( comando ) )
        {
            principal.cantidadEquiposCategoria( );
        }
        else if( MAYOR_PROMEDIO.equals( comando ) )
        {
            principal.mayorPromedio( );
        }
        else if( MISMA_CANTIDAD.equals( comando ) )
        {
            principal.mismaCantidadAficionados( );
        }
        else if( SOBREPESO.equals( comando ) )
        {
            principal.jugadoresSobrepeso( );
        }
    }

}
