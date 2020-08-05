
import java.io.File;

public class Overwriter {

    private File f;

    public Overwriter() {
        this(new File(""));
    }

    public Overwriter(String path) {
        this(new File(path));
    }

    public Overwriter(File f) {
        this.f = f;
    }

    public String extensionOf(String str) {
        if (str.contains(".")) {
            return str.substring(str.lastIndexOf(".") + 1);
        }
        return "";
    }

    public String extensionOf() {
        return extensionOf(getAbsolutePath());
    }

    public String nameOf(String str) {
        str = new File(str).getName();
        if (str.contains(extensionOf(str)) && !extensionOf(str).isEmpty()) {
            if (str.contains(extensionOf(str))) {
                str = str.substring(0, str.lastIndexOf(extensionOf(str)) - 1);
            } else {
                str = str.substring(0, str.lastIndexOf(extensionOf(str)));
            }
        }
        return str;
    }

    public String getName() {
        return nameOf(getAbsolutePath());
    }

    public String getExtension(String str) {
        return extensionOf(str);
    }

    public String getFileName(String str) {
        return str.substring(str.lastIndexOf("\\") + 1);
    }

    public String getFileName() {
        return getFileName(getAbsolutePath());
    }

    public String getExtension() {
        return extensionOf(getAbsolutePath());
    }

    public Overwriter overwrite() {
        overwrite(getAbsolutePath());
        return this;
    }

    public String overwrite(String str) {

        if (!extensionOf(str).isEmpty()) {
            if (isOriginalFileName(str, extensionOf(str))) {
                str = new StringBuilder(str).insert(str.lastIndexOf('.'), "(1)").toString();
            } else if (str.contains("(") && str.contains(")")) {
                String sub = str.substring(str.lastIndexOf("(") + 1, str.lastIndexOf(").".concat(extensionOf(str))));
                str = str.replace(sub, String.valueOf(getDigit(sub) + 1));
            }
        } else {
            if (isOriginalFileName(str, extensionOf(str))) {
                str = str.concat("(1)");
            } else {
                String sub = str.substring(str.lastIndexOf("(") + 1, str.lastIndexOf(")"));
                str = str.replace(sub, String.valueOf(getDigit(sub) + 1));
            }
//            if (str.contains("(") && str.endsWith(")")) {
//                if (isDigit(str.substring(str.lastIndexOf("(") + 1, str.lastIndexOf(")")))) {
//                    String sub = str.substring(str.lastIndexOf("(") + 1, str.lastIndexOf(")"));
//                    str = str.replace(sub, String.valueOf(getDigit(sub) + 1));
//                }
//
//            } else {
//                
//            }
        }
        return str;
    }

    public File overwriteFile() {
        return new File(overwrite(getAbsolutePath()));
    }

    public File overwriteFile(File f) {
        return new File(overwrite(f.getAbsolutePath()));
    }

    public File getFile() {
        return f;
    }

    public boolean isValidFileName(String str, String extension) {
        return str.endsWith(".".concat(extension));
    }

    public boolean isValidFileName() {
        return isValidFileName(getAbsolutePath(), getExtension());
    }

    public boolean isOriginaFileName() {
        return isOriginalFileName(getAbsolutePath(), extensionOf(getAbsolutePath()));
    }

    public boolean isOriginalFileName(String str, String extension) {
        if (str.contains("(") && str.contains(").".concat(extension))) {
            try {
                if (isDigit(str.substring(str.lastIndexOf("(") + 1, str.lastIndexOf(").".concat(extension))))) {
                    return false;
                } else {
                    return true;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                return true;
            }
        } else if (extensionOf(str).isEmpty()) {
            try {
                if (str.endsWith(")") && isDigit(str.substring(str.lastIndexOf("(") + 1, str.lastIndexOf(")")))) {
                    return false;
                } else {
                    return true;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                return true;
            }
        }
        return true;

    }

    private boolean isDigit(String str) {
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

    private int getDigit(String str) {
        return Integer.valueOf(str);
    }

    public String getAbsolutePath() {
        return f.getAbsolutePath();
    }

    public File getF() {
        return f;
    }

    @Override
    public String toString() {
        return f.getAbsolutePath();
    }

}
