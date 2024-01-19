
package Model;

public class Fruit {
    private int fruitId;
    private String fruitName;
    private int price;
    private int fruitQuan;
    private String origin;

    public Fruit(int fruitId, String fruitName,int fruitQuan, String origin, int price) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.fruitQuan = fruitQuan;
        this.origin = origin;
    }

    public Fruit() {
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFruitQuan() {
        return fruitQuan;
    }

    public void setFruitQuan(int fruitQuan) {
        this.fruitQuan = fruitQuan;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
    return String.format("%-7s%-13s%-16s%-17s%s$", "",fruitId,fruitName, origin, price);
//    return String.format("%7s%17s%17s%13s$", fruitId,fruitName, origin, price);
}

    
    
}
