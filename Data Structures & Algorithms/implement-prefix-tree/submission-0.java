class PrefixTree {                                          // 1. LeetCode ожидает название Trie, а не PrefixTree
    private class Node {                              // 2. Вложенный класс: каждый узел хранит 26 ссылок на буквы и флаг окончания слова
        Node[] children = new Node[26];               // 3. Массив для дочерних узлов (индексы 0-25 соответствуют 'a'-'z')
        boolean isEndOfWord = false;                  // 4. Флаг: true, если здесь заканчивается вставленное слово
    }

    private Node root;                                // 5. Корневой (виртуальный) узел, не содержит букву

    public PrefixTree() {                                   // 6. Инициализация корневого узла при создании объекта
        root = new Node();
    }

    public void insert(String word) {                 // 7. Добавление слова в префиксное дерево
        Node curr = root;                             // 8. Указатель, который будет "пробегать" по дереву
        for (char c : word.toCharArray()) {           // 9. Перебираем каждую букву слова по порядку
            int idx = c - 'a';                        // 10. Переводим букву в индекс 0-25 (например, 'a'→0, 'b'→1)
            if (curr.children[idx] == null) {         // 11. Если дочернего узла для буквы ещё нет...
                curr.children[idx] = new Node();      // 12. Создаём новый узел и связываем его с текущим
            }
            curr = curr.children[idx];                // 13. Сдвигаем указатель вперёд по созданному/найденому узлу
        }
        curr.isEndOfWord = true;                      // 14. После прохождения всех букв ставим флаг окончания слова
    }

    public boolean search(String word) {              // 15. Поиск полного совпадения слова
        Node curr = root;                             // 16. Начинаем обход с корня
        for (char c : word.toCharArray()) {           // 17. Проходим по всем буквам искомого слова
            int idx = c - 'a';
            if (curr.children[idx] == null) return false; // 18. Если путь обрывается → слова точно нет
            curr = curr.children[idx];                // 19. Двигаемся дальше по дереву
        }
        return curr.isEndOfWord;                      // 20. Слово найдено только если установлен флаг isEndOfWord
    }

    public boolean startsWith(String prefix) {        // 21. Поиск наличия префикса
        Node curr = root;                             // 22. Аналогичный обход по буквам
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false; // 23. Если путь обрывается → префикса нет
            curr = curr.children[idx];
        }
        return true;                                  // 24. Достаточно, что путь дошёл до конца префикса. Флаг слова не важен.
    }
}