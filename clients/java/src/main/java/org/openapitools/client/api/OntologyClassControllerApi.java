package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateOntologyClassRequest;
import org.openapitools.client.model.OntologyClassResponse;
import java.util.UUID;
import org.openapitools.client.model.UpdateOntologyClassRequest;

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
public class OntologyClassControllerApi {
    private ApiClient apiClient;

    public OntologyClassControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public OntologyClassControllerApi(ApiClient apiClient) {
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
     * @param createOntologyClassRequest The createOntologyClassRequest parameter
     * @return OntologyClassResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec create3RequestCreation(UUID projectId, UUID ontologyId, CreateOntologyClassRequest createOntologyClassRequest) throws RestClientResponseException {
        Object postBody = createOntologyClassRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling create3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling create3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'createOntologyClassRequest' is set
        if (createOntologyClassRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'createOntologyClassRequest' when calling create3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param createOntologyClassRequest The createOntologyClassRequest parameter
     * @return OntologyClassResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyClassResponse create3(UUID projectId, UUID ontologyId, CreateOntologyClassRequest createOntologyClassRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create3RequestCreation(projectId, ontologyId, createOntologyClassRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param createOntologyClassRequest The createOntologyClassRequest parameter
     * @return ResponseEntity&lt;OntologyClassResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyClassResponse> create3WithHttpInfo(UUID projectId, UUID ontologyId, CreateOntologyClassRequest createOntologyClassRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create3RequestCreation(projectId, ontologyId, createOntologyClassRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param createOntologyClassRequest The createOntologyClassRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec create3WithResponseSpec(UUID projectId, UUID ontologyId, CreateOntologyClassRequest createOntologyClassRequest) throws RestClientResponseException {
        return create3RequestCreation(projectId, ontologyId, createOntologyClassRequest);
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
    private ResponseSpec delete1RequestCreation(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling delete1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling delete1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling delete1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
    public void delete1(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        delete1RequestCreation(projectId, ontologyId, id).body(localVarReturnType);
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
    public ResponseEntity<Void> delete1WithHttpInfo(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return delete1RequestCreation(projectId, ontologyId, id).toEntity(localVarReturnType);
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
    public ResponseSpec delete1WithResponseSpec(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        return delete1RequestCreation(projectId, ontologyId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return OntologyClassResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec get1RequestCreation(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling get1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling get1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling get1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return OntologyClassResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyClassResponse get1(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get1RequestCreation(projectId, ontologyId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyClassResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyClassResponse> get1WithHttpInfo(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get1RequestCreation(projectId, ontologyId, id).toEntity(localVarReturnType);
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
    public ResponseSpec get1WithResponseSpec(UUID projectId, UUID ontologyId, UUID id) throws RestClientResponseException {
        return get1RequestCreation(projectId, ontologyId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return List&lt;OntologyClassResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec list4RequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling list4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling list4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<List<OntologyClassResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return List&lt;OntologyClassResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<OntologyClassResponse> list4(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyClassResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list4RequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseEntity&lt;List&lt;OntologyClassResponse&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<OntologyClassResponse>> list4WithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyClassResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list4RequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
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
    public ResponseSpec list4WithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return list4RequestCreation(projectId, ontologyId);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyClassRequest The updateOntologyClassRequest parameter
     * @return OntologyClassResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec update1RequestCreation(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyClassRequest updateOntologyClassRequest) throws RestClientResponseException {
        Object postBody = updateOntologyClassRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling update1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling update1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling update1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateOntologyClassRequest' is set
        if (updateOntologyClassRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'updateOntologyClassRequest' when calling update1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyClassRequest The updateOntologyClassRequest parameter
     * @return OntologyClassResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyClassResponse update1(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyClassRequest updateOntologyClassRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update1RequestCreation(projectId, ontologyId, id, updateOntologyClassRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyClassRequest The updateOntologyClassRequest parameter
     * @return ResponseEntity&lt;OntologyClassResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyClassResponse> update1WithHttpInfo(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyClassRequest updateOntologyClassRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyClassResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update1RequestCreation(projectId, ontologyId, id, updateOntologyClassRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param id The id parameter
     * @param updateOntologyClassRequest The updateOntologyClassRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec update1WithResponseSpec(UUID projectId, UUID ontologyId, UUID id, UpdateOntologyClassRequest updateOntologyClassRequest) throws RestClientResponseException {
        return update1RequestCreation(projectId, ontologyId, id, updateOntologyClassRequest);
    }
}
