package leetcode03;

import java.util.*;

public class CandidateSum {
    public static void main(String[] args) {
        int[] ints = {2, 2, 3, 7};
        combinationSum(ints, 7);
        System.out.println(combinationSum(ints, 7));

    }
    //递归回溯常常用树结构来便于理解
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if(candidates==null||candidates.length==0){
            return list;
        }

        Arrays.sort(candidates);
        int length = candidates.length;
        Deque<Integer> deque = new ArrayDeque<>();
        getSum(list,candidates,target,0,length,deque);

        return list;

    }

    public static void getSum(ArrayList<List<Integer>> list, int[] candidates, int residue, int index, int len, Deque<Integer> deque){
        if(residue==0){

            ArrayList<Integer> integers = new ArrayList<>(deque);

            list.add(integers);
            return;
        }
        if(residue<0){

                return;

            }
                //要包含所有情况则此处得有循环
                for (int i = index; i < len; i++) {
                    if(candidates[i]>residue){
                        break;
                    }
                    deque.addLast(candidates[i]);

                    getSum(list,candidates,residue-candidates[i],i,len ,deque);
                    deque.removeLast();
                }

            }


}
