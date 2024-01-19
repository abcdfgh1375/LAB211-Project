
package Model;
public class Order {
    private String buyerName;
    private int fruitId;
    private String fruitName;
    private int price;
    private int buyerQuan;
    private int amount;

    public Order(String buyerName, int fruitId, String fruitName, int price, int buyerQuan, int amount) {
        this.buyerName = buyerName;
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.buyerQuan = buyerQuan;
        this.amount = amount;
    }

    public Order() {
   }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
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

    public int getBuyerQuan() {
        return buyerQuan;
    }

    public void setBuyerQuan(int buyerQuan) {
        this.buyerQuan = buyerQuan;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
      @Override
    public String toString() {
    return String.format("%-12s%-8s%s$%8s$", fruitName, buyerQuan, price, amount);

}
}
