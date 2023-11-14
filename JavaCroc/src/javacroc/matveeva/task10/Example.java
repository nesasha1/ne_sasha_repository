package javacroc.matveeva.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Example {

    public static void main(String[] args) {

        List<String> comments = new ArrayList<>(Arrays.asList("хороший правильный, вежливый комментарий", "Мат", "bark Bark?"));
        Set<String> blackList = new HashSet<>(Arrays.asList("Bark", "мат"));

        Set<String> lowerCaseBlackList = new HashSet<>();
        for (String word : blackList) {
            lowerCaseBlackList.add(word.toLowerCase());
        }

        Filter filter = new Filter();

        System.out.println("Исходные комментарии: \n" + comments);

        filter.filterComments(comments, lowerCaseBlackList);

        System.out.println("Прошедшие проверку комментарии: \n" + comments);


    }


}


