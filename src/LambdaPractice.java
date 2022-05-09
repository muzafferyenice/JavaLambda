import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class LambdaPractice {

        /* TASK :

         * Input olarak verilen listteki isimlerden
         * icinde ‘a’ harfi bulunanlari silen bir code create ediniz.
         *
         * INPUT : list1={"Ali","Veli","Ayse","Fatma","Omer"}
         * OUTPUT : [Veli,Omer]
         */
/*
ArrayList<String> isimler = new ArrayList<String>(Arrays.asList("Ali", "Veli", "Ayse", "Fatma", "Omer"));
        isimler.removeIf(t->t.contains("a")||t.contains("A"));
        System.out.println(isimler);

 */
    public static void aHarfSilGerisiniYazdir(ArrayList<String> names) {
        System.out.println(names.stream().map(t->t.toLowerCase()).filter(t -> !t.contains("a")).collect(Collectors.toList()));
        System.out.println(names.stream().filter(t ->!t.contains("a") && !t.contains("A")).collect(Collectors.toList()));

        names.removeIf(t->t.contains("a")||t.contains("A"));
        System.out.println(names);

    }

}
