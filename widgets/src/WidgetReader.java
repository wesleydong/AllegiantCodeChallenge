import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WidgetReader {

    /**
     *
     * Reads data from the given input stream and attempts to parse it as a List of Widget Objects, including their underlying sprockets.
     * @throws IOException
     */
    public static List<Widget> readFile(InputStream fileIn) throws IOException {
        return null;
    }

    /**
     * Writes the given list of Widget objects to the given outputStream
     * @throws IOException
     */
    public void writeFile(OutputStream fileOut, List<Widget> widgets) throws IOException {

    }

    public static void main (String[] args) throws IOException{
        InputStream in = new FileInputStream(".....");
        List<Widget> results = readFile(in);
        System.out.println(results.size());
    }


}
