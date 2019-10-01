package coffemachine;

public class Sale {
    private final int[] money = {50, 100, 200, 500, 1000};
    private final int[] coins = {10, 5, 2, 1};
    private static Drinks[] drink = new Drinks[7];
    private final Input input;

    public Sale(Input input) {
        this.input = input;
    }

    public void init() {
        int value;
        int coffeId;
        boolean exit = false;
        showMenu();
         do {
             value = this.input.ask("Вставьте купюру : ");
             for (int num : money) {
                if (value == num) {
                   exit = true;
                   break;
                }
             }

         } while (!exit);
         do {
             coffeMenu();
             coffeId = this.input.ask("Выберите кофе введие число от 1 до 7");
         } while (coffeId < 1 | coffeId > 7);
         changes(value, drink[coffeId - 1].getPrice());


    }

    public int[] changes(int value, int price) {
        int[] result = new int[99];
        int cStep = 0;
        int size = 0;
        int change = value - price;
        while (change >= 1) {
            if (change >= coins[cStep]) {
                change = change - coins[cStep];
                result[size] = coins[cStep];
                size++;
            } else {
                cStep++;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

   private void coffeMenu() {
       for (int i = 0; i < drink.length; i++) {
           System.out.println(drink[i].getId() + " " + drink[i].getName() + " " + drink[i].getPrice() + "рублей");
       }
   }

    private void showMenu() {
        for (int i = 0; i != money.length; i++) {
            System.out.println(money[i]);
        }
    }


    public static void main(String[] args) {
        Sale sale = new Sale(new ConsInput());
        drink[0] = new Drinks(1, "Лате", "кофе, молоко", 45);
        drink[1] = new Drinks(2, "Капучино", "кофе, молоко", 12);
        drink[2] = new Drinks(3, "Кофе со сливками", "кофе, молоко", 25);
        drink[3] = new Drinks(4, "Американо", "кофе, молоко", 30);
        drink[4] = new Drinks(5, "Мокачино", "кофе, молоко", 20);
        drink[5] = new Drinks(6, "Экспрессо", "кофе, молоко", 35);
        drink[6] = new Drinks(7, "Черное кофе", "кофе, молоко", 26);
        sale.init();
    }
}
