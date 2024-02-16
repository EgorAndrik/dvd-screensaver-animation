import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void creatProgect() throws IOException {
        JFrame wind = new JFrame("DVD animation");
//        wind.setSize(800, 500);
//        wind.setResizable(false);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wind.setContentPane(new Panel());
        wind.pack();
        wind.setLocationRelativeTo(null);
        wind.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    creatProgect();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}