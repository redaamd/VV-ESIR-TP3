package fr.istic.vv;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;

class StringUtilsTest {
    
    /*****************************************
    TEST FALSE IMPAIR
    */
    @Test
    void isBalancedTest1() {
        String test="({}){";
        boolean rep=isBalanced(test);
        assertFalse(rep);
    }
    /*****************************************
    TEST TRUE PAIR
    */
    @Test
    void isBalancedTest2(){
        String test="({})";
        boolean rep=isBalanced(test);
        assertTrue(rep);
    }
    /*****************************************
    TEST FALSE PAIR
    */
    @Test
    void isBalancedTest3(){
        String test="([)]";
        boolean rep=isBalanced(test);
        assertFalse(rep);
    }


    @Test
    void isBalancedTest5(){
        String test=")){}";
        boolean rep=isBalanced(test);
        assertFalse(rep);
    }
    @Test
    void isBalancedTest6(){
        String test="]){}";
        boolean rep=isBalanced(test);
        assertFalse(rep);
    }
    @Test
    void isBalancedTest7(){
        String test="}){}";
        boolean rep=isBalanced(test);
        assertFalse(rep);
    }
    @Test
    void isBalancedTest8(){
        String test="[(})}";
        boolean rep=isBalanced(test);
        assertFalse(rep);
    }
    @Test
    void isBalancedTest9(){
        String test="({]}]}";
        boolean rep=isBalanced(test);
        assertFalse(rep);
    }
    @Test
    void isBalancedTest10(){
        String test="[{}]";
        boolean rep=isBalanced(test);
        assertTrue(rep);
    }



}
