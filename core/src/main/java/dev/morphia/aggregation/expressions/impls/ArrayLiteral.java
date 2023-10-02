package dev.morphia.aggregation.expressions.impls;

import com.mongodb.lang.Nullable;

import dev.morphia.annotations.internal.MorphiaInternal;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

/**
 * @hidden
 * @morphia.internal
 */
@MorphiaInternal
public class ArrayLiteral extends ArrayExpression {

    private Object[] objects;

    /**
     * @hidden
     * @morphia.internal
     */
    @MorphiaInternal
    public ArrayLiteral(Expression... values) {
        super("unused", asList(values));
    }

    /**
     * @hidden
     * @morphia.internal
     */
    @MorphiaInternal
    public ArrayLiteral(Object... objects) {
        super("unused", emptyList());
        this.objects = objects;
    }

    /**
     * @hidden
     * @morphia.internal
     */
    @MorphiaInternal
    @Nullable
    public Object[] objects() {
        return objects;
    }
}
