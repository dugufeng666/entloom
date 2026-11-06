package io.entloom.server.ontology;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import io.entloom.server.project.Project;
import io.entloom.server.project.ProjectRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OntologyRelationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    OntologyRepository ontologyRepository;

    @Autowired
    OntologyClassRepository ontologyClassRepository;

    @Autowired
    OntologyRelationRepository ontologyRelationRepository;

    @Test
    @WithMockUser
    void createsAndListsRelationsBetweenClasses() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Customer model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Customer ontology", null));
        OntologyClass customer = ontologyClassRepository.saveAndFlush(OntologyClass.create(ontology.getId(), "Customer", null));
        OntologyClass address = ontologyClassRepository.saveAndFlush(OntologyClass.create(ontology.getId(), "Address", null));

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"hasAddress\",\"description\":\"Customer addresses\",\"sourceClassId\":\""
                                + customer.getId() + "\",\"targetClassId\":\"" + address.getId()
                                + "\",\"cardinality\":\"ONE_TO_MANY\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("hasAddress"))
                .andExpect(jsonPath("$.cardinality").value("ONE_TO_MANY"))
                .andExpect(jsonPath("$.sourceClassId").value(customer.getId().toString()));

        mockMvc.perform(get("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations", project.getId(), ontology.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    @WithMockUser
    void updatesRelationWhileOntologyIsDraft() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Order model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Order ontology", null));
        OntologyClass order = ontologyClassRepository.saveAndFlush(OntologyClass.create(ontology.getId(), "Order", null));
        OntologyClass item = ontologyClassRepository.saveAndFlush(OntologyClass.create(ontology.getId(), "Item", null));
        OntologyRelation relation = ontologyRelationRepository.saveAndFlush(OntologyRelation.create(
                ontology.getId(), order.getId(), item.getId(), "contains", null, OntologyRelationCardinality.ONE_TO_MANY));

        mockMvc.perform(patch("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id}",
                        project.getId(), ontology.getId(), relation.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"containsLineItem\",\"description\":\"Order line items\",\"sourceClassId\":\""
                                + order.getId() + "\",\"targetClassId\":\"" + item.getId()
                                + "\",\"cardinality\":\"ONE_TO_MANY\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("containsLineItem"));
    }

    @Test
    @WithMockUser
    void blocksRelationChangesAfterOntologyRelease() throws Exception {
        Project project = projectRepository.saveAndFlush(Project.create("Agent model", null));
        Ontology ontology = ontologyRepository.saveAndFlush(Ontology.create(project.getId(), "Agent ontology", null));
        OntologyClass agent = ontologyClassRepository.saveAndFlush(OntologyClass.create(ontology.getId(), "Agent", null));
        OntologyClass tool = ontologyClassRepository.saveAndFlush(OntologyClass.create(ontology.getId(), "Tool", null));
        ontology.changeStatus(OntologyStatus.RELEASED);
        ontologyRepository.saveAndFlush(ontology);

        mockMvc.perform(post("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations", project.getId(), ontology.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"uses\",\"sourceClassId\":\"" + agent.getId()
                                + "\",\"targetClassId\":\"" + tool.getId() + "\",\"cardinality\":\"MANY_TO_MANY\"}"))
                .andExpect(status().isConflict());
    }
}
