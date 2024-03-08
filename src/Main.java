import java.util.*;

public class Main {

    private static void Test() {
        Collection<String> collection = new ArrayList<>();
    }
    public static void main(String[] args) {
        // Создаем HashMap для хранения записей телефонной книги
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        // Пример входных данных: имена и телефоны
        String[][] entries = {
                {"Иванов", "123456"},
                {"Петров", "234567"},
                {"Иванов", "987654"},
                {"Сидоров", "345678"},
                {"Петров", "456789"},
                {"Иванов", "654321"}
        };

        // Заполняем телефонную книгу
        for (String[] entry : entries) {
            String name = entry[0];
            String phone = entry[1];

            // Если имя уже есть в книге, добавляем телефон к существующей записи
            if (phoneBook.containsKey(name)) {
                HashSet<String> phones = phoneBook.get(name);
                phones.add(phone);
            } else {
                // Если имя новое, создаем новую запись
                HashSet<String> phones = new HashSet<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }

        // Создаем список для сортировки записей по убыванию числа телефонов
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        // Выводим отсортированные записи
        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            String name = entry.getKey();
            HashSet<String> phones = entry.getValue();

            System.out.println("Имя: " + name + ", Телефоны: " + phones + ", Количество телефонов: " + phones.size());
        }
    }
}