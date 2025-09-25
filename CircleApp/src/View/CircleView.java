package View;

import Model.ICircleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public final class CircleView extends JFrame {
    private final JButton btnMinus = new JButton("-");
    private final JButton btnPlus = new JButton("+");
    private final JLabel radiusLabel = new JLabel("", SwingConstants.CENTER);
    private final DrawingPanel drawingPanel;

    public CircleView(ICircleModel circleModel) {
        super("Circle View");
        this.drawingPanel = new DrawingPanel(circleModel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel top = new JPanel(new BorderLayout());
        top.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        radiusLabel.setFont(radiusLabel.getFont().deriveFont(Font.BOLD, 16f));
        top.add(radiusLabel, BorderLayout.CENTER);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 8));
        controls.add(btnMinus);
        controls.add(btnPlus);

        add(top, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        setSize(420, 420);
        setLocationRelativeTo(null);
    }

    public void onIncrease(ActionListener listener) { btnPlus.addActionListener(listener); }
    public void onDecrease(ActionListener listener) { btnMinus.addActionListener(listener); }

    public void setRadiusText(int radius) {
        radiusLabel.setText("Radius: " + radius + "px");
    }
    public void redraw() { drawingPanel.repaint(); }
}
