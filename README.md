# Reproduce checker-framework issue #6664

This repository contains small example that reproduces issue #6664 of the checker-framework.

With checker-framework 4.43 and 4.44 the compilation with the checker-frameworks crashes with
the error message

    Error in AnnotatedTypeMirror.fromExpression(RegexAnnotatedTypeFactory, either.map(Arrays::asList)): Enclosing type not found: type: Object supertype: Either<A extends Object, B extends Object>

version 4.42 compiles the code without problems.