package com.yogesh.Arrays;

public class Array {
    private int[] items;
    private int count = 0;

    public Array(int length){
        items = new int[length];
    }

    public void insert(int item){
        //If the arr is full resize it
        if(items.length == count){
            //create a new array - twice the size of old array
            int[] newItems = new int[count * 2];

            //copy all existing items from "items" to "newItems"
            for (int i=0; i<count; i++)
                newItems[i] = items[i];

            // set items to newItems - Basically we are referring the memory address of newItems to items so that it can point to same
            // location in memory and value gets updated in items array in next step(items[count++] = item). newItems will be referring to items in memory
            //If we don't perform this step "items" array will reach out of bounds, because the "newItems" is not referring to "items"
            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index){
        //validate index
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        //shift the items to left to fill the gap
        for(int i=index; i<count; i++)
            items[i] = items[i+1];

        //after shifting. For Eg: if arr is [1, 2, 3, 4, 5] and removeAt(2)
        //[1,2,3,4,5], so this will change to [1,2,4,5,5]. so we have to remove
        //last index. we can remove that by decrementing count
        count--; //count is reduced from 5 to 4, so while printing the loop will print only up to 4th element
    }

    public int indexOf(int index){
        for (int i=0; i<count; i++)
            if (items[i] == index)
                return i;
        return -1;
    }

    public void print(){
        for(int i=0; i< count; i++)
            System.out.println(items[i]);
    }
}
