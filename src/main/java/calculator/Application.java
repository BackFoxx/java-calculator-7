package calculator;

import calculator.application.CalculatorApplication;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        CalculatorApplication calculatorApplication = new CalculatorApplication(configuration);
        calculatorApplication.run();
    }
}
