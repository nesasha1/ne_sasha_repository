package javacroc.matveeva.task10;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.ArrayList;

public interface BlackListFilter {
    default <T> Collection<T> filterComments(Collection<T> comments, Predicate<T> filterPredicate) {
        Collection<T> filteredComments = new ArrayList<>();
        for (T comment : comments) {
            if (!filterPredicate.test(comment)) {
                filteredComments.add(comment);
            }
        }
        return filteredComments;
    }
}

