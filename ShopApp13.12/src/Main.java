import Repositories.Repository;

import java.util.Scanner;

import UI.Ui;

   /*

 + Satislar
 + Mehsullar
 + Satis elave etmek - satis elave edilerken hansi mehsullardan hansi sayda satis oldugu gonderilir
 + Satisdan mehsulun geri qaytarilmasi
 + Umumi satisin geri qaytarilmasi
 + Verilen tarix araligina gore hemin tarix araligina olan satislarin qaytarilmasi
 + Verilen bir tarixe gore hemin tarix (il,ay,gun) ucun olan satislarin qaytarilmasi
 + Verilmis mebleg araligina gore edilmis satislarin qaytarilmasi
 + Verilmis nomreye esasen satisin qaytarilmasi
 + Yeni mehsul elave etmek
 + Mehsulun adini,sayini ve meblegini,categoriyasini deyismek (code-a gore tapilacaq)
 + Verilmis kateqoriyaya esasen hemin kateqoriyada olan mehsullarin qaytarilmasi
 + Verilmis qiymet araligina esasen hemin araliqda olan mehsullarin qaytarilmasi
 + Verilmis ada esasen mehsullarin search edilib qaytarilmasi


 1.1 1 secildikde Mehsullar uzerinde aparila bilinecek emeliyyatlarla bagli secimler gosterilir:

    + 1 Yeni mehsul elave et  - userden yeni mehsul yaradilmasi ucun lazim olan melumatlari daxil edilmelidir
    + 2 Mehsul uzerinde duzelis et -  duzelis edilecek mehsulun code-u ve duzelis melumatlari daxil edilmelidir
    + 3 Mehsulu sil - mehsulu kodu daxil edilmelidir
    + 4 Butun mehsullari goster - butun mehsullar gosterilecek (kodu,adi,categoriyasi,sayi,qiymeti)
    + 5 Categoriyasina gore mehsullari goster - usere var olan kateqoriyalar gosteilecek ve onlar arasinda bir secim etmelidir ve secilmis kateqoriyadan olan butun mehsullar gosterilir (kodu,adi,categoriyasi,sayi,qiymeti)
    + 6 Qiymet araligina gore mehsullari goster - userden minmum ve maximum qiymetleri daxil etmesi istenilir ve hemin qiymet araliginda olan mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)
    + 7 Mehsullar arasinda ada gore axtaris et - useden text daxil etmesi istenilir ve adinda hemin text olan butun mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)

1.2 2 secildikde satislar uzerinde aparila bilinecek emeliyyatlarla bagli secimler gosterilir:

    + 1 Yeni satis elave etmek - istifadeciden satis yaradilmasi ucun lazimi meulatlarin daxil edilmesi istenilir (mehsullarin kodlari)
    + 2 Satisdaki hansisa mehsulun geri qaytarilmasi( satisdan cixarilmasi) - userden satisin,cixarilacaq mehsulun ve sayinin daxil edilmesi istenilir
    + 3 Satisin silinmesi - satisin nomresine esasen silinmesi
    + 4 Butun satislarin ekrana cixarilmasi (nomresi,meblegi,mehsul sayi,tarixi)
    + 5 Verilen tarix araligina gore satislarin gosterilmesi - userden qebul edilen iki tarix araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)
    + 6 Verilen mebleg araligina gore satislarin gosterilmesi - userden qebul edilen iki mebleg araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)
    + 7 Verilmis bir tarixde olan satislarin gosterilmesi  - userden qebul edilmis bir tarixde olan satislarin gosterilmesi(nomresi,meblegi,mehsul sayi,tarixi)
    + 8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi - userden qebul edilmis nomdereye esasen hemin nomreli satisin melumatlarinin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi, satis itemlari (nomresi,mehsul adi,sayi))"
     */

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repository();

        Ui.run(repo);


    }
}