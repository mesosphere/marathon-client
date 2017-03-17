package mesosphere.client.common;

/**
 * Version of a {@link java.util.function.Supplier} which is capable of throwing a {@link Throwable}.
 */
@FunctionalInterface
public interface ThrowingSupplier<T, E extends Throwable> {
    T get() throws E;
}
