package TheTempleoftheOldGod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.nio.charset.StandardCharsets;


public class ReadJSonFile {

    public Room[] rooms;

    public ReadJSonFile() {
        try {
            readRoomJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This Method Reads The Room JSON File, and Returns in Array
    public void readRoomJson() throws Exception {
        String str1 = FileUtils.readFileToString(new File("res/Rooms.json"), StandardCharsets.UTF_8);
        ObjectMapper om1 = new ObjectMapper();
        rooms = om1.readValue(str1, Room[].class);
    }

}

