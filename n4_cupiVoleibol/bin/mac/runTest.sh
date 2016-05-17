#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n4_cupiVoleibol
# Autor: Equipo Cupi2 - 03-feb-2016
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiVoleibol.jar:test/lib/junit.jar:test/lib/cupiVoleibolTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiVoleibol.test.InterfazCupiVoleibolTest
	
java -ea -classpath lib/cupiVoleibol.jar:test/lib/junit.jar:test/lib/cupiVoleibolTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiVoleibol.test.PanelImagenTest
	
java -ea -classpath lib/cupiVoleibol.jar:test/lib/junit.jar:test/lib/cupiVoleibolTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiVoleibol.test.PanelOpcionesTest
cd bin/mac

stty echo
