/*
-- ПРИНЦИП РАБОТЫ --
Решение реализовано с помощью стека
Проходим циклом for по всем элементам полученной строки, если элемент является числом, то добавляем его в стек,
иначе, получаемя два последних элемента из стека, удаляем их и проводим операцию,
знак которой мы получили из цикла, между этими двумя элементами, результат добавляем в стек.
В конечном итоге в стеке окажется одно число, оно и будет ответом

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

Из описания алгоритма следует, что чем позже элемент добавился в стек,
тем раньше он будет из неё извлечён.
Стек -- это порядок LIFO
Следовательно идеально подходит для обратной польской записи.
Получается, мы добавляем числа в стек, пока не получим знак, и в таком случае достаем последние два числа

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Операции push, pop и peek занимают O(1)
Обработка токенов в количестве n займет O(n);

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
В худшем случае, пространственная сложность будет O(n), где n - это количество операндов


ID решения 89426603
 */

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Stack<Integer> stack = new Stack<>();
        String strSigns = "+-/*";
        for (String s : str.split(" ")) {
            if (!strSigns.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    default:
                        stack.push(Math.floorDiv(b, a));
                }
            }
        }
        System.out.println(stack.peek());
    }
}