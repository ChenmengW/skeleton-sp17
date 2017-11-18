package lab9;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
public class MyHashMap<K, V> implements Map61B<K, V>, Iterable<K>{
    private static int initialSize = 4;
    private int size = initialSize;
    private int bucketNumber = 0;
    private double loadFactor = 0.6;
    private List[] data= new List[initialSize];
    private Set<K> keySet = new HashSet<K>();

    public MyHashMap(){ }
    public MyHashMap(int initialSize){
        this.initialSize = initialSize;
    }
    public MyHashMap(int initialSize, double loadFactor){
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear(){
        size = initialSize;
        data = (ArrayList<Node>[]) new Object[initialSize];
        keySet = new HashSet<K>();
    }
    @Override
    public boolean containsKey(K key){
        return get(key) == null;
    }

    @Override
    public V get(K key){
        for ( List nodeList: data){
            if (nodeList != null){
                for(Object n: nodeList){
                    Node node = (Node) n;
                    if (node.key == key){
                        return (V)node.value;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size(){
        return keySet.size();
    }

    @Override
    public void put(K key, V value){
        Node node = new Node(key, value);
        keySet.add(key);
        if (bucketNumber/size > loadFactor){
            this.resize();
        }
        if (data[node.hashCode()] == null) {
            data[node.hashCode()] = new ArrayList<Node>();
            bucketNumber += 1;
            data[node.hashCode()].add(node);
        }
        else{
            data[node.hashCode()].add(node);
        }
    }

    private void resize(){
        ArrayList<Node>[] newData= (ArrayList<Node>[]) new Object[2*size];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public Set<K> keySet(){
        return keySet;
    }

    @Override
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keySet.iterator();
    }

    private class Node<K,V>{
        K key;
        V value;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return Math.floorMod(key.hashCode(), size);
        }
    }

}
