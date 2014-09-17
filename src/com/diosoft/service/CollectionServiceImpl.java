package com.diosoft.service;

import com.diosoft.common.Person;
import com.diosoft.common.PersonAdapter;
import com.diosoft.common.PersonAdapterWrapper;
import com.diosoft.helper.CollectionHelper;
import com.diosoft.util.JAXBXMLHandler;
import org.apache.log4j.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Named("collectionServiceImpl")
public class CollectionServiceImpl implements CollectionService {

    private static final Logger LOG = Logger.getLogger(CollectionServiceImpl.class);

    @Inject
    private CollectionHelper collectionHelper;

    public CollectionServiceImpl(CollectionHelper jobc) {
        this.collectionHelper = jobc;
    }

    public CollectionServiceImpl() {
    }

    @Override
    public void jaxbInputData(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {
        File fistCollFile = new File("resources/joinOperation/fistColl.xml");
        File secondCollFile = new File("resources/joinOperation/secondColl.xml");
        JAXBXMLHandler.marshal(firstColl, fistCollFile);
        JAXBXMLHandler.marshal(secondColl, secondCollFile);
    }

    @Override
    public Set<Person> merge(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {

        LOG.info(">>> Collection: merge ");
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<Person> result = collectionHelper.merge(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File mergeFile = new File("resources/joinOperation/merge.xml");
        JAXBXMLHandler.marshal(result,mergeFile);

        return result;
    }

    @Override
    public List<Person> leftUnion(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {

        LOG.info(">>> Collection: leftUnion ");
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<Person> result = collectionHelper.leftUnion(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File leftUnionFile = new File("resources/joinOperation/leftUnion.xml");
        JAXBXMLHandler.marshal(result,leftUnionFile);

        return result;
    }

    @Override
    public Set<Person> innerJoin(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {

        LOG.info(">>> Collection: innerJoin ");
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        Set<Person> result = collectionHelper.innerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File innerJoinFile = new File("resources/joinOperation/innerJoin.xml");
        JAXBXMLHandler.marshal(result,innerJoinFile);

        return result;
    }

    @Override
    public List<Person> outerJoin(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException {

        LOG.info(">>> Collection: outerJoin ");
        LOG.info("First Collection: ");
        LOG.info(firstColl);
        LOG.info("Second Collection: ");
        LOG.info(secondColl);

        List<Person> result = collectionHelper.outerJoin(firstColl,secondColl);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File outerJoinFile = new File("resources/joinOperation/outerJoin.xml");
        JAXBXMLHandler.marshal(result,outerJoinFile);

        return result;
    }
}
