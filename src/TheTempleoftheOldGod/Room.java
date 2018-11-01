package TheTempleoftheOldGod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Room {

    private int RoomID;
    private String roomTitle;
    private String roomDesc;
    private String[] interactions;
    private String roomItem;
    private String roomMons;
    private String roomPuzzle;
    private String[] exitRooms;

    public Map<String, String> interactionMap = new HashMap<String, String>();


    public Room() {

    }

    public int getRoomID() {

        return RoomID;
    }

    public void setRoomID(int roomID) {

        RoomID = roomID;
    }

    public String[] getInteractions() {
        return interactions;
    }

    public void setInteractions(String[] interactions) {
        this.interactions = interactions;
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

    public String getRoomItem() {

        return roomItem;
    }

    public void setRoomItem(String roomItem) {

        this.roomItem = roomItem;
    }

    public String getRoomMons() {

        return roomMons;
    }

    public void setRoomMons(String roomMons) {

        this.roomMons = roomMons;
    }

    public String getRoomPuzzle() {

        return roomPuzzle;
    }

    public void setRoomPuzzle(String roomPuzzle) {

        this.roomPuzzle = roomPuzzle;
    }

    public String[] getExitRooms() {

        return exitRooms;
    }

    public void setExitRooms(String[] exitRooms) {

        this.exitRooms = exitRooms;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomID=" + RoomID +
                ", roomTitle='" + roomTitle + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                ", interactions=" + Arrays.toString(interactions) +
                ", roomItem='" + roomItem + '\'' +
                ", roomMons='" + roomMons + '\'' +
                ", roomPuzzle='" + roomPuzzle + '\'' +
                ", exitRooms=" + Arrays.toString(exitRooms) +
                '}';
    }

    public ArrayList extractAllRoomTitles(Room[] rooms) {
        ArrayList titleList = new ArrayList();
        for (int i = 0; i < rooms.length; i++) {
            titleList.add(rooms[i].getRoomTitle());
        }
        return titleList;
    }

    public ArrayList extractExitRooms(String currentRoomTitle, Room[] rooms) {
        ArrayList exitList = new ArrayList();
        for (int i = 0; i < rooms.length; i++) {
            if (currentRoomTitle.equalsIgnoreCase(rooms[i].getRoomTitle())) {
                exitList.add(Arrays.toString(rooms[i].getExitRooms()));
            }
        }
        return exitList;
    }

    public String extractRoomDesc(String currentRoomTitle, Room[] rooms) {
        String s = "";
        for (int i = 0; i < rooms.length; i++) {
            if (currentRoomTitle.equalsIgnoreCase(rooms[i].getRoomTitle())) {
                s = rooms[i].getRoomDesc();
            }
        }
        return s;
    }

    public boolean checkRoom(String currentRoomTitle, Room[] rooms) {
        boolean b = false;
        for (int i = 0; i < rooms.length; i++) {
            if (currentRoomTitle.equalsIgnoreCase(rooms[i].getRoomTitle())) {
                b = true;
                break;
            } else {
                b = false;
            }
        }
        return b;
    }

    public void extractRoomInter(String currentRoomTitle, Room[] rooms) {
        ArrayList<String> roomIner = new ArrayList();
        interactionMap.clear();
        for (int i = 0; i < rooms.length; i++) {
            if (currentRoomTitle.equalsIgnoreCase(rooms[i].getRoomTitle())) {
                //ENHANCED FOR LOOP>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> BELOW
                // for(String s: rooms[i].getInteractions()){
                // }
                for (int x = 0; x < rooms[i].getInteractions().length; x++) {
                    String s = rooms[i].getInteractions()[x];
                    roomIner.add(s);
                }
            }
        }
        for (String s : roomIner) {
            String[] holder = s.split("#");
            interactionMap.put(holder[0], holder[1]);
        }
    }


}


