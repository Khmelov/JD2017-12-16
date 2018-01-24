package by.it.patsko.jd01_15;

enum Comments {
    OneLineComment("//", "\n"), MultiLineComment("/*", "*/"), JavaDocComment("/**", "*/");

    private String start;
    private String end;

    Comments(String o, String c) {
        start = o;
        end = c;
    }

    public String getStart() {
        return start;
    }

    int numCharToSkip(String substring) {
        int i = 0, numToSkip = 1;
        StringBuilder sb = new StringBuilder();
        while (i < substring.length()) {
            if (this != OneLineComment) {
                sb.append(substring.substring(i, i + 2));
                numToSkip++;
                if (this.end.equals(sb.toString()) ||
                        i + 1 == substring.length()) {
                    numToSkip += 2;
                    break;
                }
                i++;
            } else {
                sb.append(substring.charAt(i++));
                if (this.end.equals(sb.toString())) {
                    numToSkip++;
                    break;
                }
                numToSkip++;
            }
            sb.setLength(0);
        }
        return numToSkip;
    }
}