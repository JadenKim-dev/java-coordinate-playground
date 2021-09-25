package line;

import line.controller.LengthCalculatorController;

public class Application {
    public static void main(String[] args) {
        LengthCalculatorController controller = LengthCalculatorController.newInstance();
        controller.calculate();
    }
}
