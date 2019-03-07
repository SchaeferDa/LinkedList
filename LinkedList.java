package utils;

public class LinkedList
{
    ListItem firstListItem = null;
    ListItem lastListItem = null;
    boolean sortedList = false;
    int size = 0;
    IntCompare compare;

    public LinkedList(boolean sortedList, IntCompare compare)
    {
        this.sortedList = sortedList;
        this.compare = compare;
    }

    public LinkedList() {}

    /**
     * Adding new item to the end of the list
     *
     * @param object
     */
    public void add(Object object)
    {
        ListItem newitem = new ListItem(null, lastListItem, object);
        if (firstListItem == null)
        {
            firstListItem = newitem;
            lastListItem = newitem;
        }
        else
        {
            newitem.prevListItem = lastListItem;
            lastListItem.nextListItem = newitem;
            lastListItem = newitem;
        }
        size++;

        if(sortedList)
        {
            sortList();
        }
    }

    /**
     * Getting item with the given index
     *
     * @param index
     * @return
     */
    public Object get(int index)
    {
        if ((index > size - 1) || (index < 0))
        {
            return null;
        }

        ListItem nextItem = null;

        if (index <= 0)
        {
            return firstListItem.object;
        }

        nextItem = firstListItem.nextListItem;

        int i = 1;
        while (i < index)
        {
            nextItem = nextItem.nextListItem;
            i++;
        }

        return nextItem.object;
    }

    /**
     * Returns size of list
     *
     * @return
     */
    public int size()
    {
        return size;
    }

    /**
     * inserting data to given position
     *
     * @param object
     * @param position
     */
    public void insert(Object object, int position)
    {
        if (position >= size)
        {
            add(object);
        }
        else if (position == 0)
        {
            ListItem newItem = new ListItem(null, null, object);

            newItem.nextListItem = firstListItem;
            firstListItem.prevListItem = newItem;
            firstListItem = newItem;

            size++;
        }
        else
        {
            ListItem newItem = new ListItem(null, null, object);

            ListItem searchedItem = firstListItem;

            int i = 0;
            while (i < position)
            {
                searchedItem = searchedItem.nextListItem;
                i++;
            }

            //System.out.println("DEBUG# " + searchedItem.object);

            newItem.prevListItem = searchedItem.prevListItem;
            searchedItem.prevListItem.nextListItem = newItem;
            newItem.nextListItem = searchedItem;
            searchedItem.prevListItem = newItem;

            size++;
        }

        if(sortedList) sortList();
    }

    /**
     * deletes data at given index
     * @param index
     * @return true if successful deleted
     */
    public boolean delete(int index)
    {
        if ((index > size - 1) || (index < 0))
        {
            return false;
        }

        ListItem searchedItem = firstListItem;

        int i = 0;
        while (i < index)
        {
            searchedItem = searchedItem.nextListItem;
            i++;
        }

        if(index == 0)
        {
            searchedItem.nextListItem.prevListItem = null;
            firstListItem = searchedItem.nextListItem;
        }
        else if(index == (size-1))
        {
            searchedItem.prevListItem.nextListItem = null;
            lastListItem = searchedItem.prevListItem;
        }
        else
        {
            searchedItem.nextListItem.prevListItem = searchedItem.prevListItem;
            searchedItem.prevListItem.nextListItem = searchedItem.nextListItem;
        }

        size--;
        return true;
    }

    public boolean contains(Object searchObject)
    {
        for(int i = 0; i < size; i++)
        {
            if(get(i) == searchObject) return true;
        }

        return false;
    }

    private void sortList()
    {
        ListItem sortItem = firstListItem;
        boolean swapped = false;

        do
        {
            swapped = false;
            sortItem = firstListItem;

            for(int i = 0; i < (size-1); i++)
            {
                if(!compare.AgreaterB(sortItem.object,sortItem.nextListItem.object))
                {
                    swap(sortItem,sortItem.nextListItem);
                    swapped = true;
                    break;
                }

                sortItem = sortItem.nextListItem;
            }
        }
        while(swapped);
    }

    private void swap(ListItem a, ListItem b)
    {
        Object bufferA = a.object;
        a.object = b.object;
        b.object = bufferA;
    }
}
