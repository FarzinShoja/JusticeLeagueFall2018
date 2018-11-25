package TheTempleoftheOldGod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Puzzle {


    private Map<String, String> interactionMap = new LinkedHashMap<>();
    private int PuzzleID;
    private String puzzleName;
    private String[] interactions;
    private String puzzleItem;
    private String puzzleRoom;


    public Puzzle() {

    }

    public static void main(String[] args) {
        ReadJSonFile read = new ReadJSonFile();
        Puzzle[] puzzleHolder = read.puzzles;
        Puzzle puz = new Puzzle();
        puz.extractPuzzleInter("Rubble", puzzleHolder);
    }

    public int getPuzzleID() {

        return PuzzleID;
    }

    public void setPuzzleID(int puzzleID) {

        PuzzleID = puzzleID;
    }

    public String[] getInteractions() {

        return interactions;
    }

    public void setInteractions(String[] interactions) {
        this.interactions = interactions;
    }

    public String getPuzzleName() {

        return puzzleName;
    }

    public void setPuzzleName(String puzzleName) {

        this.puzzleName = puzzleName;
    }

    public Map<String, String> getInteractionMap() {
        return interactionMap;
    }

    public void setInteractionMap(Map<String, String> interactionMap) {
        this.interactionMap = interactionMap;
    }

    public String getPuzzleItem() {

        return puzzleItem;
    }

    public void setPuzzleItem(String puzzleItem) {

        this.puzzleItem = puzzleItem;
    }

    public String getPuzzleRoom() {

        return puzzleRoom;
    }

    public void setPuzzleRoom(String puzzlePuzzle) {

        this.puzzleRoom = puzzleRoom;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "interactionMap=" + interactionMap +
                ", PuzzleID=" + PuzzleID +
                ", puzzleTitle='" + puzzleName + '\'' +
                ", interactions=" + Arrays.toString(interactions) +
                ", puzzleItem='" + puzzleItem + '\'' +
                ", puzzlePuzzle='" + puzzleRoom + '\'' +
                '}';
    }

    public ArrayList extractAllPuzzleNames(Puzzle[] puzzles) {
        ArrayList titleList = new ArrayList();
        for (int i = 0; i < puzzles.length; i++) {
            titleList.add(puzzles[i].getPuzzleName());
        }
        return titleList;
    }

    public String extractPuzzleItem(String currentPuzzleName, Puzzle[] puzzles) {
        String s = "";
        for (int i = 0; i < puzzles.length; i++) {
            if (currentPuzzleName.equalsIgnoreCase(puzzles[i].getPuzzleName())) {
                s = puzzles[i].getPuzzleItem();
            }
        }
        return s;
    }

    public String extractPuzzleRoom(String currentPuzzleName, Puzzle[] puzzles) {
        String s = "";
        for (int i = 0; i < puzzles.length; i++) {
            if (currentPuzzleName.equalsIgnoreCase(puzzles[i].getPuzzleName())) {
                s = puzzles[i].getPuzzleRoom();
            }
        }
        return s;
    }

    public void extractPuzzleInter(String currentPuzzleName, Puzzle[] puzzles) {
        ArrayList<String> puzzleIner = new ArrayList();
        interactionMap.clear();
        for (int i = 0; i < puzzles.length; i++) {
            if (currentPuzzleName.equalsIgnoreCase(puzzles[i].getPuzzleName())) {
                //ENHANCED FOR LOOP>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> BELOW
                // for(String s: puzzles[i].getInteractions()){
                // }
                for (int x = 0; x < puzzles[i].getInteractions().length; x++) {
                    String q = puzzles[i].getInteractions()[x];
                    puzzleIner.add(q);
                }
            }
        }
        for (String q : puzzleIner) {
            String[] holder = q.split("#");
            interactionMap.put(holder[0], holder[1]);
        }
    }

    public String currentPuzzleName(int pID, Puzzle[] puzzles) {
        String s = "";
        for (int i = 0; i < puzzles.length; i++) {
            if (puzzles[i].getPuzzleID() == pID) {
                s = puzzles[i].getPuzzleName();
            } else {
                //Do Nothing...
            }
        }
        return s;
    }

    public int extractPuzzleID(String newPuzzleName, Puzzle[] puzzles) {
        int newPuzzleID = 0;
        for (int i = 0; i < puzzles.length; i++) {
            if (newPuzzleName.equalsIgnoreCase(puzzles[i].getPuzzleName())) {
                newPuzzleID = puzzles[i].getPuzzleID();
            } else {
                //Do Nothing
            }
        }
        return newPuzzleID;
    }
}



