package tests.api;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MatchersTest {

    @Test
    public void twoStringsTest() {
        String a = "foo";
        String b = "foo";

        assertThat(a, equalTo(b));
        assertThat(a, equalToIgnoringCase(b));
        assertThat(a, equalToCompressingWhiteSpace(b));
    }

    @Test
    public void givenCollection_whenEmpty_thenCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void givenAList_whenChecksSize_thenCorrect() {
        List<String> hamcrestMatchers = Arrays.asList(
                "collections", "beans", "text", "number");

        assertThat(hamcrestMatchers, hasSize(4));
    }

    @Test
    public void givenArray_whenChecksSize_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers, arrayWithSize(4));
    }

    @Test
    public void givenAListAndValues_whenChecksListForGivenValues_thenCorrect() {
        List<String> hamcrestMatchers = Arrays.asList(
                "collections", "beans", "text", "number");
        assertThat(hamcrestMatchers,
                containsInAnyOrder("beans", "text", "collections", "number"));
    }

    @Test
    public void givenAListAndValues_whenChecksListForGivenValuesWithOrder_thenCorrect() {
        List<String> hamcrestMatchers = Arrays.asList(
                "collections", "beans", "text", "number");
        assertThat(hamcrestMatchers,
                contains("collections", "beans", "text", "number"));
    }

    @Test
    public void givenArrayAndValue_whenValueFoundInArray_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers, hasItemInArray("text"));
    }
}
