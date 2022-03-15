package DictionaryTypes.TrieStructureComponents;

import org.w3c.dom.Node;

public class Edge {

    private State toState;
    private char ch;
    private State s;

    public Edge(Character ch, State s) {
        this.ch = ch;
        this.s = s;

    }

    public char getCh() {
        return ch;
    }

    public int getS() {
        return s.getNN();
    }
}
