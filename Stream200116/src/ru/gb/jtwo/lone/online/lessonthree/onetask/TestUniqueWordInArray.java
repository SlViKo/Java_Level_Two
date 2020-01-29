/**
 * 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
 *   - Найти список слов, из которых состоит текст (дубликаты не считать);
 *   - Посчитать сколько раз встречается каждое слово (использовать HashMap);
 *
 * @author SlViKo
 * @version date 25/01/2010
 */

package ru.gb.jtwo.lone.online.lessonthree.onetask;

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
