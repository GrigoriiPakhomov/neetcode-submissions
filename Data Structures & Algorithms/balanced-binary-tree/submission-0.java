class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;                     // 1. Запускаем DFS-помощника: если вернёт -1, значит дисбаланс найден
    }

    private int helper(TreeNode node) {                // 2. Вспомогательный метод: возвращает высоту узла или -1 при дисбалансе
        if (node == null) return 0;                   // 3. Базовый случай: пустое поддерево имеет высоту 0

        int leftH = helper(node.left);                // 4. Рекурсивно вычисляем высоту левого поддерева
        int rightH = helper(node.right);              // 5. Рекурсивно вычисляем высоту правого поддерева

        if (leftH == -1 || rightH == -1) return -1;   // 6. Если хотя бы одно поддерево несбалансировано, сразу прерываем и возвращаем -1 вверх
        if (Math.abs(leftH - rightH) > 1) return -1;  // 7. Проверяем условие баланса для текущего узла

        return 1 + Math.max(leftH, rightH);           // 8. Возвращаем текущую высоту узла для родительского вызова
    }
}