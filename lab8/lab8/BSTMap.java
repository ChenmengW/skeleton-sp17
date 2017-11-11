package lab8;

import java.util.HashSet;
import java.util.Set;

public class BSTMap<K extends Comparable,V> implements Map61B<K, V>{
    public Node n;
    @Override
    public void clear(){
        n = null;
    }

    @Override
        /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        containsKey(key, n);
    }

    private boolean containsKey(K key, Node n){
        if (n.get(key) == null){
            return false;
        }
        else{return true;}
    }

    @Override
    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
        return get(key, n);
    }

    private V get(K key, Node n){
        return n.get(key).val;
    }

    @Override
    public int size(){
        return size(n);
    }

    private int size (Node n){
        return n.size;
    }

    @Override
    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value){
        put(key, value, n);
    }
    private void put(K key, V value, Node n){
        if (key != null && key.equals(key)) {
            return;
        }
        if (n == null) {
            n = new Node(key, value, 1);
        }
        if (key.compareTo(key)<0){
            put(key, value, n.left);
        }
        else{put(key, value, n.right);}
    }

    @Override
    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        Set<K> resultSet = new HashSet<K>();
        keySet(n, resultSet);
        return resultSet;
    }

    private void keySet(Node n, Set<K> resultSet) {
        if (n == null){
            return;
        }
        keySet(n.left, resultSet);
        resultSet.add(n.key);
        keySet(n.right, resultSet);
    }


    @Override
    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){
        throw new UnsupportedOperationException();
    }


    @Override
    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    public void printInOrder(){

    }

    private class Node {
        private K key;           // sorted by key
        private V val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K key, V val, int size) {
                this.key = key;
                this.val = val;
                this.size = size;
        }

        public Node get(K k){
            if (k != null && k.equals(key)) {
                return this;
            }
            if (size == 1) {
                return null;
            }
            if (k.compareTo(key)<0){
                return left.get(key);
            }
            else{return right.get(key);}
        }
    }

}
