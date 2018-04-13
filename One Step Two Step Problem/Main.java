package Question2;
/**
 * @author Neelesh Rambally
 * @Date 11/04/2018
 *
 * I have achieved the required calculation using recursion. The Recurrance Relation we were looking
 * for was S(N)=S(N-1)+S(N-2) where N = the length of the stair case.
 */
class RecurrenceCalculation {
    int recurranceRelation(int n) {
        int result;
        //He can go down the first step by either taking one step or taking 2 steps
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        result = recurranceRelation(n - 1) + recurranceRelation(n - 2);
        return result;
    }
}

public class Main {
        public static void main(String[] args) {
            RecurrenceCalculation obj_one = new RecurrenceCalculation();
            int a = obj_one.recurranceRelation(11);
            //n=11 because we are taking 0 into account
            System.out.println("The number of ways Liam can go down the stair case taking 1 or 2 steps is: " + a);
        }
    }

