package ex00;

public class Program {
    public static void main(String[] args) {
        User Glasha = new User( "Glasha", 200001, 1);
        User Izolda = new User( "Izolda", 13000, 2);
		// Glasha.print_user();
        System.out.println("Баланс Глафиры: " + Glasha.getBalance());
        System.out.println("Баланс Изольды: " + Izolda.getBalance());
        System.out.println("Глафира переводит 2000 Изольде:");
		// System.out.println("pukpuk");
        Transaction transfer = new Transaction(Izolda, Glasha, 2000, Category.DEBIT);
		System.out.println(transfer.print_trans());
		System.out.println();



		// once again
		System.out.println("Баланс Глафиры: " + Glasha.getBalance());
        System.out.println("Баланс Изольды: " + Izolda.getBalance());
        System.out.println("Глафира переводит 2000 Изольде:");
        Transaction transfer1 = new Transaction(Izolda, Glasha, -100, Category.DEBIT);
		System.out.println(transfer1.print_trans());
		System.out.println();




		// once again
		System.out.println("Баланс Глафиры: " + Glasha.getBalance());
		System.out.println("Баланс Изольды: " + Izolda.getBalance());
		System.out.println("Глафира переводит 2000 Изольде:");
		Transaction transfer2 = new Transaction(Izolda, Glasha, 1000, Category.CREDIT);
		System.out.println(transfer2.print_trans());
		System.out.println(Izolda.print_user());
		System.out.println(Glasha.print_user());

    }
}