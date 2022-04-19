package ex02;

public class Program {
    public static void main(String[] args) {
        User Glasha = new User( "Glasha", 200001);
        User Izolda = new User( "Izolda", 13000);
		User Sazida = new User( "Sazida", 13000);
		System.out.println(Izolda.print_user());
		System.out.println(Glasha.print_user());
		System.out.println(Sazida.print_user());


    }
}