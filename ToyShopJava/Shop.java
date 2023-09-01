package ToyShopJava;

import java.util.InputMismatchException;

public class Shop {
    ShopLogic logic = new ShopLogic();
    public void menu(){
        System.out.println("Программа Магазин Игрушек\n ВЫБЕРИТЕ ДЕЙСТВИЕ: ");
        System.out.println("1 - Создать новую игрушку");
        System.out.println("2 - Изменить вес");
        System.out.println("3 - Произвести розыгрыш");
        System.out.println("4 - Вывести имеющиеся игрушки");
        System.out.println("5 - Выход из программы");
        boolean flag = false;
        while (!flag) {
            int number = 0;
            try {
                number = logic.sc.nextInt();
            } catch (InputMismatchException e) {
                number = logic.sc.nextInt();
                continue;
            }
            switch(number){
                case 1: logic.createToy();
                break;
                case 2: logic.probabilityOfChange();
                break;
                case 3: logic.getPRIZE();
                break;
                case 4: logic.toys.forEach(System.out::println);
                break;
                case 5: flag = true;
                break;
                default: flag = true;
                System.out.println("Завершена работа!");
            }
        }
    }
}
