package com.gowri.quartz.string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author NaveenWodeyar
 * @date 18-Oct-2024
 * @time 12:24:11 am
 */
public class StringUtilsTest {

    private final StringUtils stringUtils = new StringUtils();

    @Test
    public void testIsNullOrEmpty_WithNull() {
        assertTrue(stringUtils.isNullOrEmpty(null));
    }

    @Test
    public void testIsNullOrEmpty_WithEmptyString() {
        assertTrue(stringUtils.isNullOrEmpty(""));
    }

    @Test
    public void testIsNullOrEmpty_WithNonEmptyString() {
        assertFalse(stringUtils.isNullOrEmpty("Hello"));
    }

    @Test
    public void testReverse_WithValidString() {
        assertEquals("dlroW olleH", stringUtils.reverse("Hello World"));
    }

    @Test
    public void testReverse_WithEmptyString() {
        assertEquals("", stringUtils.reverse(""));
    }

    @Test
    public void testReverse_WithNull() {
        assertEquals(null, stringUtils.reverse(null));
    }

    @Test
    public void testToUpperCase_WithValidString() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }

    @Test
    public void testToUpperCase_WithNull() {
        assertEquals(null, stringUtils.toUpperCase(null));
    }

    @Test
    public void testToLowerCase_WithValidString() {
        assertEquals("hello", stringUtils.toLowerCase("HELLO"));
    }

    @Test
    public void testToLowerCase_WithNull() {
        assertEquals(null, stringUtils.toLowerCase(null));
    }

    @Test
    public void testTrim_WithValidString() {
        assertEquals("Hello World", stringUtils.trim("  Hello World  "));
    }

    @Test
    public void testTrim_WithEmptyString() {
        assertEquals("", stringUtils.trim(""));
    }

    @Test
    public void testTrim_WithNull() {
        assertEquals(null, stringUtils.trim(null));
    }

    @Test
    public void testContains_WithValidSubstring() {
        assertTrue(stringUtils.contains("Hello World", "World"));
    }

    @Test
    public void testContains_WithInvalidSubstring() {
        assertFalse(stringUtils.contains("Hello World", "Java"));
    }

    @Test
    public void testContains_WithNullString() {
        assertFalse(stringUtils.contains(null, "World"));
    }

    @Test
    public void testContains_WithNullSubstring() {
        assertFalse(stringUtils.contains("Hello World", null));
    }

    @Test
    public void testJoin_WithValidArray() {
        String[] strings = {"Hello", "World"};
        assertEquals("HelloWorld", stringUtils.join(strings, ""));
        assertEquals("Hello, World", stringUtils.join(strings, ", "));
    }

    @Test
    public void testJoin_WithNullArray() {
        assertNull(stringUtils.join(null, ", "));
    }

    @Test
    public void testJoin_WithEmptyArray() {
        String[] strings = {};
        assertEquals("", stringUtils.join(strings, ", "));
    }

    @Test
    public void testJoin_WithNullDelimiter() {
        String[] strings = {"Hello", "World"};
        assertEquals("HelloWorld", stringUtils.join(strings, null));
    }
}

