import java.util.Locale;
import java.util.Scanner;

public class Game {

    Player player;
    private Display display;

    public Game() {

        display = new ConsoleDisplay();
        Scene entrance = new Scene("A vár bejáratánál állsz. És északra egy nagy faajtó található.");
        Scene hall = new Scene("A nagyteremben vagy. Keletre és nyugatra is van egy-egy ajtó.");
        Scene armory = new Scene("A fegyvertárban vagy. Látsz egy fényes kardot az állványon.");

        entrance.setExit(Direction.ESZAK, hall);
        hall.setExit(Direction.DEL, entrance);
        hall.setExit(Direction.NYUGAT, armory);
        armory.setExit(Direction.KELET, hall);

        player = new Player(entrance);
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        display.display("Üdv a várkalandban");


        // ez maga a játék ciklus
        while (true) {
            display.display("----------------------------");
            display.display(player.getCurrentScene().getDescription());
            display.display(">");

            //Scanner nextLine() az mindig egy teljes sort olvas be
            String input = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            String[] words = input.split(" ");

            String command = words[0];

            //Ha van második szó , majd itt kinyerjük egy terrary operator-ral -> terrary ugyanaz, mint egy if-ben, csak tömör
            String subject = words.length > 1 ? words[1] : "";

            switch (command) {

                case "menj":
                    //TODO moveplayer
                    Direction direction = Direction.fromString(subject);
                    moveplayer(direction);
                    break;
                case "kilép":
                    display.display("Köszi a játékot!");
                    scanner.close();
                    return;
                default:
                    display.display("Nem értem a parancsot");
                    break;
            }
        }
    }

    private void moveplayer(Direction direction) {
        Scene nextScene = player.getCurrentScene().getExit(direction);
        if(nextScene == null){
            display.display("Nem mehetsz arra!");
        }
        player.setScene(nextScene);
    }



    public static void main(String[] args) {

        Game game = new Game();
        game.play();
    }
}