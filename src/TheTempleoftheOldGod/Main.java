package TheTempleoftheOldGod;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Room roomClass;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        roomClass = new Room();

        //Create JsonParser Object
        JSONParser jp = new JSONParser();
        try (FileReader r = new FileReader("res/Rooms.json")) {

            Object fileObject = jp.parse(r);

            //Create Json Array
            JSONArray roomList = (JSONArray) fileObject;

            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("                                  ~******************* The Temple of the Old God Room Beta ********************~ ");
                System.out.println("                                   --------------------- Type help to get The Room Titles -------------------- ");
                System.out.println("                                    --------------------- Type Room Title Without Space --------------------- ");
                System.out.println("Enter Your Command: ");
                String rid = sc.next();

                if (rid.equalsIgnoreCase("help")) {
                    roomList.forEach(emp -> roomClass.allRoomTitle((JSONObject) emp));
                } else if (rid.equalsIgnoreCase("quit")) {
                    break;
                } else {
                    roomList.forEach(emp -> roomClass.getCurrentRoomInfo(rid, (JSONObject) emp));
                    System.out.println("Room Title: " + roomClass.getRoomTitle());
                    System.out.println("Room Description: " + roomClass.getRoomDesc());
                    System.out.println("Room Monster: " + roomClass.getRoomMons());
                    System.out.println("Room Item: " + roomClass.getRoomItem());
                    System.out.println("Room Puzzle: " + roomClass.getRoomPuzzle());


                    if (roomClass.getRoomExit4() != null && roomClass.getRoomExit3() != null) {
                        System.out.println("Available Exits: " + roomClass.getRoomExit1() + "," + roomClass.getRoomExit2()
                                + ", " + roomClass.getRoomExit3() + ", " + roomClass.getRoomExit4());
                    } else if (roomClass.getRoomExit1() != null && roomClass.getRoomExit2() != null
                            && roomClass.getRoomExit3() != null) {
                        System.out.println("Available Exits: " + roomClass.getRoomExit1() + ", " + roomClass.getRoomExit2()
                                + ", " + roomClass.getRoomExit3());
                    } else if (roomClass.getRoomExit1() != null && roomClass.getRoomExit2() != null) {
                        System.out.println("Available Exit: " + roomClass.getRoomExit1() + ", " + roomClass.getRoomExit2()
                                + ", " + roomClass.getRoomExit3());
                    } else if (roomClass.getRoomExit1() != null) {
                        System.out.println("Available Exits: " + roomClass.getRoomExit1());
                    }
                    System.out.println(" ");
                    System.out.println("Type quit to End || Enter to Continue");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
