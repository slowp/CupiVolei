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
package uniandes.cupi2.cupiVoleibol.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.cupiVoleibol.mundo.CupiVoleibol;
import uniandes.cupi2.cupiVoleibol.mundo.Equipo;
import uniandes.cupi2.cupiVoleibol.mundo.Jugador;

/**
 * Clase usada para verificar que los m�todos de la clase CupiVoleibol est�n correctamente implementados.
 */
public class CupiVoleibolTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private CupiVoleibol cupiVoleibol;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo torneo de voleibol sin jugadores.
     */
    public void setupEscenario1( )
    {
        cupiVoleibol = new CupiVoleibol( );
    }

    /**
     * Escenario 2: Crea un nuevo torneo de voleibol con jugadores.
     */
    public void setupEscenario2( )
    {
        cupiVoleibol = new CupiVoleibol( );
        try
        {
            cupiVoleibol.agregarJugador( "Deportivo Atributos", "nombre 1", "1122", 1.85, 80 );
            cupiVoleibol.agregarJugador( "Deportivo Atributos", "nombre 2", "1133", 1.95, 75 );
            cupiVoleibol.agregarJugador( "Deportivo Atributos", "nombre 3", "1144", 2.05, 95 );
            cupiVoleibol.agregarJugador( "Deportivo Atributos", "nombre 4", "1155", 1.83, 120 );
            cupiVoleibol.agregarJugador( "Deportivo Atributos", "nombre 5", "1166", 2.01, 100 );
            cupiVoleibol.agregarJugador( "Deportivo Atributos", "nombre 6", "1177", 1.60, 60 );

            cupiVoleibol.agregarJugador( "M�todos Club", "nombre 1", "2211", 1.65, 82 );
            cupiVoleibol.agregarJugador( "M�todos Club", "nombre 2", "2222", 1.75, 70 );
            cupiVoleibol.agregarJugador( "M�todos Club", "nombre 3", "2233", 1.77, 100 );

            cupiVoleibol.agregarJugador( "Cupi2", "nombre 1", "3311", 1.67, 50 );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n" );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * CupiVoleibol<br>
     * darEquipos<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente cupivoleibol, cada uno de los valores corresponde al esperado.<br>
     */
    public void testCupiVoleibol( )
    {
        setupEscenario1( );

        assertNotNull( "La lista de equipos no deber�a ser nula.", cupiVoleibol.darEquipos( ) );
        assertEquals( "Deber�a tener 8 equipos.", CupiVoleibol.CANT_EQUIPOS, cupiVoleibol.darEquipos( ).length );

        // Equipo 1
        assertEquals( "El nombre del equipo 1 qued� mal inicializado.", "Deportivo Atributos", cupiVoleibol.darEquipos( )[ 0 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 1 qued� mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 0 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 1 qued� mal inicializada.", 356, cupiVoleibol.darEquipos( )[ 0 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 1 qued� mal inicializada.", "equipo1.png", cupiVoleibol.darEquipos( )[ 0 ].darImagen( ) );

        // Equipo 2
        assertEquals( "El nombre del equipo 2 qued� mal inicializado.", "M�todos Club", cupiVoleibol.darEquipos( )[ 1 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 2 qued� mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 1 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 2 qued� mal inicializada.", 213, cupiVoleibol.darEquipos( )[ 1 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 2 qued� mal inicializada.", "equipo2.png", cupiVoleibol.darEquipos( )[ 1 ].darImagen( ) );

        // Equipo 3
        assertEquals( "El nombre del equipo 3 qued� mal inicializado.", "Deportivo Recorridos", cupiVoleibol.darEquipos( )[ 2 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 3 qued� mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 2 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 3 qued� mal inicializada.", 531, cupiVoleibol.darEquipos( )[ 2 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 3 qued� mal inicializada.", "equipo3.png", cupiVoleibol.darEquipos( )[ 2 ].darImagen( ) );

        // Equipo 4
        assertEquals( "El nombre del equipo 4 qued� mal inicializado.", "Alianza Condicionales", cupiVoleibol.darEquipos( )[ 3 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 4 qued� mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 3 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 4 qued� mal inicializada.", 758, cupiVoleibol.darEquipos( )[ 3 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 4 qued� mal inicializada.", "equipo4.png", cupiVoleibol.darEquipos( )[ 3 ].darImagen( ) );

        // Equipo 5
        assertEquals( "El nombre del equipo 5 qued� mal inicializado.", "Mundo VoleiClub", cupiVoleibol.darEquipos( )[ 4 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 5 qued� mal inicializada.", Equipo.INFANTIL, cupiVoleibol.darEquipos( )[ 4 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 5 qued� mal inicializada.", 365, cupiVoleibol.darEquipos( )[ 4 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 5 qued� mal inicializada.", "equipo5.png", cupiVoleibol.darEquipos( )[ 4 ].darImagen( ) );

        // Equipo 6
        assertEquals( "El nombre del equipo 6 qued� mal inicializado.", "Interfaz VoleiClub", cupiVoleibol.darEquipos( )[ 5 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 6 qued� mal inicializada.", Equipo.INFANTIL, cupiVoleibol.darEquipos( )[ 5 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 6 qued� mal inicializada.", 324, cupiVoleibol.darEquipos( )[ 5 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 6 qued� mal inicializada.", "equipo6.png", cupiVoleibol.darEquipos( )[ 5 ].darImagen( ) );

        // Equipo 7
        assertEquals( "El nombre del equipo 7 qued� mal inicializado.", "Cupi2", cupiVoleibol.darEquipos( )[ 6 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 7 qued� mal inicializada.", Equipo.MAYORES, cupiVoleibol.darEquipos( )[ 6 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 7 qued� mal inicializada.", 1124, cupiVoleibol.darEquipos( )[ 6 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 7 qued� mal inicializada.", "equipo7.png", cupiVoleibol.darEquipos( )[ 6 ].darImagen( ) );

        // Equipo 8
        assertEquals( "El nombre del equipo 8 qued� mal inicializado.", "CupiTaller", cupiVoleibol.darEquipos( )[ 7 ].darNombre( ) );
        assertEquals( "La categor�a del equipo 8 qued� mal inicializada.", Equipo.MAYORES, cupiVoleibol.darEquipos( )[ 7 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 8 qued� mal inicializada.", 745, cupiVoleibol.darEquipos( )[ 7 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 8 qued� mal inicializada.", "equipo8.png", cupiVoleibol.darEquipos( )[ 7 ].darImagen( ) );

    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo buscarEquipo.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarEquipo<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo buscado no existe.<br>
     * 2. El equipo buscado existe.<br>
     */
    public void testBuscarEquipo( )
    {
        setupEscenario1( );
        // Caso de prueba 1
        assertNull( "El equipo no deber�a existir.", cupiVoleibol.buscarEquipo( "Equipo" ) );

        // Caso de prueba 2
        assertNotNull( "El equipo deber�a existir.", cupiVoleibol.buscarEquipo( "Cupi2" ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo buscarJugador.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. El jugador no existe.<br>
     * 2. El jugador existe.<br>
     */
    public void testBuscarJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        assertNull( "El jugador no deber�a existir.", cupiVoleibol.buscarJugador( "9876" ) );

        // Caso de prueba 2
        assertNotNull( "El jugador deber�a existir.", cupiVoleibol.buscarJugador( "1122" ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo agregarJugador.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarJugador<br>
     * buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. No existe un jugador con la c�dula dada.<br>
     * 2. Existe un jugador con la c�dula dada.<br>
     * 3. No existe un equipo con el nombre dado.<br>
     */
    public void testAgregarJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        try
        {
            assertNull( "El jugador no deber�a existir.", cupiVoleibol.buscarJugador( "9876" ) );
            assertEquals( "El equipo deber�a tener 1 jugador.", 1, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            cupiVoleibol.agregarJugador( "Cupi2", "nombre2", "9876", 1.65, 60 );
            assertEquals( "El equipo deber�a tener 2 jugadores.", 2, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            assertNotNull( "El jugador deber�a existir.", cupiVoleibol.buscarJugador( "9876" ) );
            assertEquals( "El equipo deber�a tener 2 jugadores.", 2, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );

        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n. El jugador no existe." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.agregarJugador( "M�todos Club", "nombre 7", "2211", 1.45, 85 );
            fail( "Deber�a generar excepci�n. El jugador ya existe." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
            assertEquals( "No deber�a haber agregado al jugador.", 3, cupiVoleibol.buscarEquipo( "M�todos Club" ).darJugadores( ).size( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.agregarJugador( "M�todos", "nombre 7", "2211", 1.45, 85 );
            fail( "Deber�a generar excepci�n. El equipo no existe." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
            assertEquals( "No deber�a haber agregado al jugador.", 3, cupiVoleibol.buscarEquipo( "M�todos Club" ).darJugadores( ).size( ) );
            assertEquals( "No deber�a haber agregado al jugador.", 2, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            assertEquals( "No deber�a haber agregado al jugador.", 6, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darJugadores( ).size( ) );
        }

    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo eliminarJugador.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarJugador<br>
     * buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe un jugador con la c�dula dada.<br>
     * 2. No existe un jugador con la c�dula dada.<br>
     * 3. No existe un equipo con el nombre dado.<br>
     */
    public void testEliminarJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        try
        {
            cupiVoleibol.eliminarJugador( "Deportivo Atributos", "1122" );
            assertEquals( "El equipo deber�a tener 5 jugadores.", 5, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darJugadores( ).size( ) );
            assertNull( "El jugador no deber�a existir.", cupiVoleibol.buscarJugador( "1122" ) );

            cupiVoleibol.eliminarJugador( "Cupi2", "3311" );
            assertEquals( "El equipo ya no deber�a tener jugadores.", 0, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            assertNull( "El jugador no deber�a existir.", cupiVoleibol.buscarJugador( "3311" ) );

        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.eliminarJugador( "M�todos Club", "1122" );
            fail( "Deber�a generar excepci�n. El jugador no existe" );
        }
        catch( Exception e )
        {
            assertEquals( "El equipo deber�a tener 3 jugadores.", 3, cupiVoleibol.buscarEquipo( "M�todos Club" ).darJugadores( ).size( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.eliminarJugador( "Club Deportivo", "1144" );
            fail( "Deber�a generar excepci�n. El equipo no existe" );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n
            assertEquals( "El equipo deber�a tener 5 jugadores.", 5, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darJugadores( ).size( ) );
            assertEquals( "El equipo deber�a tener 3 jugadores.", 3, cupiVoleibol.buscarEquipo( "M�todos Club" ).darJugadores( ).size( ) );
        }

    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo registrarPuntosAnotadosJugador.<br>
     * <b> M�todos a probar: </b> <br>
     * registrarPuntosAnotadosJugador<br>
     * buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe el jugador al que se le quieren agregar los puntos.<br>
     * 2. No existe el jugador al que se le quieren agregar los puntos.<br>
     * 3. No existe el equipo dado.<br>
     */
    public void testRegistrarPuntosAnotadosJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        try
        {
            cupiVoleibol.registrarPuntosAnotadosJugador( "Deportivo Atributos", "1122", 5 );
            assertEquals( "No registr� correctamente los puntos anotados.", 5, cupiVoleibol.buscarJugador( "1122" ).darPuntosAnotados( ) );

            cupiVoleibol.registrarPuntosAnotadosJugador( "M�todos Club", "2233", 6 );
            assertEquals( "No registr� correctamente los puntos anotados.", 6, cupiVoleibol.buscarJugador( "2233" ).darPuntosAnotados( ) );

        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.registrarPuntosAnotadosJugador( "Cupi2", "8891", 7 );
            fail( "Deber�a generar excepci�n. No existe el jugador." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�
        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.registrarPuntosAnotadosJugador( "Liga juvenil", "8891", 7 );
            fail( "Deber�a generar excepci�n. No existe el equipo." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�
        }
    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo asignarPatrocinador.<br>
     * <b> M�todos a probar: </b> <br>
     * registrarPatrocinador<br>
     * buscarEquipo<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe el equipo al que se quiere asignar el patrocinador y no tiene un patrocinador asignado.<br>
     * 2. Existe el equipo al que se quiere asignar el patrocinador, y tiene un patrocinador asignado.<br>
     * 3. No existe el equipo al que se quiere asignar el patrocinador.
     */
    public void testAsignarPatrocinador( )
    {
        setupEscenario1( );

        // Caso de prueba 1
        try
        {
            cupiVoleibol.asignarPatrocinador( "Cupi2", "Patrocinador", 5, 2500.0 );
            assertNotNull( "El equipo deber�a tener patrocinador.", cupiVoleibol.buscarEquipo( "Cupi2" ).darPatrocinador( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.asignarPatrocinador( "Cupi2", "Patrocinador2", 3, 5700.0 );
            fail( "Deber�a generar excepci�n. El equipo ya tiene patrocinador" );
        }
        catch( Exception e )
        {
            assertEquals( "El patrocinador del equipo no es el esperado.", "Patrocinador", cupiVoleibol.buscarEquipo( "Cupi2" ).darPatrocinador( ).darNombre( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.asignarPatrocinador( "Equipo mayor", "Patrocinador3", 4, 8700.0 );
            fail( "Ddeber�a generar excepci�n. El equipo no existe" );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo agregarAficionados.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAficionados<br>
     * buscarEquipo<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe el equipo al que se le quieren agregar los aficionados.<br>
     * 2. No existe el equipo al que se le quieren agregar los aficionados.<br>
     */
    public void testAgregarAficionados( )
    {
        setupEscenario2( );

        // Caso de prueba 1
        try
        {
            cupiVoleibol.agregarAficionados( "Deportivo Atributos", 14 );
            assertEquals( "No agreg� correctamente los aficionados.", 370, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darCantidadAficionados( ) );

            cupiVoleibol.agregarAficionados( "Cupi2", 3 );
            assertEquals( "No agreg� correctamente los aficionados.", 1127, cupiVoleibol.buscarEquipo( "Cupi2" ).darCantidadAficionados( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n. El equipo existe." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.agregarAficionados( "Trinidad", 14 );
            fail( "Deber�a generar excepci�n. El equipo no existe." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo retirarAficionados.<br>
     * <b> M�todos a probar: </b> <br>
     * retirarAficionados<br>
     * buscarEquipo<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe el equipo al que se le quieren retirar los aficionados y tiene suficientes aficionados.<br>
     * 2. Existe el equipo al que se le quieren retirar los aficionados y no tiene suficientes aficionados.<br>
     * 3. No existe el equipo al que se le quieren retirar los aficionados.
     */
    public void testRetirarAficionados( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        try
        {
            cupiVoleibol.retirarAficionados( "Deportivo Atributos", 16 );
            assertEquals( "No retir� correctamente los aficionados.", 340, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darCantidadAficionados( ) );

            cupiVoleibol.retirarAficionados( "Mundo VoleiClub", 15 );
            assertEquals( "No retir� correctamente los aficionados.", 350, cupiVoleibol.buscarEquipo( "Mundo VoleiClub" ).darCantidadAficionados( ) );

        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.retirarAficionados( "M�todos Club", 250 );
            fail( "Deber�a generar excepci�n. No hay suficientes aficionados." );
        }
        catch( Exception e )
        {
            assertEquals( "No retir� correctamente los aficionados.", 213, cupiVoleibol.buscarEquipo( "M�todos Club" ).darCantidadAficionados( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.retirarAficionados( "Club", 1 );
            fail( "Deber�a generar excepci�n. No existe el equipo." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo hayEquiposMismaCantidadAficionados.<br>
     * <b> M�todos a probar: </b> <br>
     * hayEquiposMismaCantidadAficionados<br>
     * agregarAficionados<br>
     * <b> Casos de prueba:</b><br>
     * 1. No existen equipos con la misma cantidad de aficionados.<br>
     * 2. Existen equipos con la misma cantidad de aficionados.<br>
     */
    public void testHayEquiposMismaCantidadAficionados( )
    {
        setupEscenario1( );

        // Caso de prueba 1
        assertFalse( "No deber�an existir dos equipos con la misma cantidad de aficionados.", cupiVoleibol.hayEquiposMismaCantidadAficionados( ) );
       
        // Caso de prueba 2
        try
        {
            cupiVoleibol.agregarAficionados( "Deportivo Atributos", 9 );
            assertTrue( "Deber�an existir dos equipos con la misma cantidad de aficionados.", cupiVoleibol.hayEquiposMismaCantidadAficionados( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }

    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo buscarEquipoMayorPromedioEstatura.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarEquipoMayorPromedioEstatura<br>
     * <b> Casos de prueba:</b><br>
     * 1. Los equipos no tienen jugadores.<br>
     * 2. Los equipos tienen jugadores.<br>
     */
    public void testBuscarEquipoMayorPromedioEstatura( )
    {
        // Caso de prueba 1
        setupEscenario1( );
        assertNull( "No deber�a existir un equipo con mayor promedio de estatura.", cupiVoleibol.buscarEquipoMayorPromedioEstatura( ) );

        // Caso de prueba 2
        setupEscenario2( );
        assertNotNull( "Deber�a existir un equipo con mayor promedio de estatura.", cupiVoleibol.buscarEquipoMayorPromedioEstatura( ) );
        assertEquals( "El nombre del equipo con mayor promedio no es correcto.", "Deportivo Atributos", cupiVoleibol.buscarEquipoMayorPromedioEstatura( ).darNombre( ) );
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo darCantidadEquiposConPatrocinador.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadEquiposConPatrocinador<br>
     * asignarPatrocinador<br>
     * <b> Casos de prueba:</b><br>
     * 1. Ning�n equipo tiene patrocinador.<br>
     * 2. Un equipo tiene patrocinador.<br>
     * 3. Todos los equipos tienen patrocinador <br>
     */
    public void testDarCantidadEquiposConPatrocinador( )
    {
        setupEscenario1( );
        try
        {
            // Caso de prueba 1
            assertEquals( "Ning�n equipo deber�a tener patrocinador.", 0, cupiVoleibol.darCantidadEquiposConPatrocinador( ) );

            // Caso de prueba 2
            cupiVoleibol.asignarPatrocinador( "Deportivo Atributos", "patrocinador1", 5, 2500.0 );
            assertEquals( "Un equipo deber�a tener patrocinador.", 1, cupiVoleibol.darCantidadEquiposConPatrocinador( ) );

            // Caso de prueba 3
            cupiVoleibol.asignarPatrocinador( "M�todos Club", "patrocinador2", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Deportivo Recorridos", "patrocinador4", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Alianza Condicionales", "patrocinador5", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Mundo VoleiClub", "patrocinador6", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Interfaz VoleiClub", "patrocinador7", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Cupi2", "patrocinador8", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "CupiTaller", "patrocinador3", 5, 2500.0 );
            assertEquals( "Todos los equipos deber�an tener patrocinador.", 8, cupiVoleibol.darCantidadEquiposConPatrocinador( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }

    }

    /**
     * Prueba 13: Se encarga de verificar el m�todo darCantidadEquiposCategoria.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadEquiposCategoria<br>
     * <b> Casos de prueba:</b><br>
     * 1. Hay 4 equipos que pertenecen a la categor�a juvenil, 2 que pertenecen a la categor�a infantil y 2 que pertenecen a la categor�a mayores.<br>
     */
    public void testDarCantidadEquiposCategoria( )
    {
        setupEscenario1( );
        assertEquals( "Deber�a haber 4 equipos en la categor�a juvenil.", 4, cupiVoleibol.darCantidadEquiposCategoria( Equipo.JUVENIL ) );
        assertEquals( "Deber�a haber 2 equipos en la categor�a infantil.", 2, cupiVoleibol.darCantidadEquiposCategoria( Equipo.INFANTIL ) );
        assertEquals( "Deber�a haber 2 equipos en la categor�a mayores.", 2, cupiVoleibol.darCantidadEquiposCategoria( Equipo.MAYORES ) );
    }

    /**
     * Prueba 14: Se encarga de verificar el m�todo darCantidadTotalJugadoresSobrepeso.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadTotalJugadoresSobrepeso<br>
     * <b> Casos de prueba: <b><br>
     * 1. No hay jugadores en ning�n equipo. 2. Hay jugadores en los equipos.
     */
    public void testDarCantidadTotalJugadoresSobrepeso( )
    {
        // Caso de prueba 1

        setupEscenario1( );
        assertEquals( "", 0, cupiVoleibol.darCantidadTotalJugadoresSobrepeso( ) );

        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "", 3, cupiVoleibol.darCantidadTotalJugadoresSobrepeso( ) );

    }

}
