import java.util.*;

public class Test {
    public static void main(String[] args) {

//        A a = new B();
//        System.out.println(a.m1());
//        System.out.println(a.m2());
//        System.out.println(a.m3());

        List<Integer> ar = new ArrayList<>();
        System.out.println(ar.size());
        ar.add(1234);
        System.out.println(ar.size());
        int a = ar.size();
        Integer b = ar.size();
        ar.add(123);
        System.out.println(a);
        System.out.println(b);
        System.out.println("qwed");
        System.out.println(new Test().sdgqag());
//        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put("1", "1");
//        Set<String> set = new LinkedHashSet<>();
    }

    public int sdgqag() {
        try {
            System.out.println(1);
            return 1;
        } catch (Exception e) {
            System.out.println(2);
            return 2;
        }
        finally {
            return 3;
        }
    }




    static class A {
        public  int m1(){
            return 1;
        } // return 1;
        public  int m2(){
            return 2;
        } // return 2;


    }

    static class B extends A {
        public  int m2(){
            return -2;
        } // return 1;
        public  int m3(){
            return 3;
        } // return 3;
    }

}
