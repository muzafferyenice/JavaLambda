package lambda;

import java.util.*;

public class Lambda03 {

    public static void yazdirStr(String M) {//seed printer
        System.out.print(M + " ");

    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuyukHarfTekrarsiz(List<String> yemek) {
        yemek.stream().
                map(t -> t.toUpperCase(Locale.CHINA)).
                sorted().
                distinct().//benzersiz tekrarsiz yapildi
                forEach(Lambda03::yazdirStr);
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void strKarakterSayisiYazdir(List<String> yemek) {
        yemek.stream().
                map(t -> t.length()).
                sorted(Comparator.reverseOrder()).
                distinct().//benzersiz tekrarsiz yapildi
                forEach(Lambda01::yazdir);
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void strKarakterSayiKucuktenBuyuge(List<String> yemek) {
        yemek.stream().sorted(Comparator.comparing(String::length)).forEach(Lambda03::yazdirStr);
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeGoreTersSira(List<String> yemek) {
        //yemek.stream().map(t->t.substring(t.length()-1)).
        //      sorted(Comparator.reverseOrder()).forEach(Lambda03::yazdirStr);
        yemek.stream().
                sorted(Comparator.
                        comparing(t -> t.toString().//comparing karsilastirir
                                charAt(t.toString().length() - 1)).//41 42 son harfi veriyor
                        reversed()).
                forEach(Lambda03::yazdirStr);

    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz
    // buyukten kucuge sirali  print ediniz..
    public static boolean ciftBulStrKarakter(String str) {

        return str.length() % 2 == 0;
    }
    public static void karakterCiftKareBuyuktenKucuge(List<String> yemek) {
        yemek.stream().filter(Lambda03::ciftBulStrKarakter).map(t->t.length()*t.length()).
                sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);

    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.


}
