package ru.gb.jtwo.lone.online.lessonthree;

public class TestUniqueWordInArray {
    public static void main(String[] args) {
        String[] animals = new String[] {"Кошка", "Собака", "Мышь", "Овца", "Лошадь", "Кошка", "Курица", "Мышь",
                                        "Жираф", "Корова", "Собака", "Медведь", "Волк", "Кошка", "Лошадь", "Корова",
                                        "Кошка", "Волк", "Курица", "Индюк", "Кошка", "Мышь", "Лошадь", "Курица"};

        UniqueWordInArray uniqueWordInArray = new UniqueWordInArray(animals);
        uniqueWordInArray.printUniqueWord();
        uniqueWordInArray.printQuantityRepeatWords();
    }
}
