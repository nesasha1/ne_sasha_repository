package javacroc.matveeva.task10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Filter implements BlackListFilter {

    public void filterComments(List<String> comments, Set<String> blackList) {

        Predicate<String> filterPredicate = comment -> {

            String[] words = comment.split("[\\s.,!?]+");

            for (String word : words) {
                if (blackList.contains(word.toLowerCase())) {
                    return true;
                }
            }
            return false;
        };

        Collection<String> filteredComments = filterComments(comments, filterPredicate);

        comments.clear();
        comments.addAll(filteredComments);
    }
}