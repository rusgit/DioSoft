package com.diosoft.service;

import com.diosoft.interfaces.JoinOperationByCollection;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named("serviceCollection")
public class ServiceCollection {

    private static final Logger LOG = Logger.getLogger(ServiceCollection.class);

    @Inject
    private JoinOperationByCollection joinOperationByCollection;

    public ServiceCollection(JoinOperationByCollection jobc) {
        this.joinOperationByCollection = jobc;
    }

    public ServiceCollection() {
    }

    public <T> Set<T> merge(List<T> firstArray, List<T> secondArray) {
        LOG.info("First Collection: ");
        LOG.info(firstArray);
        LOG.info("Second Collection: ");
        LOG.info(secondArray);

        Set<T> result = joinOperationByCollection.merge(firstArray,secondArray);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public <T> List<T> leftUnion(List<T> firstArray, List<T> secondArray) {
        LOG.info("First Collection: ");
        LOG.info(firstArray);
        LOG.info("Second Collection: ");
        LOG.info(secondArray);

        List<T> result = joinOperationByCollection.leftUnion(firstArray,secondArray);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public <T> Set<T> innerJoin(List<T> firstArray, List<T> secondArray) {
        LOG.info("First Collection: ");
        LOG.info(firstArray);
        LOG.info("Second Collection: ");
        LOG.info(secondArray);

        Set<T> result = joinOperationByCollection.innerJoin(firstArray,secondArray);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public <T> List<T> outerJoin(List<T> firstArray, List<T> secondArray) {
        LOG.info("First Collection: ");
        LOG.info(firstArray);
        LOG.info("Second Collection: ");
        LOG.info(secondArray);

        List<T> result = joinOperationByCollection.outerJoin(firstArray,secondArray);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }
}
