public class  Clothing extends Product {

    public String size;
    public String color;

    public Clothing(){

    }

    public Clothing(String size, String color){

        this.size = size;
        this.color = color;
    }
    public Clothing(String productID,String productName,int productOfItems,double price, String size, String color ){
        super(productID,productName,productOfItems,price);
        this.size = size;
        this.color = color;
    }
    public void setSize(String size1){
        this.size = size1;

    }
    public void setColor(String color1){
        this.color = color1;
    }

    public String getSize(){
        return size;
    }

    public String getColor() {

        return color;
    }




    public String toString(){
        return getSize()+","+getColor();
    }

    public String getInfo(){
        return "\nProduct ID: "+getProduct_ID() +"\n"+ "Category: "+ this.getClass().getSimpleName() +"\n"+ "Name: " +getProduct_name() +"\n"+ "Size: " + getSize() +"\n"+"Color: "+getColor()+"\n"+"Items Available: "+getNum_of_items();
    }

}

