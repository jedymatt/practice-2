package testlearning;
import java.io.File;

public class Overwriter {

    private File file;
    private String filePath;
    private String fileName;
    private String name;
    private String extension;

    public Overwriter(String fileName, String extension) {
        
        this.fileName = fileName;
        this.extension = extension;
        setName(fileName);

    }
    
    public Overwriter(File f){
        file = f;
        filePath = f.getAbsolutePath();
        fileName = f.getName();
        extension = fileName.substring(fileName.lastIndexOf(".") +1);
        setName(fileName);
    }

    private void setName(String fileName) {
        if (fileName.endsWith(".".concat(extension))) {
            name = fileName.substring(0, fileName.lastIndexOf(extension));
        } else {
            throw new NullPointerException("File has no extension!");
        }

    }

//    public FileOverwriter overwrite(int num) {
//        FileOverwriter another = new FileOverwriter(fileName, extension);
//        for (int i = 0; i < num; i++) {
//            another = new FileOverwriter(another.fileName, another.extension).overwrite();
//        }
//        return another;
//    }

    private String overwriteFileName() {
        if (isOriginaFileName()) {
            fileName = new StringBuilder(name).insert(name.lastIndexOf('.'), "(1)").append(extension).toString();
        } else {
            String sub = fileName.substring(fileName.lastIndexOf("(") + 1, fileName.lastIndexOf(").".concat(extension)));
            fileName = name.replace(sub, String.valueOf(getDigit(sub) + 1)).concat(extension);
        }
        return fileName;
    }

    public String overwritePath() {
        filePath = filePath.substring(0, filePath.lastIndexOf(fileName)).concat(overwriteFileName());
        return filePath;
    }
    
    public File overwriteFile() {
        return file = new File(overwritePath());
    }

    private boolean isOriginaFileName() {
        if (fileName.contains("(") && fileName.contains(").".concat(extension))) {
            try {
                if (isDigit(fileName.substring(fileName.lastIndexOf("(") + 1, fileName.lastIndexOf(").".concat(extension))))) {
                    return false;
                } else {
                    return true;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                ex.printStackTrace();
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

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return fileName;
    }

}
