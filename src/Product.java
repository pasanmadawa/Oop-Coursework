public abstract class Product {

    private String product_ID;
    private String product_name;
    private int num_of_items;
    private double price;

    private int UserQuantity = 0;

    public Product() {

    }

    public Product(String product_ID, String product_name, int num_of_items, double price) {

        this.product_ID = product_ID;
        this.product_name = product_name;
        this.num_of_items = num_of_items;
        this.price = price;
    }

    public String getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(String product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getNum_of_items() {
        return num_of_items;
    }

    public void setNum_of_items(int num_of_items) {
        this.num_of_items = num_of_items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public int getUserQuantity() {

        return UserQuantity;
    }

    public void setUserQuantity(int userQuantity) {
        UserQuantity = userQuantity;
    }


    public abstract String toString();



    public abstract String getInfo();



}