package lambdaPracticeElifHoca;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {
        birden30olanSayilariSirala();
        System.out.println("\n" + "\n*********");
        birden30olanSayilariSirala2();
        System.out.println("\n*********");
        ikiDegerTopla();
        System.out.println("\n*********");
        ortBul3040();
        System.out.println("\n*********");
        bolunen8e();
        System.out.println("\n*********");
        bolunen8eYaz();
        System.out.println("\n*********");
        bolunen8eTopla();
        System.out.println("\n*********");
        carp7ile15();
        System.out.println("\n*********");
        pozitifTekIlk10AL();
        System.out.println("\n*********");
        tekYaz21DenBuyukOlan();
        System.out.println("\n*********");
        tekYaz21DenBuyukOlanTopla();
        System.out.println("\n*********");


    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void birden30olanSayilariSirala() {
        IntStream.iterate(1, t -> t + 1).limit(30).forEach(t -> System.out.print(t + " "));
        System.out.println();
        IntStream.range(1, 31).forEach(t -> System.out.print(t + " "));
    }

    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void birden30olanSayilariSirala2() {
        IntStream.rangeClosed(1, 30).forEach(t -> System.out.print(t + " "));
    }

    //S3 Istenen iki deger(dahil arasindaki sayilari toplayalim
    public static void ikiDegerTopla() {
        System.out.println(IntStream.rangeClosed(1, 30).sum());
    }

    //S4: 30 ile 40 arasindaki sayilarin (dahil) ortalamasini bulalim
    public static void ortBul3040() {
        System.out.println(IntStream.rangeClosed(30, 40).average());
    }

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static void bolunen8e() {
        System.out.println(IntStream.rangeClosed(325, 468).filter(t -> t % 8 == 0).count());
    }

    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void bolunen8eYaz() {
        IntStream.rangeClosed(325, 468).filter(t -> t % 8 == 0).forEach(t -> System.out.print(t + " "));
    }

    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static void bolunen8eTopla() {
        System.out.println(IntStream.rangeClosed(325, 468).filter(t -> t % 8 == 0).sum());
    }

    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static void carp7ile15() {
        IntStream.rangeClosed(7, 15).filter(t -> t % 2 == 1).map(t -> t * t).forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.println(IntStream.iterate(7, t -> t + 2).limit(5).reduce(1, (m, y) -> m * y));
        System.out.println();
        System.out.println(IntStream.rangeClosed(7, 15).filter(t -> t%2==1).reduce(1, (m, y) -> m * y));

    }
    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void pozitifTekIlk10AL() {
        IntStream.rangeClosed(1,200).filter(t -> t%2==1).limit(10).forEach(t -> System.out.print(t + " "));
        System.out.println();
        IntStream.iterate(1,t->t+2).limit(10).forEach(t -> System.out.print(t + " "));//coook basarili cleaner

    }

    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void tekYaz21DenBuyukOlan() {
        IntStream.iterate(21,t->t+7).filter(t->t%2==1).limit(10).forEach(t -> System.out.print(t + " "));

    }

    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
    public static void tekYaz21DenBuyukOlanTopla() {
        System.out.println(IntStream.iterate(21, t -> t + 7).limit(20).sum());
        IntStream.rangeClosed(7,300).sum();

    }
}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz