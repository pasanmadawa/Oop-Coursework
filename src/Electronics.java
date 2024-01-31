public  class Electronics extends Product {

    private String brand;
    private String warranty_period;

    public Electronics(){

    }

    public Electronics(String brand, String warranty_period){

        this.brand = brand;
        this.warranty_period = warranty_period;
    }
    public Electronics(String productID,String productName, int productItems,double price,String brand, String warranty_period){
        super(productID,productName,productItems,price);
        this.brand = brand;
        this.warranty_period = warranty_period;
    }


    public void setBrand(String brand1){

        this.brand = brand1;
    }

    public void setWarranty_period(String warranty_period1){

        this.warranty_period = warranty_period1;
    }

    public String getBrand() {

        return brand;
    }

    public String getWarranty_period() {

        return warranty_period;
    }

    @Override
    public String toString() {

        return getBrand()+","+getWarranty_period();
    }

    public String getInfo(){
        return "\nProduct ID: "+getProduct_ID() +"\n"+ "Category: "+ this.getClass().getSimpleName() +"\n"+ "Name: " +getProduct_name() +"\n"+ "Brand :" + getBrand() +"\n"+"Warranty Period: "+getWarranty_period() +"\n"+"Items Available: "+getNum_of_items();
    }
}
