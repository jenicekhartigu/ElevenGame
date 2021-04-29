package HarHolCha;

import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import jdk.javadoc.internal.doclets.formats.html.markup.Table;

public class GameCore implements GameInterface{

    //stul s kartami
    List<Card> stul = new ArrayList<>();

    //balicek s kartami
    List<Card> balicek = new ArrayList<>();

    public GameCore(){
        String[] symbol = DataStore.loadSymbols();
        String[] values = DataStore.loadValues();
        int[] points = DataStore.loadNPoints();

        //pro kazdy symbol vygeneruje kartu jednoho cisla a ulozit je do listu balicek
        for (String string : symbol) {
            for (int i = 0; i < 13; i++) {
                Card card = new Card(values[i], string, points[i]);
                balicek.add(card);
            }
        }
        //zamichat balicek
        Collections.shuffle(balicek);

        //vyndat karty na stul - pridat karty do listu stul a odebrat z baliku
        for (int i = 0; i < nCards() - 1; i++) {
            stul.add(balicek.remove(i));
        }
    }

    @Override
    public boolean anotherPlayIsPossible() {
        if (stul.size() > 1){
            int trojce = 0;
            double sum = 0;
            int n = stul.size();
            for (int i = 0; i < n; i++) {
                if (stul.get(i).getPoints() == 0){
                    trojce++;
                } else {
                    sum = sum + stul.get(i).getPoints();
                }
            }

        }
        return false;
    }

    @Override
    public String getCardDescriptionAt(int index) {
        return stul.get(index).toString();
    }

    @Override
    public int getDeckSize() {
        return balicek.size();
    }

    @Override
    public String getName() {
        return "Eleven Game";
    }

    @Override
    public int nCards() {
        return DataStore.getNCards();
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isWon() {
        return stul.isEmpty() && balicek.isEmpty();
    }

    //generator nahodnych cisel
    private int Random(int a){
        Random rand = new Random();
        return rand.nextInt(a);
    }
    
}