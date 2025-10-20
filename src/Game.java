import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Game {
    Player player;
    public Game(){
        Scene entrance = new Scene("A vár bejáratánál állsz! Északra van egy nagy faajtó található");
        Scene hall = new Scene("A nagyteremben vagy. Keltre és Nyugatra is van egy-egy ajtó");
        Scene armory = new Scene("A fegyvertárban vagy. Látsz egy fényes kardot az állványon");

        entrance.setExit(Direction.ESZAK, hall);
        hall.setExit(Direction.DEL, entrance);
        hall.setExit(Direction.NYUGAT, armory);
        armory.setExit(Direction.KELET, hall);

        player = new Player(entrance);

    }


    public static void main(String[] args) {
        //git remote add origin URL
        //git remote add origin https://github.com/Bendi156/worldofyesking.git

        Game game = new Game();
        game.play();
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        display("Üdv a várkalandban!");
        display(player.getCurrentScene().getDescription());

        // ez maga a játék ciklus
        while(true){
            display("............................");
            display(player.getCurrentScene().getDescription());
            display(">");

            String input = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            String[] words = input.split("");

            String command = words[0];

            // Ha van második szó itt kinyerjük termary operator-ral -> termary operator az ugyanaz mint egy if-ben, csak tömör
            String subject = words.length > 1 ? words[1] : "";

            switch (command){
                case "menj":
                    Direction direction = Direction.fromString(subject);
                    moveplayer(direction);
                    break; // ha nincs akkor tovább megy a következő ágra.

                case "kilep":
                    display("Köszi a játékot!");
                    scanner.close();
                    return;
                default:
                    display("Nem értem a parancsot");
                    break;
            }
        }
    }

    private void moveplayer(Direction direction) {
        Scene nextScene = player.getCurrentScene().getExit(direction);
        if(nextScene == null){
            display("Nem mehetsz arra");
        }
        player.setScene(nextScene);
    }

    private void display(String message) {
        System.out.println(message);
    }

}