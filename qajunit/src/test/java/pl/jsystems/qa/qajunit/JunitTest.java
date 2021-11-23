package pl.jsystems.qa.qajunit;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;

@Tags({@Tag("junit"),@Tag("smoketests")})
public class JunitTest {

    //przykladowe uruchomienie po referencji: mvn clean test -Dtest=pl.jsystems.qa.qajunit.JunitTest#firstTest

    private static final String STRING_TESTOWY = "stringTestowy";
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    @Test
    public void firstTest() {



        Assertions.assertEquals(2+3,5);
        Assertions.assertTrue(STRING_TESTOWY.contains("st"));

    }

    @Test
    public void junitTest() {
        System.out.println(0.2 * 0.2);
        Assertions.assertNotEquals(0.2*0.2, 0.04);
        //use:
        //double result = new BigDecimal(0.2) i potem pobrac .doubleValue
    }

    @Test
    public void stringTest() {
        String simpleString = "simpleString";
        String simple = "simpleString";

        String simpleString_2 = new String("simpleString");

    }

    @Test
    public void googleTruth() {
        assertThat(STRING_TESTOWY).contains("ingT");
    }

    @Tags({@Tag("junit"),@Tag("zadanie1tag")}) //przykladowe uruchomienie po tagu: >mvn clean test -Dgroups=zadanie1tag
    @DisplayName("zadanie1")
    @Test
    public void zad1() {
        String resultString = "Wordpress powers 100% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        Assert.assertTrue(isNumeric(resultString.replace("Wordpress powers ","").replace("% of the internet","")));
        Assert.assertTrue(Integer.parseInt(resultString.replace("Wordpress powers ","").replace("% of the internet","")) >= 0);
        Assert.assertTrue(Integer.parseInt(resultString.replace("Wordpress powers ","").replace("% of the internet","")) <= 100);

        //inaczej, prosty regex na wartosc calkowita:
        Assert.assertTrue(resultString.matches("Wordpress powers \\d+% of the internet"));
    }


}
