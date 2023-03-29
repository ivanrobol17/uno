import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Mazzo m = new Mazzo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quanti giocatori partecipano?");
        int numGiocatori=sc.nextInt();
        System.out.println(m.carteGiocatori(numGiocatori));

        sc.close();
    }
}