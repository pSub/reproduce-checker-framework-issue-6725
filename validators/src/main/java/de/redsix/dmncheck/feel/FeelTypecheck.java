package de.redsix.dmncheck.feel;

import static de.redsix.dmncheck.util.Eithers.left;
import static de.redsix.dmncheck.util.Eithers.right;

import de.redsix.dmncheck.util.Either;

public final class FeelTypecheck {

    private static Either<String, Long> checkOperatorCompatibility(int i) {
        return switch (i) {
            case 1 -> right(1L);
            default -> left("Unexpected operand ");
        };
    }
}
