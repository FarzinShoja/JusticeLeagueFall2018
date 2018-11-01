package TheTempleoftheOldGod;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ReadJSonExample read = new ReadJSonExample();
        Room r = new Room();
        Room[] roomsHolder = read.rooms;


        //System.out.println(Arrays.toString(roomsHolder));
        //System.out.println(r.extractAllRoomTitles(roomsHolder));

//        System.out.println(
//
//                r.extractAllRoomTitles(roomsHolder).get(1)
//
//        );
//
//        System.out.println(
//
//                r.extractExitRooms("Outside",roomsHolder
//        ));
//
//        //This to get room Description, if the room title doesn't exits return try again
//        if(!r.checkRoom("Outside", roomsHolder)){
//            System.out.println("Try again");
//        }else{
//            System.out.println(
//                    r.extractRoomDesc("outside", roomsHolder
//                    ));
//        }


        r.extractRoomInter("Outside", roomsHolder);

        if (r.interactionMap.containsKey("Check Rubble")) {
            System.out.println(r.interactionMap.get("Check Rubble"));
        }


    }

}
