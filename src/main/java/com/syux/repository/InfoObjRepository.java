package com.syux.repository;

import com.syux.model.InfoObj;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface InfoObjRepository extends Neo4jRepository<InfoObj, String> {

    @Query("MATCH (n: INFO_OBJ) RETURN n AS node")
    List<InfoObj> findAll();

    @Query("MATCH (node:INFO_OBJ) " +
            "WHERE node.name = $name " +
            "RETURN node")
    Optional<InfoObj> findInfoObjByName(String name);

    @Query("MATCH (d:INFO_OBJ {name: $name})<-[*]-(relatedNode) " +
            "RETURN relatedNode")
    List<InfoObj> findAncestorNodes(String name);

    @Query("MATCH (d:INFO_OBJ {name: $name})-[*]->(relatedNode:INFO_OBJ) " +
            "WHERE relatedNode <> d " +
            "RETURN relatedNode")
    List<InfoObj> findDescendantNodes(String name);

    @Query("MATCH (node:INFO_OBJ) " +
            "WHERE node.name = $name AND node.status = $oldStatus " +
            "SET node.status = $newStatus " +
            "RETURN node")
    void updateInfoObjStatus(String name, String oldStatus, String newStatus);

    @Query("MATCH (node:INFO_OBJ {name: $name}) " +
            "DELETE node")
    void deleteInfoObjByName(String name);

    @Query("MATCH (n:INFO_OBJ {name: $name})<-[r:LEADS_TO]-(sourceNode) " +
            "DELETE r")
    void unlinkRelationshipToInfoObj(String name);

    @Query("MATCH (d:INFO_OBJ {name: $name})-[r:LEADS_TO]->(targetNode:INFO_OBJ) " +
            "DELETE r")
    void unlinkRelationshipFromInfoObj(String name);

}
