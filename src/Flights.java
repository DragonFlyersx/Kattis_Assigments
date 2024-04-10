/*import edu.princeton.cs.algs4.Queue;

import java.util.Scanner;
public class Flights {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Amount of planes coming in with a time stamp and destination seperated by a space
        int m = scanner.nextInt(); // Amount of commands coming in
        scanner.nextLine();
        //create Binary Search Tree
        BST Search = new BST<>();
        for(int i = 0; i < n; i++){
            // Take in flight split line create flight object use time as second bst
            String flight = scanner.nextLine();

            String[] parts = flight.split(" ");
            Search.put(timeasseconds(parts[0]),parts[1]);
           // System.out.println(Search.get(timeasseconds(parts[0])));

        }
        for(int j = 0; j < m; j++){
            String command = scanner.nextLine();
            String[] command_parts = command.split(" ");

            switch (command_parts[0]){
                case "destination":
                    destination(Search, timeasseconds(command_parts[1]));
                    break;
                case "cancel":
                    cancel(Search,timeasseconds(command_parts[1]));
                    break;
                case "delay":
                    delay(Search,timeasseconds(command_parts[1]),Integer.parseInt(command_parts[2]));
                    break;
                case "reroute":
                    reroute(Search,timeasseconds(command_parts[1]),command_parts[2]);
                    break;
                case "next":
                    next(Search, timeasseconds(command_parts[1]));
                    break;
                case "count":
                    count(Search, timeasseconds(command_parts[1]), timeasseconds(command_parts[2]));
            }
        }

    }

    private static int timeasseconds(String time){
      String[] parts = time.split(":");
      int hours = Integer.parseInt(parts[0]);
      int minutes = Integer.parseInt(parts[1]);
      int seconds = Integer.parseInt(parts[2]);

       return hours * 3600 + minutes * 60 + seconds;
    }

    private static String Second_to_Time(int Seconds){
        int hours = Seconds/ 3600;
        int remainingSeconds = Seconds % 3600;
        int minutes = remainingSeconds / 60;
        int second = remainingSeconds % 60;
        return (hours + ":" + minutes + ":" + second);
    }

    private static void destination(BST search, int s){
        if(search.get(s) != null) System.out.println(search.get(s));
        else System.out.println("-");
    }

    private static void reroute(BST search, int s, String c){
        search.put(s,c);
    }

    private static void cancel(BST search, int s){
        search.delete(s);
    }

    private static void delay(BST search, int s, int d){
        int new_time = s+d;
        search.put(new_time,search.get(s));
        search.delete(s);


    }
    private static void next(BST search, int s){
        int next_flight = (int) search.ceiling(s);
        System.out.println(Second_to_Time(next_flight) + " " + search.get(next_flight));
    }
}

// Add BST SET time to be seconds and update the key and use value as an object. plane object
// Change time for delay that is used as key // remove when canceled set key to null?

class BST<Key extends Comparable<Key>, String>
{
    private Node root; // root of BST
    private class Node
    {
        private Key key; // key
        private String val; // associated value
        private Node left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here
        public Node(Key key, String val, int N)
        { this.key = key; this.val = val; this.N = N; }
    }
    public int size()
    { return size(root); }
    private int size(Node x)
    {
        if (x == null) return 0;
        else return x.N;
    }
    public void put(Key key, String val) {
        root = put(root, key, val);}
    public Node put(Node x, Key key, String val){
            if(x == null) return  new Node(key,val, 1);
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = put(x.left, key,val);
            else if (cmp > 0) x.right = put(x.right, key, val);
            else x.val = val;

            x.N = 1+ size(x.left) + size(x.right);
            return  x;

    }
    public String get(Key key){
        Node x = root;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
            }
        return null;
    }
    public Key min()
    {
        return min(root).key;
    }
    private Node min(Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }
    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    public Key max()
    {
        return max(root).key;
    }
    private Node max(Node x)
    {
        if (x.right == null) return x;
        return min(x.right);
    }
    public Key ceiling(Key key)
    {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else return x;
    }
    public Key select(int k)
    {
        return select(root, k).key;
    }
    private Node select(Node x, int k) {
        // Return Node containing key of rank k.
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }
    public int rank(Key key) {
        return rank(key, root); }
    private int rank(Key key, Node x) { // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key) {
        root = delete(root, key); }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else
        {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right); // See page 407.
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;

    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}

*/



