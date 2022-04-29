package lambda;

import java.util.List;

public class Lambda04 {
    /*
   TASK :
   fields --> Universite (String)
              bolum (String)
              ogrcSayisi (int)
              notOrt (int)
              olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
    */


    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

public static boolean noyOrt74BuyukUniv(List<Lambda04Pojo> universite){
    return universite.stream().allMatch(t->t.getNotOrt()>74);
}
    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.


    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.


    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz


    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.


    //task 10-->Ogrenci sayilari 130'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz


    //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

}

