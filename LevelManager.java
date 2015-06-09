import java.util.List;
import java.util.ArrayList;

public class LevelManager {
    List<Level> levelList;
    private static final LevelManager INSTANCE = new LevelManager();
    
    /**
     * Gibt ein beliebiges Level anhand seiner Nummer zurueck.
     * @param i Das Level das zurückgegeben werden soll. Das erste Level hat die Nummer 1.
     * @return Das Level mit der Nummer i
     */
    public Level getLevel(int i) {
        return levelList.get(i - 1);
    }
    
    /**
     * Gibt das nachfolgende Level zurück. Wenn es kein nachfolgendes Level gibt, wird eine
     * IndexOutOfBoundsException geworfen.
     * @param level Das aktuelle Level
     * @return das nachfolgende Level
     */
    public Level getNextLevel(Level level) {
        int index = levelList.indexOf(level);
        return levelList.get(index + 1);
    }
    
    private LevelManager() {
        levelList = new ArrayList<Level>();
        levelList.add(0, new No1()); // Level 1
        levelList.add(1, new No2()); // Level 2
        levelList.add(2, new No3()); // Level 3
    }
    
    /**
     * Benutze diese Methode um Zugriff auf den Levelmanager zu erhalten. Sie ist die einzige
     * Möglichkeit um eine Instanz von dieser Klasse zu erhalten.
     */
    public static LevelManager getInstance() {
        return INSTANCE;
    }
}
