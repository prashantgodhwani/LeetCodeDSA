import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Leetcode_FlattenNestedListIterator_341 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
    }
}

class NestedIterator implements Iterator<Integer> {

    Stack<Integer> stack;
    int size = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        this.flattenList(nestedList, nestedList.size());
    }

    private void flattenList(List<NestedInteger> nestedList, int idx){

        if(idx == -1){
            return;
        }

        for(int i = nestedList.size() - 1; i >= 0; i--){
            if(nestedList.get(i).isInteger()){
                size++;
                stack.push(nestedList.get(i).getInteger());
            }else{
                flattenList(nestedList.get(i).getList(), i);
            }
        }
    }

    @Override
    public Integer next() {
        size--;
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return (size > 0);
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
