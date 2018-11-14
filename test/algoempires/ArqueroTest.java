package algoempires;





import algoempires.direccion.*;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

    public class ArqueroTest {



        @Test
        public void test01MuevoUnArqueroAbajo() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);

            Direccion direccion = new DireccionAbajo();

            arquero.desplazarHacia(direccion);

            assertTrue(arquero.estaEnCasillero(new Casillero(2,1)));

        }

        @Test
        public void test02MuevoUnArqueroArriba() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);

            Direccion direccion = new DireccionArriba();

            arquero.desplazarHacia(direccion);

            assertTrue(arquero.estaEnCasillero(new Casillero(2,3)));

        }

        @Test
        public void test03MuevoUnArqueroIzquierda() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);

            Direccion direccion = new DireccionIzquierda();

            arquero.desplazarHacia(direccion);

            //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
            assertTrue(arquero.estaEnCasillero(new Casillero(1, 2)));

        }

        @Test
        public void test04MuevoUnArqueroDerecha() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);

            Direccion direccion = new DireccionDerecha();

            arquero.desplazarHacia(direccion);

            assertTrue(arquero.estaEnCasillero(new Casillero(3, 2)));

        }

        @Test
        public void test05MuevoUnArqueroArribaIzquierda() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);

            Direccion direccion = new DireccionArribaIzquierda();

            arquero.desplazarHacia(direccion);

            assertTrue(arquero.estaEnCasillero(new Casillero(1, 3)));

        }

        @Test
        public void test06MuevoUnArqueroArribaDerecha() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);


            Direccion direccion = new DireccionArribaDerecha();

            arquero.desplazarHacia(direccion);

            assertTrue(arquero.estaEnCasillero(new Casillero(3, 3)));

        }

        @Test
        public void test07MuevoUnArqueroAbajoIzquierda() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);

            Direccion direccion = new DireccionAbajoIzquierda();

            arquero.desplazarHacia(direccion);

            assertTrue(arquero.estaEnCasillero(new Casillero(1, 1)));

        }

        @Test
        public void test08MuevoUnArqueroAbajoDerecha() throws CasilleroInvalidoException {

            Terreno terreno = new Terreno(10, 10);

            Casillero casillero = new Casillero(2,2);

            Arquero arquero= new Arquero(terreno, casillero);

            Direccion direccion = new DireccionAbajoDerecha();

            arquero.desplazarHacia(direccion);

            assertTrue(arquero.estaEnCasillero(new Casillero(3, 1)));

        }
    }

