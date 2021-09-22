package homework4;

/*
Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    ArrayList<String> setOfWords = new ArrayList<>();
        setOfWords.add("манго");
        setOfWords.add("виноград");
        setOfWords.add("гранат");
        setOfWords.add("маракуйя");
        setOfWords.add("виноград");
        setOfWords.add("личи");
        setOfWords.add("ананас");
        setOfWords.add("кокос");
        setOfWords.add("питахайя");
        setOfWords.add("гранат");

    System.out.println("Изначальный список: " + setOfWords);
        System.out.println();

    HashSet<String> uniqueSetOfWords = new HashSet<>();
    uniqueSetOfWords.addAll(setOfWords);

    System.out.println("Список уникальных слов: " + uniqueSetOfWords);
        System.out.println();

    for (String s : setOfWords)
        System.out.println("Слово " + s + " встречается " + Collections.frequency(setOfWords, s) + " раз");

    }
}
