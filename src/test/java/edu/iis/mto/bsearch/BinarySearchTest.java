package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static edu.iis.mto.bsearch.BinarySearch.search;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BinarySearchTest {


    private static int size = (int) Math.ceil(Math.random() * 100 + 2);
    private static int[] seq;

    @BeforeClass
    public static void setUp() {
        seq = new int[size];
        for(int i = size; i > 0; i--) {
            seq[i - 1] = i;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void showErrorWhenSeqIsEmpty() throws IllegalArgumentException{
        search(0, new int[0]);
    }

    @Test
    public void findElementInSeqWhenSeqLengthIsOne(){
        int[] seq = new int[1];
        seq[0] = 1;
        assertThat(search(1,seq).isFound(), is(true));
    }

    @Test
    public void notFindElementInSeqWhenSeqLengthIsOne(){
        int[] seq = new int[1];
        seq[0] = 1;
        assertThat(search(2, seq).isFound(), is(not(true)));
    }

    @Test
    public void notFindElementInSeqWhenSeqLengthIsBiggerThanOne(){
        assertThat(search(250, seq).isFound(), is(not(true)));
    }

    @Test
    public void findElementInSeqOnFirstPositionWhenSeqLengthIsBiggerThanOne(){
        assertThat(search(seq[0], seq).getPosition(), is(1));
    }

    @Test
    public void findElementInSeqOnLastPositionWhenSeqLengthIsBiggerThanOne(){
        assertThat(search(seq[seq.length-1], seq).getPosition(), is(seq.length));
    }

    @Test
    public void findElementInSeqOnMiddlePositionWhenSeqLengthIsBiggerThanOne(){
        int key = seq[(seq.length-1)/2];
        int middlePosition = (seq.length+1)/2;
        assertThat(search(key, seq).getPosition(),is(middlePosition));
    }

    @Test
    public void findElementInSeqOnMiddlePositionPlusOneWhenSeqLengthIsBiggerThanOne(){
        int key = seq[(seq.length)/2];
        int middlePosition = (seq.length+2)/2;
        assertThat(search(key, seq).getPosition(),is(middlePosition));
    }

    @Test
    public void findElementInSeqOnMiddlePositionMinusOneWhenSeqLengthIsBiggerThanOne(){
        int key = seq[(seq.length-2)/2];
        int middlePosition = (seq.length)/2;
        assertThat(search(key, seq).getPosition(),is(middlePosition));
    }
}