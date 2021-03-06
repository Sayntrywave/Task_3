package course1;

import util.Customer;
import util.SwingUtils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Queue;


public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }
}
