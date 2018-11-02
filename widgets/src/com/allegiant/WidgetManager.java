package com.allegiant;

import java.util.List;
import java.util.*;
import java.lang.*;

class TitleCompare implements Comparator<Widget> {

    @Override
    public int compare(Widget o1, Widget o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

class SaturationCompare implements Comparator<Sprocket> {

    @Override
    public int compare(Sprocket s1, Sprocket s2) {
        if (s1.getSaturation() < s2.getSaturation()) return -1;
        if (s1.getSaturation() > s2.getSaturation()) return 1;
        return 0;
    }
}
/**
 * Implement these methods;
 */
public class WidgetManager {


    private List<Widget> widgets = new ArrayList<Widget>();

    /**
     * Returns the widget with the given id. If none is found, this method will return null;
     *
     * @param id the id of the widget
     * @return an int of the id of the widget or null if id was not found
     */
    public Widget get(int id) {

        for (Widget w : widgets) {
            if (w.getId() == id)
                return w;
        }

        return null;
    }

    /**
     * Adds the given widget to the manager.
     *
     * @param addWidget the Widget to be appended to widgets
     */
    public void add(Widget addWidget) {

        widgets.add(addWidget);
    }

    /**
     * Deletes the given widget from the manager
     *
     * @param deleteWidget the widget that needs to be deleted from widgets
     */
    public void delete(Widget deleteWidget) {

        widgets.remove(deleteWidget);
    }

    /**
     * Updates the widget with the given widget's id.
     *
     * @param updateWidget a widget to be updated in the list
     * @Throws IllegalArgumentException if no widget with that ID is found
     */
    public void update(Widget updateWidget) {

        int widgetId = updateWidget.getId();
        Widget w = get(widgetId);

        if (w == null)
            throw new IllegalArgumentException();

        delete(w);          // since index and Id are separate, I found that it was difficult to use set()
        add(updateWidget);
    }

    /**
     * Adds the given sprocket to the widget with the given ID.
     *
     * @param sprocket the sprocket that will be appended to Widget of widgetId
     * @param widgetId the id of the Widget
     * @throws IllegalArgumentException if no such widget is found.
     */
    public void addSprocket(int widgetId, Sprocket sprocket) {

        Widget w = get(widgetId);

        if (w == null)
            throw new IllegalArgumentException();

        w.addSprocket(sprocket);
        update(w);
    }

    /**
     * Returns the sum of the prices of the sprockets in the given widget
     *
     * @param widgetId the id of the Widget
     * @return the sum of the prices of sprockets of a Widget
     * @throws IllegalArgumentException if no widget with that ID is found
     */
    public Double getTotalPrice (int widgetId) {

        Widget w = get(widgetId);

        if (w == null)
            throw new IllegalArgumentException();

        List<Sprocket> list =  w.getSprockets();
        double sum = 0;

        for (Sprocket s : list) {
            sum += s.getPrice();
        }

        return sum;
    }

    /**
     * Returns all widgets whose title contains the given search string. (Use a case insensitive comparison)
     *
     * @param title the String to be compared to
     * @return a list of Widgets with titles matching the search String
     */
    public List<Widget> searchByTitle(String title) {

        List<Widget> searchedList = new ArrayList<Widget>();

        for (Widget w : widgets) {
            if (w.getTitle().equalsIgnoreCase(title))
                searchedList.add(w);
        }

        return searchedList;
    }

    /**
     * Returns all widgets whose description contains the given search string. (Use a case insensitive comparison)
     *
     * @param description the String to be compared to
     * @return a list of Widgets with descriptions matching the search String
     */
    public List<Widget> searchByDescription(String description) {

        List<Widget> searchedList = new ArrayList<Widget>();

        for (Widget w : widgets) {
            if (w.getDescription().equalsIgnoreCase(description))
                searchedList.add(w);
        }

        return searchedList;
    }

    /**
     * Returns the given input list sorted by title in ascending lexicographic order. ("Alpha","Beta","Charlie"...)
     *
     * @param inputs a list of Widgets
     * @return the list of inputs sorted based on ascending order
     */
    public List<Widget> sortByTitle(List<Widget> inputs) {
        Collections.sort(inputs, new TitleCompare());

        return inputs;
    }

    /**
     * Returns the given input list sorted in order of the average saturation value of the color attributes of each widgets sprockets.
     *
     * @param inputs a list of Widgets
     * @return the list of inputs sorted based on saturation
     */
    public List<Widget> sortBySaturation(List<Widget> inputs) {

        List<Widget> sortedSaturation = new ArrayList<>();
        for (Widget w: inputs) {
            List<Sprocket> sprockets = w.getSprockets();

            for(Sprocket s: sprockets) {
                double red = (double)s.getColor().getRed() / 255;
                double green = (double)s.getColor().getGreen() / 255;
                double blue = (double)s.getColor().getBlue() / 255;

                double maxRGB = Math.max(Math.max(red, green), blue);
                double minRGB = Math.min(Math.min(red, green), blue);

                double luminosity = .5*(maxRGB + minRGB);
                //System.out.println(luminosity);
                double saturation = 0;
                if (luminosity < 1) {
                    saturation = (maxRGB - minRGB) / (1 - Math.abs(2*luminosity - 1));

                }

                if (luminosity == 1) {
                    saturation = 0;
                }

                //System.out.println(s.getSaturation());
                s.setSaturation(saturation);
            }

            Collections.sort(sprockets, new SaturationCompare());
            w.setSprockets(sprockets);
            sortedSaturation.add(w);
        }


        return sortedSaturation;
    }


}
