class Solution {
    private int maxDiameter = 0;                   // 1. Поле класса для хранения максимального пути по всему дереву

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);                                 // 2. Запускаем глубинный обход (DFS) от корня
        return maxDiameter;                        // 3. Возвращаем накопленный максимум после полного обхода
    }

    private int dfs(TreeNode node) {               // 4. Вспомогательный метод: возвращает глубину узла
        if (node == null) return 0;                // 5. Базовый случай: пустой узел имеет глубину 0 рёбер

        int left = dfs(node.left);                 // 6. Рекурсивно считаем глубину левого поддерева
        int right = dfs(node.right);               // 7. Рекурсивно считаем глубину правого поддерева

        maxDiameter = Math.max(maxDiameter, left + right); // 8. Обновляем глобальный максимум (путь через текущий узел)

        return 1 + Math.max(left, right);          // 9. Возвращаем текущую глубину для родительского вызова
    }
}