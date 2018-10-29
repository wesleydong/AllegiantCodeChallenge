package com.allegiant;

import java.util.List;

/**
 * Implement these methods;
 */
public class WidgetManager {


    private List<Widget> widgets;

    /**
     * Returns the widget with the given id. If none is found, this method will return null;
     */
    public Widget get(int id) {
        return null;
    }

    /**
     * Adds the given widget to the manager.
     *
     */
    public void add(Widget addWidget) {}

    /**
     * Deletes the given widget from the manaager
     */
    public void delete(Widget deleteWidget) {}

    /**
     * Updates the widget with the given widget's id.
     * @Throws IllegalArgumentException if no widget with that ID is found
     */
    public void update(Widget updateWidget) {}

    /**
     * Adds the given sprocket to the widget with the given ID.
     * @Throws IllegalArgumentException if no such widget is found.
     */
    public void addSprocket(int widgetId, Sprocket sprocket) {

    }

    /**
     * Returns the sum of the prices of the sprockets in the given widget
     * @param widgetId
     * @throws IllegalArgumentException if no widget with that ID is found
     */
    public Double getTotalPrice (int widgetId) {
        return null;
    }

    /**
     *
     * returns all widgets whose title contains the given search string. (Use a case insensitive comparison)
     */
    public List<Widget> searchByTitle(String title) {
        return null;
    }

    /**
     * Returns all widgets whose description contains the given search string. (Use a case insensitive comparison)
     */
    public List<Widget> searchByDescription(String description){
        return null;
    }

    /**
     * Returns the given input list sorted by title in ascending lexicographic order. ("Alpha","Beta","Charlie"...)
     *
     */
    public List<Widget> sortByTitle(List<Widget> inputs) {
        return null;
    }

    /**
     * Returns the given input list sorted in order of the average saturation value of the color attributes of each widgets sprockets.
     */
    public List<Widget> sortBySaturation(List<Widget> inputs) {
        return null;
    }



}
