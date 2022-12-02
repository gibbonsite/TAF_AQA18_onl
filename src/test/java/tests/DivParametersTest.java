package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivParametersTest {
    @Parameters({"firstNumber", "secondNumber"})
    @Test
    public void divParametersTest(@Optional("24") String firstNumber, @Optional("6") String secondNumber) {
        System.out.println("" + firstNumber + " divided by " + secondNumber + " is " +
                Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
    }
}
