package TheTempleoftheOldGod;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Room {

    private int RoomID;
    private String allRoomTitles;
    private String roomTitle;
    private String roomDesc;
    private String roomItem;
    private String roomMons;
    private String roomPuzzle;
    private JSONArray roomExits;
    private String roomExit1;
    private String roomExit2;
    private String roomExit3;
    private String roomExit4;


    public String getRoomMons() {
        return roomMons;
    }

    public void setRoomMons(String roomMons) {
        this.roomMons = roomMons;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public String getAllRoomTitles() {
        return allRoomTitles;
    }

    public void setAllRoomTitles(String allRoomTitles) {
        this.allRoomTitles = allRoomTitles;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomPuzzle() {
        return roomPuzzle;
    }

    public void setRoomPuzzle(String roomPuzzle) {
        this.roomPuzzle = roomPuzzle;
    }

    public JSONArray getRoomExits() {
        return roomExits;
    }

    public void setRoomExits(JSONArray roomExits) {
        this.roomExits = roomExits;
    }

    public String getRoomExit1() {
        return roomExit1;
    }

    public void setRoomExit1(String roomExit1) {
        this.roomExit1 = roomExit1;
    }

    public String getRoomExit2() {
        return roomExit2;
    }

    public void setRoomExit2(String roomExit2) {
        this.roomExit2 = roomExit2;
    }

    public String getRoomExit3() {
        return roomExit3;
    }

    public void setRoomExit3(String roomExit3) {
        this.roomExit3 = roomExit3;
    }

    public String getRoomExit4() {
        return roomExit4;
    }

    public void setRoomExit4(String roomExit4) {
        this.roomExit4 = roomExit4;
    }

    public String getRoomItem() {
        return roomItem;
    }

    private void setRoomItem(String roomItem) {
        this.roomItem = roomItem;
    }

    public void getCurrentRoomInfo(String roomT, JSONObject rooms) {


        JSONObject jo = (JSONObject) rooms.get("rooms");

        //This Gives me the Room-ID from JSon File

        if (roomT.equalsIgnoreCase(jo.get("roomTitle").toString())) {
            setRoomTitle((String) jo.get("roomTitle"));
            setRoomDesc((String) jo.get("roomDesc"));
            setRoomMons((String) jo.get("roomMons"));
            setRoomItem((String) jo.get("roomItem"));
            setRoomPuzzle((String) jo.get("roomPuzzle"));
            setRoomExit1((String) jo.get("roomExit1"));
            setRoomExit2((String) jo.get("roomExit2"));
            setRoomExit3((String) jo.get("roomExit3"));
            setRoomExit4((String) jo.get("roomExit4"));
        }
    }

    public void allRoomTitle(JSONObject rooms) {

        JSONObject jo = (JSONObject) rooms.get("rooms");
        System.out.println("The Room Title-> " + jo.get("roomTitle"));
    }
}

