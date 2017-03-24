import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * Created by ravi.krishnan on 07/02/17.
 */
public class InterLeavingIterator<T> implements Iterator<T> {

    List<Iterator<T>> iteratorList;
    int currentIndex;
    InterLeavingIterator(List<Iterator<T>> iterators){
        iteratorList = iterators;
    }

    @Override
    public boolean hasNext() {
        int initialIndex = currentIndex;
        int tempIndex = initialIndex;
            while(!iteratorList.get(initialIndex).hasNext()){
                initialIndex++;
                if(initialIndex == iteratorList.size()){
                    initialIndex = 0;
                }if(initialIndex == tempIndex){
                    return false;
                }
            }
        return true;
    }

    @Override
    public T next(){
        T element = null;
            while(!iteratorList.get(currentIndex).hasNext()){
                currentIndex++;
                if(currentIndex == iteratorList.size()){
                    currentIndex =0;
                }
            }
            element = (T)iteratorList.get(currentIndex).next();
        currentIndex++;
        if(currentIndex == iteratorList.size()){
            currentIndex =0;
        }
        return element;
    }


    public static void main(String[] args) {

        Integer [] arr1 = {1,3,4};
        Integer [] arr2 = {4,9,15,20,25,30,35};
        Integer [] arr3 = {30,24,27,29};
        List<Integer> arr1List = Arrays.asList(arr1);
        List<Integer> arr2List = Arrays.asList(arr2);
        List<Integer> arr3List = Arrays.asList(arr3);
        List<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(arr1List.iterator());
        iterators.add(arr2List.iterator());
        iterators.add(arr3List.iterator());
        InterLeavingIterator<Integer> integerInterLeavingIterator = new InterLeavingIterator<Integer>(iterators);
        while(integerInterLeavingIterator.hasNext()){
            System.out.println(integerInterLeavingIterator.next());
        }
    }
}
