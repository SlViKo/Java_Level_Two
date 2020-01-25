package ru.gb.jtwo.lone.online.lessonthree.onetask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueWordInArray {
    private String[] words;

    public UniqueWordInArray(String[] words) {
        this.words = words;
    }

    public void printUniqueWord() {

        HashSet<String> uniqueWordsInArray = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            uniqueWordsInArray.add(words[i]);
        }
        System.out.println("Список уникальных слов в массиве: ");
        System.out.println(uniqueWordsInArray);
    }

    public void printQuantityRepeatWords() {
        HashMap<String, Integer> quantityRepeatWords = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!quantityRepeatWords.containsKey(words[i])) {
                quantityRepeatWords.put(words[i], 1);
            } else {
                quantityRepeatWords.put(words[i], quantityRepeatWords.get(words[i]) + 1);
            }
        }
        for (Map.Entry<String, Integer> o : quantityRepeatWords.entrySet()) {
            System.out.println(o.getKey() +" встречается - "  + o.getValue());
        }
    }


}
