/**
 * 
 */
package io.triangle.validation;

import java.math.BigDecimal;
import java.util.List;

import io.triangle.exception.ValidationException;
import io.triangle.model.Triangle;

/**
 * @author Omar Issa
 *
 */
public class TriangleValidator {
	  public void validate(Triangle triangle) throws ValidationException {
	        List<Number> edges = triangle.getEdges();
	        if (edges.size() != 3) {
	            throw new ValidationException("You should specify all three edges length");
	        }
	        for (Number edge : edges) {
	            if (edge == null) {
	                throw new ValidationException("Triangle edges must be not null");
	            }
	            BigDecimal edgeLength = BigDecimal.valueOf(edge.doubleValue());
	            if (edgeLength.compareTo(BigDecimal.ZERO) <= 0) {
	                throw new ValidationException("Triangle edges length must be positive");
	            }
	            BigDecimal twoOtherEdgesLengthSum = edges.stream()
	                .map(value -> BigDecimal.valueOf(value.doubleValue()))
	                .reduce(BigDecimal.ZERO, BigDecimal::add)
	                .add(edgeLength.negate());
	            if (edgeLength.compareTo(twoOtherEdgesLengthSum) >= 0) {
	                throw new ValidationException("Triangle with such edges can not exist");
	            }
	        }
	    }

}
