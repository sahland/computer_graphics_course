import Controller.CircleController;
import Model.CircleModel;
import Model.ICircleModel;
import View.CircleView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ICircleModel model = new CircleModel(60, 10, 150);
            CircleView view = new CircleView(model);
            new CircleController(model, view);
            view.setVisible(true);
        });
    }
}