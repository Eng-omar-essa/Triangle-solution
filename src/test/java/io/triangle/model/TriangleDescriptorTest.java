package io.triangle.model;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Omar Issa
 * This test class for testing TriangleDiscriptor .
 */
public class TriangleDescriptorTest {

    @Test
    public void assertEquilateralTypeForEquilateralTriangleTest() throws Exception {
        Triangle triangle = new Triangle(Arrays.asList(3, 3, 3));
        assertThat(type(triangle), is(equalTo("equilateral")));
    }


    @Test
    public void assertIsoscelesTypeForIsoscelesAndNotEquilateralTriangleTest() throws Exception {
        Triangle triangle = new Triangle(Arrays.asList(3, 3, 2));
        assertThat(type(triangle), is(equalTo("isosceles")));
    }

    @Test
    public void assertScaleneTypeForScaleneTriangleTest() throws Exception {
        Triangle triangle = new Triangle(Arrays.asList(3, 4, 5));
        assertThat(type(triangle), is(equalTo("scalene")));
    }


    private String type(Triangle triangle) {
        return new TriangleDescriptor(triangle).type();
    }
}