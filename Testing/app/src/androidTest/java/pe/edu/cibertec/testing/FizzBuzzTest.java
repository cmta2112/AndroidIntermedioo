package pe.edu.cibertec.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    // se realiza antes de la prueba
    // se crean los recursos necesarios para realizar la prueba
    @Before
    public void setUp() throws Exception{
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testMultiple3(){
        String result = fizzBuzz.execute(7);
        assertThat(result, is(FizzBuzz.FIZZ));  // EL RESULTADO ESPERADO
    }

    @Test
    public void testMultiple5(){
        String result = fizzBuzz.execute(10);
        assertThat(result, is(FizzBuzz.BUZZ)); // EL RESULTADO ESPERADO
    }

    public void testMultiple3and5(){
        String result  = fizzBuzz.execute(15);
        assertThat(result,is(FizzBuzz.FIZZ + FizzBuzz.BUZZ));  // EL RESULTADO ESPERADO
    }

    // Se invoca despues de las pruebas
    //Liberar los recuros creados para realizar la prueba
    @After
    public void close() throws  Exception{
        fizzBuzz = null;
    }

}
