package io.triangle;

import io.triangle.factory.DefaultShapeFactory;
import io.triangle.factory.ShapeFactory;
import io.triangle.model.Triangle;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static io.triangle.specfication.TriangleSpecifications.byEdges;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DetectTriangleTest {
    private ShapeFactory shapeFactory ;

    @Before
    public void setUp() throws Exception {
        shapeFactory = new DefaultShapeFactory();
    }




    @Test
    public void assertTriangleWithAllEqualEdgesLengthIsEquilateralTest() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 3)));
        assertThat(triangle.isEquilateral(), is(true));
    }

    @Test
    public void assertTriangleWithNotAllEqualEdgesLengthIsNotEquilateralTest() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 4, 5)));
        assertThat(triangle.isEquilateral(), is(false));
    }

    @Test
    public void assertTriangleWithTwoEqualEdgesLengthIsIsoscelesTest() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 2)));
        assertThat(triangle.isIsosceles(), is(true));
    }

    @Test
    public void assertTriangleWithAllThreeEdgesOfDifferentLengthIsNotIsoscelesTest() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 4, 5)));
        assertThat(triangle.isIsosceles(), is(false));
    }

    @Test
    public void assertEquilateralTriangleIsIsoscelesTest() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 3)));
        assertThat(triangle.isIsosceles(), is(true));
    }

    @Test
    public void assertTriangleWithAllThreeEdgesOfDifferentLengthIsScaleneTest() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 4, 5)));
        assertThat(triangle.isScalene(), is(true));
    }

    @Test
    public void assertEquilateralTriangleIsNotScaleneTest() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 3)));
        assertThat(triangle.isScalene(), is(false));
    }

    @Test
    public void assertIsoscelesTriangleIsNotScalene() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 4)));
        assertThat(triangle.isScalene(), is(false));
    }

}