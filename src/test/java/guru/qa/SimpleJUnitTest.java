package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleJUnitTest {

    @Test
        void assertTest() {
            Assertions.assertTrue(2 < 3);
        }
}
