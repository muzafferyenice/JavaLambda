package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lambda.Lambda03.*;

public class Lambda03Runner {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "Wadana", "trilice", "havucdilim", "buryan",
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
        karakterSayiYedidenBuyuk(menu);
        System.out.println("\n   ***   ");
        basHarfiWIleBaslayan(menu);
        System.out.println("\n   ***   ");
        xIleBitenEleman(menu);
        System.out.println("\n   ***   ");
        karkterEnFazla(menu);
        System.out.println("\n   ***   ");
        sonHarfeGoreSiralaIlkHaricElmanlariYaz(menu);
        System.out.println("\n   ***   ");

    }
}
