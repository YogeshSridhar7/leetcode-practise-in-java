public class CollectionsDemo {
    public static void main(String[] args) {
        Bob b = new Bob(9,"Blob");
        System.out.println(b);
    }
}

class Bob{
    int shoeSize;
    String nickName;
    Bob(int shoeSize, String nickName){
        this.shoeSize = shoeSize;
        this.nickName = nickName;
    }
    public String toString() {
        return ("HI my name is Bob and my nick name is "
                + nickName
                + ". My shoe size is "
                + shoeSize);
    }
}
