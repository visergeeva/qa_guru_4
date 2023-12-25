package guru.qa;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void setUp() {
        System.out.println("_______setUp()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("_______beforeEach");
    }

    @Test
    void firstTest() {
        System.out.println("_______firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("_______secondTest");
    }

    @AfterEach
    void afterEach() {
        System.out.println("_______afterEach");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("_______tearDown()");
    }
}