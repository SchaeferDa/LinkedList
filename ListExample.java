import utils.IntCompare;
import utils.LinkedList;

public class ListExample
{
    public static void main (String[] args)
    {
        LinkedList liste = new LinkedList(true, new IntCompare()
        {
            @Override
            public boolean AgreaterB(Object a, Object b)
            {
                if(a.toString().codePointAt(0) < b.toString().codePointAt(0))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });

        liste.add("Erstes Item");
        liste.add("Zweites Item");
        liste.add("Drittes Item");

        printoutList(liste);

        liste.insert("Viertes Item",1);

        printoutList(liste);

        liste.add(5);

        printoutList(liste);

        liste.delete(0);

        printoutList(liste);
    }

    private static void printoutList(LinkedList liste)
    {
        for(int i = 0; i < liste.size(); i++)
        {
            System.out.println(liste.get(i));
        }
        System.out.println("\n");
    }
}
