package com.diosoft.service;

import com.diosoft.domain.Person;
import com.diosoft.interfaces.JoinOperationByCollection;
import com.diosoft.util.JAXBXMLHandler;
import org.apache.log4j.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
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

    public void jaxbInputData(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {
        File fistArrayFile = new File("resources/result/fistArray.xml");
        File secondArrayFile = new File("resources/result/secondArray.xml");
        JAXBXMLHandler.marshal(firstColl, fistArrayFile);
        JAXBXMLHandler.marshal(secondColl, secondArrayFile);
    }

    public Set<Person> merge(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {

        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<Person> result = joinOperationByCollection.merge(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File mergeFile = new File("resources/result/merge.xml");
        JAXBXMLHandler.marshal(result,mergeFile);

        return result;
    }

    public List<Person> leftUnion(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<Person> result = joinOperationByCollection.leftUnion(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File leftUnionFile = new File("resources/result/leftUnion.xml");
        JAXBXMLHandler.marshal(result,leftUnionFile);

        return result;
    }

    public Set<Person> innerJoin(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<Person> result = joinOperationByCollection.innerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File innerJoinFile = new File("resources/result/innerJoin.xml");
        JAXBXMLHandler.marshal(result,innerJoinFile);

        return result;
    }

    public List<Person> outerJoin(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<Person> result = joinOperationByCollection.outerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File outerJoinFile = new File("resources/result/outerJoin.xml");
        JAXBXMLHandler.marshal(result,outerJoinFile);

        return result;
    }
}
