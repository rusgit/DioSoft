package com.diosoft.service;

import com.diosoft.common.Person;
import com.diosoft.helper.ArrayHelper;
import org.apache.log4j.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

@Named("arrayServiceImpl")
public class ArrayServiceImpl implements ArrayService {

    private static final Logger LOG = Logger.getLogger(ArrayServiceImpl.class);

    @Inject
    private ArrayHelper arrayHelper;

    public ArrayServiceImpl(ArrayHelper joba) {
        this.arrayHelper = joba;
    }

    public ArrayServiceImpl() {
    }

    @Override
    public Person[] merge(Person[] firstArray, Person[] secondArray) {

        LOG.info(">>> Array: merge ");
        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = arrayHelper.merge(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }

    @Override
    public Person[] leftUnion(Person[] firstArray, Person[] secondArray) {

        LOG.info(">>> Array: leftUnion ");
        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = arrayHelper.leftUnion(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }

    @Override
    public Person[] innerJoin(Person[] firstArray, Person[] secondArray) {

        LOG.info(">>> Array: innerJoin ");
        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = arrayHelper.innerJoin(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }

    @Override
    public Person[] outerJoin(Person[] firstArray, Person[] secondArray) {

        LOG.info(">>> Array: outerJoin ");
        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = arrayHelper.outerJoin(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }
}
