package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    private UndoableStringBuilder text = new UndoableStringBuilder();
    private ArrayList<Member> clients = new ArrayList<>();

    @Override
    public void register(Member obj)
    {
        clients.add(obj);
        obj.update(text);
    }

    @Override
    public void unregister(Member obj)
    {
        clients.remove(obj);
    }

    @Override
    public void insert(int offset, String obj)
    {
        text.insert(offset, obj);
    }

    @Override
    public void append(String obj)
    {
        text.append(obj);
    }

    @Override
    public void delete(int start, int end)
    {
        text.delete(start, end);
    }

    @Override
    public void undo()
    {
        text.undo();
    }

    @Override
    public String toString()
    {
        return clients.toString();
    }
}


