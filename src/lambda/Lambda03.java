package lambda;

import java.util.*;
import java.util.stream.Stream;

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
        //yemek.stream().map(t->t.substring(t.length()-1)). yanlis
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
        yemek.stream().
                filter(Lambda03::ciftBulStrKarakter).
                map(t -> t.length() * t.length()).
                distinct().//tekrarsiz yapildi
                sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void karakterSayiYedidenBuyuk(List<String> yemek) {
        //amele kod
        boolean kontrol = yemek.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elmanlari 7 ve daha az harften olurus");
        } else System.out.println("list elmanlari 7 den buyuk  ");
        System.out.println(kontrol);
        //cincik yazimi
        System.out.println(yemek.stream().allMatch(t -> t.length() <= 7) ? "list elmanlari 7 ve daha az harften olurus" : "list elmanlari 7 den buyuk  ");
    }
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void basHarfiWIleBaslayan(List<String> yemek) {
        System.out.println(yemek.stream().allMatch(t -> t.startsWith("W")) ? "W ilebaslayan yemegin menude ne isi var" : "beyle yemek olr mu");
        System.out.println(yemek.stream().noneMatch(t -> t.startsWith("W")) ? "W ilebaslayan yemegin menude ne isi var" : "beyle yemek olr mu");

    }
    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenEleman(List<String> yemek) {
        System.out.println(yemek.stream().anyMatch(t -> t.endsWith("x")) ? " var " : "yok");
    }
    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karkterEnFazla(List<String> yemek) {
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
// şekilde kesilmiş bir akış return eder. Stream return eder.
       Stream<String> sonIsim =yemek.stream().
                sorted(Comparator.
                        comparing(t -> t.toString().length()).//length leri kiyasla
                        reversed()).//tersine cevir buykten kucuge
                limit(1);//limit(a) akisidan cikan elemanlerri a paramaetresine gore ilk a elemani alir
/*
sonIsim.toArray()--> limit() meth return dan dolayı  stream type olan sonIsim toArray() method ile array type convert edildi
 */
        System.out.println(Arrays.toString(sonIsim.toArray()));//arraya cevrilen sonisim stream print edildi
               // findFirst());//ilkini al
        System.out.println(yemek.stream().
                reduce(String.valueOf(Integer.MAX_VALUE), (x, y) -> x.length() > y.length() ? x : y));
    }
    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSiralaIlkHaricElmanlariYaz(List<String> yemek) {
     yemek.stream().sorted(Comparator.
             comparing(t -> t.toString().charAt(t.toString().length()-1)).
             reversed()).skip(1).forEach(Lambda03::yazdirStr);
    }

/*
  TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz.
  Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray()));
kullanılabilir.

   */
}
