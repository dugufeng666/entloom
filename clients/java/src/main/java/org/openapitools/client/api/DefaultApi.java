package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import java.util.UUID;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient.ResponseSpec;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.10.0")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    @Autowired
    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Read the authenticated user
     * 
     * <p><b>200</b> - Authenticated user
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1AuthMeGetRequestCreation() throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/auth/me", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Read the authenticated user
     * 
     * <p><b>200</b> - Authenticated user
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1AuthMeGet() throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1AuthMeGetRequestCreation().body(localVarReturnType);
    }

    /**
     * Read the authenticated user
     * 
     * <p><b>200</b> - Authenticated user
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1AuthMeGetWithHttpInfo() throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1AuthMeGetRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Read the authenticated user
     * 
     * <p><b>200</b> - Authenticated user
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1AuthMeGetWithResponseSpec() throws RestClientResponseException {
        return apiV1AuthMeGetRequestCreation();
    }
    /**
     * List projects
     * 
     * <p><b>200</b> - Project list
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsGetRequestCreation() throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List projects
     * 
     * <p><b>200</b> - Project list
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsGet() throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsGetRequestCreation().body(localVarReturnType);
    }

    /**
     * List projects
     * 
     * <p><b>200</b> - Project list
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsGetWithHttpInfo() throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsGetRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * List projects
     * 
     * <p><b>200</b> - Project list
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsGetWithResponseSpec() throws RestClientResponseException {
        return apiV1ProjectsGetRequestCreation();
    }
    /**
     * Create a project
     * 
     * <p><b>201</b> - Created project
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsPostRequestCreation() throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a project
     * 
     * <p><b>201</b> - Created project
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsPost() throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsPostRequestCreation().body(localVarReturnType);
    }

    /**
     * Create a project
     * 
     * <p><b>201</b> - Created project
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsPostWithHttpInfo() throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsPostRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Create a project
     * 
     * <p><b>201</b> - Created project
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsPostWithResponseSpec() throws RestClientResponseException {
        return apiV1ProjectsPostRequestCreation();
    }
    /**
     * List project ontologies
     * 
     * <p><b>200</b> - Ontology list
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesGetRequestCreation(UUID projectId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List project ontologies
     * 
     * <p><b>200</b> - Ontology list
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesGet(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesGetRequestCreation(projectId).body(localVarReturnType);
    }

    /**
     * List project ontologies
     * 
     * <p><b>200</b> - Ontology list
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesGetWithHttpInfo(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesGetRequestCreation(projectId).toEntity(localVarReturnType);
    }

    /**
     * List project ontologies
     * 
     * <p><b>200</b> - Ontology list
     * @param projectId The projectId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesGetWithResponseSpec(UUID projectId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesGetRequestCreation(projectId);
    }
    /**
     * Import a transfer JSON document as a new draft
     * 
     * <p><b>201</b> - Imported draft ontology
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesImportPostRequestCreation(UUID projectId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesImportPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/import", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Import a transfer JSON document as a new draft
     * 
     * <p><b>201</b> - Imported draft ontology
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesImportPost(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesImportPostRequestCreation(projectId).body(localVarReturnType);
    }

    /**
     * Import a transfer JSON document as a new draft
     * 
     * <p><b>201</b> - Imported draft ontology
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesImportPostWithHttpInfo(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesImportPostRequestCreation(projectId).toEntity(localVarReturnType);
    }

    /**
     * Import a transfer JSON document as a new draft
     * 
     * <p><b>201</b> - Imported draft ontology
     * @param projectId The projectId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesImportPostWithResponseSpec(UUID projectId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesImportPostRequestCreation(projectId);
    }
    /**
     * Export an ontology as transfer JSON
     * 
     * <p><b>200</b> - Ontology transfer document
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdExportGetRequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdExportGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdExportGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/export", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Export an ontology as transfer JSON
     * 
     * <p><b>200</b> - Ontology transfer document
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesOntologyIdExportGet(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesOntologyIdExportGetRequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     * Export an ontology as transfer JSON
     * 
     * <p><b>200</b> - Ontology transfer document
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesOntologyIdExportGetWithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesOntologyIdExportGetRequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
    }

    /**
     * Export an ontology as transfer JSON
     * 
     * <p><b>200</b> - Ontology transfer document
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdExportGetWithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesOntologyIdExportGetRequestCreation(projectId, ontologyId);
    }
    /**
     * Read graph layout
     * 
     * <p><b>200</b> - Graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGetRequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/layout", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Read graph layout
     * 
     * <p><b>200</b> - Graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGetRequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     * Read graph layout
     * 
     * <p><b>200</b> - Graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGetWithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGetRequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
    }

    /**
     * Read graph layout
     * 
     * <p><b>200</b> - Graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGetWithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGetRequestCreation(projectId, ontologyId);
    }
    /**
     * Save graph layout
     * 
     * <p><b>200</b> - Saved graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatchRequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/layout", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Save graph layout
     * 
     * <p><b>200</b> - Saved graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatchRequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     * Save graph layout
     * 
     * <p><b>200</b> - Saved graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatchWithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatchRequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
    }

    /**
     * Save graph layout
     * 
     * <p><b>200</b> - Saved graph layout
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatchWithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatchRequestCreation(projectId, ontologyId);
    }
    /**
     * List validation jobs
     * 
     * <p><b>200</b> - Validation job history
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGetRequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/validation-jobs", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List validation jobs
     * 
     * <p><b>200</b> - Validation job history
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGetRequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     * List validation jobs
     * 
     * <p><b>200</b> - Validation job history
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGetWithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGetRequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
    }

    /**
     * List validation jobs
     * 
     * <p><b>200</b> - Validation job history
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGetWithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGetRequestCreation(projectId, ontologyId);
    }
    /**
     * Run a validation job
     * 
     * <p><b>201</b> - Completed validation job
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPostRequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/validation-jobs", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Run a validation job
     * 
     * <p><b>201</b> - Completed validation job
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPostRequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     * Run a validation job
     * 
     * <p><b>201</b> - Completed validation job
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPostWithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPostRequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
    }

    /**
     * Run a validation job
     * 
     * <p><b>201</b> - Completed validation job
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPostWithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPostRequestCreation(projectId, ontologyId);
    }
    /**
     * Create an ontology
     * 
     * <p><b>201</b> - Created ontology
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1ProjectsProjectIdOntologiesPostRequestCreation(UUID projectId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling apiV1ProjectsProjectIdOntologiesPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create an ontology
     * 
     * <p><b>201</b> - Created ontology
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void apiV1ProjectsProjectIdOntologiesPost(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        apiV1ProjectsProjectIdOntologiesPostRequestCreation(projectId).body(localVarReturnType);
    }

    /**
     * Create an ontology
     * 
     * <p><b>201</b> - Created ontology
     * @param projectId The projectId parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> apiV1ProjectsProjectIdOntologiesPostWithHttpInfo(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1ProjectsProjectIdOntologiesPostRequestCreation(projectId).toEntity(localVarReturnType);
    }

    /**
     * Create an ontology
     * 
     * <p><b>201</b> - Created ontology
     * @param projectId The projectId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1ProjectsProjectIdOntologiesPostWithResponseSpec(UUID projectId) throws RestClientResponseException {
        return apiV1ProjectsProjectIdOntologiesPostRequestCreation(projectId);
    }
}
