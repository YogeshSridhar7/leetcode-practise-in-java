import java.util.Arrays;

class Demo{
    public static Demo d;
    static {
        System.out.println("In static block");
    }
   private Demo(){
       System.out.println("In constructor");
    }

   public static synchronized Demo getInstance(){
       if(d == null) {
           System.out.println(d + "==================================True "+ Thread.currentThread().getName());
           d = new Demo();
           return d;
       } else {
           //System.out.println(d + "False");
           return d;
       }
   }
}
public class TestDemo {
    private TestDemo(){

    }
    static String out ="";
    public static void main(String[] args) {
        Runnable nr = () -> {
            for (int i = 0;i<5;i++){
                Demo d = Demo.getInstance();
                System.out.println(Thread.currentThread().getName() +" "+ d);
            }
        };
        Thread one = new Thread(nr);
        Thread two = new Thread(nr);
        Thread three = new Thread(nr);
        one.setName("One");
        two.setName("Two");
        three.setName("Three");
        one.start();
        two.start();
        three.start();
        System.out.println(Demo.d);


        /*int x=10;
        if(x>10){
            int y =20;
        } else {
            int y =30;
        }
        System.out.println(y);*/

        /*int x=5,y=8;
        if(x++ ==5) {
            out += "1";
        }
        if(x!=6){}
        else if (x>9){out+="2";}
        else if (y>9){out+="3";}
        else if (x==6){out+="4";}
        else {out+="5";}

        System.out.println(out);

        for(int k=10;k--;k>0);

        for(;; System.out.println("a")){}*/

        /*int x=0;
        String[] animal = new String[3];
        do{animal[x] ="Cat";x++;}while (false);
        do{animal[x] ="Dog";}while (x>animal[x++].length());
        do{animal[x] ="Rat";}while (x>3);

        for (String s:animal){
            System.out.println(s+"");
        }

        for(int j=0,k=5;j<k;k--);
        for(int j=0;j++<3;);
        for(int i=0;i<5;i++,System.out.print(i+".Hi"));*/

        int[] ints = {2,-1,3,4,5};
        Arrays.sort(ints);
        System.out.println(Arrays.binarySearch(ints,-1));

        TestDemo testDemo = new TestDemo();
        int[] num = new int[3];
        num[0] = 4;
        num[1] = 4;
        num[2] = 4;
        System.out.println(testDemo.triangleType(num));

        int[] count = new int[3];
        count[0] = 2;
        count[1] = 2;
        count[2] = -5;
        System.out.println(testDemo.returnToBoundaryCount(count));
    }

    public String triangleType(int [] nums){

        Arrays.sort(nums);
        if (nums.length==3) {
            if (nums[0] + nums[1] <= nums[2]) return "none";
            if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
            if (nums[0] == nums[1] || nums[1] == nums[2]) return "isosceles";
            return "scalene";
        } return "not a triangle";
    }

    public int returnToBoundaryCount(int[] nums){
        int count =0, displacement = 0;
        for ( int num : nums){
            displacement += num;
            if (displacement == 0){
                count++;
            }
        }
        return count;
    }
}

