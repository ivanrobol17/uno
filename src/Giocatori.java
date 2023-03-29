import java.util.Scanner;

public class Giocatori {
    private Scanner sc = new Scanner(System.in);
    private Mazzo m = new Mazzo();
    private Giocatore[] giocatori;
    public Giocatori(int numGiocatori) {
        Carta [][] carteGiocatori =m.carteGiocatorii(numGiocatori);
        giocatori = new Giocatore[numGiocatori];
        for (int i = 0; i < giocatori.length; i++) {
            Giocatore g = new Giocatore(carteGiocatori[i]);
            giocatori[i]=g;
        }
    }

    public void turno() {
        int scelta = 0;
        System.out.println("Le tue carte sono: " + toString()
                + "\nQuale carta vuoi usare?(qualsiasi altro numero per passare)");
        scelta = sc.nextInt();
    }
}
