/**
 *
 */
package com.github.maumay.jflow.iterators;

import java.util.OptionalInt;

/**
 * Abstraction of a sequence whose (possibly infinite) size may not be known.
 *
 * @author ThomasB
 */
@FunctionalInterface
public interface OptionallySized
{
	/**
	 * Retrieves the (possibly unknown) size of this object.
	 * 
	 * @return The size of the sequence if it known, otherwise nothing to indicate
	 *         the value is unknown.
	 */
	OptionalInt size();

	/**
	 * Indicates whether the size of this object is known.
	 * 
	 * @return true if the size of this sequence is known, false otherwise.
	 */
	default boolean sizeIsKnown()
	{
		return size().isPresent();
	}
}
