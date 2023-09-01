package ToyShopJava;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ShopLogic {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    Set<Toy> toys = new HashSet<>();

    public Toy getByID(int randomValue){
        return toys.stream().filter(toy -> toy.getID() == randomValue).findFirst().orElse(null);
    }
    public void createToy(){
        try{
            String name = inputNAME();
            if(toys.stream().anyMatch(t -> t.getNAME().equals(name))){
                System.out.println("Игрушка с таким именем уже есть в магазине");
                return;
            }
            Integer probability = inputPROBABILITY();
            if(probability == null){
                return;
            }
            Integer count = inputCOUNT();
            if(count == null){
                return;
            }
            Toy toy = new Toy(random.nextInt(Integer.MAX_VALUE), name, count, probability);
            toys.add(toy);
            System.out.printf("Игрушка успешно добавлена в магазин!", toy);
        } catch (InputMismatchException e){
            System.out.println("Необходимо ввести целочисленное значение!");
            sc.next();
        }
    }
    public void probabilityOfChange(){
        String name = inputNAME();
        if(toys.stream().noneMatch(toy -> toy.getNAME().equals(name))){
            System.out.println("Такой игрушки нет в магазине!");
            return;
        }
        try{
            Integer probability = inputPROBABILITY();
            if(probability == null){
                return;
            }
            toys.stream().filter(toy -> toy.getNAME().equals(name))
                    .peek(toy -> toy.setPROBABILITY(probability))
                    .forEach(System.out::println);
        } catch (InputMismatchException e){
            System.out.println("Необходимо ввести целочисленное значение");
            sc.next();
        } 
    }
    private String inputNAME(){
        System.out.println("Введите название игрушки: ");
        String s = sc.nextLine();
        return s;
    }
    private Integer inputCOUNT(){
        System.out.println("Введите количество игрушек");
        int count = sc.nextInt();
        if(count < 0){
            System.out.println("Необходимо ввести количество больше чем 0(ноль)");
            return null;
        }
        return count;
    }
    private Integer inputPROBABILITY(){
        System.out.println("Введите необходимый вес в %(от 0 до 100)");
        int probability = sc.nextInt();
        if(probability > 100){
            System.out.println("Вероятность выпадения должна быть в пределах от 0 до 100!");
            return null;
        }
        return probability;
    }
    public void saveToysInFile(Toy toys){
        String text = toys.toString();
        try(FileWriter writer = new FileWriter("ToyShopJava/Prize.txt", true)){
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void getPRIZE(){
        List<Integer> listToys = new ArrayList();
        for(Toy toy : toys){
            if(toy.getCOUNT() == 0){
                continue;
            }
            for (int i = 0; i < toy.getPROBABILITY(); i++) {
                listToys.add(toy.getID());
            }
        }
        if(listToys.size() == 0){
            System.out.println("Магазин пуст! Игрушек нет!");
            return;
        }
        int randomValue = random.nextInt(listToys.size());
        Toy prize = getByID(listToys.get(randomValue));
        prize.setCOUNT(prize.getCOUNT() - 1);
        System.out.println("Приз выпал!!!");
        saveToysInFile(prize);
        System.out.println("PRIZE WRITE IN FILE");
    }
}
