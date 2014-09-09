package com.diosoft.helper;

import com.diosoft.common.Person;
import com.diosoft.util.PersonComparator;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ArrayHelperImplTest extends TestCase {

    private Person person1 = new Person.Builder().name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
    private Person person2 = new Person.Builder().name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
    private Person person3 = new Person.Builder().name("Ekaterina").lastName("Volkova").age(28).post(Person.Post.DEVELOPER).build();
    private Person person4 = new Person.Builder().name("Illya").lastName("Pinchuk").age(20).post(Person.Post.QA).build();
    private Person person5 = new Person.Builder().name("Elena").lastName("Kirichenko").age(30).post(Person.Post.QA).build();
    private Person person6 = new Person.Builder().name("Vladimir").lastName("Kudyna").age(35).post(Person.Post.QA).build();
    private Person person7 = new Person.Builder().name("Vitaliy").lastName("Bondar").age(31).post(Person.Post.QA).build();
    private Person person8 = new Person.Builder().name("Violete").lastName("Egorova").age(40).post(Person.Post.DIRECTOR).build();
    private Person person9 = new Person.Builder().name("Svyatoslav").lastName("Drobich").age(45).post(Person.Post.DIRECTOR).build();
    private Person person10 = new Person.Builder().name("Svetlana").lastName("Mirnaya").age(50).post(Person.Post.DIRECTOR).build();
    // Create Duplicate
    private Person person1_dupl = new Person.Builder(person1).build();
    private Person person3_dupl = new Person.Builder(person3).build();
    private Person person6_dupl = new Person.Builder(person6).build();
    private Person person9_dupl = new Person.Builder(person9).build();


    @Test
    public void testLeftUnion() throws Exception {

        Person[] firstArray = {person1, person4, person3, person5};
        Person[] secondArray = {person1, person2, person3, person6, person7, person4};
        Person[] expectedArray = {person1, person4, person3, person5, person1, person4, person3};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testLeftUnion_WithNullFirstArray() throws Exception {

        Person[] firstArray = null;
        Person[] secondArray = {person1, person3, person2};
        Person[] expectedArray = {};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testLeftUnion_WithNullSecondArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {person1, person3, person2};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testLeftUnion_WithEmptyFirstArray() throws Exception {

        Person[] firstArray = {};
        Person[] secondArray = {person1, person3, person2, person10};
        Person[] expectedArray = {};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testLeftUnion_WithEmptySecondArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person10};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2, person10};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
     public void testLeftUnion_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person10, person3, person2, person1, person3_dupl};
        Person[] expectedArray = {person1, person3, person2, person1_dupl, person3_dupl, person3, person2, person1, person3_dupl};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testMerge() throws Exception {

        Person[] firstArray = {person1, person4, person3, person5};
        Person[] secondArray = {person1, person2, person3, person6, person7, person4};
        Person[] expectedArray = {person1, person2, person3, person4, person5, person6, person7};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testMerge_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {person1, person3, person2};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testMerge_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person10};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2, person10};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testMerge_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person10, person3, person2, person1, person3_dupl};
        Person[] expectedArray = {person1, person3, person2, person10};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testInnerJoin() throws Exception {

        Person[] firstArray = {person5, person1, person6, person3, person10};
        Person[] secondArray = {person10, person4, person1, person4, person7};
        Person[] expectedArray = {person1, person10};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.innerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testInnerJoin_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.innerJoin(firstArray, secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testInnerJoin_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = {};
        Person[] expectedArray = {};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.innerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());


        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testInnerJoin_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person1, person3, person6 ,person6_dupl,};
        Person[] expectedArray = {person1, person3};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.innerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testOuterJoin() throws Exception {

        Person[] firstArray = {person5, person1, person6, person3, person7, person2};
        Person[] secondArray = {person2, person4, person7};
        Person[] expectedArray = {person5, person1, person6, person3, person4};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testOuterJoin_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {person1, person3, person2};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testOuterJoin_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testOutetJoin_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person3, person2, person3_dupl};
        Person[] expectedArray = {person1, person1_dupl};

        ArrayHelper ah = new ArrayHelperImpl();
        Person[] actualArray = ah.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void test_WithMaxSizeArray() {
        Person[] firstArray = null;
        for (int i = Integer.MAX_VALUE; i >= 0; i--) {
            try {
                firstArray = new Person[i/100];
                System.out.println("Successful init, size: " + firstArray.length);
                // size: new Person[21474836] - Successful init
                break;
            } catch (Error err2) {
                System.out.println("Failed, iteration: " + i);
            }
        }
    }

}