/**
 *
 */
package xawd.jflow.collections;

import java.util.Collection;

import xawd.jflow.collections.impl.FlowHashSet;
import xawd.jflow.collections.impl.UnmodifiableDelegatingFlowSet;

/**
 * A collection of static factory methods pertaining to the creation of
 * {@link FlowSet} instances.
 *
 * @author ThomasB
 */
public final class Sets
{
	private Sets()
	{
	}

	/**
	 * Create an immutable FlowSet containing the passed arguments.
	 *
	 * @param elements
	 *            The elements to cache into a FlowSet.
	 * @return An immutable FlowSet containing all the specified elements.
	 */
	@SafeVarargs
	public static <E> FlowSet<E> of(E... elements)
	{
		final FlowSet<E> mutable = new FlowHashSet<>();
		for (final E element : elements) {
			mutable.add(element);
		}
		return new UnmodifiableDelegatingFlowSet<>(mutable);
	}

	/**
	 * Create an immutable FlowSet containing elements in the parameter Collection.
	 *
	 * @param src
	 *            The container to copy references from.
	 * @return An immutable FlowSet containing the same references as in the
	 *         parameter Collection.
	 */
	public static <E> FlowSet<E> copyOf(Collection<? extends E> src)
	{
		final FlowSet<E> mutable = new FlowHashSet<>(src);
		return new UnmodifiableDelegatingFlowSet<>(mutable);
	}

	/**
	 * Create an mutable FlowSet containing the passed arguments.
	 *
	 * @param elements
	 *            The elements to cache into a FlowSet.
	 * @return n mutable FlowSet containing all the specified elements.
	 */
	@SafeVarargs
	public static <E> FlowSet<E> mutableOf(E... elements)
	{
		final FlowSet<E> mutable = new FlowHashSet<>();
		for (final E element : elements) {
			mutable.add(element);
		}
		return mutable;
	}

	/**
	 * Create an mutable FlowSet containing elements in the parameter Collection.
	 *
	 * @param src
	 *            The container to copy references from.
	 * @return A mutable FlowSet containing the same references as in the parameter
	 *         Collection.
	 */
	public static <E> FlowSet<E> mutableCopyOf(Collection<? extends E> src)
	{
		return new FlowHashSet<>(src);
	}
}
