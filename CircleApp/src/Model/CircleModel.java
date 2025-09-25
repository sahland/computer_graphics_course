package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class CircleModel implements ICircleModel {
    public static final String PROP_RADIUS = ICircleModel.PROP_RADIUS;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final int minRadius;
    private final int maxRadius;
    private int radius;

    public CircleModel(int initial, int minRadius, int maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radius = clamp(initial);
    }

    @Override
    public int getRadius() { return this.radius; }

    @Override
    public void setRadius(int radius) {
        int newVal = clamp(radius);
        if (newVal != this.radius) {
            int old = this.radius;
            this.radius = newVal;
            pcs.firePropertyChange(PROP_RADIUS, old, newVal);
        }
    }

    @Override
    public void increment(int step) { setRadius(this.radius + step); }

    @Override
    public void decrement(int step) { setRadius(this.radius - step); }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) { pcs.addPropertyChangeListener(listener); }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) { pcs.removePropertyChangeListener(listener); }

    @Override
    public int clamp(int radius) {
        return Math.max(minRadius, Math.min(maxRadius, radius));
    }
}
