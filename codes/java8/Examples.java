import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.prefs.Preferences;

import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

class Example {

    
    public Example()
    {
        int N = 412333;
        double K = Math.log10(N);
        K = K - Math.floor(K);
        int X = (int)Math.pow(10, K);

        System.out.println(X);
    }


    public static void main(String[] args) {
        new Example();
    }
}