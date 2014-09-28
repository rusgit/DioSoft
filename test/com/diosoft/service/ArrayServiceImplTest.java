package com.diosoft.service;

import com.diosoft.common.Person;
import com.diosoft.helper.ArrayHelper;
import com.diosoft.util.PersonComparator;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArrayServiceImplTest {
    //local code review (vtegza): no need to be final @ 31.08.14
    // (rusgit): corrected
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
        
//        ArrayServiceImpl arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.leftUnion(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        //local code review (vtegza): no need in times(1) @ 9/28/2014
        verify(mock,times(1)).leftUnion(firstArray,secondArray);
    }

    @Test
    public void testLeftUnion_WithNullFirstArray() throws Exception {

        Person[] firstArray = null;
        Person[] secondArray = {person1, person3, person2};
        Person[] expectedArray = {};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.leftUnion(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).leftUnion(firstArray,secondArray);
    }

    @Test
    public void testLeftUnion_WithNullSecondArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {person1, person3, person2};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.leftUnion(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).leftUnion(firstArray,secondArray);
    }

    @Test
    public void testLeftUnion_WithEmptyFirstArray() throws Exception {

        Person[] firstArray = {};
        Person[] secondArray = {person1, person3, person2, person10};
        Person[] expectedArray = {};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.leftUnion(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).leftUnion(firstArray,secondArray);
    }

    @Test
    public void testLeftUnion_WithEmptySecondArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person10};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2, person10};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.leftUnion(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).leftUnion(firstArray,secondArray);
    }

    @Test
    public void testLeftUnion_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1,person3,person2,person1_dupl,person3_dupl};
        Person[] secondArray = {person10, person3, person2, person1, person3_dupl};
        Person[] expectedArray = {person1, person3, person2, person1_dupl, person3_dupl, person3, person2, person1, person3_dupl};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.leftUnion(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.leftUnion(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).leftUnion(firstArray,secondArray);
    }

    @Test
    public void testMerge() throws Exception {

        Person[] firstArray = {person1, person4, person3, person5};
        Person[] secondArray = {person1, person2, person3, person6, person7, person4};
        Person[] expectedArray = {person1, person2, person3, person4, person5, person6, person7};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.merge(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).merge(firstArray,secondArray);
    }

    @Test
    public void testMerge_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {person1, person3, person2};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.merge(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).merge(firstArray,secondArray);
    }

    @Test
    public void testMerge_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person10};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2, person10};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.merge(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).merge(firstArray,secondArray);
    }

    @Test
    public void testMerge_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person10, person3, person2, person1, person3_dupl};
        Person[] expectedArray = {person1, person3, person2, person10};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.merge(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.merge(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).merge(firstArray,secondArray);
    }

    @Test
    public void testInnerJoin() throws Exception {

        Person[] firstArray = {person5, person1, person6, person3, person10};
        Person[] secondArray = {person10, person4, person1, person4, person7};
        Person[] expectedArray = {person1, person10};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.innerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.innerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).innerJoin(firstArray,secondArray);
    }

    @Test
    public void testInnerJoin_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.innerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.innerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).innerJoin(firstArray,secondArray);
    }

    @Test
    public void testInnerJoin_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = {};
        Person[] expectedArray = {};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.innerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.innerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).innerJoin(firstArray,secondArray);
    }

    @Test
    public void testInnerJoin_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person1, person3, person6 ,person6_dupl,};
        Person[] expectedArray = {person1, person3};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.innerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.innerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).innerJoin(firstArray,secondArray);
    }

    @Test
    public void testOuterJoin() throws Exception {

        Person[] firstArray = {person5, person1, person6, person3, person7, person2};
        Person[] secondArray = {person2, person4, person7};
        Person[] expectedArray = {person5, person1, person6, person3, person4};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.outerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).outerJoin(firstArray,secondArray);
    }

    @Test
    public void testOuterJoin_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = null;
        Person[] expectedArray = {person1, person3, person2};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.outerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).outerJoin(firstArray,secondArray);
    }

    @Test
    public void testOuterJoin_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.outerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).outerJoin(firstArray,secondArray);
    }

    @Test
    public void testOutetJoin_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person3, person2, person3_dupl};
        Person[] expectedArray = {person1, person1_dupl};

//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();
        ArrayHelper mock = mock(ArrayHelper.class);
        ArrayService arrayService = new ArrayServiceImpl(mock);

        when(mock.outerJoin(firstArray,secondArray)).thenReturn(expectedArray);

        Person[] actualArray = arrayService.outerJoin(firstArray,secondArray);

        Arrays.sort(expectedArray, new PersonComparator());
        Arrays.sort(actualArray, new PersonComparator());

        assertArrayEquals(expectedArray, actualArray);
        verify(mock,times(1)).outerJoin(firstArray,secondArray);
    }
}
