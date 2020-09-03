//temporary

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClipboardHandler {

    private final static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    private ClipboardHandler() {

    }

    public static String getClipboardContents() {
        try {
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException ex) {
            Logger.getLogger(ClipboardHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void setClipboardContents(String str) {
        clipboard.setContents(new StringSelection(str), null);
    }
}
