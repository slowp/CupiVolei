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
import uniandes.cupi2.cupiVoleibol.mundo.Equipo;
import uniandes.cupi2.cupiVoleibol.mundo.Jugador;

/**
 * Clase usada para verificar que los métodos de la clase Equipo estén correctamente implementados.
 */
public class EquipoTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Equipo equipo;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo equipo.
     */
    public void setupEscenario1( )
    {
        equipo = new Equipo( "Nombre", Equipo.INFANTIL, 150, "imagen" );
    }

    /**
     * Escenario 1: Crea un nuevo equipo con jugadores.
     */
    public void setupEscenario2( )
    {
        equipo = new Equipo( "Nombre", Equipo.INFANTIL, 150, "imagen" );
        try
        {
            equipo.agregarJugador( "nombre1", "123", 1.57, 53 );
            equipo.agregarJugador( "nombre2", "456", 1.85, 105 );
            equipo.agregarJugador( "nombre3", "789", 1.75, 90 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * - Equipo<br>
     * - darNombre<br>
     * - darCategoria<br>
     * - darJugadores<br>
     * - darCantidadAficionados<br>
     * - darImagen<br>
     * - darPatrocinador<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente el equipo, cada uno de los valores corresponde al esperado.<br>
     */
    public void testEquipo( )
    {
        setupEscenario1( );

        assertEquals( "El nombre no fue inicializado correctamente.", "Nombre", equipo.darNombre( ) );
        assertEquals( "La categoría no fue inicializada correctamente.", Equipo.INFANTIL, equipo.darCategoria( ) );
        assertNotNull( "La lista de jugadores no fue inicializada.", equipo.darJugadores( ) );
        assertEquals( "La lista de jugadores no fue inicializada correctamente.", 0, equipo.darJugadores( ).size( ) );
        assertEquals( "La cantidad de aficionados no fue inicializada correctamente.", 150, equipo.darCantidadAficionados( ) );
        assertEquals( "La imagen no fue inicializada correctamente.", "imagen", equipo.darImagen( ) );
        assertNull( "El patrocinador debería ser nulo.", equipo.darPatrocinador( ) );

    }

    /**
     * Prueba 2: Se encarga de verificar el método buscarJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * - buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo no tiene jugadores.<br>
     * 2. El equipo tiene jugadores y el jugador buscado no existe.<br>
     * 3. El equipo tiene jugadores y el jugador buscado existe.<br>
     */
    public void testBuscarJugador( )
    {
        // Caso de prueba 1
        setupEscenario1( );
        assertNull( "El jugador buscado no existe.", equipo.buscarJugador( "nombre" ) );

        // Caso de prueba 2
        setupEscenario2( );
        assertNull( "El jugador buscado no existe.", equipo.buscarJugador( "nombre" ) );

        // Caso de prueba 3
        assertNotNull( "El jugador buscado no existe.", equipo.buscarJugador( "123" ) );
        assertEquals( "El nombre del jugador no corresponde.", "nombre1", equipo.buscarJugador( "123" ).darNombre( ) );
        assertEquals( "La cédula del jugador no corresponde.", "123", equipo.buscarJugador( "123" ).darCedula( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método asignarPatrocinador.<br>
     * <b> Métodos a probar: </b> <br>
     * - asignarPatrocinador<br>
     * - darPatrocinador<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo no tiene patrocinador.<br>
     * 2. El equipo tiene patrocinador.<br>
     */
    public void testAsignarPatrocinador( )
    {
        setupEscenario1( );
        // Caso de prueba 1
        try
        {
            assertNull( "El patrocinador debería ser nulo.", equipo.darPatrocinador( ) );
            equipo.asignarPatrocinador( "patrocinador", 5, 2500.0 );
            assertNotNull( "El equipo debería tener patrocinador.", equipo.darPatrocinador( ) );
            assertEquals( "El nombre del patrocinador no es correcto.", "patrocinador", equipo.darPatrocinador( ).darNombre( ) );
            assertEquals( "El nombre del patrocinador no es correcto.", 5, equipo.darPatrocinador( ).darAnhosContrato( ) );
            assertEquals( "El nombre del patrocinador no es correcto.", 2500.0, equipo.darPatrocinador( ).darDineroAportado( ), 0.1 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción. El equipo no tiene patrocinador" );
        }

        try
        {
            equipo.asignarPatrocinador( "Patrocinador 2", 4, 3500.0 );
            fail( "Debería generar excepción. El equipo ya tiene patrocinador" );

        }
        catch( Exception e )
        {
            // Debe pasar por aquí.
        }

    }

    /**
     * Prueba 4: Se encarga de verificar el método agregarAficionados.<br>
     * <b> Métodos a probar: </b> <br>
     * - agregarAficionados<br>
     * - darCantidadAficionados<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo tiene los aficionados del inicio.<br>
     * 2. El equipo tiene más aficionados.<br>
     */
    public void testAgregarAficionados( )
    {
        // Caso de prueba 1
        setupEscenario1( );
        assertEquals( "La cantidad de aficionados no fue inicializada correctamente.", 150, equipo.darCantidadAficionados( ) );

        // Caso de prueba 2
        equipo.agregarAficionados( 75 );
        assertEquals( "La cantidad de aficionados no es correcta.", 225, equipo.darCantidadAficionados( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método agregarJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * - agregarJugador<br>
     * - buscarJugador<br>
     * - darJugadores<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo no tiene jugadores.<br>
     * 2. El equipo ya tiene jugadores.<br>
     * 4. El peso del jugador a agregar es menor a cero.<br>
     */
    public void testAgregarJugador( )
    {
        setupEscenario1( );

        // Caso de prueba 1
        try
        {
            equipo.agregarJugador( "nombre", "987", 1.65, 60 );
            assertEquals( "El equipo debería tener 1 jugador.", 1, equipo.darJugadores( ).size( ) );
            Jugador jugador = ( Jugador )equipo.darJugadores( ).get( 0 );
            assertEquals( "El nombre del jugador no corresponde.", "nombre", jugador.darNombre( ) );
            assertEquals( "La cédula del jugador no corresponde.", "987", jugador.darCedula( ) );
            assertEquals( "La estatura del jugador no corresponde.", 1.65, jugador.darEstatura( ), 0.1 );
            assertEquals( "El peso del jugador no corresponde", 60, jugador.darPeso( ), 0.1 );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

        // Caso de prueba 2
        try
        {
            equipo.agregarJugador( "nombre2", "988", 1.75, 75 );
            assertEquals( "El equipo debería tener 2 jugadores.", 2, equipo.darJugadores( ).size( ) );
            Jugador jugador = ( Jugador )equipo.darJugadores( ).get( 1 );
            assertEquals( "El nombre del jugador no corresponde.", "nombre2", jugador.darNombre( ) );
            assertEquals( "La cédula del jugador no corresponde.", "988", jugador.darCedula( ) );
            assertEquals( "La estatura del jugador no corresponde.", 1.75, jugador.darEstatura( ), 0.1 );
            assertEquals( "El peso del jugador no corresponde", 75, jugador.darPeso( ), 0.1 );

            equipo.agregarJugador( "nombre3", "1988", 1.85, 72 );
            assertEquals( "El equipo debería tener 3 jugadores.", 3, equipo.darJugadores( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

        // Caso de prueba 3
        try
        {
            equipo.agregarJugador( "nombre4", "1987", 1.95, -92 );
            fail( "Debería generarExcepción" );
        }
        catch( Exception e )
        {
            assertEquals( "El equipo debería tener 4 jugadores.", 4, equipo.darJugadores( ).size( ) );
            Jugador jugador = ( Jugador )equipo.darJugadores( ).get( 3 );
            assertEquals( "El nombre del jugador no corresponde.", "nombre4", jugador.darNombre( ) );
            assertEquals( "La cédula del jugador no corresponde.", "1987", jugador.darCedula( ) );
            assertEquals( "La estatura del jugador no corresponde.", 1.95, jugador.darEstatura( ), 0.1 );
            assertEquals( "El peso del jugador no corresponde", 92, jugador.darPeso( ), 0.1 );
        }
    }
    /**
     * Prueba 6: Se encarga de verificar el método retirarAficionados.<br>
     * <b> Métodos a probar: </b> <br>
     * - retirarAficionados<br>
     * - darCantidadAficionados<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo tiene suficientes aficionados para retirar.<br>
     * 2. El equipo no tiene suficientes aficionados para retirar.<br>
     */
    public void testRetirarAficionados( )
    {
        // Caso de prueba 1
        setupEscenario1( );
        try
        {
            assertEquals( "La cantidad de aficionados no fue inicializada correctamente.", 150, equipo.darCantidadAficionados( ) );
            equipo.retirarAficionados( 75 );
            assertEquals( "La cantidad de aficionados no es correcta.", 75, equipo.darCantidadAficionados( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

        // Caso de prueba 2
        try
        {
            equipo.retirarAficionados( 85 );
            fail( "Debería generar excepción." );

        }
        catch( Exception e )
        {
            assertEquals( "La cantidad de aficionados no es correcta. No debería haber retirado los aficionados", 75, equipo.darCantidadAficionados( ) );

        }

    }

    /**
     * Prueba 7: Se encarga de verificar el método eliminadorJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * - eliminarJugador<br>
     * - buscarJugador<br>
     * - darJugadores<br>
     * <b> Casos de prueba:</b><br>
     * 2. El jugador a eliminar no existe 1. El jugador a eliminar existe.<br>
     */
    public void testEliminarJugador( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        try
        {
            equipo.eliminarJugador( "572" );
            fail( "Debería generar excepción. El jugador con la cédula dada no existe" );

        }
        catch( Exception e )
        {
            assertEquals( "El equipo debería tener 3 jugadores.", 3, equipo.darJugadores( ).size( ) );
        }

        // Caso de prueba 2
        try
        {
            equipo.eliminarJugador( "123" );
            assertEquals( "El equipo debería tener 2 jugadores.", 2, equipo.darJugadores( ).size( ) );
            assertNull( "El jugador no debería existir.", equipo.buscarJugador( "123" ) );

            equipo.eliminarJugador( "456" );
            assertEquals( "El equipo debería tener 1 jugador.", 1, equipo.darJugadores( ).size( ) );
            assertNull( "El jugador no debería existir.", equipo.buscarJugador( "456" ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar error:" + e.getMessage( ) );
        }

    }
    /**
     * Prueba 8: Se encarga de verificar el método calcularPromedioEstatura.<br>
     * <b> Métodos a probar: </b> <br>
     * - calcularPromedioEstatura<br>
     * <b> Casos de prueba:</b><br>
     * 1. El equipo no tiene jugadores.<br>
     * 2. El equipo tiene 3 jugadores.<br>
     */
    public void testCalcularPromedioEstatura( )
    {
        // Caso de prueba 1
        setupEscenario1( );
        assertEquals( "El promedio cuando no hay jugadores debería ser -1.", -1, equipo.calcularPromedioEstatura( ), 0.1 );

        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "El promedio de estatura debería ser 1.7.", 1.7, equipo.calcularPromedioEstatura( ), 0.1 );

    }

    /**
     * Prueba 9: Se encarga de verificar el método registrarPuntosAnotadosJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * - registrarPuntosAnotadosJugador<br>
     * - buscarJugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. El jugador con la cédula dada existe.<br>
     * 2. El jugador con la cédula dada no existe.<br>
     */
    public void testRegistrarPuntosAnotadosJugador( )
    {
        setupEscenario2( );

        // Caso de prueba 1
        try
        {
            equipo.registrarPuntosAnotadosJugador( "123", 17 );
            assertEquals( "Los puntos anotados no fueron registrados correctamente.", 17, equipo.buscarJugador( "123" ).darPuntosAnotados( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción: " + e.getMessage( ) );
        }

        // Caso de prueba 2
        try
        {
            equipo.registrarPuntosAnotadosJugador( "579", 13 );
            fail( "Debería generar excepción. El jugador no existe." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }
    }

    /**
     * Prueba: Se encarga de verificar el método darCantidadJugadoresSobrepeso<br>
     * <b> Métodos a probar: </b><br>
     * - darCantidadJugadoresSobrepeso<br>
     * - agregarJugador<br>
     * <b> Casos de prueba: </b><br>
     * 1. Se calcula la cantidad de jugadores con sobrepeso sin inconvenientes.
     */
    public void testDarCantidadJugadoresSobrepeso( )
    {
        setupEscenario2( );
        try
        {
            assertEquals( "La cantidad de jugadores con sobrepeso no es la esperada", 2, equipo.darCantidadJugadoresSobrepeso( ) );

            equipo.agregarJugador( "Jugador 4", "513", 1.63, 52 );
            assertEquals( "La cantidad de jugadores con sobrepeso no es la esperada", 2, equipo.darCantidadJugadoresSobrepeso( ) );

            equipo.agregarJugador( "Jugador 5", "413", 1.65, 82 );
            assertEquals( "La cantidad de jugadores con sobrepeso no es la esperada", 3, equipo.darCantidadJugadoresSobrepeso( ) );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }

    }
}
