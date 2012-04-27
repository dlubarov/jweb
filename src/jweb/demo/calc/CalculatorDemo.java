package jweb.demo.calc;

import java.io.IOException;

import jweb.http.Server;

public class CalculatorDemo {
    public static void main(String[] args) throws IOException {
        new Server(8000, new CalculationHandler()).run();
    }
}
