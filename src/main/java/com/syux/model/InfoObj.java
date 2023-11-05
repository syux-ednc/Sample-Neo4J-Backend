package com.syux.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.RelationshipId;

@Getter
@Setter
@NoArgsConstructor
@Node("INFO_OBJ")
public class InfoObj {

    @RelationshipId
    private String id;

    private String name;

    private String info_obj_grp;

    private String status;
}
