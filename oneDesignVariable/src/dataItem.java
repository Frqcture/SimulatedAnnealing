import java.util.ArrayList;
import java.util.List;

public class dataItem
{
    public int getValue()
    {
        return value;
    }

    private int value;
    dataItem(int value)
    {
        this.value = value;
    }

    List<dataItem> generateNeighbours()
    {
        List<dataItem> neighbours = new ArrayList<>();
        neighbours.add(new dataItem(this.value - 1));
        neighbours.add(new dataItem(this.value + 1));
        return neighbours;
    }
}
