/**
 * 
 */
package io.triangle.factory;

import io.triangle.model.Triangle;
import io.triangle.specfication.TriangleSpecifications;

/**
 * @author Omar Issa
 * This is an Interface of ShapeFactory .
 */
public interface ShapeFactory {
	
	Triangle createTriangle(TriangleSpecifications specifications);

}
