package com.diosoft.service;

import com.diosoft.impl.ArrayHelper;
import com.diosoft.domain.Person;
import com.diosoft.interfaces.JoinOperationByArray;
import org.apache.log4j.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

@Named("serviceArray")
public class ServiceArray {

    private static final Logger LOG = Logger.getLogger(ServiceArray.class);

    private JoinOperationByArray joinOperationByArray;

    public ServiceArray(JoinOperationByArray joba) {
        this.joinOperationByArray = joba;
    }

    public ServiceArray() {
    }

    public Person[] merge(Person[] firstArray, Person[] secondArray) {

        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = joinOperationByArray.merge(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }

    public Person[] leftUnion(Person[] firstArray, Person[] secondArray) {

        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = joinOperationByArray.leftUnion(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }

    public Person[] innerJoin(Person[] firstArray, Person[] secondArray) {

        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = joinOperationByArray.innerJoin(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }

    public Person[] outerJoin(Person[] firstArray, Person[] secondArray) {

        LOG.info("First Array: ");
        LOG.info(Arrays.toString(firstArray));
        LOG.info("Second Array: ");
        LOG.info(Arrays.toString(secondArray));

        Person[] result = joinOperationByArray.outerJoin(firstArray,secondArray);

        LOG.info("Result Array: ");
        LOG.info(Arrays.toString(result));

        return result;
    }
}
