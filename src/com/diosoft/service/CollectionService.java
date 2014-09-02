package com.diosoft.service;

import com.diosoft.interfaces.JoinOperationByCollection;
import org.apache.log4j.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named("serviceCollection")
public class CollectionService {

    private static final Logger LOG = Logger.getLogger(CollectionService.class);

    @Inject
    private JoinOperationByCollection joinOperationByCollection;

    public CollectionService(JoinOperationByCollection jobc) {
        this.joinOperationByCollection = jobc;
    }

    public CollectionService() {
    }

    public <T> Set<T> merge(List<T> firstColl, List<T> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<T> result = joinOperationByCollection.merge(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public <T> List<T> leftUnion(List<T> firstColl, List<T> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<T> result = joinOperationByCollection.leftUnion(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public <T> Set<T> innerJoin(List<T> firstColl, List<T> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<T> result = joinOperationByCollection.innerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public <T> List<T> outerJoin(List<T> firstColl, List<T> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<T> result = joinOperationByCollection.outerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }
}
