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

import junit.framework.TestCase;
import uniandes.cupi2.cupiVoleibol.mundo.Jugador;

/**
 * Clase usada para verificar que los métodos de la clase Equipo estén correctamente implementados.
 */
public class JugadorTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Jugador jugador;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo jugador.
     */
    public void setupEscenario1( )
    {
        try
        {
            jugador = new Jugador( "Nombre", "1234", 185, 80.5 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Jugador<br>
     * darNombre<br>
     * darCedula<br>
     * darEstatura<br>
     * darPuntosAnotados<br>
     * darPeso<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente el jugador, cada uno de los valores corresponde al esperado.<br>
     */
    public void testJugadorOk( )
    {
        setupEscenario1( );

        assertEquals( "El nombre no fue inicializado correctamente.", "Nombre", jugador.darNombre( ) );
        assertEquals( "La cédula fue inicializada correctamente.", "1234", jugador.darCedula( ) );
        assertEquals( "La estatura no fue inicializada correctamente.", 185, jugador.darEstatura( ), 0.1 );
        assertEquals( "Los puntos anotados no fueron inicializados correctamente.", 0, jugador.darPuntosAnotados( ) );
        assertEquals( "El peso no fue inicializado correctamente.", 80.5, jugador.darPeso( ) );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Jugador<br>
     * <b> Casos de prueba:</b><br>
     * 1. El peso del jugador es negativo.<br>
     */
    public void testJugadorError( )
    {
        try
        {
            jugador = new Jugador( "Nombre", "1234", 1.86, -4 );
            fail( "Debería generar excepción." );
        }
        catch( Exception e )
        {
            assertNull("No debería haber creado al jugador.", jugador);
        }
    }

    /**
     * Prueba 2: Se encarga de verificar el método registrarPuntosAnotados.<br>
     * <b> Métodos a probar: </b> <br>
     * registrarPuntosAnotados<br>
     * darPuntosAnotados<br>
     * <b> Casos de prueba:</b><br>
     * 1. El jugador no tiene puntos anotados.<br>
     * 2. El jugador ya tiene puntos anotados.<br>
     */
    public void testRegistrarPuntosAnotados( )
    {
        setupEscenario1( );

        // 1
        assertEquals( "El jugador no debería tener puntos anotados.", 0, jugador.darPuntosAnotados( ) );
        jugador.registrarPuntosAnotados( 5 );
        assertEquals( "Los puntos anotados no corresponden.", 5, jugador.darPuntosAnotados( ) );

        // 2
        jugador.registrarPuntosAnotados( 15 );
        assertEquals( "Los puntos anotados no corresponden.", 20, jugador.darPuntosAnotados( ) );
        
        jugador.registrarPuntosAnotados( 5 );
        assertEquals( "Los puntos anotados no corresponden.", 25, jugador.darPuntosAnotados( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método toString de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * toString<br>
     * <b> Casos de prueba:</b><br>
     * 1. El mensaje de toString corresponde a nombre(cédula).<br>
     */
    public void testToString( )
    {
        setupEscenario1( );

        assertEquals( "El toString no retorna el valor esperado.", "Nombre(1234)", jugador.toString( ) );
    }
}
