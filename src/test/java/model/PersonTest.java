package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() { person = new Person(); }

    @Test
    void defaultValues_areNullAndZero() {
        // Before setting, name should be null and age should be 0
        assertNull(person.getName(), "Default name should be null");
        assertEquals(0, person.getAge(), "Default age should be 0");
    }
}
