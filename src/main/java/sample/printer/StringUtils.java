package sample.printer;

public final class StringUtils {

    public static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder(str.length() * count);
        for (int i = 0; i < count; i++)
            sb.append(str);
        return sb.toString();
    }
}
