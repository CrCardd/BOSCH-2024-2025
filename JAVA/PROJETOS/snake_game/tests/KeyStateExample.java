import javax.swing.*;
import java.awt.event.*;

public class KeyStateExample {
    public static void main(String[] args) {
        // JFrame frame = new JFrame("Key State Example");
        // frame.setSize(300, 200);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // frame.addKeyListener(new KeyAdapter() {

        while (true) {
            keyPressed();
        }

        }
        // );
        
        // frame.setFocusable(true);
        // frame.setVisible(true);
        // }
        public void keyPressed(KeyEvent e) {
            if (e.isControlDown()) {
                System.out.println("Ctrl key is pressed");
            }
            if (e.isShiftDown()) {
                System.out.println("Shift key is pressed");
            }
            if (e.isAltDown()) {
                System.out.println("Alt key is pressed");
            }
        }
}
