import javax.swing.*;
import java.io.*;

import java.util.*;
public  class  WestminsterShoppingManager implements ShoppingManager {

    static ArrayList<Product> productList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    static ArrayList<User> userList = new ArrayList<>();

    public void console(){

        WestminsterShoppingManager obj = new WestminsterShoppingManager();

        while (true){

            System.out.println("\n------------ Shopping Cart Admin Menu ------------"+ "\n");
            System.out.println("Options");
            System.out.println("Enter 1 for add a new product");
            System.out.println("Enter 2 for Delete a product");
            System.out.println("Enter 3 for  print list of products ");
            System.out.println("Enter 4 for save in a file ");
            System.out.println("Enter 5 for Go to the GUI ");
            System.out.println("Enter 6 for Exit from the console \n");

            Scanner input = new Scanner(System.in);
            boolean optionChecker = false;
            while (!optionChecker){

                System.out.print("Enter option: ");
                int option = 0;
                try {
                    option = input.nextInt();
                    input.nextLine();

                    if(option > 7 || option <= 0 ){
                        System.out.println("Invalid input,Try again.");
                        continue;
                    }

                    optionChecker = true;
                }
                catch (InputMismatchException ex) {
                    System.out.println("Invalid input,Try again.");
                    input.next();
                }

                switch (option){
                    case 1:
                        obj.addNewProduct();
                        break;
                    case 2:
                        obj.deleteProduct();
                        break;
                    case 3:
                        obj.printProducts();
                        break;
                    case 4:
                        obj.saveFile();
                        break;
                    case 5:
                        obj.logToGUI();
                        break;
                    case 6:
                        obj.exit();
                        break;
                }

            }

        }

    }

    public  void addNewProduct(){

        System.out.println("\n"+"Do yo need add Electronic items, Enter no 1");
        System.out.println("Do yo need add Clothing items, Enter no 2" + "\n");

        Scanner input = new Scanner(System.in);
        boolean inputChecker = false;
        int productClass = 0;
        while (!inputChecker) {
            System.out.print("Enter product class: ");
            try {
                productClass = input.nextInt();
                if (productClass > 3 || productClass < 0) {
                    System.out.println("Invalid input, Enter Again");
                    continue;
                }
                inputChecker = true;
            } catch (InputMismatchException ex) {
                System.out.println("Wrong Input, Enter Again");
                input.next();
            }
        }

        if(productClass == 1){

            String productID = "";
            inputChecker = false;
            int digits = 0;
            while (!inputChecker) {
                System.out.print("Enter Product ID of Electronics(Please enter numbers only) : ");
                try {
                    digits = input.nextInt();
                    if (digits<0 || digits>=10000){
                        System.out.println("Enter valid integer !!!");
                        continue;
                    }
                    productID = "A"+String.valueOf(digits);
                    boolean productExisted = false;
                    for (Product product:productList){
                        if (product.getProduct_ID().equals(productID)){
                            System.out.println("Product already exists in the stock");
                            productExisted = true;
                            break;
                        }
                    }
                    if (productExisted){
                        continue;
                    }
                    inputChecker = true;
                }
                catch (Exception e){
                    System.out.println("Enter only integers !!! ");
                    input.next();
                }
            }

            System.out.print("Enter product Name: ");
            String productName = input.next();


            int availableItems = 0;
            inputChecker = false;
            while (!inputChecker) {
                System.out.print("Enter Available items: ");
                try {
                    availableItems = input.nextInt();
                    if (availableItems<0){
                        System.out.println("Enter correct Input  ");
                        continue;
                    }
                    inputChecker = true;
                }
                catch (Exception e){
                    System.out.println("Enter correct Input");
                    input.next();
                }
            }

            double price = 0;
            inputChecker = false;
            while (!inputChecker) {
                System.out.print("Enter product price: ");
                try {
                    price = input.nextDouble();
                    if (price<0.0){
                        System.out.println("Enter correct Input");
                        continue;
                    }
                    inputChecker = true;
                }
                catch (Exception e){
                    System.out.println("Enter correct Input");
                    input.next();
                }
            }

            System.out.print("Enter product brand: ");
            String brand = input.next();

            System.out.print("Enter product Warranty: ");
            String  warranty = input.next();

            Electronics e = new Electronics(productID,productName,availableItems,price,brand,warranty);
            productList.add(e);

        }else if(productClass == 2){

            String productID = "";
            inputChecker = false;
            int digits = 0;
            while (!inputChecker) {
                System.out.print("Enter Product ID of Clothing(Please enter numbers only) : ");
                try {
                    digits = input.nextInt();
                    if (digits<0 || digits>=10000){
                        System.out.println("Enter valid integer !!!");
                        continue;
                    }
                    productID = "B"+String.valueOf(digits);
                    boolean productExisted = false;
                    for (Product product:productList){
                        if (product.getProduct_ID().equals(productID)){
                            System.out.println("Product already exists in the stock");
                            productExisted = true;
                            break;
                        }
                    }
                    if (productExisted){
                        continue;
                    }
                    inputChecker = true;
                }
                catch (Exception e){
                    System.out.println("Enter only integers !!! ");
                    input.next();
                }
            }

            System.out.print("Enter product Name: ");
            String productName = input.next();


            int availableItems = 0;
            inputChecker = false;
            while (!inputChecker) {
                System.out.print("Enter Available items: ");
                try {
                    availableItems = input.nextInt();
                    if (availableItems<0){
                        System.out.println("Enter correct Input  ");
                        continue;
                    }
                    inputChecker = true;
                }
                catch (Exception e){
                    System.out.println("Enter correct Input");
                    input.next();
                }
            }

            double price = 0;
            inputChecker = false;
            while (!inputChecker) {
                System.out.print("Enter product price: ");
                try {
                    price = input.nextDouble();
                    if (price<0.0){
                        System.out.println("Enter correct Input");
                        continue;
                    }
                    inputChecker = true;
                }
                catch (Exception e){
                    System.out.println("Enter correct Input");
                    input.next();
                }
            }

            System.out.print("Enter product size: ");
            String size = input.next();

            System.out.print("Enter product colour: ");
            String  color = input.next();

            Clothing e = new Clothing(productID,productName,availableItems,price,size,color);
            productList.add(e);

        }

    }


    public  void deleteProduct() {
        System.out.println("Madawa");
        String productID = "";
        boolean inputChecker = false;
        int digits = 0;
        String productId = "";
        while (!inputChecker) {
            System.out.print("Enter Product ID to delete in format 'A0000' or 'B0000' : ");
            productId = input.next();

            if ((productId.substring(0,1).equals("A") || productId.substring(0,1).equals("B")) ){
                try{
                    int digits1 = Integer.parseInt(productId.substring(1));
                    if (digits1<0 || digits1>=10000){
                        System.out.println("Invalid input number !!! ");
                        continue;
                    }
                    inputChecker = true;
                }catch (Exception e){
                    System.out.println("Invalid input number !!!");
                }
            }else{
                System.out.println("Invalid product ID !!!");
            }
        }
        for (Product product:productList){
            if (product.getProduct_ID().equals(productId)){
                productList.remove(product);
                System.out.println("Product is successfully removed !!!");
                return;
            }
        }
        System.out.println("Product ID doesn't exist !!!");
    }
    public  void printProducts(){

        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {

                return o1.getProduct_ID().compareTo(o2.getProduct_ID());
            }

        });
        for (Product products:productList) {
            System.out.println(products.getInfo());
        }



    }
    public  void saveFile() {

        try {
            FileWriter writer = new FileWriter("Cart.txt");
            for (Product product : productList) {
                if (product instanceof Electronics) {
                    writer.write(product.getProduct_ID() + "," + product.getProduct_name() + ","+"Electronics," + product.getNum_of_items() + "," + product.getPrice() + ","+ ((Electronics) product).getBrand()+","+ ((Electronics) product).getWarranty_period()+"\n");
                }else if (product instanceof Clothing){
                    writer.write(product.getProduct_ID() + "," + product.getProduct_name() + "," +"Clothing,"+ product.getNum_of_items() + "," + product.getPrice() + ","+ ((Clothing) product).getSize()+","+ ((Clothing) product).getColor()+"\n");
                }
            }
            writer.close();
            System.out.println("Data saved to file successfully");
        } catch (IOException e) {
            System.out.println("\nError while saving data: " + e);
        }
    }

    public void saveUserInfo(){

        try {
            FileWriter writer = new FileWriter("UserInfo.txt");

            for (User user: userList){
                writer.write(user.getUsername() +","+ user.getPassword() +"\n");
            }
            writer.close();
            System.out.println("Data saved to file successfully");
        }
        catch (IOException e){
            System.out.println("\nError while saving data" + e);
        }
    }

    public static void saveInfo() {
        try {
            FileWriter writer = new FileWriter("Cart.txt");
            for (Product product : productList) {
                if (product instanceof Electronics) {
                    writer.write(product.getProduct_ID() + "," + product.getProduct_name() + ","+"Electronics," + product.getNum_of_items() + "," + product.getPrice() + ","+ ((Electronics) product).getBrand()+","+ ((Electronics) product).getWarranty_period()+"\n");
                }else if (product instanceof Clothing){
                    writer.write(product.getProduct_ID() + "," + product.getProduct_name() + "," +"Clothing,"+ product.getNum_of_items() + "," + product.getPrice() + ","+ ((Clothing) product).getSize()+","+ ((Clothing) product).getColor()+"\n");
                }
            }
            writer.close();
            System.out.println("Data saved to file successfully");
        } catch (IOException e) {
            System.out.println("\nError while saving data: " + e);
        }
    }

    public  void  exit(){

        System.exit(0);
    }

    public  void logToGUI() {
        Scanner input = new Scanner(System.in);
        while (true) {

            String user = "";
            boolean inputChecker = false;
            while (!inputChecker) {

                System.out.print("Are you a new user(Enter y to yes, Enter n to no): ");

                try {

                    user = input.nextLine();
                    if (!user.equals("y") && (!user.equals("Y")) && (!user.equals("n")) && (!user.equals("N"))){
                        System.out.println("Enter valid input");
                        continue;
                    }
                    inputChecker = true;

                } catch (Exception e) {
                    System.out.println("Enter valid input");
                    input.next();
                }

            }
            if ((user.equals("y")) || (user.equals("Y")) )  {
                System.out.print("Enter Username: ");
                String userNameY = input.nextLine();

                System.out.print("Enter Password: ");
                String passwordY = input.nextLine();

                boolean userExisted = false;
                for (User details: userList){
                    if (details.getUsername().equals(userNameY) && details.getPassword().equals(passwordY)){
                        System.out.println("Username and password exit");
                        userExisted = true;
                        break;

                    }
                }
                if (!userExisted){
                    User info = new User(userNameY,passwordY);
                    userList.add(info);

                    WestminsterGUI frame = new WestminsterGUI(productList);
                    frame.setTitle("Westminster Shopping Center");
                    frame.setSize(900, 800);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    saveUserInfo();
                    return;
                }

//                for (User user1: userList){
//                    System.out.println(user1.toString());
//                }


            }


             if ((user.equals("n")) || (user.equals("N")) )  {
                System.out.print("Enter Username: ");
                String userNameN = input.nextLine();

                System.out.print("Enter Password: ");
                String passwordN = input.nextLine();

                 boolean userExisted = false;
                 for (User details: userList){
                     if (details.getUsername().equals(userNameN) && details.getPassword().equals(passwordN)){
                         System.out.println("Successfully login");
                         WestminsterGUI frame = new WestminsterGUI(productList);
                         frame.setTitle("Westminster Shopping Center");
                         frame.setSize(900, 800);
                         frame.setVisible(true);
                         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         userExisted = true;
                         break;

                     }
                 }
                 if (!userExisted){
                     System.out.println("Username or password are not in the list \n");


                 }

            }

            break;


        }
    }

    public void load(){
        try (BufferedReader reader = new BufferedReader(new FileReader("Cart.txt"))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if (data[2].equals("Electronics")){
                    productList.add(new Electronics(data[0],data[1],Integer.parseInt(data[3]),Double.parseDouble(data[4]),data[5],data[6]));
                } else if (data[2].equals("Clothing")) {
                    productList.add(new Clothing(data[0],data[1],Integer.parseInt(data[3]),Double.parseDouble(data[4]),data[5],data[6]));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void userLoad(){
        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");

                userList.add(new User(data[0], data[1]));
            }

        }
        catch (IOException e){
            e.printStackTrace();

        }
    }


}

