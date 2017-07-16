import ExercicioTDD.FormatarEmPortugues;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Eugenio on 05/06/2017.
 */
public class FormatarEmPortuguesTest {
    @Test
    public void set0() { //Deve exibir zero
        FormatarEmPortugues f = new FormatarEmPortugues();
        Assert.assertEquals("zero", f.setFormatarNumero(0));
    }

    @Test
    public void naoAceitaNegativos() throws Exception{ // é para dar um aviso
        FormatarEmPortugues f = new FormatarEmPortugues();
        Assert.assertEquals("Não é permitido numeros negativos!", f.setFormatarNumero(-2));
    }

    @Test
    public void set1a20SemMulpliplosDe10() throws Exception{ //Deve exibir 1 palavra
        FormatarEmPortugues f = new FormatarEmPortugues();
        assertEquals("dezenove" , f.setFormatarNumero(19));
    }

    @Test
    public void set21a99SemMultiplosDe10() throws Exception{ //Deve exibir 3 palavras
        FormatarEmPortugues f = new FormatarEmPortugues();
        assertEquals("vinte e um", f.setFormatarNumero(21));
    }

    @Test
    public void set101a119SemMultiplosDe10() throws Exception { //Deve exibir 3 palavras
        FormatarEmPortugues f = new FormatarEmPortugues();
        assertEquals("cento e onze", f.setFormatarNumero(111));
    }

    @Test
    public void setMultiplosDe10De1a99() throws Exception { //Deve exibir 1 palavra
        FormatarEmPortugues f = new FormatarEmPortugues();
        assertEquals("cinquenta", f.setFormatarNumero(50));
    }

    @Test
    public void setMultiplosDe10De100a999() throws Exception { //Deve exibir 3 palavras
        FormatarEmPortugues f = new FormatarEmPortugues();
        assertEquals("cento e cinquenta", f.setFormatarNumero(150));
    }

    @Test
    public void setMultiplosDe100De100a999() throws Exception { //Deve exibir 1 palavra
        FormatarEmPortugues f = new FormatarEmPortugues();
        assertEquals("trezentos", f.setFormatarNumero(300));
    }

    @Test
    public void set121a999SemMultiplosDe10Ou100() throws Exception { //Deve exibir 5 palavras
        FormatarEmPortugues f = new FormatarEmPortugues();
        assertEquals("novecentos e noventa e quatro", f.setFormatarNumero(994));
    }
}
