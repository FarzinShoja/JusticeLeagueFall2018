package TheTempleoftheOldGod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;


public class ReadJSonExample {

    public Item[] items;

    public ReadJSonExample() {
        try {
            readItemJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This Method Reads The Item JSON File, and Returns in Array
    public void readItemJson() throws Exception {
        String str1 = FileUtils.readFileToString(new File("res/Items.json"), StandardCharsets.UTF_8);
        ObjectMapper om1 = new ObjectMapper();
        items = om1.readValue(str1, Item[].class);
    }


}

