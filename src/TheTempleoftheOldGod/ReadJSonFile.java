package TheTempleoftheOldGod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;


public class ReadJSonFile {

    public Room[] rooms;
    public Item[] items;
    public Monster[] monsters;
    public Puzzle[] puzzles;

    public ReadJSonFile() {
        try {
            readRoomJson();
            readItemJson();
            readMonsterJson();
            readPuzzleJson();
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

    //This Method Is Responsible for Reading The Monster JSON File, and Returns it in Array
    public void readMonsterJson() throws Exception {
        String str1 = FileUtils.readFileToString(new File("res/Monsters.json"), StandardCharsets.UTF_8);
        ObjectMapper om1 = new ObjectMapper();
        monsters = om1.readValue(str1, Monster[].class);
    }

    //This Method Is Responsible for Reading The Puzzle JSON File, and Returns it in Array
    public void readPuzzleJson() throws Exception {
        String str1 = FileUtils.readFileToString(new File("res/Puzzles.json"), StandardCharsets.UTF_8);
        ObjectMapper om1 = new ObjectMapper();
        puzzles = om1.readValue(str1, Puzzle[].class);
    }
}

