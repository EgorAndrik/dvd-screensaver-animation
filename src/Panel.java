import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {
    private int x = 0, y = 10, xSpeed = 2, ySpeed = 4, width = 100, height = 100;
    private final BufferedImage dvdPictur = ImageIO.read(new File("src/dvd-logo-icon-download-icons-20.png"));
    private JLabel dvd = new JLabel(
            new ImageIcon(dvdPictur.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH))
    );

    public Panel() throws IOException {
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.BLACK);

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update position
                x += xSpeed;
                y += ySpeed;

                // Wrap around if exceeding panel bounds
                if (x + dvd.getWidth() > getWidth() && x + dvd.getWidth() > 0) {
                    xSpeed = -xSpeed;
                } else if (x <= 0) {
                    xSpeed = -1 * xSpeed;
                } else {
                    xSpeed = xSpeed;
                }

                if (y + dvd.getHeight() > getHeight() && y + dvd.getHeight() > 0) {
                    ySpeed = -ySpeed;
                } else if (y <= 0) {
                    ySpeed = -1 * ySpeed;
                } else {
                    ySpeed = ySpeed;
                }

//                System.out.println(x + " cords " + y);

                // Repaint panel
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dvd.setSize(width, height);
        dvd.setLocation(x, y);
        add(dvd);
    }
}
