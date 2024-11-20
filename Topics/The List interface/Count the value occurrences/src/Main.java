import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        // there is no need to input data from the command line
        // instead, use arguments elem, list1 and list2
        int elemList1Counter = 0, elemList2Counter = 0;

        for (Integer list1Elem : list1) {
            if (list1Elem == elem) {
                elemList1Counter++;
            }
        }

        for (Integer list2Elem : list2) {
            if (list2Elem == elem) {
                elemList2Counter++;
            }
        }

        if (elemList1Counter == elemList2Counter) {
            return true;
        }

        return false;
    }
}
