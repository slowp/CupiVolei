@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n4_cupiVoleibol
REM Autor: Equipo Cupi2 - 03-feb-2016
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiVoleibol.jar;test/lib/junit.jar;test/lib/cupiVoleibolTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiVoleibol.test.InterfazCupiVoleibolTest
	
java -ea -classpath lib/cupiVoleibol.jar;test/lib/junit.jar;test/lib/cupiVoleibolTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiVoleibol.test.PanelImagenTest
	
java -ea -classpath lib/cupiVoleibol.jar;test/lib/junit.jar;test/lib/cupiVoleibolTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiVoleibol.test.PanelOpcionesTest
cd bin/win