package javacroc.matveeva.task9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example {

    public static void main(String[] args) {

        BlackListFilter filter = new Filter();
        List<String> comments = new ArrayList<>();

        comments.add("хороший правильный, вежливый комментарий");
        comments.add("мат");
        comments.add("быть или не быть");
        comments.add("yuppy!!!");
        comments.add("bark bark?");
        comments.add("что-то очень плохое");

        Set<String> blackList = new HashSet<>();

        blackList.add("мат");
        blackList.add("bark");
        blackList.add("плохое");

        System.out.println("Исходные комментарии: \n" + comments);

        filter.filterComments(comments, blackList);

        System.out.println("Прошедшие проверку комментарии: \n" + comments);

    }
}


