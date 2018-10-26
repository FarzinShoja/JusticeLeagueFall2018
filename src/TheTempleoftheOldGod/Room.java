package TheTempleoftheOldGod;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Room {

    private int RoomID;
    private String roomTitile;
    private String roomDesc;
    private String roomItem;
    private int roomNorth;
    private int roomSouth;
    private int roomEast;
    private int roomWest;


    public Room() {

    }

    public Room(int roomID, String roomTitile, String roomDesc, String roomItem, int roomNorth, int roomSouth, int roomEast, int roomWest) {
        RoomID = roomID;
        this.roomTitile = roomTitile;
        this.roomDesc = roomDesc;
        this.roomItem = roomItem;
        this.roomNorth = roomNorth;
        this.roomSouth = roomSouth;
        this.roomEast = roomEast;
        this.roomWest = roomWest;
    }

    public int getRoomID() {
        return RoomID;
    }

    public String getRoomTitile() {
        return roomTitile;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public String getRoomItem() {
        return roomItem;
    }

    public int getRoomNorth() {
        return roomNorth;
    }

    public int getRoomSouth() {
        return roomSouth;
    }

    public int getRoomEast() {
        return roomEast;
    }

    public int getRoomWest() {
        return roomWest;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public void setRoomTitile(String roomTitile) {
        this.roomTitile = roomTitile;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public void setRoomItem(String roomItem) {
        this.roomItem = roomItem;
    }

    public void setRoomNorth(int roomNorth) {
        this.roomNorth = roomNorth;
    }

    public void setRoomSouth(int roomSouth) {
        this.roomSouth = roomSouth;
    }

    public void setRoomEast(int roomEast) {
        this.roomEast = roomEast;
    }

    public void setRoomWest(int roomWest) {
        this.roomWest = roomWest;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomID=" + RoomID +
                ", roomTitile='" + roomTitile + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                ", roomItem='" + roomItem + '\'' +
                ", roomNorth=" + roomNorth +
                ", roomSouth=" + roomSouth +
                ", roomEast=" + roomEast +
                ", roomWest=" + roomWest +
                '}';
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Create JsonParser Object
        JSONParser jp = new JSONParser();
        try (FileReader r = new FileReader("res/Rooms.json")) {

            Object fileObject = jp.parse(r);

            //Create Json Array
            JSONArray roomList = (JSONArray) fileObject;

            //This Prints out all of the rooms object
            //System.out.println(roomList);

            roomList.forEach(emp -> parseRoomObject((JSONObject) emp));
            //System.out.println(roomList);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String parseRoomObject(JSONObject rooms) {

        //System.out.println(rooms);
        if (rooms.containsKey("rooms2")) {
            //  System.out.println(rooms);
            JSONObject er = (JSONObject) rooms.get("rooms2");    // <-------- Example to pick whatever you want from the json file
            System.out.println("\n" + er.get("roomDesc"));
        }
//        JSONObject er = (JSONObject) rooms.get("rooms1");


//        String roomID = (String) er.get("roomID");
//        System.out.println("Room ID:"+ roomID);
//        System.out.println("");
//        String roomTitle = (String) er.get("roomTitle");
//        System.out.println("Room Title: " + roomTitle);
//        System.out.println("");
//        String roomDesc = (String) er.get("roomDesc");
//        System.out.println("Room Description: " + roomDesc);
//        System.out.println("");

        return null;
    }


}
