import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
help to print the map and the table out
 */
public class PrintUtils {

    private static final String headSplitSymbol = "/";


    public static void printSpace(Cell[][] cells) {
        int spaceLength = cells[0].length;
        int headLength = spaceLength * 6 + 1;
        System.out.println(padLeft("", headLength, '*'));
        printTitle(headLength, "Cell Info List");
        System.out.println(padLeft("", headLength, '-'));
        for (int rowIndex = 0; rowIndex < spaceLength; rowIndex++) {
            StringBuffer rowSB = new StringBuffer();
            for (int columnIndex = 0; columnIndex < cells.length; columnIndex++) {
                if (columnIndex == 0) {
                    rowSB.append("|");
                }
                rowSB.append("  ").append(cells[rowIndex][columnIndex].getSymbol()).append("  |");
            }
            System.out.println(rowSB);
            System.out.println(padLeft("", headLength, '-'));
        }
    }

    public static void printTable(String title, String head, Object obj) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(obj);
        printTable(title,head,objects);

    }

    public static void printTable(String title, String head, ArrayList<?> rows) {

        String[] headSplit = head.split(headSplitSymbol);
        //get column
        int columnCount = headSplit.length;
        int rowCount = rows.size();
        //max length for each column
        int[] maxLen = new int[columnCount];

        for (int i = 0; i < headSplit.length; i++) {
            String headValue = headSplit[i].trim();
            headSplit[i] = headValue;
            maxLen[i] = headValue.length();
        }
        HashMap<Integer, ArrayList<String>> rowMap = new HashMap<>();
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            if (rows.get(rowIndex) == null){
                continue;
            }
            String rowStr = rows.get(rowIndex).toString();
            String[] rowSplit = rowStr.split(headSplitSymbol);
            for (int columIndex = 0; columIndex < rowSplit.length; columIndex++) {
                String value = rowSplit[columIndex].trim();
                if (value.length() > maxLen[columIndex]) {
                    maxLen[columIndex] = value.length();
                }
                rowMap.computeIfAbsent(rowIndex, k -> new ArrayList<>());
                rowMap.get(rowIndex).add(value);
            }
        }

        int headLength = Arrays.stream(maxLen).sum() + columnCount * 5 + 6;
        System.out.println(padLeft("", headLength, '*'));
        printTitle(headLength, title);

        System.out.println(padLeft("", headLength, '*'));
        StringBuffer headSB = new StringBuffer();
        headSB.append("* NO *");
        for (int i = 0; i < columnCount; i++) {
            headSB.append("  ").append(padRight(headSplit[i], maxLen[i], ' ')).append("  *");
        }
        System.out.println(headSB);
        System.out.println(padLeft("", headLength, '*'));
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            if (rows.get(rowIndex) == null){
                continue;
            }
            StringBuffer rowSB = new StringBuffer();
            ArrayList<String> rowValueList = rowMap.get(rowIndex);
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                if (columnIndex == 0) {
                    rowSB.append("*").append(padLeft(rowIndex + "", 3, ' ')).append(" *");
                }
                rowSB.append("  ").append(padRight(rowValueList.get(columnIndex), maxLen[columnIndex], ' ')).append("  *");
            }
            System.out.println(rowSB);
        }

        System.out.println(padLeft("", headLength, '*'));
    }

    private static void printTitle(int headLength, String title) {
        int titleLength = title.length();
        int left = (headLength - titleLength - 2) / 2;
        int right = headLength - left - titleLength - 2;
        StringBuffer sb = new StringBuffer();
        sb.append("*").append(padLeft("", left, ' ')).append(title).append(padRight("", right, ' ')).append("*");
        System.out.println(sb);
    }

    /**
     * pad left
     */
    public static String padLeft(String origin, int length, char ch) {
        StringBuilder originBuilder = new StringBuilder(origin);
        while (originBuilder.length() < length) {
            originBuilder.insert(0, ch);
        }
        return originBuilder.toString();
    }

    /**
     * pad right
     */
    public static String padRight(String origin, int length, char ch) {
        StringBuilder originBuilder = new StringBuilder(origin);
        while (originBuilder.length() < length) {
            originBuilder.append(ch);
        }
        return originBuilder.toString();
    }
}
