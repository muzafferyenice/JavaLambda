package lambdaPracticeElifHoca;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL = Arrays.asList(-2, -8, -5, 0, 2, 5, 6, 7, 15, 6, 8);

        boslukluTek(intL);
        System.out.println("\n"+"**********");
        ciftCarp(intL);
        System.out.println("\n"+"**********");
        negatifKareTopla(intL);
        System.out.println("\n"+"**********");
        pozitifKupMAxYazdir(intL);
        System.out.println("\n"+"**********");

    }

    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void boslukluTek(List<Integer> y){
        y.stream().filter(t->t%2!=0).forEach(t-> System.out.print(t+" "));
    }
    // S2: ciftlein carpimini bulalim
    public static void ciftCarp(List<Integer> g){
        System.out.println(g.stream().filter(t -> t % 2 == 0).reduce(1, (y, a) -> y * a));
    }
    // S3: negatiflerin kare toplamlarini  bulalim
    public static void negatifKareTopla(List<Integer> g){
        System.out.println(g.stream().filter(t -> t < 0).map(t -> t * t).reduce(0, (q, w) -> q + w));
    }

    // S4: poziflerin kuplerinden max yazdiralim
    public static void pozitifKupMAxYazdir(List<Integer> g){
        System.out.println(g.stream().filter(t -> t > 0).mapToInt(t -> t * t * t).max());
        System.out.println(g.stream().filter(t -> t > 0).mapToInt(t -> t * t * t).min());
        System.out.println(g.stream().filter(t -> t > 0).mapToInt(t -> t * t * t).sum());
        System.out.println(g.stream().filter(t -> t > 0).mapToInt(t -> t * t * t).average());
        System.out.println(g.stream().filter(t -> t > 0).mapToInt(t -> t * t * t).count());
        System.out.println(g.stream().filter(t -> t > 0).reduce(0,(a,b)->a-b));
    }//-2, -8, -5, 0, 2, 5, 6, 7, 15, 6, 8);


}























