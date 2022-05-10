package lambdaPracticeElifHoca;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class C5_Method_Referance_String {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon");
        buyukHarfliBosluklu(l);
    }
    // S1: Tum harfleri buyuk harf ile aralarinda bosluk birakarak yazdiralim
    public static void buyukHarfliBosluklu(List<String> l) {
        l.stream().map(String::toUpperCase).forEach(t-> System.out.print(t+" "));
        System.out.println("**");
        System.out.println(l.stream().map(String::toUpperCase).
                map(t -> t.split("")).// array oldu
                flatMap(Arrays::stream).// arrayi yazdirmaya yarayan yani referans degerlerini ceviren
                collect(Collectors.toList()));
    }

    //S2: Stringleri uzunluklarina gore siralayip yaziniz


    //S3: E ILE Baslayanlari yazdiralim


}
