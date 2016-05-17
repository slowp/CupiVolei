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
package uniandes.cupi2.cupiVoleibol.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.cupiVoleibol.mundo.CupiVoleibol;
import uniandes.cupi2.cupiVoleibol.mundo.Equipo;
import uniandes.cupi2.cupiVoleibol.mundo.Jugador;

/**
 * Clase usada para verificar que los métodos de la clase CupiVoleibol estén correctamente implementados.
 */
public class CupiVoleibolTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private CupiVoleibol cupiVoleibol;

    // -------------------------------------------------------------
    // Métodos
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

            cupiVoleibol.agregarJugador( "Métodos Club", "nombre 1", "2211", 1.65, 82 );
            cupiVoleibol.agregarJugador( "Métodos Club", "nombre 2", "2222", 1.75, 70 );
            cupiVoleibol.agregarJugador( "Métodos Club", "nombre 3", "2233", 1.77, 100 );

            cupiVoleibol.agregarJugador( "Cupi2", "nombre 1", "3311", 1.67, 50 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción" );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * CupiVoleibol<br>
     * darEquipos<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente cupivoleibol, cada uno de los valores corresponde al esperado.<br>
     */
    public void testCupiVoleibol( )
    {
        setupEscenario1( );

        assertNotNull( "La lista de equipos no debería ser nula.", cupiVoleibol.darEquipos( ) );
        assertEquals( "Debería tener 8 equipos.", CupiVoleibol.CANT_EQUIPOS, cupiVoleibol.darEquipos( ).length );

        // Equipo 1
        assertEquals( "El nombre del equipo 1 quedó mal inicializado.", "Deportivo Atributos", cupiVoleibol.darEquipos( )[ 0 ].darNombre( ) );
        assertEquals( "La categoría del equipo 1 quedó mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 0 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 1 quedó mal inicializada.", 356, cupiVoleibol.darEquipos( )[ 0 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 1 quedó mal inicializada.", "equipo1.png", cupiVoleibol.darEquipos( )[ 0 ].darImagen( ) );

        // Equipo 2
        assertEquals( "El nombre del equipo 2 quedó mal inicializado.", "Métodos Club", cupiVoleibol.darEquipos( )[ 1 ].darNombre( ) );
        assertEquals( "La categoría del equipo 2 quedó mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 1 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 2 quedó mal inicializada.", 213, cupiVoleibol.darEquipos( )[ 1 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 2 quedó mal inicializada.", "equipo2.png", cupiVoleibol.darEquipos( )[ 1 ].darImagen( ) );

        // Equipo 3
        assertEquals( "El nombre del equipo 3 quedó mal inicializado.", "Deportivo Recorridos", cupiVoleibol.darEquipos( )[ 2 ].darNombre( ) );
        assertEquals( "La categoría del equipo 3 quedó mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 2 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 3 quedó mal inicializada.", 531, cupiVoleibol.darEquipos( )[ 2 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 3 quedó mal inicializada.", "equipo3.png", cupiVoleibol.darEquipos( )[ 2 ].darImagen( ) );

        // Equipo 4
        assertEquals( "El nombre del equipo 4 quedó mal inicializado.", "Alianza Condicionales", cupiVoleibol.darEquipos( )[ 3 ].darNombre( ) );
        assertEquals( "La categoría del equipo 4 quedó mal inicializada.", Equipo.JUVENIL, cupiVoleibol.darEquipos( )[ 3 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 4 quedó mal inicializada.", 758, cupiVoleibol.darEquipos( )[ 3 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 4 quedó mal inicializada.", "equipo4.png", cupiVoleibol.darEquipos( )[ 3 ].darImagen( ) );

        // Equipo 5
        assertEquals( "El nombre del equipo 5 quedó mal inicializado.", "Mundo VoleiClub", cupiVoleibol.darEquipos( )[ 4 ].darNombre( ) );
        assertEquals( "La categoría del equipo 5 quedó mal inicializada.", Equipo.INFANTIL, cupiVoleibol.darEquipos( )[ 4 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 5 quedó mal inicializada.", 365, cupiVoleibol.darEquipos( )[ 4 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 5 quedó mal inicializada.", "equipo5.png", cupiVoleibol.darEquipos( )[ 4 ].darImagen( ) );

        // Equipo 6
        assertEquals( "El nombre del equipo 6 quedó mal inicializado.", "Interfaz VoleiClub", cupiVoleibol.darEquipos( )[ 5 ].darNombre( ) );
        assertEquals( "La categoría del equipo 6 quedó mal inicializada.", Equipo.INFANTIL, cupiVoleibol.darEquipos( )[ 5 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 6 quedó mal inicializada.", 324, cupiVoleibol.darEquipos( )[ 5 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 6 quedó mal inicializada.", "equipo6.png", cupiVoleibol.darEquipos( )[ 5 ].darImagen( ) );

        // Equipo 7
        assertEquals( "El nombre del equipo 7 quedó mal inicializado.", "Cupi2", cupiVoleibol.darEquipos( )[ 6 ].darNombre( ) );
        assertEquals( "La categoría del equipo 7 quedó mal inicializada.", Equipo.MAYORES, cupiVoleibol.darEquipos( )[ 6 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 7 quedó mal inicializada.", 1124, cupiVoleibol.darEquipos( )[ 6 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 7 quedó mal inicializada.", "equipo7.png", cupiVoleibol.darEquipos( )[ 6 ].darImagen( ) );

        // Equipo 8
        assertEquals( "El nombre del equipo 8 quedó mal inicializado.", "CupiTaller", cupiVoleibol.darEquipos( )[ 7 ].darNombre( ) );
        assertEquals( "La categoría del equipo 8 quedó mal inicializada.", Equipo.MAYORES, cupiVoleibol.darEquipos( )[ 7 ].darCategoria( ) );
        assertEquals( "La cantidad de aficionados del equipo 8 quedó mal inicializada.", 745, cupiVoleibol.darEquipos( )[ 7 ].darCantidadAficionados( ) );
        assertEquals( "La imagen del equipo 8 quedó mal inicializada.", "equipo8.png", cupiVoleibol.darEquipos( )[ 7 ].darImagen( ) );

    }

    /**
     * Prueba 2: Se encarga de verificar el método buscarEquipo.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarEquipo<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo buscado no existe.<br>
     * 2. El equipo buscado existe.<br>
     */
    public void testBuscarEquipo( )
    {
        setupEscenario1( );
        // Caso de prueba 1
        assertNull( "El equipo no debería existir.", cupiVoleibol.buscarEquipo( "Equipo" ) );

        // Caso de prueba 2
        assertNotNull( "El equipo debería existir.", cupiVoleibol.buscarEquipo( "Cupi2" ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método buscarJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. El jugador no existe.<br>
     * 2. El jugador existe.<br>
     */
    public void testBuscarJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        assertNull( "El jugador no debería existir.", cupiVoleibol.buscarJugador( "9876" ) );

        // Caso de prueba 2
        assertNotNull( "El jugador debería existir.", cupiVoleibol.buscarJugador( "1122" ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método agregarJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarJugador<br>
     * buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. No existe un jugador con la cédula dada.<br>
     * 2. Existe un jugador con la cédula dada.<br>
     * 3. No existe un equipo con el nombre dado.<br>
     */
    public void testAgregarJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        try
        {
            assertNull( "El jugador no debería existir.", cupiVoleibol.buscarJugador( "9876" ) );
            assertEquals( "El equipo debería tener 1 jugador.", 1, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            cupiVoleibol.agregarJugador( "Cupi2", "nombre2", "9876", 1.65, 60 );
            assertEquals( "El equipo debería tener 2 jugadores.", 2, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            assertNotNull( "El jugador debería existir.", cupiVoleibol.buscarJugador( "9876" ) );
            assertEquals( "El equipo debería tener 2 jugadores.", 2, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción. El jugador no existe." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.agregarJugador( "Métodos Club", "nombre 7", "2211", 1.45, 85 );
            fail( "Debería generar excepción. El jugador ya existe." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
            assertEquals( "No debería haber agregado al jugador.", 3, cupiVoleibol.buscarEquipo( "Métodos Club" ).darJugadores( ).size( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.agregarJugador( "Métodos", "nombre 7", "2211", 1.45, 85 );
            fail( "Debería generar excepción. El equipo no existe." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
            assertEquals( "No debería haber agregado al jugador.", 3, cupiVoleibol.buscarEquipo( "Métodos Club" ).darJugadores( ).size( ) );
            assertEquals( "No debería haber agregado al jugador.", 2, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            assertEquals( "No debería haber agregado al jugador.", 6, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darJugadores( ).size( ) );
        }

    }

    /**
     * Prueba 5: Se encarga de verificar el método eliminarJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarJugador<br>
     * buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe un jugador con la cédula dada.<br>
     * 2. No existe un jugador con la cédula dada.<br>
     * 3. No existe un equipo con el nombre dado.<br>
     */
    public void testEliminarJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        try
        {
            cupiVoleibol.eliminarJugador( "Deportivo Atributos", "1122" );
            assertEquals( "El equipo debería tener 5 jugadores.", 5, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darJugadores( ).size( ) );
            assertNull( "El jugador no debería existir.", cupiVoleibol.buscarJugador( "1122" ) );

            cupiVoleibol.eliminarJugador( "Cupi2", "3311" );
            assertEquals( "El equipo ya no debería tener jugadores.", 0, cupiVoleibol.buscarEquipo( "Cupi2" ).darJugadores( ).size( ) );
            assertNull( "El jugador no debería existir.", cupiVoleibol.buscarJugador( "3311" ) );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.eliminarJugador( "Métodos Club", "1122" );
            fail( "Debería generar excepción. El jugador no existe" );
        }
        catch( Exception e )
        {
            assertEquals( "El equipo debería tener 3 jugadores.", 3, cupiVoleibol.buscarEquipo( "Métodos Club" ).darJugadores( ).size( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.eliminarJugador( "Club Deportivo", "1144" );
            fail( "Debería generar excepción. El equipo no existe" );
        }
        catch( Exception e )
        {
            // Debería generar excepción
            assertEquals( "El equipo debería tener 5 jugadores.", 5, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darJugadores( ).size( ) );
            assertEquals( "El equipo debería tener 3 jugadores.", 3, cupiVoleibol.buscarEquipo( "Métodos Club" ).darJugadores( ).size( ) );
        }

    }

    /**
     * Prueba 6: Se encarga de verificar el método registrarPuntosAnotadosJugador.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "No registró correctamente los puntos anotados.", 5, cupiVoleibol.buscarJugador( "1122" ).darPuntosAnotados( ) );

            cupiVoleibol.registrarPuntosAnotadosJugador( "Métodos Club", "2233", 6 );
            assertEquals( "No registró correctamente los puntos anotados.", 6, cupiVoleibol.buscarJugador( "2233" ).darPuntosAnotados( ) );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.registrarPuntosAnotadosJugador( "Cupi2", "8891", 7 );
            fail( "Debería generar excepción. No existe el jugador." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí
        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.registrarPuntosAnotadosJugador( "Liga juvenil", "8891", 7 );
            fail( "Debería generar excepción. No existe el equipo." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí
        }
    }

    /**
     * Prueba 7: Se encarga de verificar el método asignarPatrocinador.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertNotNull( "El equipo debería tener patrocinador.", cupiVoleibol.buscarEquipo( "Cupi2" ).darPatrocinador( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.asignarPatrocinador( "Cupi2", "Patrocinador2", 3, 5700.0 );
            fail( "Debería generar excepción. El equipo ya tiene patrocinador" );
        }
        catch( Exception e )
        {
            assertEquals( "El patrocinador del equipo no es el esperado.", "Patrocinador", cupiVoleibol.buscarEquipo( "Cupi2" ).darPatrocinador( ).darNombre( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.asignarPatrocinador( "Equipo mayor", "Patrocinador3", 4, 8700.0 );
            fail( "Ddebería generar excepción. El equipo no existe" );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el método agregarAficionados.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "No agregó correctamente los aficionados.", 370, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darCantidadAficionados( ) );

            cupiVoleibol.agregarAficionados( "Cupi2", 3 );
            assertEquals( "No agregó correctamente los aficionados.", 1127, cupiVoleibol.buscarEquipo( "Cupi2" ).darCantidadAficionados( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción. El equipo existe." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.agregarAficionados( "Trinidad", 14 );
            fail( "Debería generar excepción. El equipo no existe." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método retirarAficionados.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "No retiró correctamente los aficionados.", 340, cupiVoleibol.buscarEquipo( "Deportivo Atributos" ).darCantidadAficionados( ) );

            cupiVoleibol.retirarAficionados( "Mundo VoleiClub", 15 );
            assertEquals( "No retiró correctamente los aficionados.", 350, cupiVoleibol.buscarEquipo( "Mundo VoleiClub" ).darCantidadAficionados( ) );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

        // Caso de prueba 2
        try
        {
            cupiVoleibol.retirarAficionados( "Métodos Club", 250 );
            fail( "Debería generar excepción. No hay suficientes aficionados." );
        }
        catch( Exception e )
        {
            assertEquals( "No retiró correctamente los aficionados.", 213, cupiVoleibol.buscarEquipo( "Métodos Club" ).darCantidadAficionados( ) );

        }

        // Caso de prueba 3
        try
        {
            cupiVoleibol.retirarAficionados( "Club", 1 );
            fail( "Debería generar excepción. No existe el equipo." );
        }
        catch( Exception e )
        {
            // Debería generar excepción
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el método hayEquiposMismaCantidadAficionados.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertFalse( "No deberían existir dos equipos con la misma cantidad de aficionados.", cupiVoleibol.hayEquiposMismaCantidadAficionados( ) );
       
        // Caso de prueba 2
        try
        {
            cupiVoleibol.agregarAficionados( "Deportivo Atributos", 9 );
            assertTrue( "Deberían existir dos equipos con la misma cantidad de aficionados.", cupiVoleibol.hayEquiposMismaCantidadAficionados( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

    }

    /**
     * Prueba 11: Se encarga de verificar el método buscarEquipoMayorPromedioEstatura.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarEquipoMayorPromedioEstatura<br>
     * <b> Casos de prueba:</b><br>
     * 1. Los equipos no tienen jugadores.<br>
     * 2. Los equipos tienen jugadores.<br>
     */
    public void testBuscarEquipoMayorPromedioEstatura( )
    {
        // Caso de prueba 1
        setupEscenario1( );
        assertNull( "No debería existir un equipo con mayor promedio de estatura.", cupiVoleibol.buscarEquipoMayorPromedioEstatura( ) );

        // Caso de prueba 2
        setupEscenario2( );
        assertNotNull( "Debería existir un equipo con mayor promedio de estatura.", cupiVoleibol.buscarEquipoMayorPromedioEstatura( ) );
        assertEquals( "El nombre del equipo con mayor promedio no es correcto.", "Deportivo Atributos", cupiVoleibol.buscarEquipoMayorPromedioEstatura( ).darNombre( ) );
    }

    /**
     * Prueba 12: Se encarga de verificar el método darCantidadEquiposConPatrocinador.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadEquiposConPatrocinador<br>
     * asignarPatrocinador<br>
     * <b> Casos de prueba:</b><br>
     * 1. Ningún equipo tiene patrocinador.<br>
     * 2. Un equipo tiene patrocinador.<br>
     * 3. Todos los equipos tienen patrocinador <br>
     */
    public void testDarCantidadEquiposConPatrocinador( )
    {
        setupEscenario1( );
        try
        {
            // Caso de prueba 1
            assertEquals( "Ningún equipo debería tener patrocinador.", 0, cupiVoleibol.darCantidadEquiposConPatrocinador( ) );

            // Caso de prueba 2
            cupiVoleibol.asignarPatrocinador( "Deportivo Atributos", "patrocinador1", 5, 2500.0 );
            assertEquals( "Un equipo debería tener patrocinador.", 1, cupiVoleibol.darCantidadEquiposConPatrocinador( ) );

            // Caso de prueba 3
            cupiVoleibol.asignarPatrocinador( "Métodos Club", "patrocinador2", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Deportivo Recorridos", "patrocinador4", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Alianza Condicionales", "patrocinador5", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Mundo VoleiClub", "patrocinador6", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Interfaz VoleiClub", "patrocinador7", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "Cupi2", "patrocinador8", 5, 2500.0 );
            cupiVoleibol.asignarPatrocinador( "CupiTaller", "patrocinador3", 5, 2500.0 );
            assertEquals( "Todos los equipos deberían tener patrocinador.", 8, cupiVoleibol.darCantidadEquiposConPatrocinador( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

    }

    /**
     * Prueba 13: Se encarga de verificar el método darCantidadEquiposCategoria.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadEquiposCategoria<br>
     * <b> Casos de prueba:</b><br>
     * 1. Hay 4 equipos que pertenecen a la categoría juvenil, 2 que pertenecen a la categoría infantil y 2 que pertenecen a la categoría mayores.<br>
     */
    public void testDarCantidadEquiposCategoria( )
    {
        setupEscenario1( );
        assertEquals( "Debería haber 4 equipos en la categoría juvenil.", 4, cupiVoleibol.darCantidadEquiposCategoria( Equipo.JUVENIL ) );
        assertEquals( "Debería haber 2 equipos en la categoría infantil.", 2, cupiVoleibol.darCantidadEquiposCategoria( Equipo.INFANTIL ) );
        assertEquals( "Debería haber 2 equipos en la categoría mayores.", 2, cupiVoleibol.darCantidadEquiposCategoria( Equipo.MAYORES ) );
    }

    /**
     * Prueba 14: Se encarga de verificar el método darCantidadTotalJugadoresSobrepeso.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadTotalJugadoresSobrepeso<br>
     * <b> Casos de prueba: <b><br>
     * 1. No hay jugadores en ningún equipo. 2. Hay jugadores en los equipos.
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
