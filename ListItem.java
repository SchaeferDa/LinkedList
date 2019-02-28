package utils;

public class ListItem
{
    ListItem nextListItem;
    ListItem prevListItem;
    Object object;

    public ListItem(ListItem nextListItem, ListItem prevListItem, Object object)
    {
        this.nextListItem = nextListItem;
        this.prevListItem = prevListItem;
        this.object = object;
    }
}
