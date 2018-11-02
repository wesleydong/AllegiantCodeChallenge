package com.allegiant;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class WidgetReader {

    /**
     *
     * Reads data from the given input stream and attempts to parse it as a List of com.allegiant.Widget Objects, including their underlying sprockets.
     * @throws IOException
     */
    public static List<Widget> readFile(InputStream fileIn) throws IOException {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(fileIn, "UTF-8"));
        List<Widget> widgets = new ArrayList<Widget>();
        reader.beginArray();

        while (reader.hasNext()) {
            Widget w = gson.fromJson(reader, Widget.class);
            widgets.add(w);
        }
        reader.endArray();
        reader.close();
        return widgets;

        // I had originally went through an incredibly long way of trying to use the JsonReader
        // and I realized that the purpose of gson was to do the same thing in a more dynamic fashion.
        /*JsonReader reader = new JsonReader(new InputStreamReader(fileIn,"UTF-8"));
        try {
            return readWidgetsArray(reader);
        } finally {
            reader.close();
        }*/
    }


    /*
    public List<Widget> readWidgetsArray(JsonReader reader) throws IOException {
        List<Widget> w = new ArrayList<Widget>();

        reader.beginArray();
        while (reader.hasNext()) {
            w.add(readWidget(reader));
        }
        reader.endArray();
        return w;
    }

    public Widget readWidget(JsonReader reader) throws IOException {

        int id = -1;
        String title = null;
        String description = null;
        List<Sprocket> sprocket = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextInt();
            } else if (name.equals("title")) {
                title = reader.nextString();
            } else if (name.equals("sprocket") && reader.peek() != JsonToken.NULL) {
                sprocket = readSprocketArray(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Widget(id);
    }

    public List<Sprocket> readSprocketArray(JsonReader reader) throws IOException {
        List<Sprocket> sprockets = new ArrayList<Sprocket>();

        reader.beginArray();
        while (reader.hasNext()) {
            sprockets.add(readSprocket(reader));
        }
        reader.endArray();
        return sprockets;
    }

    public Sprocket readSprocket(JsonReader reader) throws IOException {
        int id = -1;
        Color color = null;
        double price = -1;

        reader.beginObject();
        while(reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextInt();
            } else if (name.equals("color")) {
                color = readColor(reader);
            } else if (name.equals("price")) {
                price = reader.nextDouble();
            }
        }
        reader.endObject();
        return new Sprocket(id, color, price);
    }

    public Color readColor(JsonReader reader) throws IOException {
        int red = -1;
        int green = -1;
        int blue = -1;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("red")) {
                red = reader.nextInt();
            } else if (name.equals("green")) {
                green = reader.nextInt();
            } else if (name.equals("blue")) {
                blue = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Color(red, green, blue);
    }*/

    /**
     * Writes the given list of com.allegiant.Widget objects to the given outputStream
     * @throws IOException
     */
    public void writeFile(OutputStream fileOut, List<Widget> widgets) throws IOException {
        Gson gson = new Gson();
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(fileOut, "UTF-8"));
        writer.setIndent("  ");
        writer.beginArray();
        for (Widget w : widgets) {
            gson.toJson(w, Widget.class, writer);
        }
        writer.endArray();
        writer.close();
    }

    public static void main (String[] args) throws IOException {

        InputStream in = new FileInputStream("/Users/wesleydong/IdeaProjects/AllegiantCodeChallenge2/widgets/resources/widgets.JSON");
        List<Widget> results = readFile(in);

        System.out.println(results.size());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(results);
        System.out.println(json);
    }


}
