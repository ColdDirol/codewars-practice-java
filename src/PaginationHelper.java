import java.util.*;

public class PaginationHelper<I> {
    HashMap<Integer, ArrayList<I>> hashMapCollection = new HashMap<>();
    private List<I> elementsList;
    private int itemsPerPage;
    /**
     * The constructor takes in an array of items and an integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> elementsList, int itemsPerPage) {
        this.elementsList = elementsList;
        this.itemsPerPage = itemsPerPage;
        constructCollection();
    }

    public void constructCollection() {
        ArrayList<I> newList = new ArrayList<>();
        int pageCount = 0;
        for(int i = 1; i <= elementsList.size(); i++) {
            if(i % itemsPerPage == 0 || i == elementsList.size()) {
                newList.add(elementsList.get(i-1));
                hashMapCollection.put(pageCount, new ArrayList<>(newList));
                newList.clear();
                pageCount++;
                continue;
            }
            newList.add(elementsList.get(i-1));
        }
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return elementsList.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (int) Math.ceil( (double) elementsList.size() / (double) itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        try {
            return hashMapCollection.get(pageIndex).size();
        } catch (NullPointerException e) {
            return -1;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    // fail in random test fckk
//    public int pageIndex(int itemIndex) {
//        if (elementsList.size() > itemIndex && itemIndex >= 0) {
//            for (Map.Entry<Integer, ArrayList<I>> item : hashMapCollection.entrySet()) {
//                if (item.getValue().contains(elementsList.get(itemIndex))) return item.getKey();
//            }
//        }
//        return -1;
//    }
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= itemCount()) {
            return -1;
        }
        return itemIndex / itemsPerPage;
    }


    public static void main(String args[])
    {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount()); // should == 2
        System.out.println(helper.itemCount()); // should == 6
        System.out.println(helper.pageItemCount(0)); // should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5)); // should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); // should == 0
        System.out.println(helper.pageIndex(20)); // should == -1
        System.out.println(helper.pageIndex(-10)); // should == -1

    }
}
