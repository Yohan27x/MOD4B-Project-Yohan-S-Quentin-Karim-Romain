package Shop.models;
import java.util.ArrayList;


public class ListOfProducts {
    public ArrayList<Product> AllAvailableProducts = new ArrayList<>();

    public ListOfProducts(){

        // retrieve MySQL data ...
    }

    public void FillUserCart(){
        // ajouter seulememnt les produits qui ont true pour user à la liste
        Product product1 = new Product("Apple", 5, "https://static.wikia.nocookie.net/minecraft/images/e/e5/AppleOld.png/revision/latest?cb=20200805163025", "food");
        AllAvailableProducts.add(product1);
        Product product2 = new Product("Bone", 3, "https://static.wikia.nocookie.net/minecraft/images/2/25/BoneNew.png/revision/latest?cb=20190901164534", "armor");
        AllAvailableProducts.add(product2);
        Product product3 = new Product("Coal", 3, "https://static.wikia.nocookie.net/minecraft/images/d/de/CoalNew.png/revision/latest?cb=20190902204730", "food");
        AllAvailableProducts.add(product3);
        Product product4 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        AllAvailableProducts.add(product4);
        Product product5 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
    }

    public void FillShopAvailableProduct(){
        Product product1 = new Product("Apple", 5, "https://static.wikia.nocookie.net/minecraft/images/e/e5/AppleOld.png/revision/latest?cb=20200805163025", "food");
        AllAvailableProducts.add(product1);
        Product product2 = new Product("Bone", 3, "https://static.wikia.nocookie.net/minecraft/images/2/25/BoneNew.png/revision/latest?cb=20190901164534", "armor");
        AllAvailableProducts.add(product2);
        Product product3 = new Product("Coal", 3, "https://static.wikia.nocookie.net/minecraft/images/d/de/CoalNew.png/revision/latest?cb=20190902204730", "food");
        AllAvailableProducts.add(product3);
        Product product4 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");
        AllAvailableProducts.add(product4);
        Product product5 = new Product("Diamond", 3, "https://static.wikia.nocookie.net/minecraft/images/2/2f/New_DiamondB.png/revision/latest?cb=20190520094830", "food");

    }


}
