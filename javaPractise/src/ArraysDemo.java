import java.util.*;

public class ArraysDemo {
    public static void main(String[] args) {
        List<Integer> a= List.of(10,5,3,2,-6,9,11);
        List<Integer> b = new ArrayList(Arrays.asList(1,2,3,4));

        ArrayList<String>[] c = new ArrayList[4];

        List<String>[] c1 = new ArrayList[]{new ArrayList<>(Arrays.asList("1","2","3")),new ArrayList<>(Arrays.asList("4","5","6"))};
//        c1[3] =  new ArrayList<>(Arrays.asList("7","8","9"));
//        c1[4] =  new ArrayList<>(Arrays.asList("10","11","12"));
        System.out.println(a);
        System.out.println(b.size());
        int [] arr1 = new int[]{1,2,3};
        String arr[]= new String[]{"1","2", "3"};
//        arr[4] = "xyz";

        long [] arr2 = new long[10];
        arr2[0] = 1L;
        arr2[1] = 3L;
        System.out.println(arr1.length);
        System.out.println(arr);

        for(int i=0;i<c1.length;i++){
            System.out.println(c1[i]);
        }

        int sum=4;
        for(int i=0; i<a.size();i++){
            for(int j=i+1; j<a.size();j++){
               if(sum == a.get(i)+a.get(j)){
                   System.out.println(a.get(i)+","+a.get(j));
               }
            }
        }

        Set<Integer> A= new HashSet<>();
                for(int i=0;i<a.size();i++){
                    if(A.contains(4-a.get(i))){
                        System.out.println(a.get(i)+","+(4-a.get(i)));
                    } else {
                        A.add(a.get(i));
                    }
                }
        System.out.println(A);

        System.out.println("_________________SETS__________________");

        Set<String> h = new HashSet<>();
        h.add("A");
        h.add("y");
        h.add("C");
        h.add("b");
        System.out.println(h);

        Set<String> h1 = new LinkedHashSet<>();
        h1.add("A");
        h1.add("y");
        h1.add("C");
        h1.add("b");
        System.out.println(h1);
    }
}
