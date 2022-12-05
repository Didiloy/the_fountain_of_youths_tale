package test;

import org.junit.jupiter.api.Test;

import static common.input.ParseArg.enumContains;
import static org.junit.jupiter.api.Assertions.*;

class parseArgTest {

    @Test
    void enumContainsTest() {
        assertTrue(enumContains("LOOK"));
        assertFalse(enumContains("FALSE"));
        assertTrue(enumContains("HELP"));
        assertFalse(enumContains("DUMMY"));
        assertTrue(enumContains("YES"));
        assertTrue(enumContains("QUIT"));
    }
}