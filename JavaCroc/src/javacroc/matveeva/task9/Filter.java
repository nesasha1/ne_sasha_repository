package javacroc.matveeva.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {
        @Override
        public void filterComments(List<String> comments, Set<String> blackList) {

            List<String> approvedComments = new ArrayList<>();

            for (String comment : comments) {

                boolean containsBlackListWord = false;
                String[] words = comment.split("[\\s.,!?]+");

                for (String word : words) {
                    if (blackList.contains(word.toLowerCase())) {
                        containsBlackListWord = true;
                        break;
                    }
                }
                if (!containsBlackListWord) {
                    approvedComments.add(comment);
                }
            }

            comments.clear();
            comments.addAll(approvedComments);
        }
}