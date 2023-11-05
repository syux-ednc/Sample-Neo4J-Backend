CREATE
(a:INFO_OBJ{name:"a", info_obj_grp: "G1", status: "UNPROCESSED"}),
(b:INFO_OBJ{name:"b", info_obj_grp: "G1", status: "UNPROCESSED"}),
(c:INFO_OBJ{name:"c", info_obj_grp: "G1", status: "UNPROCESSED"}),
(d:INFO_OBJ{name:"d", info_obj_grp: "G2", status: "UNPROCESSED"}),
(e:INFO_OBJ{name:"e", info_obj_grp: "G2", status: "UNPROCESSED"}),
(f:INFO_OBJ{name:"f", info_obj_grp: "G1", status: "UNPROCESSED"}),
(g:INFO_OBJ{name:"g", info_obj_grp: "G1", status: "UNPROCESSED"}),
(h:INFO_OBJ{name:"h", info_obj_grp: "G3", status: "UNPROCESSED"}),
(i:INFO_OBJ{name:"i", info_obj_grp: "G3", status: "UNPROCESSED"}),
(j:INFO_OBJ{name:"j", info_obj_grp: "G3", status: "UNPROCESSED"}),

(a)-[:LEADS_TO]->(b),
(b)-[:LEADS_TO]->(c),
(c)-[:LEADS_TO]->(f),
(f)-[:LEADS_TO]->(g),
(d)-[:LEADS_TO]->(e),
(e)-[:LEADS_TO]->(f),
(h)-[:LEADS_TO]->(i),
(i)-[:LEADS_TO]->(j),
(j)-[:LEADS_TO]->(g);

MATCH (n) DETACH DELETE n;