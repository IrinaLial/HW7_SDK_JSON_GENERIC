package fruit;

public class Fruit {
    private FruitType fruitType;
    private int shelfTime;
    private String date;
    private int price;

    public Fruit ( FruitType fruitType , int shelfTime , String date , int price ) {
        this.fruitType = fruitType;
        this.shelfTime = shelfTime;
        this.date = date;
        this.price = price;
    }

    public FruitType getFruitType ( ) {
        return fruitType;
    }

    public void setFruitType ( FruitType fruitType ) {
        this.fruitType = fruitType;
    }

    public int getShelfTime ( ) {
        return shelfTime;
    }

    public void setShelfTime ( int shelfTime ) {
        this.shelfTime = shelfTime;
    }

    public String getDate ( ) {
        return date;
    }

    public void setDate ( String date ) {
        this.date = date;
    }

    public int getPrice ( ) {
        return price;
    }

    public void setPrice ( int price ) {
        this.price = price;
    }

    @Override
    public String toString ( ) {
        return "Fruit{" +
                "fruitType=" + fruitType +
                ", shelfTime=" + shelfTime +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
