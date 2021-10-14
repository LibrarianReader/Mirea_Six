public class Main {

    public static void main(String[] args) {
        MyString myStr = new MyString(" Orange ".toCharArray());
        System.out.println(myStr.isEmpty());
        myStr.print();
        System.out.println(myStr.length());
        System.out.println(myStr.CharAt(3));
        myStr = myStr.trim();
        System.out.println(myStr.compareTo(new MyString("Orange")));
        myStr = myStr.concat(new MyString("Juice".toCharArray()));
        System.out.println(myStr);
    }
}