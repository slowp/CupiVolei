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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.cupiVoleibol.mundo.Jugador;
import uniandes.cupi2.cupiVoleibol.mundo.Patrocinador;

/**
 * Panel con la información del equipo actual.
 */
public class PanelInfoEquipo extends JPanel implements ActionListener, ListSelectionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando anterior.
     */
    private static final String ANTERIOR = "<<";

    /**
     * Constante que representa el comando siguiente.
     */
    private static final String SIGUIENTE = ">>";

    /**
     * Constante que representa el comando buscar.
     */
    private static final String BUSCAR = "Buscar";

    /**
     * Constante que representa el comando asignar patrocinador.
     */
    private static final String ASIGNAR = "Asignar patrocinador";

    /**
     * Constante que representa el comando para agregar aficionados.
     */
    private static final String AGREGAR_AFIC = "Agregar aficionados";

    /**
     * Constante que representa el comando para retirar aficionados.
     */
    private static final String RETIRAR_AFIC = "Retirar aficionados";

    /**
     * Constante que representa el comando para agregar un jugador.
     */
    private static final String AGREGAR_JUG = "Agregar jugador";

    /**
     * Constante que representa el comando para eliminar un jugador.
     */
    private static final String ELIMINAR_JUG = "Eliminar jugador";

    /**
     * Constante que representa el comando para registrar puntos a un jugador.
     */
    private static final String REGISTRAR_PUNTOS = "Registrar puntos";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiVoleibol principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para ir al equipo anterior.
     */
    private JButton btnAnterior;

    /**
     * Botón para ir al equipo siguiente.
     */
    private JButton btnSiguiente;

    /**
     * Botón para buscar un equipo.
     */
    private JButton btnBuscar;

    /**
     * Botón para asignar un patrocinador.
     */
    private JButton btnAsignar;

    /**
     * Botón para agregar aficionados.
     */
    private JButton btnAgregarAficionados;

    /**
     * Botón para retirar aficionados.
     */
    private JButton btnRetirarAficionados;

    /**
     * Botón para agregar un jugador.
     */
    private JButton btnAgregarJugador;

    /**
     * Botón para eliminar un jugador.
     */
    private JButton btnEliminarJugador;

    /**
     * Botón para registrar puntos a un jugador.
     */
    private JButton btnRegistrarPuntos;

    /**
     * Campo de texto para el nombre del equipo.
     */
    private JTextField txtNombreEquipo;

    /**
     * Campo de texto para la cantidad de aficionados del equipo.
     */
    private JTextField txtCantidadAficionados;

    /**
     * Campo de texto para la categoría del equipo.
     */
    private JTextField txtCategoria;

    /**
     * Etiqueta para la imagen del equipo.
     */
    private JLabel lblImagen;

    /**
     * Campo de texto para el nombre del patrocinador.
     */
    private JTextField txtNombrePatrocinador;

    /**
     * Campo de texto para los años de contrato del patrocinador.
     */
    private JTextField txtAnhosContrato;

    /**
     * Campo de texto para el dinero aportado por el patrocinador.
     */
    private JTextField txtDineroAportado;
    
    /**
     * Campo de texto para los jugadores con sobrepeso.
     */
    private JTextField txtJugadoresSobrepeso;

    /**
     * Lista de los jugadores del equipo.
     */
    private JList listaJugadores;

    /**
     * Campo de texto para el nombre del jugador.
     */
    private JTextField txtNombreJugador;

    /**
     * Campo de texto para la cédula del jugador.
     */
    private JTextField txtCedula;

    /**
     * Campo de texto para la estatura del jugador.
     */
    private JTextField txtEstatura;
    
    /**
     * Campo de texto para el peso del jugador.
     */
    private JTextField txtPeso;

    /**
     * Campo de texto para los puntos anotados del jugador.
     */
    private JTextField txtPuntosAnotados;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye el pánel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelInfoEquipo( InterfazCupiVoleibol pPrincipal )
    {
        principal = pPrincipal;
        setBorder( new TitledBorder( "Equipos" ) );
        setLayout( new BorderLayout( ) );
        JPanel panelGrandeEquipo = new JPanel( );
        panelGrandeEquipo.setLayout( new BorderLayout( ) );
        
        JPanel panelIzquierda = new JPanel( );
        panelIzquierda.setLayout( new GridLayout( 2, 1 ) );

        JPanel panelImagenEquipo = new JPanel( );
        panelImagenEquipo.setLayout( new BorderLayout( ) );
        JPanel panelEquipo = new JPanel( );
        panelEquipo.setLayout( new GridLayout( 6, 2, 5, 5 ) );
        panelEquipo.add( new JLabel( "Nombre equipo:" ) );
        txtNombreEquipo = new JTextField( );
        txtNombreEquipo.setEditable( false );
        panelEquipo.add( txtNombreEquipo );

        panelEquipo.add( new JLabel( "Categoría:" ) );
        txtCategoria = new JTextField( );
        txtCategoria.setEditable( false );
        panelEquipo.add( txtCategoria );

        panelEquipo.add( new JLabel( "Aficionados:" ) );
        txtCantidadAficionados = new JTextField( );
        txtCantidadAficionados.setEditable( false );
        panelEquipo.add( txtCantidadAficionados );
        
        panelEquipo.add( new JLabel( "Jugadores sobrepeso:" ) );
        txtJugadoresSobrepeso = new JTextField( );
        txtJugadoresSobrepeso.setEditable( false );
        panelEquipo.add( txtJugadoresSobrepeso );

        btnAgregarAficionados = new JButton( "Agregar aficionados" );
        btnAgregarAficionados.setActionCommand( AGREGAR_AFIC );
        btnAgregarAficionados.addActionListener( this );
        panelEquipo.add( btnAgregarAficionados );

        btnRetirarAficionados = new JButton( "Retirar aficionados" );
        btnRetirarAficionados.setActionCommand( RETIRAR_AFIC );
        btnRetirarAficionados.addActionListener( this );
        panelEquipo.add( btnRetirarAficionados );

        btnAgregarJugador = new JButton( "Agregar jugador" );
        btnAgregarJugador.setActionCommand( AGREGAR_JUG );
        btnAgregarJugador.addActionListener( this );
        panelEquipo.add( btnAgregarJugador );

        btnEliminarJugador = new JButton( "Eliminar jugador" );
        btnEliminarJugador.setActionCommand( ELIMINAR_JUG );
        btnEliminarJugador.addActionListener( this );
        panelEquipo.add( btnEliminarJugador );
        panelImagenEquipo.add( panelEquipo, BorderLayout.CENTER );
        
        lblImagen = new JLabel( );
        ImageIcon imagen = new ImageIcon( "./data/imagenes/vacio.png" );
        lblImagen.setIcon( imagen );
        panelImagenEquipo.add( lblImagen, BorderLayout.EAST );
        
        panelIzquierda.add( panelImagenEquipo );

        JPanel panelPatrocinador = new JPanel( );
        panelPatrocinador.setLayout( new GridLayout( 3, 2, 5, 5 ) );

        panelPatrocinador.add( new JLabel( "Nombre:" ) );
        txtNombrePatrocinador = new JTextField( "Sin patrocinador" );
        txtNombrePatrocinador.setEditable( false );
        panelPatrocinador.add( txtNombrePatrocinador );

        panelPatrocinador.add( new JLabel( "Años contrato:" ) );
        txtAnhosContrato = new JTextField( "Sin patrocinador" );
        txtAnhosContrato.setEditable( false );
        panelPatrocinador.add( txtAnhosContrato );

        panelPatrocinador.add( new JLabel( "Dinero aportado:" ) );
        txtDineroAportado = new JTextField( "Sin patrocinador" );
        txtDineroAportado.setEditable( false );
        panelPatrocinador.add( txtDineroAportado );

        btnAsignar = new JButton( "Asignar patrocinador" );
        btnAsignar.setActionCommand( ASIGNAR );
        btnAsignar.addActionListener( this );

        JPanel panelAuxiliar = new JPanel( );
        panelAuxiliar.setBorder( new TitledBorder( "Patrocinador" ) );
        panelAuxiliar.setLayout( new BorderLayout( ) );
        panelAuxiliar.add( panelPatrocinador, BorderLayout.CENTER );
        panelAuxiliar.add( btnAsignar, BorderLayout.SOUTH );

        panelIzquierda.add( panelAuxiliar );

        JPanel panelDerecha = new JPanel( );
        panelDerecha.setLayout( new GridLayout( 2, 1 ) );
        panelDerecha.setBorder( new TitledBorder( "Jugadores:" ) );

        JScrollPane panelJugadores = new JScrollPane( );
        listaJugadores = new JList( );
        listaJugadores.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaJugadores.addListSelectionListener( this );
        listaJugadores.setSelectedIndex( -1 );
        panelJugadores.setViewportView( listaJugadores );
        panelJugadores.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        panelJugadores.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        
        panelDerecha.add( panelJugadores );

        JPanel panelJugador = new JPanel( );
        panelJugador.setBorder( new TitledBorder( "Jugador seleccionado" ) );
        panelJugador.setLayout( new GridLayout( 6, 2, 5, 5 ) );

        panelJugador.add( new JLabel( "Nombre:" ) );
        txtNombreJugador = new JTextField( );
        txtNombreJugador.setEditable( false );
        panelJugador.add( txtNombreJugador );

        panelJugador.add( new JLabel( "Cédula:" ) );
        txtCedula = new JTextField( );
        txtCedula.setEditable( false );
        panelJugador.add( txtCedula );

        panelJugador.add( new JLabel( "Estatura:" ) );
        txtEstatura = new JTextField( );
        txtEstatura.setEditable( false );
        panelJugador.add( txtEstatura );
        
        panelJugador.add( new JLabel( "Peso:" ) );
        txtPeso = new JTextField( );
        txtPeso.setEditable( false );
        panelJugador.add( txtPeso );

        panelJugador.add( new JLabel( "Puntos anotados:" ) );
        txtPuntosAnotados = new JTextField( );
        txtPuntosAnotados.setEditable( false );
        panelJugador.add( txtPuntosAnotados );

        panelJugador.add( new JLabel( ) );
        btnRegistrarPuntos = new JButton( "Registrar puntos" );
        btnRegistrarPuntos.setActionCommand( REGISTRAR_PUNTOS );
        btnRegistrarPuntos.addActionListener( this );
        btnRegistrarPuntos.setEnabled( false );
        panelJugador.add( btnRegistrarPuntos );

        panelDerecha.add( panelJugador );

        panelGrandeEquipo.add( panelIzquierda, BorderLayout.CENTER );
        panelGrandeEquipo.add( panelDerecha, BorderLayout.EAST );
        add(panelGrandeEquipo, BorderLayout.CENTER);
        
        JPanel panelNavegacion = new JPanel( );
        panelNavegacion.setLayout( new GridLayout( 1, 3 ) );

        btnAnterior = new JButton( "<<" );
        btnAnterior.setActionCommand( ANTERIOR );
        btnAnterior.addActionListener( this );
        panelNavegacion.add( btnAnterior );

        btnBuscar = new JButton( "Buscar" );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        panelNavegacion.add( btnBuscar );

        btnSiguiente = new JButton( ">>" );
        btnSiguiente.setActionCommand( SIGUIENTE );
        btnSiguiente.addActionListener( this );
        panelNavegacion.add( btnSiguiente );

        add( panelNavegacion, BorderLayout.SOUTH  );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza los campos de texto con los valores dados por parámetro.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     * @param pCategoria Categoría del equipo. pCategoria != null && pCategoria != "".
     * @param pCantidadAficionados Cantidad de aficionados del equipo. pCantidadAficionados > 0.
     * @param pJugadores Lista de jugadores del equipo. pJugadores != null.
     * @param pImagen Imagen del equipo. pImagen != null && pImagen != "".
     * @param pJugadoresSobrepeso Cantidad de jugadores con sobrepeso en el equipo.
     */
    public void actualizarInfoEquipo( String pNombreEquipo, String pCategoria, int pCantidadAficionados, ArrayList pJugadores, String pImagen, int pJugadoresSobrepeso )
    {
        txtNombreEquipo.setText( pNombreEquipo );
        txtCategoria.setText( pCategoria );
        txtCantidadAficionados.setText( String.valueOf( pCantidadAficionados ) );
        txtJugadoresSobrepeso.setText( String.valueOf( pJugadoresSobrepeso ) );
        listaJugadores.setListData( pJugadores.toArray( ) );
        if( listaJugadores.getSelectedIndex( ) == -1 && pJugadores.size( ) > 0 )
        {
            listaJugadores.setSelectedIndex( 0 );
            Jugador primero = ( Jugador )pJugadores.get( 0 );
            txtNombreJugador.setText( primero.darNombre( ) );
            txtCedula.setText( primero.darCedula( ) );
            txtEstatura.setText( String.valueOf( primero.darEstatura( ) ) );
            txtPeso.setText( String.valueOf( primero.darPeso( ) ) );
            txtPuntosAnotados.setText( String.valueOf( primero.darPuntosAnotados( ) ) );
            btnRegistrarPuntos.setEnabled( true );
        }
        else
        {
            listaJugadores.setSelectedIndex( 0 );
            txtNombreJugador.setText( "" );
            txtCedula.setText( "" );
            txtEstatura.setText( "" );
            txtPeso.setText( "" );
            txtPuntosAnotados.setText( "" );
            btnRegistrarPuntos.setEnabled( false );
        }
        ImageIcon imagen = new ImageIcon( "./data/imagenes/" + pImagen );
        lblImagen.setIcon( imagen );
    }

    /**
     * Actualiza la información del patrocinador.
     * @param pPatrocinador Patrocinador del equipo, puede ser null.
     */
    public void actualizarPatrocinador( Patrocinador pPatrocinador )
    {
        if( pPatrocinador != null )
        {
            txtNombrePatrocinador.setText( pPatrocinador.darNombre( ) );
            txtAnhosContrato.setText( String.valueOf( pPatrocinador.darAnhosContrato( ) ) );
            txtDineroAportado.setText( String.valueOf( pPatrocinador.darDineroAportado( ) ) );
        }
        else
        {
            txtNombrePatrocinador.setText( "Sin patrocinador" );
            txtAnhosContrato.setText( "Sin patrocinador" );
            txtDineroAportado.setText( "Sin patrocinador" );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR_AFIC ) )
        {
            principal.agregarAficionados( txtNombreEquipo.getText( ) );
        }
        else if( comando.equals( RETIRAR_AFIC ) )
        {
            principal.retirarAficionados( txtNombreEquipo.getText( ) );
        }
        else if( comando.equals( AGREGAR_JUG ) )
        {
            principal.mostrarDialogoAgregarJugador( txtNombreEquipo.getText( ) );
        }
        else if( comando.equals( ELIMINAR_JUG ) )
        {
            principal.eliminarJugador( txtNombreEquipo.getText( ) );
        }
        else if( comando.equals( ASIGNAR ) )
        {
            principal.mostrarDialogoAsignarPatrocinador( txtNombreEquipo.getText( ) );
        }
        else if( comando.equals( ANTERIOR ) )
        {
            principal.cambiarAnteriorEquipo( );
        }
        else if( comando.equals( SIGUIENTE ) )
        {
            principal.cambiarSiguienteEquipo( );
        }
        else if( comando.equals( BUSCAR ) )
        {
            principal.buscarEquipo( );
        }
        else if( comando.equals( REGISTRAR_PUNTOS ) )
        {
            principal.registrarPuntos( txtNombreEquipo.getText( ), txtCedula.getText( ) );
        }
    }

    /**
     * Maneja los eventos de selección de la lista.
     * @param pEvento Evento de selección. pEvento != null.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        if( listaJugadores.getSelectedValue( ) != null )
        {
            Jugador jugador = ( Jugador )listaJugadores.getSelectedValue( );
            txtNombreJugador.setText( jugador.darNombre( ) );
            txtCedula.setText( jugador.darCedula( ) );
            txtEstatura.setText( String.valueOf( jugador.darEstatura( ) ) );
            txtPeso.setText( String.valueOf( jugador.darPeso( ) ) );
            txtPuntosAnotados.setText( String.valueOf( jugador.darPuntosAnotados( ) ) );
            btnRegistrarPuntos.setEnabled( true );
        }
    }
}
