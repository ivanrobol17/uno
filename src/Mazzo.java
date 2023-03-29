import java.util.Random;

public class Mazzo {
    private Carta[] mazzo = new Carta[108];
    private int utilizzo=0;
    private Random r = new Random();

    public Mazzo() {
        setCarte();
    }
    public int getUtilizzo() {
        return utilizzo;
    }

    private void setCarte() {
        for (int k = 0; k < 4; k++) {
            mazzo[k] = new Carta(k, 0);
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 13; j++) {
                for (int k = 0; k < 4; k++) {
                    mazzo[3 + j + k * 12 + i * 48] = new Carta(k, j);
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 4; k++) {
                mazzo[100 + k + i * 4] = new Carta(5, i + 13);
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int j = 0; j < mazzo.length; j++) {
            s += mazzo[j].toString() + "\n";
        }
        return s;
    }

    private void mischiaMazzo() {
        utilizzo=0;
        Carta tmp;
        int r1, r2;
        for (int i = 0; i < mazzo.length; i++) {
            r1 = r.nextInt(mazzo.length);
            r2 = r.nextInt(mazzo.length);
            tmp = mazzo[r1];
            mazzo[r1] = mazzo[r2];
            mazzo[r2] = tmp;
        }
    }

    public String carteGiocatori(int numGiocatori) {
        mischiaMazzo();
        String s = "";
        for (int i = 0; i < numGiocatori; i++) {
            s += "\u001B[37m le carte del giocatore n° " + (i + 1) + " sono: ";
            for (int j = 0; j <= 7; j++) {
                s += mazzo[i * 7 + j].toString() + ", ";
            }
            s += "\n";
        }
        return s;
    }

    public Carta[][] carteGiocatorii(int numGiocatori) {
        mischiaMazzo();
        Carta[][] carteGiocatori = new Carta[7][numGiocatori];
        for (int i = 0; i < numGiocatori; i++) {
            for (int j = 0; j <= carteGiocatori.length; j++) {
                carteGiocatori[j][i] = mazzo[i * 7 + j];
            }
            utilizzo+=7;
        }
        return carteGiocatori;
    }

    public Carta getCarta(){
        return mazzo[utilizzo++];
    }
    public Carta[] getPiuDue(){
        Carta[] carte = new Carta[2];
            for (int i = 0; i < carte.length; i++) {
                carte[i] = mazzo[utilizzo++];
            }
        return carte;
    }
    public Carta[] getPiuQuattro(){
        Carta[] carte = new Carta[4];
            for (int i = 0; i < carte.length; i++) {
                carte[i] = mazzo[utilizzo++];
            }
        return carte;
    }
    
    public Carta test(){
        return null;
    }

}