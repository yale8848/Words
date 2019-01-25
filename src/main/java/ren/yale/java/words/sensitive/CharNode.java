package ren.yale.java.words.sensitive;

/**
 * Yale
 * create at: 2019-01-24 14:13
 **/
class CharNode {
    private CharNode next;
    private boolean isLast;
    private char ch;

    public static CharNode create(char ch){
        CharNode charNode = new CharNode();
        charNode.setCh(ch);
        return charNode;
    }
    public static CharNode create(char ch,boolean last){
        CharNode charNode = new CharNode();
        charNode.setCh(ch);
        charNode.setLast(last);
        return charNode;
    }
    public CharNode getNext() {
        return next;
    }

    public void setNext(CharNode next) {
        this.next = next;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }
}
