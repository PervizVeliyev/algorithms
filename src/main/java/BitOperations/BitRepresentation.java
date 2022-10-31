package BitOperations;

public class BitRepresentation {
    public static void main(String[] args) {
        int x = 56;
        System.out.println(BitRepresentation.bit(x));
    }

    public static String bit(int x){
        StringBuilder sb = new StringBuilder("");
        int i = 256;

        for(int k = 0; k < 8; k++){
            if (x >= i / 2) {
                sb.append(1);
                x = x % (i / 2);
            } else {
                sb.append(0);
            }
            i = i / 2;
        }
        return sb.toString();
    }
}
