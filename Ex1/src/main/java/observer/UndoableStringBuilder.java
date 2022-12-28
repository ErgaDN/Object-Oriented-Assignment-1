package observer;

import java.util.EmptyStackException;
import java.util.Stack;
import java.lang.StringBuilder;

public class UndoableStringBuilder {
    private Stack<StringBuilder> stack;
    private StringBuilder stB;

    /**
     * constructor
     */
    public UndoableStringBuilder(){
        this.stack = new Stack<>();
        this.stB = new StringBuilder();
    }


    /**
     * the method do a deep cope of str and insert to the stack
     * @param str = the StringBuilder that we want to save
     */
    private void InsertionToStack(StringBuilder str) {
        StringBuilder stbToStack = new StringBuilder(str);
        stack.push(stbToStack);
    }

    /**
     * toString method
     * @return a string from  StringBuilder
     */
    public String toString(){

        return this.stB.toString();
    }

    /**
     * the method appends the specified string to this character sequence and save the new StringBuilder in the stack
     * @param str - String
     * @return the updated stack
     */
    public UndoableStringBuilder append(String str){
        stB.append(str);
        InsertionToStack(stB);
        return this;
    }

    /**
     * the method delete from the specified string from index start to index end-1
     * @param start - index (int)
     * @param end - index (int)
     * @return the updated stack
     */
    public UndoableStringBuilder delete(int start, int end){
        try {
            stB.delete(start, end);
            InsertionToStack(stB);
            return this;
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("The indexes are invalid");
            return this;
        }
    }


    /**
     * the method insert in the specified string a new String str from index offset
     * @param offset - index(int)
     * @param str - new String
     * @return the updated stack
     */
    public UndoableStringBuilder insert(int offset, String str){
        try {
            stB.insert(offset, str);
            InsertionToStack(stB);
            return this;
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("The indexes are invalid");
            return this;
        }
    }

    /**
     * the method replace the index start to end-1 from the specified string with the new string
     * @param start - index(int)
     * @param end - index(int)
     * @param str - new String
     * @return the updated stack
     */
    public UndoableStringBuilder replace(int start,int end, String str){
        try {
            stB.replace(start, end, str);
            InsertionToStack(stB);
            return this;
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("The indexes are invalid");
            return this;
        }
    }

    /**
     * Causes the specified string character sequence to be replaced by the reverse of the sequence
     * @return the updated stack
     */
    public UndoableStringBuilder reverse(){
        stB.reverse();
        InsertionToStack(stB);
        return this;
    }

    /**
     * the method return the specified string before the last action. If the stack is empty the method will do nothing
     *
     */
    public void undo(){
        try{
            this.stack.pop();
            stB = this.stack.peek();
        }
        catch(EmptyStackException e){
            if(!stack.isEmpty())
                this.stack.pop();
            stB = new StringBuilder();
        }
    }
}

