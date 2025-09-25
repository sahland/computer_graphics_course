package Controller;

import Model.ICircleModel;
import View.CircleView;

import java.beans.PropertyChangeListener;

public class CircleController {
    private final ICircleModel model;
    private final CircleView view;

    public CircleController(ICircleModel model, CircleView view){
        this.model = model;
        this.view = view;

        // Подписка на UI
        view.onIncrease(e -> model.increment(5));
        view.onDecrease(e -> model.decrement(5));

        // Подписка на изменение модели
        PropertyChangeListener listener = evt -> {
            if (ICircleModel.PROP_RADIUS.equals(evt.getPropertyName())) {
                int radius = (int) evt.getNewValue();
                view.setRadiusText(radius);
                view.redraw();
            }
        };
        model.addPropertyChangeListener(listener);

        view.setRadiusText(model.getRadius());
        view.redraw();
    }
}
