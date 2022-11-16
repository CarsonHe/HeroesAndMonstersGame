/**
 * cell of the board
 */
public abstract class Cell {
    /**
     * symbol
     */
    protected char symbol;
    /**
     * if the cell is reachable
     */
    protected boolean reachable;
    protected int[] position;
    /**
     * type
     */
    protected String type;

    protected Cell(char symbol, boolean reachable, int[] position) {
        this.symbol = symbol;
        this.reachable = reachable;
        this.position = position;
    }

    public char getSymbol() {
        return symbol;
    }

    public char updateSymbol(char newSymbol) {
        this.symbol = newSymbol;
        return newSymbol;
    }

    public boolean isAccessible() {
        return reachable;
    }

    public int[] getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }
    
}