public class valueofN {
    public static void main(String [] args){

        System.out.println(baseN(5));

    }
    public static int baseN(int N){
        int x = 0;
        for(int n = N; n >1; n/=2){
            x++;
        }
        return x;
    }
}
