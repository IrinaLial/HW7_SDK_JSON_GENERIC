import fruit.Fruit;
import fruit.FruitType;
import fruit.FruitDate;
import shop.Shop;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main ( String[] args ) throws ParseException, IOException {
        final String FILEPATH = "files/file_fruits.json";

        Fruit fruitApple = new Fruit(FruitType.Apple, 9, "21/10/2017", 14);
        Fruit fruitOrange = new Fruit(FruitType.Lemon, 5, "21/10/2017", 18);
        Fruit fruitBanana = new Fruit(FruitType.Banana, 2, "21/10/2017", 18);

        Shop shop = new Shop();
        shop.add(fruitApple);
        shop.add(fruitOrange);
        shop.add(fruitBanana);
        String stringCheckDate = "21/10/2017";
        Date checkDate = new SimpleDateFormat("dd/MM/yyyy").parse(stringCheckDate);


       List<Fruit> available =  shop.getAvailableFruits(checkDate);
       for (Fruit fruit : available) {
            System.out.println(fruit.toString ());
        }
        System.out.println("...................................");
        List<Fruit> spoiled =  shop.getSpoiledFruits(checkDate);
        for (Fruit fruit : spoiled) {
            System.out.println("SPOILED:\n" + fruit.toString ());
        }

        List<Fruit> added = shop.getAddedFruits(checkDate);
        for (Fruit fruit : added) {
            System.out.println("ADDED on " + stringCheckDate + ":\n" + fruit.toString ());

        }
        System.out.println("...................................");

        shop.save(FILEPATH);
        shop.load(FILEPATH);
        shop.addFruits(FILEPATH);
        shop.addFruits(FILEPATH);
        shop.toString ();

        FruitDate appleDates = new FruitDate(fruitApple);
        System.out.println(("Date received: " + new SimpleDateFormat("dd.MM.yyyy").format(appleDates.getDateReceived())));
        System.out.println(("Date spoiled: " + new SimpleDateFormat("dd.MM.yyyy").format(appleDates.getDateSpoiled())));



    }

}

