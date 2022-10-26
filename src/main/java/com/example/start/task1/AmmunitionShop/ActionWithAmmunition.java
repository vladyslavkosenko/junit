package com.example.start.task1.AmmunitionShop;
/*
1.	Определить иерархию амуниции. Экипировать мотоциклиста. Посчитать стоимость.
 Провести сортировку амуниции на основе веса. Найти элементы амуниции, соответствующие заданному диапазону параметров цены.

 */

import com.example.start.task1.Ammunition.MotorcycleAmmunition;

import java.util.*;


public class ActionWithAmmunition {

    private Shop shop;

    public ActionWithAmmunition(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    //вывод на  консоль информации о списке
    public void showItemsInfo(List<? extends MotorcycleAmmunition> list) {

        for (MotorcycleAmmunition motorcycleAmmunitions : list) {
            System.out.println(motorcycleAmmunitions);
        }
    }

    //проверка является ли  предлагаемый список  пустым
    public boolean isAmmunitionListNotEmpty(List<? extends MotorcycleAmmunition> list) {

        if (list.size() > 0) {
            return true;
        }
        return false;
    }


    //ввод индекс значения
    public String inputIndexValue(String message) {
        System.out.println("Enter your value");

        Scanner sc = new Scanner(System.in);

        String value = sc.nextLine();

        while (!(isInputIndexValidationTrue(value))) {
            System.out.println(message);
            value = sc.nextLine();
        }

        return value;

    }

    //проверка вводимого значения индекса
    public boolean isInputIndexValidationTrue(String value) {

        if (value.matches("^-?[0-9]+$")) {
            return true;
        }
        return false;
    }

    //присваивание значения(общее для всех методов)
    public int parseValue(String value) {

        int number = Integer.parseInt(value);

        return number;
    }


    //ввод значения да/нет
    public String inputYesNoValue(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your value");

        String value = sc.nextLine();

        while (!(isYesNoValidationTrue(value))) {
            System.out.println(message);
            value = sc.nextLine();
        }

        return value;

    }

    //проверка вводимого значения да/нет
    public boolean isYesNoValidationTrue(String value) {

        if (value.matches("^(0|1)$")) {
            return true;
        }
        return false;
    }


    //проверка индекс значения   с размерностью передоваемого списка
    public boolean isInputIndexNumberBeInRangeListSize(int number, List<? extends MotorcycleAmmunition> list) {

        if (number < list.size() && number >= 0) {
            return true;
        }
        return false;
    }

    // проверка  на ввод отрицания, т.е. что покупателю не нужно ничего из  списка
    public boolean isDenial(int number) {
        int cancel = -1;

        if (number == cancel) {
            return true;
        }
        return false;
    }

    // проверка  на ввод да/нет( если необходимо еще добавить какой то  итем из списка)
    public boolean isYesOrNo(int number) {

        int yes = 0;
        if (number == yes) {
            return true;
        }
        return false;
    }

    //Выбор того или  иного итема
    public List<? extends MotorcycleAmmunition> selectAmmunition(List<? extends MotorcycleAmmunition> list) {

        List<MotorcycleAmmunition> selectedItems = new ArrayList<>();

        boolean valid = true;
        if (isAmmunitionListNotEmpty(list)) {

            while (valid) {
                System.out.println("Please make you choose");
                int enterIndexNumber = parseValue(inputIndexValue("Please,try again, you need to enter a number"));
                if (isDenial(enterIndexNumber)) {
                    break;
                }
                if (isInputIndexNumberBeInRangeListSize(enterIndexNumber, list)) {
                    //   for (int i = 0; i < list.size(); i++) {

                    //     if (i == enterIndexNumber) {
                    selectedItems.add(list.get(enterIndexNumber));
                    valid = false;
                    System.out.println("Do you want to choose more? - Yes(0)/No(1)");
                    int selectYesNo = parseValue(inputYesNoValue("Please,try again "));

                    if (isYesOrNo(selectYesNo)) {
                        valid = true;
                        break;
                    } else {
                        break;
                        //    }
                        //       }
                    }
                    //    } else {
                    //        System.out.println("Incorrect index number");
                }
            }

        } else {
            System.out.println("No items");
        }

        return selectedItems;
    }


    //сортировка по весу
    public List<? extends MotorcycleAmmunition> sortByWeight(List<? extends MotorcycleAmmunition> list) {
        Comparator<MotorcycleAmmunition> comparator = new ClassComparator();

        Collections.sort(list, comparator);

        return list;
    }

    //метод для ввода диапазона значений
    public String inputMaxMinValue(String message) {
        Scanner sc = new Scanner(System.in);

        String value = sc.nextLine();

        while (!(isMaxMinValidationTrue(value))) {
            System.out.println(message);
            value = sc.nextLine();
        }

        return value;

    }

    //проверка МАХ МИН значения
    public boolean isMaxMinValidationTrue(String value) {

        if (value.matches("^[0-9]+\\.?[0-9]*$")) {
            return true;
        }
        return false;
    }

    //поиск элементов в  диапазоне
    public void findAndShowItemsInRangePrice(List<? extends MotorcycleAmmunition> list) {

        boolean valid = true;

        double minPrice;
        double maxPrice;

        if (isAmmunitionListNotEmpty(list)) {
            while (valid) {
                minPrice = parseValue(inputMaxMinValue("Wrong min value, Please, try again"));
                maxPrice = parseValue(inputMaxMinValue("Wrong max value, Please, try again"));

                if (minPrice < maxPrice && minPrice > 0 && maxPrice > 0) {

                    for (MotorcycleAmmunition motorcycleAmmunition : list) {

                        if (motorcycleAmmunition.getPrice() >= minPrice && motorcycleAmmunition.getPrice() <= maxPrice) {
                            System.out.println(motorcycleAmmunition);
                            valid = false;

                        }
                    }
                    if (valid) {
                        System.out.println("Sorry, we don't have  items  in  this price range , please try again ");
                    }

                } else {
                    System.out.println("Sorry,incorrect values,  please try again ");
                }
            }
        } else {
            System.out.println("No items");
        }
    }
}


/*

ТЕСТ
1 стоимость не может быть отрицательной, стоимость не может быть равна 0
2 вес не может быть отрицательным( возможно объединить со стоимостью) , вес  не может быть равна 0
3 диапазон цен не может быть отрицательным
Действие --- ожидаемый результат --- фактический результат

    По-русски валидация – это проверка правильности выводов.
    То есть, должен быть свод знаний, в котором описано, как получить описание конструкции на основе данных об объекте.

 */