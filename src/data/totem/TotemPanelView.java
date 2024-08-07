package data.totem;

import javax.swing.*;
import java.awt.*;

public class TotemPanelView implements ITotemView{

    private JFrame frame;
    private JPanel panel;

    public TotemPanelView() {
        createAndShowGUI();
        createPanel(frame);
    }

    public void showText(String text){
        JLabel label = new JLabel(text);
        panel.add(label);

        refreshFrameAndPanel();
    }

    public void clearBuffer(){
        frame.remove(panel);
        panel.removeAll();
        frame.add(panel);

        refreshFrameAndPanel();
    }

    public void setTotemTitle(String title){
        frame.setTitle(title);
    }

    private void createPanel(JFrame frame){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);
    }

    private void createAndShowGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    private void refreshFrameAndPanel(){
        frame.remove(panel);

        panel.revalidate();
        panel.repaint();

        frame.add(panel);

        frame.revalidate();
        frame.repaint();
    }
}
