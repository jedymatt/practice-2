


public class StringFile {

    public static String overwrite(String str) {
        if (str.endsWith(".")) {
            str = str.substring(0, str.lastIndexOf("."));
        }
        String name = getName(str);
        if (isOriginal(str)) {
            return new StringBuilder(str).insert(getName(str).length(), "(1)").toString();
        } else {
            String tmp = str.substring(name.lastIndexOf("(") + 1, name.lastIndexOf(")"));
            return new StringBuilder(str).replace(name.lastIndexOf("(") +1, name.length()-1, String.valueOf(getDigit(tmp)+1)).toString();
        }
//        return str;
    }
    
    public static java.io.File overwriteFile(java.io.File f) {
        return new java.io.File(overwrite(f.getAbsolutePath()));
    }
    
    public static java.io.File overwriteFile(String str) {
        return new java.io.File(overwrite(str));
    }

    public static boolean isOriginal(String str) {
        String name = getName(str);
        if (hasExtension(str)) {
            if (name.contains("(") && name.endsWith(")")) {
                String tmp = name.substring(name.lastIndexOf("(") + 1, name.lastIndexOf(")"));
                return !isDigit(tmp);
            } else {
                return true;
            }
        } else {
            if (name.contains("(") && name.endsWith(")")) {
                String tmp = name.substring(name.lastIndexOf("(") + 1, name.lastIndexOf(")"));
                return !isDigit(tmp);
            } else {
                return true;
            }
        }
    }

    private static boolean hasExtension(String str) {
        return str.contains(".");
    }

    private static String getExtension(String str) {
        if (hasExtension(str)) {
            return str.substring(str.lastIndexOf(".") + 1);
        } else {
            throw new NullPointerException("File name has no extension");
        }
    }

    private static String getName(String str) {
        if (hasExtension(str)) {
            return str.substring(0, str.lastIndexOf(".".concat(getExtension(str))));
        } else {
            return str;
        }

    }

    private static boolean isDigit(String str) {
        boolean isDigit = false;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                isDigit = true;
            } else {
                return false;
            }
        }
        return isDigit;
    }

    private static int getDigit(String str) {
        return Integer.valueOf(str);
    }
    
}
