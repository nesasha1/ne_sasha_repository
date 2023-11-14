package javacroc.matveeva.task12;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {
    public static <T, R> R ternaryOperator(T input, Predicate<T> condition, Function<T, R> ifTrue, Function<T, R> ifFalse) {
        return condition.test(input) ? ifTrue.apply(input) : ifFalse.apply(input);
    }

}
