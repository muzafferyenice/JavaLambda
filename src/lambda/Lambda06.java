package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

        System.out.println("\nTASK 01 --> haluk.txt dosyasini okuyunuz -->  ");
        Path haluk = Path.of("src/lambda/haluk.txt");//path haluk obj sine atandi
        Stream<String> akis = Files.lines(haluk);//haluk txt den datalari akis ile streama atandi
        Files.
                lines(Path.of("src/lambda/haluk.txt")).//dosya yolu tirnak icinde paste yapildiu
                forEach(System.out::println);
        Files.lines(Paths.get("src/lambda/haluk.txt")).forEach(System.out::println);
//2. yol
        akis.forEach(System.out::println);
        System.out.println("\nTASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files.lines(Paths.get("src/lambda/haluk.txt")).
                map(String::toUpperCase).//buyuk harfe cevrildi
                forEach(System.out::println);

        System.out.println("\nTASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz  -->  ");
        Files.lines(haluk).map(String::toLowerCase).limit(1).forEach(System.out::println);
        //2.yol
        System.out.println(Files.lines(haluk).map(String::toLowerCase).findFirst());

        System.out.println("\nTASK 04 --> haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(haluk).map(String::toLowerCase).filter(t -> t.contains("basari")).count());

        System.out.println("\nTASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).//split, array yapar kelimeleri
                        flatMap(Arrays::stream).//duz tek eleman array yapar
                distinct().//akistadi elemanlar tekrarsiz yapildi
                collect(Collectors.toList()));
//2. yol
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).//split, array yapar kelimeleri
                        flatMap(Arrays::stream).//duz tek eleman array yapar
                        collect(Collectors.toSet()));
        System.out.println("\nTASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
Files.lines(haluk).map(t->t.split(" ")).flatMap(Arrays::stream).sorted().forEach(System.out::println);

        System.out.println("\nTASK 07 --> haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.toLowerCase().split(" ")).//split ile array a cevrildi
                flatMap(Arrays::stream).//tek array a cevrildi akisa sunuldu
                filter(t -> t.equals("basari")).//istenen filtre yyapildi
                count());//sayisi

        System.out.println("\nTASK 08 --> haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).//txt dosyasina ersidldi
                map(t -> t.split(" ")).//satirlar akisa alindi
                flatMap(Arrays::stream).//her satirda ki her kelime akisa alindi
                filter(t -> t.contains("a")).//a bulunduran kelimeler filtrelendi
                count());//sayildik

        System.out.println("\nTASK 09 --> haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).map(t -> t.split(" ")).
                flatMap(Arrays::stream).filter(t -> t.contains("a")).//filter(t -> !t.contains("a")). cok onemli unlem li
                collect(Collectors.toList()));//tekrr toplayip yazdirdi

        System.out.println("\nTASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\W", "").//ozel karakterleri alir
                        replaceAll("\\d", "").split("")).//rakamlari alir
                flatMap(Arrays::stream).distinct().count());

        System.out.println("\nTASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", "").//ozel karakterleri alir
                     split(" ")).flatMap(Arrays::stream).distinct().count());
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", ""). //ozel karakterleri alir
                       split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));

        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", ""). //ozel karakterleri alir
                        split(" ")).flatMap(Arrays::stream).distinct().count());
    }
}

