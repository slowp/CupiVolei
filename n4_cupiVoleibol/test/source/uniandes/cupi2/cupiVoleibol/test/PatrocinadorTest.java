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
import uniandes.cupi2.cupiVoleibol.mundo.Patrocinador;

/**
 * Clase usada para verificar que los métodos de la clase Patrocinador estén correctamente implementados.
 */
public class PatrocinadorTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Patrocinador patrocinador;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo patrocinador.
     */
    public void setupEscenario1( )
    {
        patrocinador = new Patrocinador( "Nombre", 5, 2500.0 );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Patrocinador<br>
     * darNombre<br>
     * darAnhosContrato<br>
     * darDineroAportado<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente el patrocinador, cada uno de los valores corresponde al esperado.<br>
     */
    public void testPatrocinador( )
    {
        setupEscenario1( );

        assertEquals( "El nombre no fue inicializado correctamente.", "Nombre", patrocinador.darNombre( ) );
        assertEquals( "Los años de contrato no fue inicializado correctamente.", 5, patrocinador.darAnhosContrato( ) );
        assertEquals( "El dinero aportado no fue inicializado correctamente.", 2500.0, patrocinador.darDineroAportado( ), 0.01 );
    }
}
