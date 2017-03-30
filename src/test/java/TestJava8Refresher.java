import org.junit.Test;

import java.text.NumberFormat;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;

public class TestJava8Refresher {

    private static final ThreadLocal<NumberFormat> nf = new ThreadLocal<NumberFormat>() {

        @Override
        protected NumberFormat initialValue() {

            final NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumIntegerDigits(2);

            return nf;
        }
    };


    @Test
    public void thing() {

         assertTrue(nf.get().format(333.22).equals("33.22"));
    }

    @Test
    public void testFunction() {

        final Function<Integer, Integer> multiply = x -> x * 2;
        assertTrue(multiply.apply(5).equals(25));
    }
}
