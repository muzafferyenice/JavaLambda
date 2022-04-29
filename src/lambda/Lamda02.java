package lambda;

import java.util.*;

public class Lamda02 {
    public static void main(String[] args) {
// Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, -35, 20, 63, 21, -8, 38, 15));
        ciftKarePrint(sayi);//1156 484 256 400 64 1444
        System.out.println("\n ***  ");
        tekKupBirFazlaPrint(sayi);//1332 250048 9262 3376    1332 -42874 250048 9262 3376
        System.out.println("\n ***  ");
        ciftKareKokPrint(sayi);
        System.out.println("\n ***  ");
        maxElBul(sayi);
        System.out.println("\n ***  ");
        ciftKareEnBuyukPrint(sayi);
        System.out.println("\n ***  ");
        elTopla(sayi);
        System.out.println("\n ***  ");
        ciftCarp(sayi);
        System.out.println("\n ***  ");
        enKucuk(sayi);
        System.out.println("\n ***  ");
        bestenBuyukEnKucuk(sayi);
        System.out.println("\n ***  ");
        ciftlerinKareKucuktenBuyuge(sayi);
        System.out.println("\n ***  ");
        teklerinKareBuyuktenKucuge(sayi);
        System.out.println("\n ***  ");


    }

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).forEach(Lambda01::yazdir);
    }
    //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya
    // üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.


    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin
    // bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().// akisa girdi sayilar
                filter(t -> t % 2 == 1).//tek elmanlar filtrrlendi  filter(t->t%2!=0).boylede yazabilrisin
                map(t -> (t * t * t) + 1).//tek elemanlari kuplerinin 1 fazlasina update edoildi
                forEach(Lambda01::yazdir);//yazdirld

    }

    public static void ciftKareKokPrint(List<Integer> sayi) {
// Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
// Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

        sayi.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t -> System.out.print(t + " "));

    }

    //en buyyk eleman
    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);//akisa giren elemanlarin action sonrasi tek eleman haline getirir
        System.out.println(maxSayi);
        System.out.println("halukca" + sayi.stream().reduce(Math::max));
/*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareEnBuyukPrint(List<Integer> sayi) {

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).reduce(Math::max));
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//specific class daha hizli run olur
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);//a ilk degerini her zaman atanan degerden (identity) den alir
        //b  degerini herzman streamden alir akistan alir
        // a ilk degerinden sonraki her degeri action isleemden alir

        System.out.println(sayi.stream().reduce(Integer::sum));
        System.out.println("toplam = " + toplam);
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi) {
        //method ref
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
        //Lambda expression
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> (a * b)));
    }
//listteki eleman enkucuk 4 farkli yadir

    public static void enKucuk(List<Integer> sayi) {
        //1yontem method reference
        Optional<Integer> minSayi = sayi.stream().reduce(Integer::min);
        System.out.println("minSayi = " + minSayi);
        //2 yonem method reference
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        //3 yonte, lambda expression
        int minSayiLamda = sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println("minSayiLamda = " + minSayiLamda);
        //4 yintemn
        Optional<Integer> minHaluk = sayi.stream().reduce(Lamda02::byHalukMin);


    }

    public static int byHalukMin(int a, int b) { //bu method veroilen iki int degerin enkucugunu return eder
        return a < b ? a : b;

    }

    //listteki 5 den buyuk en kucuk tek sayi print et
    public static void bestenBuyukEnKucuk(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lamda02::byHalukMin));

    }

    public static void ciftlerinKareKucuktenBuyuge(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).//karesi alindi
                sorted().//ciftler siralandi dogal sira kucukten buyuge
                forEach(Lambda01::yazdir);
    }

    public static void teklerinKareBuyuktenKucuge(List<Integer> sayi) {
        sayi.stream().filter(t->t%2==1).map(t->t*t).sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);
        int min = sayi.
                stream().
                min((x, y) -> x - y).get();
    }


}
