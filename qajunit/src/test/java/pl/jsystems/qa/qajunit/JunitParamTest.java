package pl.jsystems.qa.qajunit;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
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

}
