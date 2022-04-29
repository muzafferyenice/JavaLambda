package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lambda.Lambda04.noyOrt74BuyukUniv;

public class Lambda04Runner {

    public static void main(String[] args) {
        Lambda04Pojo bogazici = new Lambda04Pojo("bogazici", "bilgisayar", 571, 88);
        Lambda04Pojo marmara = new Lambda04Pojo("marmara", "diyetisyen", 666, 96);
        Lambda04Pojo harran = new Lambda04Pojo("harran", "kimya", 550, 75);
        Lambda04Pojo odtu = new Lambda04Pojo("odtu", "matematik", 1222, 95);
        Lambda04Pojo itu = new Lambda04Pojo("itu", "biyoloji", 1500, 90);
        List<Lambda04Pojo> universite = new ArrayList<>(Arrays.asList(bogazici,marmara,harran,odtu,itu));

        System.out.println(noyOrt74BuyukUniv(universite));
        System.out.println("***************************");





    }
}
