package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* Problem: Aladdin and his carpet
 * Description: Aladdin will travel on his carpet on a circular path. He can start from any point and collect the magic. To move to the next stop,
 * he need to use the magic equals to amount of distance travelled. On reaching the new destination, he will be rewarded with some magic. Need to
 * calculate the lowest index of the magic where he should start his journey from.
 * URL: https://medium.com/beyond-programming/alaaddin-and-his-carpet-algorithm-problem-of-the-week-i-8b4e39cc13bb
*/
public class AladdinAndCarpet {
    private static int optimalPoint(int[] magic, int[] dist){
       int remainingMagic=0, usedMagic=0, startIndex=0;
       for (int i=0; i<magic.length; i++){
           //Got magic[i] on start, but used dist[i] to move to the next point
           remainingMagic += magic[i] - dist[i];
           if(remainingMagic<0) {
               startIndex= i+1;
               usedMagic += remainingMagic;
               remainingMagic =0;
           }
       }
       return usedMagic+remainingMagic >=0 ? startIndex : -1;
    }

    @Test
    void findOptimalPoint(){
        int[] magic1 = {3,2,5,4};
        int[] dist1 = {2,3,4,2};
        int[] magic2 = {2,5,4,2};
        int[] dist2 = {4,3,1,3};

        assertAll(
                () -> assertEquals(0, optimalPoint(magic1, dist1)),
                () -> assertEquals(1, optimalPoint(magic2, dist2))
        );
    }
}
