import org.example.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class Test {
    private StringListImpl expected;
    private StringListImpl actual;

    @BeforeEach
    public void setup() {
        expected = new StringListImpl(10);
        String string1 = "s1";
        String string2 = "s2";
        String string3 = "s3";
        String string4 = "s4";
        expected.add(string1);
        expected.add(string2);
        expected.add(string3);
        expected.add(string4);
        actual = new StringListImpl(10);
        actual.add(string1);
        actual.add(string2);
        actual.add(string3);
        actual.add(string4);
    }

    @org.junit.jupiter.api.Test
    public void addString() {
        StringListImpl stringList1 = new StringListImpl(10);
        String string1 = "s1";
        String string2 = "s2";
        String string3 = "s3";
        String string4 = "s4";
        stringList1.add(string1);
        stringList1.add(string2);
        stringList1.add(string3);
        stringList1.add(string4);
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void addByIndex() {
        expected.add(1, "set");
        actual.add(1, "set");
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void set() {
        expected.set(1, "set");
        actual.set(1, "set");
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void removeByIndex() {
        expected.remove(1);
        actual.remove(1);
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void contains() {
        Assertions.assertTrue(actual.contains("s1"));
    }

    @org.junit.jupiter.api.Test
    public void indexOf() {
        Assertions.assertEquals(expected.indexOf("s1"), 0);
    }

    @org.junit.jupiter.api.Test
    public void lastIndexOf() {
        Assertions.assertEquals(expected.indexOf("s1"), 0);
    }

    @org.junit.jupiter.api.Test
    public void get() {
        Assertions.assertEquals(expected.get(0), "s1");
    }

    @org.junit.jupiter.api.Test
    public void equals() {
        Assertions.assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    public void size() {
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @org.junit.jupiter.api.Test
    public void isEmpty() {
        Assertions.assertFalse(expected.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void clear() {
        expected.clear();
        Assertions.assertTrue(expected.isEmpty());
    }


    @org.junit.jupiter.api.Test
    public void toArray() {
        String[] strings1 = expected.toArray();
        String[] strings2 = new String[10];
        strings2[0] = "s1";
        strings2[1] = "s2";
        strings2[2] = "s3";
        strings2[3] = "s4";
        Assertions.assertArrayEquals(strings1, strings2);

    }

    @org.junit.jupiter.api.Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenUseMethodAdd() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> expected.add(11, null));
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodAdd() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.add(11, null));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.add(null));
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenUseMethodSet() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> expected.set(11, null));
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodSet() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.set(8, null));
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodRemove() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.remove(null));
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodContains() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.contains(null));
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodEquals() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> expected.equals(null));
    }

}
