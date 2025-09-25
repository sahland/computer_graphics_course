package View;

import Model.ICircleModel;

import javax.swing.*;
import java.awt.*;

public final class DrawingPanel extends JPanel {
    private final ICircleModel circleModel;

    public DrawingPanel(ICircleModel circleModel) {
        this.circleModel = circleModel;
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int radius = circleModel.getRadius();
            int diameter = radius * 2;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            g2.setStroke(new BasicStroke(2f));
            g2.drawOval(x, y, diameter, diameter);
        } finally {
            g2.dispose();
        }
    }
}
