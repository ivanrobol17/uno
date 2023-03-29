public class Carta {
    private int colore;
    private int valore;
    public Carta() {
    }

    public Carta(int colore, int valore) {
        inserisciCarta(colore, valore);
    }

    public int getColore() {
        return this.colore;
    }

    private void setColore(int colore) {
        this.colore = colore;
    }

    public int getValore() {
        return this.valore;
    }

    private void setValore(int valore) {
        this.valore = valore;
    }

    public boolean equals(Carta c) {
        return getColore()==c.getColore() && c.getValore()==getValore();
    }

    public boolean inserisciCarta(int colore, int valore){
        if(valore>13 && colore<4){
            return false;
        }else{
            setColore(colore);
            setValore(valore);
            return true;
        }
    }

    public String toString() {
        String stampa=""; 
        switch (colore) {
            case 0: stampa="\033[1;31m"; break;
            case 1: stampa="\033[1;33m"; break;
            case 2: stampa="\033[1;32m"; break;
            case 3: stampa="\033[1;34m"; break;
            default: stampa="\033[1;30m";
        }
        switch (valore) {
            case 14:    stampa+="+4";
                        break;
            case 13:    stampa+="cambia colore";
                        break;
            case 12:    stampa+="+2";
                        break;
            case 11:    stampa+="cambio giro";
                        break;
            case 10:   stampa+="salta turno";
                        break;
            default:  stampa+=valore;
        }
    return stampa+"\u001B[37m";
    }

}
