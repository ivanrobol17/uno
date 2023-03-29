import java.util.ArrayList;

public class Giocatore {
    private ArrayList<Carta> mano;

    public Giocatore(Carta[] carte) {
        mano = new ArrayList<Carta>();
        addCarte(carte);
    }

    public void addCarte(Carta[] carte) {
        for (int i = 0; i < carte.length; i++) {
            mano.add(carte[i]);
        }
    }

    public Carta turno(int scelta, Carta ultimaGiocata) {
        if ((scelta >= 0 && scelta <= mano.size()) && (ultimaGiocata.getColore() == mano.get(scelta).getColore()
                || ultimaGiocata.getValore() == mano.get(scelta).getValore()
                || mano.get(scelta).getColore() == 4)) {
            ultimaGiocata = mano.get(scelta);
            return ultimaGiocata;
        } else {
            return null;
        }

    }

    public Carta turnoPiuCarte(Carta[] carte, int scelta, Carta ultimaGiocata) {
        addCarte(carte);
        if ((scelta >= 0 && scelta <= mano.size()) && (ultimaGiocata.getColore() == mano.get(scelta).getColore()
                || ultimaGiocata.getValore() == mano.get(scelta).getValore()
                || mano.get(scelta).getColore() == 4)) {
            ultimaGiocata = mano.get(scelta);
            return ultimaGiocata;
        } else {
            return null;
        }
    }

    public int getNumCarte(){
        return mano.size();
    }

    @Override
    public String toString() {
        String s = "";
        for (int j = 0; j < mano.size(); j++) {
            s += (j + 1) + mano.get(j).toString() + "\n";
        }
        return s;
    }
}
