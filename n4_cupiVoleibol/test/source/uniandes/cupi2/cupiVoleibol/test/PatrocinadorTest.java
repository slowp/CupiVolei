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

import junit.framework.TestCase;
import uniandes.cupi2.cupiVoleibol.mundo.Patrocinador;

/**
 * Clase usada para verificar que los m�todos de la clase Patrocinador est�n correctamente implementados.
 */
public class PatrocinadorTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Patrocinador patrocinador;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo patrocinador.
     */
    public void setupEscenario1( )
    {
        patrocinador = new Patrocinador( "Nombre", 5, 2500.0 );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
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
        assertEquals( "Los a�os de contrato no fue inicializado correctamente.", 5, patrocinador.darAnhosContrato( ) );
        assertEquals( "El dinero aportado no fue inicializado correctamente.", 2500.0, patrocinador.darDineroAportado( ), 0.01 );
    }
}
