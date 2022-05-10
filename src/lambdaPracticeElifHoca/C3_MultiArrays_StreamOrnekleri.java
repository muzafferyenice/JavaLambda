package lambdaPracticeElifHoca;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

/*
public static int[][] clone(int[][] mat) {
        if (mat == null) {
            return null;
        }

        int[][] copy = Arrays.stream(mat)
                .map(arr ->  Arrays.copyOf(arr, arr.length))
                .toArray(int[][]::new);
        return copy;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {3, 5, 7, 9},
                {2, 4, 6},
                {10, 12}
        };

        int[][] copy = clone(mat);

        Arrays.stream(copy).map(Arrays::toString).forEach(System.out::println);
    }

 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc", "Erik"}};

        tumElemanListYap(arr);
        System.out.println("*********************");
        System.out.println("ilkHarfEDoubleYaz(arr) = " + ilkHarfEDoubleYaz(arr));
        System.out.println("*********************");
        System.out.println("ilkHarfEOlanYaz(arr) = " + ilkHarfEOlanYaz(arr));
        System.out.println("*********************");
        System.out.println("sonHarfKOlan(arr) = " + sonHarfKOlan(arr));
        System.out.println("*********************");

    }

    // S1 : tum elemanlari list yapayim
    public static void tumElemanListYap(String[][] arr) {
        for (String[] w : arr) {
            System.out.println(Arrays.stream(w).collect(Collectors.toList()));
        }
        System.out.println(
                Arrays.stream(arr).
                        flatMap(Arrays::stream).//md arrayi tek liste cevirir
                        collect(Collectors.toList()));
        Arrays.stream(arr).flatMap(t -> Arrays.stream(t)).collect(Collectors.toList());
    }

    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static List<String> ilkHarfEDoubleYaz(String[][] r) {
        return Arrays.stream(r).
                flatMap(Arrays::stream).
                filter(t -> t.startsWith("E")).
                map(t -> t.toLowerCase() + t.toLowerCase()).collect(Collectors.toList());
    }

    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static List<String> ilkHarfEOlanYaz(String[][] r) {
        return Arrays.stream(r).flatMap(Arrays::stream).filter(t -> t.startsWith("E")).collect(Collectors.toList());
    }
    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static List<String> sonHarfKOlan(String[][] r) {
        return Arrays.stream(r).
                flatMap(Arrays::stream).
                filter(t -> t.endsWith("k")).
                map(t->t+"*").
        collect(Collectors.toList());
    }



}