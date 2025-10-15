import java.util.ArrayList;

public class Player {
    private Scene scene;
    private ArrayList<Item> inventory;

    public Player(Scene scene) {
        this.scene = scene;
        inventory = new ArrayList<>();
    }

    public Scene getScene(){
        return scene;
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void takeItem(Item item) {
        inventory.add(item);
    }

    public String getInventoryString(){
        if(inventory.isEmpty()){
            return "A leltárad üres";
        }
        // A StringBuilder objektumot olyan szituációkban használjuk,
        // mint pl egy loop ahol sok Stringet fuzunk ossze (concate-nalunk)
        //Ez azért kell mert a Java-ban a String imutable, és egyébként mindig újat hozna létre, ami költséges művelet, lassú lenne
        StringBuilder returnString = new StringBuilder();
        for(Item item: inventory){
            returnString.append(" ").append(item.getName());
        }
        return returnString.toString();
    }
}
