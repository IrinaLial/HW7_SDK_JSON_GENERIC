package shop;

import com.alibaba.fastjson.JSON;
import fruit.Fruit;
import fruit.FruitDate;
import fruit.FruitType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class Shop {
    private List <Fruit> fruits = new ArrayList <> ( );

    public Shop ( ) {
    }
    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

    public List <Fruit> getFruits ( ) {
        return fruits;
    }

    public void addFruits ( String pathToJsonFile ) throws FileNotFoundException {
        String delivery = new Scanner (new File (pathToJsonFile)).useDelimiter ("\\Z").next ( );
        fruits.addAll (JSON.parseArray (delivery , Fruit.class));
    }

    public void save ( String pathToJsonFile ) throws IOException {
        FileWriter writer = new FileWriter (pathToJsonFile);
        writer.write (JSON.toJSONString (fruits));
        writer.flush ( );
    }

    public void load ( String pathToJsonFile ) throws FileNotFoundException {
        String json = new Scanner (new File (pathToJsonFile)).useDelimiter ("\\Z").next ( );
        fruits = JSON.parseArray (json , Fruit.class);
    }

    public List <Fruit> getSpoiledFruits ( Date date ) throws ParseException {
        List <Fruit> spoiledFruits = new ArrayList <> ( );
        for ( Fruit fruit : fruits ) {
            if ( new FruitDate (fruit).getDateSpoiled ( ).before (date) ) {
                spoiledFruits.add (fruit);
            }
        }
        return spoiledFruits;
    }

    public List <Fruit> getSpoiledFruits ( Date date , FruitType type ) throws ParseException {
        List <Fruit> spoiledFruits = new ArrayList <> ( );
        for ( Fruit fruit : fruits ) {
            if ( fruit.getFruitType ( ).equals (type) && new FruitDate (fruit).getDateSpoiled ( ).before (date) ) {
                spoiledFruits.add (fruit);
            }
        }
        return spoiledFruits;
    }

    public List <Fruit> getAvailableFruits ( Date date ) throws ParseException {
        List <Fruit> availableFruits = new ArrayList <> ( );
        for ( Fruit fruit : fruits ) {
            FruitDate fruitDate = new FruitDate (fruit);
            if ( fruitDate.getDateSpoiled ( ).after (date) || fruitDate.getDateSpoiled ( ).equals (date) ) {
                availableFruits.add (fruit);
            }
        }
        return availableFruits;
    }

    public List <Fruit> getAvailableFruits ( Date date , FruitType type ) throws ParseException {
        List <Fruit> availableFruits = new ArrayList <> ( );
        for ( Fruit fruit : fruits ) {
            FruitDate fruitDate = new FruitDate (fruit);
            if ( fruit.getFruitType ( ).equals (type) && ( fruitDate.getDateSpoiled ( ).after (date) || fruitDate.getDateSpoiled ( ).equals (date) ) ) {
                availableFruits.add (fruit);
            }
        }
        return availableFruits;
    }

    public List <Fruit> getAddedFruits ( Date date ) throws ParseException {
        List <Fruit> addedFruits = new ArrayList <> ( );
        SimpleDateFormat sdt = new SimpleDateFormat ("dd/MM/yyyy");
        for ( Fruit fruit : fruits ) {
            Date fruitDate = sdt.parse (fruit.getDate ( ));
            if ( fruitDate.equals (date) ) {
                addedFruits.add (fruit);
            }
        }
        return addedFruits;
    }

    public List <Fruit> getAddedFruits ( Date date , FruitType type ) throws ParseException {
        List <Fruit> addedFruits = new ArrayList <> ( );
        SimpleDateFormat sdt = new SimpleDateFormat ("dd/MM/yyyy");
        for ( Fruit fruit : fruits ) {
            if ( fruit.getFruitType ( ).equals (type) ) {
                Date fruitDate = sdt.parse (fruit.getDate ( ));
                if ( fruitDate.equals (date) ) {
                    addedFruits.add (fruit);
                }
            }
        }
        return addedFruits;
    }
}
