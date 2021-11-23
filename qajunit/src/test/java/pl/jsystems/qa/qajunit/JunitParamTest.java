package pl.jsystems.qa.qajunit;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.google.common.truth.Truth.assertThat;

@Tags({@Tag("junit"), @Tag("smoke"), @Tag("param")})
@DisplayName("Param test")
public class JunitParamTest {

    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(ints = {5,15,25})
    public void firstParamTest(int number) {
        Assert.assertEquals(number % 5, 0);
    }

    @ParameterizedTest(name = "Parameter test for string say hello")
    @ValueSource(strings = {"Hello","Hello junit","Helo students"})
    public void stringParamTest(String param) {
        assertThat(param).contains("Hello");
    }

    @DisplayName("Parameter test with multi param")
    @ParameterizedTest(name = "Parameter test: {0}, {1}")
    @CsvSource(value = {"Hello; 5","Hello, junit; 15", "Hello students; 25"}, delimiter = ';') //ozna uzyc ' do wydzielania grup ktore tez korzystaja z delimitera
    public void csvParamTest(String param, int number) {
        assertThat(param).contains("Hello");
        Assert.assertEquals(number % 5, 0);
    }

    //mozna też przygotowav plik csv
    @DisplayName("Parameter test with multi param, csv file")
    @ParameterizedTest(name = "Parameter test: {0}, {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ';')
    public void multiCsvParamTest(String param, int number) {
        assertThat(param).contains("Hello");
        Assert.assertEquals(number % 5, 0);
    }

}
