package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateOntologyRelationRequest;
import org.openapitools.client.model.OntologyRelationResponse;
import java.util.UUID;
import org.openapitools.client.model.UpdateOntologyRelationRequest;

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
public class OntologyRelationControllerApi {
    private ApiClient apiClient;

    public OntologyRelationControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public OntologyRelationControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param createOntologyRelationRequest The createOntologyRelationRequest parameter
     * @return OntologyRelationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec create2RequestCreation(UUID projectId, UUID ontologyId, CreateOntologyRelationRequest createOntologyRelationRequest) throws RestClientResponseException {
        Object postBody = createOntologyRelationRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling create2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling create2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'createOntologyRelationRequest' is set
        if (createOntologyRelationRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'createOntologyRelationRequest' when calling create2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param createOntologyRelationRequest The createOntologyRelationRequest parameter
     * @return OntologyRelationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyRelationResponse create2(UUID projectId, UUID ontologyId, CreateOntologyRelationRequest createOntologyRelationRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create2RequestCreation(projectId, ontologyId, createOntologyRelationRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param createOntologyRelationRequest The createOntologyRelationRequest parameter
     * @return ResponseEntity&lt;OntologyRelationResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyRelationResponse> create2WithHttpInfo(UUID projectId, UUID ontologyId, CreateOntologyRelationRequest createOntologyRelationRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create2RequestCreation(projectId, ontologyId, createOntologyRelationRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param createOntologyRelationRequest The createOntologyRelationRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec create2WithResponseSpec(UUID projectId, UUID ontologyId, CreateOntologyRelationRequest createOntologyRelationRequest) throws RestClientResponseException {
        return create2RequestCreation(projectId, ontologyId, createOntologyRelationRequest);
    }
    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteRequestCreation(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling delete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling delete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling delete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void delete(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteRequestCreation(projectId, ontologyId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWithHttpInfo(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteRequestCreation(projectId, ontologyId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteWithResponseSpec(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        return deleteRequestCreation(projectId, ontologyId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return OntologyRelationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getRequestCreation(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling get", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling get", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling get", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return OntologyRelationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyRelationResponse get(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getRequestCreation(projectId, ontologyId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyRelationResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyRelationResponse> getWithHttpInfo(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getRequestCreation(projectId, ontologyId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getWithResponseSpec(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        return getRequestCreation(projectId, ontologyId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return List&lt;OntologyRelationResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec list3RequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling list3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling list3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<List<OntologyRelationResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return List&lt;OntologyRelationResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<OntologyRelationResponse> list3(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyRelationResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list3RequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseEntity&lt;List&lt;OntologyRelationResponse&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<OntologyRelationResponse>> list3WithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyRelationResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list3RequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec list3WithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return list3RequestCreation(projectId, ontologyId);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyRelationRequest The updateOntologyRelationRequest parameter
     * @return OntologyRelationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateRequestCreation(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyRelationRequest updateOntologyRelationRequest) throws RestClientResponseException {
        Object postBody = updateOntologyRelationRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling update", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling update", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling update", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateOntologyRelationRequest' is set
        if (updateOntologyRelationRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'updateOntologyRelationRequest' when calling update", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyRelationRequest The updateOntologyRelationRequest parameter
     * @return OntologyRelationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyRelationResponse update(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyRelationRequest updateOntologyRelationRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateRequestCreation(projectId, ontologyId, id, updateOntologyRelationRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyRelationRequest The updateOntologyRelationRequest parameter
     * @return ResponseEntity&lt;OntologyRelationResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyRelationResponse> updateWithHttpInfo(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyRelationRequest updateOntologyRelationRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyRelationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateRequestCreation(projectId, ontologyId, id, updateOntologyRelationRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyRelationRequest The updateOntologyRelationRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateWithResponseSpec(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyRelationRequest updateOntologyRelationRequest) throws RestClientResponseException {
        return updateRequestCreation(projectId, ontologyId, id, updateOntologyRelationRequest);
    }
}
