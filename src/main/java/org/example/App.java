package org.example;


import java.util.AbstractList;
import java.util.Arrays;
import java.util.logging.*;
class MyList<E> extends AbstractList<E>
{
    private static final Logger LOGGER=Logger.getLogger(App.class.getName());
    private static final int INITIAL_CAPACITY = 10;
    private int actSize = 0;
    private Object eleData[];
    private int i=0;
    public MyList()
    {
        eleData=new Object[INITIAL_CAPACITY];
        i=0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index)
    {
        E x =(E)eleData[index];
        return x;
    }
    public boolean add(E e)
    {
        eleData[i]=e;
        i++;

        if(i >= actSize)
        {
            increaseListSize();
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index)
    {
        int j;
        Object x=eleData[index];
        for(j=index;j<actSize-1;j++)
        {
            eleData[j]=eleData[j+1];
        }
        i--;
        actSize--;
        return (E)x;
    }

    public int size()
    {
        return i;
    }

    private void increaseListSize()
    {
        actSize = eleData.length * 2;
        eleData = Arrays.copyOf(eleData, actSize);
    }

    public void display()
    {
        String s="";
        for (int i = 0; i < this.i; i++)
            s=s+eleData[i]+" ";
        LOGGER.info(s+"\n");
    }

}

public class App
{
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        MyList<Integer> my_list = new MyList<Integer>();
        LOGGER.severe("Executing My List\n");
        for(int i = 0;i<15;i++)
        {
            my_list.add(i);
        }
        my_list.remove(3);
        my_list.remove(3);
        LOGGER.info("Size of my List :"+my_list.size()+"");
        LOGGER.info(" List : \n");
        my_list.display();
    }
}