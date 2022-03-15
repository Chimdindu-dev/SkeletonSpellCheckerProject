package DictionaryTypes.TrieStructureComponents;

import java.util.ArrayList;

public class State {

    private ArrayList<Edge> outgoingEdges = new ArrayList<>();
    private int NN;
    private boolean accept;
    private String wordUpUntil;

    public State(int NN, boolean accept, String wordUpUntil) {
        this.NN = NN;
        this.accept = accept;
        this.wordUpUntil = wordUpUntil;

    }

    public void removeLink(State s, Character ch) {
        // you don't have to use this but you can if you want to
    }

    public void addLink(State s, Character ch) {
        // you don't have to use this but you can if you want to
    }

    public int getNN() {
        return NN;
    }



}
