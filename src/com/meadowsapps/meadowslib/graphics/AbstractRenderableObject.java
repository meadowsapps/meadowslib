package com.meadowsapps.meadowslib.graphics;

import java.awt.*;

/**
 * Created by dmeadows on 9/9/16.
 */
public abstract class AbstractRenderableObject implements RenderableI {

    /**
     * The location of the Renderable object
     */
    private Point location;

    /**
     * The size of the Renderable object
     */
    private Dimension size;

    /**
     * Determines if the Renderable needs to update
     */
    private boolean dirty = false;

    /**
     * Gets the location of the Renderable object inside of the Renderer
     *
     * @return the location of the Renderable
     */
    @Override
    public Point getLocation() {
        return location;
    }

    /**
     * Sets the location of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param location the new location of the Renderable
     */
    @Override
    public void setLocation(Point location) {
        this.location = location;
        setDirty(true);
    }

    /**
     * Sets the location of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param x the new x location of the Renderable
     * @param y the new y location of the Renderable
     */
    @Override
    public void setLocation(int x, int y) {
        if (this.location == null) {
            this.location = new Point();
        }
        this.location.setLocation(x, y);
        setDirty(true);
    }

    /**
     * Gets the size of the Renderable object inside of the Renderer
     *
     * @return the size of the Renderable
     */
    @Override
    public Dimension getSize() {
        return size;
    }

    /**
     * Sets the size of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param size the new size of the Renderable
     */
    @Override
    public void setSize(Dimension size) {
        this.size = size;
        setDirty(true);
    }

    /**
     * Sets the size of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param width  the new width of the Renderable
     * @param height the new height of the Renderable
     */
    @Override
    public void setSize(int width, int height) {
        if (this.size == null) {
            this.size = new Dimension();
        }
        this.size.setSize(width, height);
        setDirty(true);
    }

    /**
     * Gets if the Renderable object is dirty to determine if
     * the Renderer needs to update on it's next repaint cycle
     *
     * @return if the Renderable is dirty
     */
    @Override
    public boolean isDirty() {
        return dirty;
    }

    /**
     * Sets the dirty bit for the Renderable object so
     * the Renderer will update
     *
     * @param dirty new dirty state
     */
    @Override
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}
