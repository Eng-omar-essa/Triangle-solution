/**
 * 
 */
package io.triangle.factory;

import io.triangle.model.Triangle;
import io.triangle.specfication.TriangleSpecifications;

/**
 * @author Omar Issa
 * This implemention of Factory interface
 */
public class DefaultShapeFactory implements ShapeFactory {

	/* (non-Javadoc)
	 * @see io.triangle.factory.ShapeFactory#createTriangle(io.triangle.specfication.TriangleSpecifications)
	 */
	@Override
	public Triangle createTriangle(TriangleSpecifications specifications) {
		  return new Triangle(specifications.getEdges());
	}

}
