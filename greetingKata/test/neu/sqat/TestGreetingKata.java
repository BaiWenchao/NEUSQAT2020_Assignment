package neu.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * trace:
 * 1. when solving 5, I change the module: get two name string to the module:
 *    get multiple name string
 * 2. when solving 6, I delete handle uppercase name, because they are
 *    "test double"
 *    I also refactor my code: I split the upper and lower
 *    and split the return string as : lowerPrefix + lower + mid + upperPrefix + upper
 * 3. when solving 7, I use preprocess, and change the method input:
 *    getUpperNames and getLowerNames
 * */

public class TestGreetingKata {

    // 1.1 single greeting: normal name
    @Test
    void test_GreetingKata_greet_singleName() {
        GreetingKata gk = new GreetingKata();
        String str = gk.greet("Bob");
        assertEquals("Hello, Bob.", str);
    }
    // 1.2 single greeting: empty name
    @Test
    void test_GreetingKata_greet_singleEmptyName() {
        GreetingKata gk = new GreetingKata();
        String str = gk.greet("");
        assertEquals("Hello, my friend.", str);
    }
    // 1.3. invalid char
    @Test
    void test_GreetingKata_greet_singleInvalidName() {
        GreetingKata gk = new GreetingKata();
        assertThrows(IllegalArgumentException.class, () -> {
            gk.greet("Bo1b");
        });
    }

    // 2.1 null greeting
    @Test
    void test_GreetingKata_greet_nullName() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet(null);
        assertEquals("Hello, my friend.", str);
    }

    // 3.1. uppercase greeting
    @Test
    void test_GreetingKata_greet_uppercaseName() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("JERRY");
        assertEquals("HELLO JERRY!", str);
    }

    // 4.1. two names greeting
    @Test
    void test_GreetingKata_greet_twoName() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Jill", "Jane");
        assertEquals("Hello, Jill and Jane.", str);
    }

    // 5.1. multiple names greeting
    @Test
    void test_GreetingKata_greet_multiName() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "Brian", "Charlotte");
        assertEquals("Hello, Amy, Brian, and Charlotte.", str);
    }

    // 6.1. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith2LowerAnd1Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "Charlotte");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", str);
    }

    // 6.2. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith2LowerAnd2Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "Charlotte", "DANIEL");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN AND DANIEL!", str);
    }

    // 6.3. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith2LowerAnd3Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "Charlotte", "DANIEL", "CURRY");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN, DANIEL, AND CURRY!", str);
    }

    // 6.4. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith1LowerAnd1Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN");
        assertEquals("Hello, Amy. AND HELLO BRIAN!", str);
    }

    // 6.5. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith1LowerAnd2Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "DANIEL");
        assertEquals("Hello, Amy. AND HELLO BRIAN AND DANIEL!", str);
    }

    // 6.6. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith1LowerAnd3Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "DANIEL", "CURRY");
        assertEquals("Hello, Amy. AND HELLO BRIAN, DANIEL, AND CURRY!", str);
    }

    // 6.7. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith3LowerAnd1Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "Charlotte", "James");
        assertEquals("Hello, Amy, Charlotte, and James. AND HELLO BRIAN!", str);
    }

    // 6.8. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith3LowerAnd2Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "Charlotte", "DANIEL", "James");
        assertEquals("Hello, Amy, Charlotte, and James. AND HELLO BRIAN AND DANIEL!", str);
    }

    // 6.9. multiple mix case names greeting
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWith3LowerAnd3Upper() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "Charlotte", "DANIEL", "CURRY", "James");
        assertEquals("Hello, Amy, Charlotte, and James. AND HELLO BRIAN, DANIEL, AND CURRY!", str);
    }

    // 7.1. multiple mix case names greeting with input with ','
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWithCommaInput() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN", "Charlotte", "DANIEL, CURRY", "James");
        assertEquals("Hello, Amy, Charlotte, and James. AND HELLO BRIAN, DANIEL, AND CURRY!", str);
    }

    // 7.2. multiple mix case names greeting with input with ','
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWithMixedCommaInput() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN, Charlotte", "DANIEL, CURRY", "James");
        assertEquals("Hello, Amy, Charlotte, and James. AND HELLO BRIAN, DANIEL, AND CURRY!", str);
    }


    // 8.1. multiple mix case names greeting with input with ','
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWithMixedCommaInputAndDoubleQuotes() {
        GreetingKata gk = new GreetingKata();

        String str = gk.greet("Amy", "BRIAN, Charlotte", "\"DANIEL, CURRY\"", "James");
        assertEquals("Hello, Amy, Charlotte, and James. AND HELLO BRIAN, DANIEL, AND CURRY!", str);
    }

    // 8.2. multiple mix case names greeting with input with ',' and illegal input
    @Test
    void test_GreetingKata_greet_multiMixCaseNameWithMixedCommaInputAndDoubleQuotesAndIllegalInput() {
        GreetingKata gk = new GreetingKata();

        assertThrows(IllegalArgumentException.class, () -> {
            gk.greet("Amy", "BRIAN, Charlotte", "\"DANIEL, CURRY\"", "Jame3s");
        });
    }



}
