import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Room {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Create JsonParser Object
        JSONParser jp = new JSONParser();
        try (FileReader r = new FileReader("res/Items.json")) {

            Object fileObject = jp.parse(r);

            //Create Json Array
            JSONArray roomList = (JSONArray) fileObject;

            //This Prints out all of the rooms object
            //System.out.println(roomList);

            roomList.forEach(emp -> parseRoomObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String parseRoomObject(JSONObject items) {

       /* JSONObject er = (JSONObject) items.get("rooms");
        String roomID = (String) er.get("roomID");
        System.out.println("Room ID:"+ roomID);
        System.out.println("");
        String roomTitle = (String) er.get("roomTitle");
        System.out.println("Room Title: " + roomTitle);
        System.out.println("");
        String roomDesc = (String) er.get("roomDesc");
        System.out.println("Room Description: " + roomDesc);
        System.out.println("");

        return roomID;*/

        JSONObject er = (JSONObject) items.get("rooms");
        System.out.println("Room ID:"+ room01);
    }
}
