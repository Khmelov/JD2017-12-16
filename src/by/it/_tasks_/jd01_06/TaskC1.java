package by.it._tasks_.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] lines = Poem.text.split("\n");
        int maxLen = 0;
        for (String l : lines)
            if (l.length() > maxLen)
                maxLen = l.length();
        for (int i = 0; i < lines.length; i++) {
            int pos = 0;
            StringBuilder sb = new StringBuilder(lines[i]);
            while (sb.length() < maxLen) {
                while (sb.charAt(pos) != ' ')
                    pos = (pos != sb.length() - 1 ? pos + 1 : 0);
                sb.insert(pos, ' ');
                while (sb.charAt(pos) == ' ')
                    pos = (pos != sb.length() - 1 ? pos + 1 : 0);
            }
            lines[i]=sb.toString();
        }
        for (String line : lines) {
            System.out.println(line);
        }

    }
}
