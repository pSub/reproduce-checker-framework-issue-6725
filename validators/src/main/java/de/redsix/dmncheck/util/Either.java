package de.redsix.dmncheck.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.derive4j.Data;
import org.derive4j.Derive;
import org.derive4j.Make;

@Data(value = @Derive(make = {Make.constructors, Make.caseOfMatching, Make.getters}))
public abstract class Either<A, B> {
    public abstract <X> X match(Function<A, X> left, Function<B, X> right);

    public <C> Either<A, C> map(Function<B, C> function) {
        return this.match(Eithers::left, right -> Eithers.right(function.apply(right)));
    }

    /**
     * checker-framework version 3.43 and 3.44 break at this method. Specifically at `either.map(Arrays::asList)` with
     * the error message
     *
     * <p>Enclosing type not found: type: Object supertype: Either<A extends Object, B extends Object>
     *
     * <p>checker-framework version 3.42 compiles this code successfully.
     */
    public static <A, B> Collector<Either<A, B>, ?, Either<A, List<B>>> breakIt() {
        return Collectors.reducing(
                Eithers.right(new ArrayList<>()), either -> either.map(Arrays::asList), (either, eithers) -> either);
    }
}
