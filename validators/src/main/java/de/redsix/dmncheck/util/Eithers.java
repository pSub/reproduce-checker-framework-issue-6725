package de.redsix.dmncheck.util;

import java.util.function.Function;

public final class Eithers {
    private Eithers() {}

    public static <A, B> Either<A, B> left(A left) {
        return new Left<>(left);
    }

    public static <A, B> Either<A, B> right(B right) {
        return new Right<>(right);
    }

    private static final class Left<A, B> extends Either<A, B> {
        private final A left;

        Left(A left) {
            this.left = left;
        }

        @Override
        public <X> X match(Function<A, X> left, Function<B, X> right) {
            return left.apply(this.left);
        }
    }

    private static final class Right<A, B> extends Either<A, B> {
        private final B right;

        Right(B right) {
            this.right = right;
        }

        @Override
        public <X> X match(Function<A, X> left, Function<B, X> right) {
            return right.apply(this.right);
        }
    }
}
