package Model;

import java.beans.PropertyChangeListener;

public interface ICircleModel {
    public static final String PROP_RADIUS = "radius";

    int getRadius();
    void setRadius(int radius);

    void increment(int step);
    void decrement(int step);

    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);

    int clamp(int radius);
}
