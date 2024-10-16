package calculator;

import calculator.application.CalculatorApplication;

public class Application {
    public static void main(String[] args) {
        var configuration = new Configuration();
        var calculatorApplication = new CalculatorApplication(configuration);
        calculatorApplication.run();
    }
}
