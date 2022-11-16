/**
 * Space abstract class that extends cell class contains the accessible space for hero and the symbol of hero
 */
public abstract class AccessibleSpace extends Cell {

    protected boolean isHeroSquadHere;
    
    protected AccessibleSpace(char symbol, int[] position) {
        super(symbol, true, position);
        this.isHeroSquadHere = false;
    }

    @Override
    public char getSymbol() {
        if (isHeroSquadHere) {
            return 'H';
        }
        return symbol;
    }

    public void setHere() {
        this.isHeroSquadHere = true;
    }

    public void removeHere() {
        this.isHeroSquadHere = false;
    }
 
}