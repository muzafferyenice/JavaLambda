package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lambda.Lambda03.*;

public class Lambda03Runner {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilice", "havucdilim", "buryan",
                "kokorec", "yagalama", "guvec"));
        System.out.println("\n   ***   ");
        alfabetikBuyukHarfTekrarsiz(menu);
        System.out.println("\n   ***   ");
        strKarakterSayisiYazdir(menu);
        System.out.println("\n   ***   ");
        strKarakterSayiKucuktenBuyuge(menu);
        System.out.println("\n   ***   ");
        sonHarfeGoreTersSira(menu);
        System.out.println("\n   ***   ");
        karakterCiftKareBuyuktenKucuge(menu);
        System.out.println("\n   ***   ");

    }
}
