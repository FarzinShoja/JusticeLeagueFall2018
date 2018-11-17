package TheTempleoftheOldGod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;


public class ReadJSonFile {

    public Room[] rooms;
    public Item[] items;

    public ReadJSonFile() {
        try {
            readRoomJson();
            readItemJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////This Method Is Responsible for Reading The Room JSON File, and Returns it in Array
    public void readRoomJson() throws Exception {
        String str1 = FileUtils.readFileToString(new File("res/Rooms.json"), StandardCharsets.UTF_8);
        ObjectMapper om1 = new ObjectMapper();
        rooms = om1.readValue(str1, Room[].class);
    }

    //This Method Is Responsible for Reading The Item JSON File, and Returns it in Array
    public void readItemJson() throws Exception {
        String str1 = FileUtils.readFileToString(new File("res/Items.json"), StandardCharsets.UTF_8);
        ObjectMapper om1 = new ObjectMapper();
        items = om1.readValue(str1, Item[].class);
    }
}

