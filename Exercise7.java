package exercise;


/***
 * Bitte fuellen sie die folgenden Felder mit ihren Daten aus!
 *
 * Name: --
 * Vorname: --
 * Matrikelnummer: --
 */
public class Exercise7 {
    public static final boolean NAIVE_GAME_IS_IMPLEMENTED = true;
    public static final boolean GAME_IS_IMPLEMENTED = true;


    /*
     * Implementieren Sie hier eine naive (enumerative) Version des
     * Algorithmus
     */
    public static int naiveGame(Integer[] bowls) {
        int i = naiveGame(bowls,0,bowls.length-1);
        return i;
    }

        //Recursiv
    public static int naiveGame(Integer[] bowls, int i , int j){
        if ( i == j){
            return bowls[i];
        }
        if (i+1 == j){
            return Integer.max(bowls[i], bowls[j]);
        }

        long beginn = bowls[i] + Integer.min(naiveGame(bowls,i+2,j),naiveGame(bowls,i+1,j-1));
        long end = bowls[j] + Integer.min(naiveGame(bowls,i+1,j-1),naiveGame(bowls,i,j-2));

        return Integer.max((int) beginn,(int) end);

    }

    /*
     * Implementieren Sie hier ein dynamisches Programm
     */
    public static int dynGame(Integer[] bowls) {

        int i = dynGame1(bowls);
        return i;
    }
        //Iterativ
    public static int dynGame1(Integer[] bowls){

        if (bowls.length == 1){
            return bowls[0];
        }
        if (bowls.length==2){
            return Integer.max(bowls[0], bowls[1]);
        }
        int[][] arr = new int[bowls.length][bowls.length];

            int iter = 0;
            while (iter<bowls.length){
            for (int i = 0, j= iter; j<bowls.length; i++,j++){
                long start = calSE(bowls[i],Integer.min(cal(arr,i+2,j),cal(arr,i+1,j-1))) ;
                long end   = calSE(bowls[j],Integer.min(cal(arr,i+1,j-1),cal(arr,i,j-2)));
                arr[i][j] = Integer.max((int)start,(int)end);
            }
            iter++;
        }
        return arr[0][bowls.length-1];
    }

        public static int cal(int[][] arr,int i , int j){
            if (i<=j){
                return arr[i][j];
            }
            return 0;
        }
        public static long calSE(int i , int j ){
            return i+j;
        }
}
