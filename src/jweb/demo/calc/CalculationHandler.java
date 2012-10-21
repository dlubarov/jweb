package jweb.demo.calc;

import java.util.Scanner;

import jweb.Logger;
import jweb.http.*;

public class CalculationHandler implements Handler {
    private static int evaluate(String exp) {
        Scanner sc = new Scanner(exp);
        int x = sc.nextInt();
        while (sc.hasNext()) {
            String op = sc.next();
            if (!op.equals("+")) {
                return -1;
            }
            x += sc.nextInt();
        }
        return x;
    }

    @Override
    public Response handle(Request req) {
        if (req.method != Method.GET)
            return null;

        String exp = req.resource.substring(1);
        Logger.info("Evaluating: %s", exp);
        int result = evaluate(exp);
        Logger.info("Result: %d.", result);
        return new Response(Integer.toString(result));
    }
}
