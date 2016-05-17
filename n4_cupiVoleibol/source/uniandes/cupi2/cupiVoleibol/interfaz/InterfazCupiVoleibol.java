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

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.cupiVoleibol.mundo.CupiVoleibol;
import uniandes.cupi2.cupiVoleibol.mundo.Equipo;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazCupiVoleibol extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private CupiVoleibol cupiVoleibol;

    /**
     * N�mero del equipo actual.
     */
    private int numeroEquipoActual;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la informaci�n de un equipo y sus jugadores.
     */
    private PanelInfoEquipo panelInfoEquipo;

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana de la aplicaci�n. <br>
     * <b>post: </b> Se inicializaron los p�neles con la informaci�n del sistema.
     */
    public InterfazCupiVoleibol( )
    {
        cupiVoleibol = new CupiVoleibol( );

        setLayout( new BorderLayout( ) );
        setSize( 925, 650 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setTitle( "CupiVoleibol" );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelInfoEquipo = new PanelInfoEquipo( this );
        add( panelInfoEquipo, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        numeroEquipoActual = 0;
        actualizarInfoEquipo( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Busca el equipo dado el nombre.
     */
    public void buscarEquipo( )
    {
        String nombreEquipo = JOptionPane.showInputDialog( this, "Nombre del equipo buscado:", "Buscar equipo", JOptionPane.INFORMATION_MESSAGE );

        if( nombreEquipo != null )
        {
            Equipo buscado = cupiVoleibol.buscarEquipo( nombreEquipo );
            boolean encontro = false;
            if( buscado != null )
            {
                for( int i = 0; i < CupiVoleibol.CANT_EQUIPOS && !encontro; i++ )
                {
                    Equipo actual = cupiVoleibol.darEquipos( )[ i ];
                    if( actual.darNombre( ).equals( nombreEquipo ) )
                    {
                        numeroEquipoActual = i;
                        encontro = true;
                    }
                }
                actualizarInfoEquipo( );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se encontr� un equipo con el nombre dado.", "Buscar equipo", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Cambia el equipo actual al siguiente.<br>
     * Si se encuentra en el �ltimo, cambia al primero.
     */
    public void cambiarSiguienteEquipo( )
    {
        numeroEquipoActual++;
        if( numeroEquipoActual == CupiVoleibol.CANT_EQUIPOS )
        {
            numeroEquipoActual = 0;
        }
        actualizarInfoEquipo( );
    }

    /**
     * Cambia el equipo actual al anterior.<br>
     * Si se encuentra en el primero, cambia al �ltimo.
     */
    public void cambiarAnteriorEquipo( )
    {
        numeroEquipoActual--;
        if( numeroEquipoActual == -1 )
        {
            numeroEquipoActual = ( CupiVoleibol.CANT_EQUIPOS - 1 );
        }
        actualizarInfoEquipo( );
    }

    /**
     * Agrega el n�mero de aficionados al equipo actual.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     */
    public void agregarAficionados( String pNombreEquipo )
    {
        String ingresado = JOptionPane.showInputDialog( this, "Cantidad de aficionados a agregar:", "Agregar aficionados", JOptionPane.INFORMATION_MESSAGE );
        if( ingresado != null )
        {
            try
            {
                int cantidad = Integer.parseInt( ingresado );
                if( cantidad > 0 )
                {
                    try
                    {
                        cupiVoleibol.agregarAficionados( pNombreEquipo, cantidad );
                        actualizarInfoEquipo( );
                    }
                    catch( Exception e )
                    {
                        JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar aficionados", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad de aficionados a agregar debe ser un n�mero positivo.", "Agregar aficionados", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un n�mero.", "Agregar aficionados", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Retira el n�mero de aficionados del equipo actual.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     */
    public void retirarAficionados( String pNombreEquipo )
    {
        String ingresado = JOptionPane.showInputDialog( this, "Cantidad de aficionados a retirar:", "Retirar aficionados", JOptionPane.INFORMATION_MESSAGE );
        if( ingresado != null )
        {
            try
            {
                int cantidad = Integer.parseInt( ingresado );
                if( cantidad > 0 )
                {

                    try
                    {
                        cupiVoleibol.retirarAficionados( pNombreEquipo, cantidad );
                        actualizarInfoEquipo( );
                    }
                    catch( Exception e )
                    {
                        JOptionPane.showMessageDialog( this, e.getMessage( ), "Retirar aficionados", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad de aficionados a retirar debe ser un n�mero positivo.", "Retirar aficionados", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un n�mero.", "Retirar aficionados", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Registra los puntos ingresados al equipo actual.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     * @param pCedulaJugador C�dula del jugador. pCedulaJugador != null && pCedulaJugador != "".
     */
    public void registrarPuntos( String pNombreEquipo, String pCedulaJugador )
    {
        String ingresado = JOptionPane.showInputDialog( this, "Cantidad de puntos a registrar:", "Registrar puntos", JOptionPane.INFORMATION_MESSAGE );
        if( ingresado != null )
        {
            try
            {
                int cantidad = Integer.parseInt( ingresado );
                if( cantidad > 0 )
                {
                    try
                    {
                        cupiVoleibol.registrarPuntosAnotadosJugador( pNombreEquipo, pCedulaJugador, cantidad );
                        actualizarInfoEquipo( );
                    }
                    catch( Exception e )
                    {
                        JOptionPane.showMessageDialog( this, e.getMessage( ), "Registrar puntos", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad de puntos a registrar debe ser un n�mero positivo.", "Registrar puntos", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un n�mero.", "Registrar puntos", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * 
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     * @param pNombrePatrocinador Nombre del patrocinador. pNombrePatrocinador != null && pNombrePatrocinador != "".
     * @param pAnhosContrato A�os del contrato del patrocinador. pAnhosContrato > 0.
     * @param pDineroAportado Dinero aportado por el patrocinador. pDineroAportado > 0.
     */
    public void asignarPatrocinador( String pNombreEquipo, String pNombrePatrocinador, int pAnhosContrato, double pDineroAportado )
    {
        try
        {
            cupiVoleibol.asignarPatrocinador( pNombreEquipo, pNombrePatrocinador, pAnhosContrato, pDineroAportado );
            actualizarInfoEquipo( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Asignar patrocinador", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega el jugador con los datos dados al equipo dado.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     * @param pNombreJugador Nombre del jugador. pNombreJugador != null && pNombreJugador != "".
     * @param pCedula C�dula del jugador. pCedula != null & pCedula != "".
     * @param pEstatura Estatura del jugador. pEstatura > 0.
     * @param pPeso Peso del jugador.
     */
    public void agregarJugador( String pNombreEquipo, String pNombreJugador, String pCedula, double pEstatura, double pPeso )
    {
        try
        {
            cupiVoleibol.agregarJugador( pNombreEquipo, pNombreJugador, pCedula, pEstatura, pPeso );
            actualizarInfoEquipo( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar jugador", JOptionPane.ERROR_MESSAGE );
            actualizarInfoEquipo( );
        }
    }

    /**
     * Elimina el jugador con la c�dula dada.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     */
    public void eliminarJugador( String pNombreEquipo )
    {
        String cedula = JOptionPane.showInputDialog( this, "C�dula del jugador", "Eliminar jugador", JOptionPane.INFORMATION_MESSAGE );
        try
        {
            cupiVoleibol.eliminarJugador( pNombreEquipo, cedula );
            actualizarInfoEquipo( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar jugador", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el di�logo para agregar un jugador.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     */
    public void mostrarDialogoAgregarJugador( String pNombreEquipo )
    {
        DialogoAgregarJugador dialogo = new DialogoAgregarJugador( this, pNombreEquipo );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el di�logo para asignar un patrocinador.
     * @param pNombreEquipo Nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     */
    public void mostrarDialogoAsignarPatrocinador( String pNombreEquipo )
    {
        DialogoAsignarPatrocinador dialogo = new DialogoAsignarPatrocinador( this, pNombreEquipo );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Determina la cantidad de equipos con patrocinador.
     */
    public void cantidadEquiposPatrocinador( )
    {
        int cuantos = cupiVoleibol.darCantidadEquiposConPatrocinador( );
        if( cuantos > 0 )
        {
            JOptionPane.showMessageDialog( this, "Hay " + cuantos + " equipo(s) con patrocinador.", "Equipos con patrocinador", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay equipos con patrocinador.", "Equipos con patrocinador", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Muestra cu�ntos equipos pertenecen a una categor�a dada.
     */
    public void cantidadEquiposCategoria( )
    {
        Object[] posibilidades = new Object[3];
        posibilidades[ 0 ] = Equipo.INFANTIL;
        posibilidades[ 1 ] = Equipo.JUVENIL;
        posibilidades[ 2 ] = Equipo.MAYORES;

        String categoria = ( String )JOptionPane.showInputDialog( this, "Elegir categor�a:", "Equipos por categor�a", JOptionPane.INFORMATION_MESSAGE, null, posibilidades, posibilidades[ 0 ] );

        if( categoria != null )
        {
            int cuantos = cupiVoleibol.darCantidadEquiposCategoria( categoria );
            if( cuantos > 0 )
            {
                JOptionPane.showMessageDialog( this, "Hay " + cuantos + " equipo(s) en la categor�a " + categoria + ".", "Equipos por categor�a", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No hay equipos en la categor�a " + categoria + ".", "Equipos por categor�a", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    /**
     * Muestra el nombre del equipo con mayor promedio de estatura
     */
    public void mayorPromedio( )
    {
        Equipo mayorPromedio = cupiVoleibol.buscarEquipoMayorPromedioEstatura( );

        if( mayorPromedio != null )
        {
            JOptionPane.showMessageDialog( this, "El equipo con mayor promedio de estatura es: " + mayorPromedio.darNombre( ) + ".", "Mayor promedio estatura", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ning�n equipo tiene jugadores.", "Mayor promedio estatura", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Determina si hay 2 o m�s equipos con la misma cantidad de aficionados.
     */
    public void mismaCantidadAficionados( )
    {
        boolean hay = cupiVoleibol.hayEquiposMismaCantidadAficionados( );
        if( hay == true )
        {
            JOptionPane.showMessageDialog( this, "Si hay dos equipos con la misma cantidad de aficionados.", "Misma cantidad aficionados", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay dos equipos con la misma cantidad de aficionados.", "Misma cantidad aficionados", JOptionPane.INFORMATION_MESSAGE );
        }

    }

    /**
     * Muestra la cantidad de jugadores con sobre peso en el torneo.
     */
    public void jugadoresSobrepeso( )
    {
        JOptionPane.showMessageDialog( this, "En el torneo hay: " + cupiVoleibol.darCantidadTotalJugadoresSobrepeso( ) + " jugadores con sobrepeso.", "Jugadores con sobrepeso", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Actualiza la informaci�n de PanelInfoEquipo.
     */
    private void actualizarInfoEquipo( )
    {
        Equipo equipoActual = cupiVoleibol.darEquipos( )[ numeroEquipoActual ];
        panelInfoEquipo.actualizarInfoEquipo( equipoActual.darNombre( ), equipoActual.darCategoria( ), equipoActual.darCantidadAficionados( ), equipoActual.darJugadores( ), equipoActual.darImagen( ), equipoActual.darCantidadJugadoresSobrepeso( ) );
        panelInfoEquipo.actualizarPatrocinador( equipoActual.darPatrocinador( ) );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = cupiVoleibol.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = cupiVoleibol.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecuci�n de la aplicaci�n. En este caso no son necesarios.
     */
    public static void main( String[] pArgs )
    {
        InterfazCupiVoleibol interfaz = new InterfazCupiVoleibol( );
        interfaz.setVisible( true );
    }

}
