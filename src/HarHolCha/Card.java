package HarHolCha;

public class Card {
    //data
    private String value;
    private String symbol;
    private int points;


    //konstruktor
    public Card(String value, String symbol, int points){
        this.value = value;
        this.symbol = symbol;
        this.points = points;
    }
    
    public String getValue(){
        return value;
    }

    public String getSymbol(){
        return symbol;
    }

    public int getPoints(){
        return points;
    }
    @Override
    public String toString() {
        return "Card [symbol=" + symbol + ", value=" + value + "]";
    }
    //comment 1
}
