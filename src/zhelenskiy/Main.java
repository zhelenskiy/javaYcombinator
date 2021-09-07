package zhelenskiy;


public class Main {
    @FunctionalInterface
    interface F1 {
        Object a(Object arg1);
    }
    @FunctionalInterface
    interface F2 {
        Object a(Object arg1, Object arg2);
    }
    @FunctionalInterface
    interface F4 {
        Object a(Object arg1, Object arg2, Object arg3, Object arg4);
    }
    public static F4 y = (Object isGeneralCase, Object whenTrue, Object nextRecurParameter, Object otherwise) -> (F1)((Object arg) -> ((F1) (Object x) -> ((F1)((F1)((F4)x).a(isGeneralCase, whenTrue, nextRecurParameter, otherwise)).a(arg)).a(x)).a((F4) (Object pred, Object then, Object next, Object other) -> (F1) ((Object arg_) -> !(boolean)((F1)pred).a(arg_) ? (F1) (Object x) -> other : (F1) (Object x) -> ((F2)then).a(arg_, ((F1)((F1)((F4)x).a(pred, then, next, other)).a(((F1)next).a(arg_))).a(x)))));

    public static void main(String[] args) {
        var factorial = y.a((F1)(x -> (int)x > 0), (F2)((cur, got) -> (int)cur * (int) got), (F1)(x -> (int)x - 1), 1);
        class Pair {
            final int item1, item2;

            public Pair(int item1, int item2) {
                this.item1 = item1;
                this.item2 = item2;
            }
        }
        var fibonacci = y.a((F1)(x -> (int)x > 0), (F2)((cur, pair) -> {
            var p = (Pair) pair;
            return new Pair(p.item2, p.item1 + p.item2);
        }), (F1)(x -> (int)x - 1), new Pair(0, 1));
        for (int i = 0; i < 10; i++) {
            System.out.println(((F1)factorial).a(i));
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(((Pair)((F1)fibonacci).a(i)).item1);
        }
    }
}
