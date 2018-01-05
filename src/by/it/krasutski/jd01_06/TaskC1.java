package by.it.krasutski.jd01_06;

public class TaskC1 {
    private static int maxLength;

    public static void main(String[] args) {
        String[] str = Poem.text.split("\\n");
        maxLength = findMaxLength(str);
        for (int i = 0; i < str.length; i++) {
            str[i] = addBlank(str[i]);
        }
        for (String s : str) {
            System.out.println(s);
        }
    }

    private static int findMaxLength(String[] str) {
        int max = 0;
        for (String s : str) {
            if (max < s.length()) max = s.length();
        }
        return max;
    }

    private static String addBlank(String str) {
        StringBuilder text = new StringBuilder(str);
        int numOfBlank = maxLength - text.length();
        int i = 0;
        while (numOfBlank != 0) {
            if (i == text.length() - 1) i = 0;
            else if (text.charAt(i) == ' ' && text.charAt(i - 1) != ' ') {
                text.insert(i++, ' ');
                if (--numOfBlank == 0) break;
            }
            i++;
        }
        return text.toString();
    }
}
