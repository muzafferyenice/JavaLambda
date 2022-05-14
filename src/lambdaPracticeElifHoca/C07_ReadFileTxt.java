package lambdaPracticeElifHoca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class C07_ReadFileTxt {

    /*
dosya eklemek icin 2 yol var
1) Files.lines(Path.of("path")  buradan stream e eklemek icin
Stream <String> satir=Files.lines(Path.of(".........."));
bu bize tekrardan stream tanimlamadan kullanmayi saglar
2) //Files.lines(Paths.get("..........")).  kullanilir
==========================================================
intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
sonrasinda copy path seciyoruz bundan sonra iki secenek var
1) absolute path seciyoruz yada
2) path from content root seciyoruz
her ikisinde de path kopyalamis oluyoruz
cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
*/
    public static void main(String[] args) throws  IOException {
        Files.lines(Path.of("src/linklerCodePractice"));// akisa sunmak icin dosya yolu budur
        Stream<String> satir=Files.lines(Path.of("src/linklerCodePractice"));// atama yapip obj uzerinden akisa sunduk
        Stream<String> satire=Files.lines(Path.of("src/lambdaPracticeElifHoca/asd"));// atama yapip obj uzerinden akisa sunduk

        // S1: Yazdiralim
       // satir.forEach(t-> System.out.println(t+" "));

        //S2: tum harflari buyuk harf ile yazdiralim
       // satir.map(t->t.toUpperCase()).forEach(System.out::println);
        System.out.println();
       // satir.map(String::toUpperCase).forEach(System.out::println);
       // Files.lines(Path.of("src/linklerCodePractice")).map(t->t.toUpperCase()).forEach(System.out::println);

        // S3: son satiri buyuk harfle yazdiralim
        //System.out.println(satire.count());
       Files.lines(Path.of("src/linklerCodePractice")).
               skip(Files.lines(Path.of("src/linklerCodePractice")).count()-1).
               map(String::toUpperCase).forEach(System.out::println);
        //satire.skip(4).map(String::toUpperCase).forEach(System.out::println);
       // satir.skip(15).map(String::toUpperCase).forEach(System.out::println);

        //S4: 2.ve 3. satirlari yazdiralim

        Files.lines(Path.of("src/linklerCodePractice")).skip(1).limit(2).// limit kac kez islem yapmak istediginiz belirler
                forEach(System.out::println);

        //S5: kac tane "icin" kelimesi vardir
        System.out.println(Files.lines(Path.of("src/linklerCodePractice")).filter(t -> t.contains("projesi")).count());
        System.out.println(Files.lines(Path.of("src/linklerCodePractice")).map(t -> t.split(" ")).flatMap(Arrays::stream).
                filter(t -> t.equals("projesi")).count());

        //S6: tum kelimeleri natural order  yazdiriniz.
        Path haluk = Path.of("src/linklerCodePractice");//path haluk obj atandi
        //Stream<String> akis = Files.lines(haluk);//haluk.çtxt dataları akıs stream'e atandı
        Files.lines(haluk).map(t -> t.split(" ")).flatMap(Arrays::stream).sorted().forEach(System.out::println);
        //Files.lines(haluk).map(t -> t.split(" ")).flatMap(Arrays::stream).sorted(Comparator.reverseOrder()).
                //forEach(System.out::println); terstten

        // S7:  metinde kac tane "a"  vardir
        System.out.println(Files.lines(haluk).map(t -> t.split("")).flatMap(Arrays::stream).
                filter(t -> t.equals("a")).count());// tum harfler icinde kac tane var
        System.out.println(Files.lines(haluk).filter(t -> t.contains("a")).count());//kac satirda geciyuor

    }
}
