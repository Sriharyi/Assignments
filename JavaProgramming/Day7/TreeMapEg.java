import java.util.Collection;
import java.util.TreeMap;

public class TreeMapEg{
    public static void main(String[] args) {
        TreeMap<Integer,Integer> treemap = new TreeMap<>();
        treemap.put(1,3);
        treemap.put(2,4);
        treemap.put(3,6);
        treemap.put(4,6);
        TreeMap<Integer,Integer> clonemap = (TreeMap<Integer, Integer>) treemap.clone();
        System.out.println(treemap.get(3));
        System.out.println(treemap.containsValue(4));
        System.out.println(treemap.containsKey(3));
        System.out.println(treemap.equals(clonemap));
        clonemap = treemap;
        System.out.println(treemap.equals(clonemap));
        System.out.println(treemap.isEmpty());
        System.out.println(treemap.hashCode());
        System.out.println(treemap.hashCode() == clonemap.hashCode());
        System.out.println(treemap.toString());
        System.out.println(treemap.size());
        System.out.println(treemap.getOrDefault(6, -1));
        System.out.println(treemap.remove(3));
        System.out.println(treemap.getClass());
        System.out.println(treemap.replace(2,6));
        System.out.println(treemap.toString());

        for(Integer k:treemap.keySet())
        {
            System.out.print("Key:"+k);
            System.out.println("Value:"+treemap.get(k));
        }

        Collection<Integer> c = treemap.values();
        for(Integer i:c)
        {
            System.out.println(i);
        }
    }
}