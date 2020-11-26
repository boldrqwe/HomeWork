package ProductShop;

import org.omg.CORBA.Object;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    //main
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        CartService cartService = context.getBean("cartService", CartService.class);
        System.out.println("сегодня в магазине есть следующие товары:");
        productService.display();
        boolean inShop = true;
        while (inShop) {
            System.out.println("напишите 1 чтобы купить новый товар");
            System.out.println("напишите 2 чтобы посмотреть товары в корзине");
            System.out.println("напишите 3 чтобы убрать товары из корзины");
            System.out.println("напишите 4 чтобы выйти из магазина");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {

                case 1:
                    System.out.println("Чтобы добавить товар в корзину выберите id товара");
                    Product p = productService.intoBasket(scanner.nextInt());
                    if (!Objects.equals(p,null)) {
                        cartService.add(p);
                        System.out.println("вы положили в корзину"+ p.toString());
                    } else {
                        System.out.println("такого товара нет в магазине!");
                    }
                    break;
                case 2:
                    System.out.println("общая сумма товаров составляет: " + cartService.totalCost());
                    cartService.findAll();
                    break;
                case 3:
                    System.out.println("введите id товара");

                    Product product = cartService.remove(scanner.nextInt());
                    if (!Objects.equals(product,null)) {
                        System.out.println("из корзины убрали: \n" + product.toString());
                        productService.addProduct(product);
                    } else {
                        System.out.println("такого товара нет в корзине");
                    }
                    break;
                case 4:
                    inShop = false;
                    break;
                default:
                    System.out.println("нет такой команды");
                    break;

            }

        }
    }
}
