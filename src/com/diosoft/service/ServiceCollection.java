package com.diosoft.service;

import com.diosoft.domain.Person;
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

    public Set<Person> merge(List<Person> firstColl, List<Person> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<Person> result = joinOperationByCollection.merge(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public List<Person> leftUnion(List<Person> firstColl, List<Person> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<Person> result = joinOperationByCollection.leftUnion(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public Set<Person> innerJoin(List<Person> firstColl, List<Person> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<Person> result = joinOperationByCollection.innerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }

    public List<Person> outerJoin(List<Person> firstColl, List<Person> secondColl) {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<Person> result = joinOperationByCollection.outerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        return result;
    }
}
