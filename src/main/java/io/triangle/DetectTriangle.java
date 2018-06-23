/**
 * 
 */
package io.triangle;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.triangle.factory.DefaultShapeFactory;
import io.triangle.factory.ShapeFactory;
import io.triangle.model.Triangle;
import io.triangle.model.TriangleDescriptor;
import io.triangle.specfication.TriangleSpecifications;

import static io.triangle.specfication.TriangleSpecifications.byEdges;

/**
 * @author Omar Issa
 *
 */
public class DetectTriangle {

	private static final Logger logger = LoggerFactory.getLogger(DetectTriangle.class);

    public static void main(String[] args) {

        try {
            List<Number> edgesLength = mapCommandLineArgumentsToNumbers(args);
            logger.info("trying to create triangle with edges: {}", edgesLength);
            Triangle triangle = createTriangleBySpecifiedEdgesLength(edgesLength);
            logger.info("created triangle: {}", triangle);
            logger.info("triangle type is: {}", triangleType(triangle));
        } catch (Exception e) {
            logger.error("error while defining triangle type", e);
            printHelp();
        }
    }

    private static List<Number> mapCommandLineArgumentsToNumbers(String[] args) {
        return Stream.of(args)
            .map(arg -> {
                try {
                    return NumberFormat.getInstance().parse(arg);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Triangle edge length must be a number: " + arg, e);
                }
            })
            .collect(Collectors.toList());
    }

    private static Triangle createTriangleBySpecifiedEdgesLength(List<Number> edgesLength) {
        ShapeFactory shapeFactory = new DefaultShapeFactory();
        return shapeFactory.createTriangle(byEdges(edgesLength));
    }

 
	private static String triangleType(Triangle triangle) {
        return new TriangleDescriptor(triangle).type();
    }

    private static void printHelp() {
        System.out.println("command syntax: java " + DetectTriangle.class.getName() +
            " <all three triangle edges length>");
    }
}

