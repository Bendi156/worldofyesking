import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Game {
    public static void main(String[] args) {
        //git remote add origin URL
        //git remote add origin https://github.com/Bendi156/worldofyesking.git

        Game game = new Game();
        game.play();
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        display("Üdv a várkalandban!");

        // ez maga a játék ciklus
        while(true){

            String input = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            String command = input;


            switch (command){
                case "kilep":
                    display("Köszi a játékot!");
                    scanner.close();
                    return;
            }
        }
    }

    private void display(String message) {
        System.out.println(message);
    }


}