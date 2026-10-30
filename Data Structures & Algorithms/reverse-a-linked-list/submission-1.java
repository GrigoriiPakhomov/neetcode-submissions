class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;                          // 1. Указатель на предыдущий узел (в конце станет новым head)
        ListNode curr = head;                          // 2. Текущий узел, с которым работаем прямо сейчас
        
        while (curr != null) {                         // 3. Цикл идёт, пока не дойдём до конца списка (null)
            ListNode nextTemp = curr.next;             // 4. Сохраняем ссылку на следующий узел, чтобы не потерять хвост
            
            curr.next = prev;                          // 5. Меняем направление стрелки: текущий указывает назад
            prev = curr;                               // 6. Сдвигаем prev вперёд: он теперь стал текущим
            curr = nextTemp;                           // 7. Сдвигаем curr вперёд: берём сохранённый следующий узел
        }
        
        return prev;                                   // 8. После цикла curr == null, а prev стоит на последнем узле — это новый head
    }
}