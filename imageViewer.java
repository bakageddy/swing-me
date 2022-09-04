import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class imageViewer {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("Usage: imageViewer <path_to_image>");
            return;
        } else {
            String path = args[0];
            File dir = new File(path);
            File files[] = dir.listFiles();
            List<File> list = Arrays.asList(files);
            for (File file: list) {
                if (file.getName().endsWith(".jpg")) {
                    continue;
                } else {
                    list.remove(file);
                }
            }
            try {
                ImageDrawer myView = new ImageDrawer(list);
                myView.go();
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

class ImageDrawer {
    JFrame win;
    JButton next, prev;
    JLabel image;
    int pos;
    List<File> myList;
    public ImageDrawer(List<File> list) throws IOException {
        win = new JFrame();
        next = new JButton("→");
        prev = new JButton("←");
        image = new JLabel();
        myList = list;
        win.setLayout(new FlowLayout());

        win.setVisible(true);
        win.setSize(1600, 900);
        next.setLocation(new Point(200 , 200));
        prev.setLocation(new Point(200, 500));


        win.setResizable(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        win.add(next);
        win.add(image);
        win.add(prev);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pos + 1 == myList.size()) {
                    // Do nothing
                    return;
                }
                pos++;
                try {
                    go();
                } catch (IOException err) {
                    System.out.println(err.getMessage());
                }
            }
        });

        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pos - 1 < 0) {
                    // Do Nothing
                    return;
                }
                pos--;
                try {
                    go();
                } catch (IOException err) {
                    System.out.println(err.getMessage());
                }
            }
        });
    }

    public void go() throws IOException {
        File img = myList.get(pos);
        BufferedImage imgBuffer = ImageIO.read(img);
        ImageIcon foo = new ImageIcon(imgBuffer);
        image.setIcon(foo);
    }
}
