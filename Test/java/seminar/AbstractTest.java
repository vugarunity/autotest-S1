package java.seminar;

import org.junit.jupiter.api.BeforeAll;
import seminar.Door;

public class AbstractTest {
    static Door door;

    @BeforeAll
    static void init() {
        door = new Door(true);
    }
}
