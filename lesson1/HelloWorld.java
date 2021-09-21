public class HelloWorld {
    public static void main(String[] args) {
		for (int i = 0; i < 5; i++ ) {
            System.out.println(String.format("%d + %d = %d", i, 5, add(i, 5)));
		}
    }
    private static int add(int a, int b){
        return a + b;
    }
}
