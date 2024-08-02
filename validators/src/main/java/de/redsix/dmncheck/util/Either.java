package de.redsix.dmncheck.util;

import java.util.function.Function;

// @Data(value = @Derive(make = {Make.constructors, Make.caseOfMatching, Make.getters}))
public abstract class Either<A, B> {
    public abstract <X> X match(Function<A, X> left, Function<B, X> right);
}
