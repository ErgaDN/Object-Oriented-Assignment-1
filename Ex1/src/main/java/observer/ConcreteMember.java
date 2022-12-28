package observer;

public class ConcreteMember implements Member
{
    private UndoableStringBuilder ustb = new UndoableStringBuilder();
    @Override
    public void update(UndoableStringBuilder usb)
    {
        this.ustb = usb;
    }

    @Override
    public String toString()
    {
        return ustb.toString();
    }
}
