package by.it.patsko.jd01_06;
/*
TaskC1.
Отформатировать исходный текст с выравниванием по обоим краям.
Для этого добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной,
а число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
причем на единицу большие последовательности пробелов должны идти с начала строки.
 */


public class TaskC1 {
    private static int maxLength;

    public static void main(String[] args) {
        String[] str = Poem.text.split("\\n");
        maxLength = findMaxLengthString(str);
        for (int i = 0; i < str.length; i++) {
            str[i] = addSpaces(str[i]);
        }
        for (String s : str) {
            System.out.println(s);
        }
    }

    private static int findMaxLengthString(String[] str) {
        int max = Integer.MIN_VALUE;
        for (String s : str) {
            if (max < s.length()) max = s.length();
        }
        return max;
    }

    private static String addSpaces(String str) {
        StringBuilder sb = new StringBuilder(str);
        int numOfSpaces = maxLength - sb.length();
        int i = 0;
        while (numOfSpaces != 0) {
            if (i == sb.length() - 1) i = 0;
            else if (sb.charAt(i) == ' ' && sb.charAt(i - 1) != ' ') {
                sb.insert(i++, ' ');
                if (--numOfSpaces == 0) break;
            }
            i++;
        }
        return sb.toString();
    }
}
