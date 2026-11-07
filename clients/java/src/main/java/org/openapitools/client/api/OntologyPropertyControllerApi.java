package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateOntologyPropertyRequest;
import org.openapitools.client.model.OntologyPropertyResponse;
import java.util.UUID;
import org.openapitools.client.model.UpdateOntologyPropertyRequest;

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
public class OntologyPropertyControllerApi {
    private ApiClient apiClient;

    public OntologyPropertyControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public OntologyPropertyControllerApi(ApiClient apiClient) {
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
     * @param classId The classId parameter
     * @param createOntologyPropertyRequest The createOntologyPropertyRequest parameter
     * @return OntologyPropertyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec create4RequestCreation(UUID projectId, UUID ontologyId, UUID classId, CreateOntologyPropertyRequest createOntologyPropertyRequest) throws RestClientResponseException {
        Object postBody = createOntologyPropertyRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling create4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling create4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'classId' is set
        if (classId == null) {
            throw new RestClientResponseException("Missing the required parameter 'classId' when calling create4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'createOntologyPropertyRequest' is set
        if (createOntologyPropertyRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'createOntologyPropertyRequest' when calling create4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("classId", classId);

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

        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param createOntologyPropertyRequest The createOntologyPropertyRequest parameter
     * @return OntologyPropertyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyPropertyResponse create4(UUID projectId, UUID ontologyId, UUID classId, CreateOntologyPropertyRequest createOntologyPropertyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create4RequestCreation(projectId, ontologyId, classId, createOntologyPropertyRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param createOntologyPropertyRequest The createOntologyPropertyRequest parameter
     * @return ResponseEntity&lt;OntologyPropertyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyPropertyResponse> create4WithHttpInfo(UUID projectId, UUID ontologyId, UUID classId, CreateOntologyPropertyRequest createOntologyPropertyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create4RequestCreation(projectId, ontologyId, classId, createOntologyPropertyRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param createOntologyPropertyRequest The createOntologyPropertyRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec create4WithResponseSpec(UUID projectId, UUID ontologyId, UUID classId, CreateOntologyPropertyRequest createOntologyPropertyRequest) throws RestClientResponseException {
        return create4RequestCreation(projectId, ontologyId, classId, createOntologyPropertyRequest);
    }
    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec delete2RequestCreation(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling delete2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling delete2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'classId' is set
        if (classId == null) {
            throw new RestClientResponseException("Missing the required parameter 'classId' when calling delete2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling delete2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("classId", classId);
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
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void delete2(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        delete2RequestCreation(projectId, ontologyId, classId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> delete2WithHttpInfo(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return delete2RequestCreation(projectId, ontologyId, classId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec delete2WithResponseSpec(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        return delete2RequestCreation(projectId, ontologyId, classId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @return OntologyPropertyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec get2RequestCreation(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling get2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling get2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'classId' is set
        if (classId == null) {
            throw new RestClientResponseException("Missing the required parameter 'classId' when calling get2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling get2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("classId", classId);
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

        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @return OntologyPropertyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyPropertyResponse get2(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get2RequestCreation(projectId, ontologyId, classId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyPropertyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyPropertyResponse> get2WithHttpInfo(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get2RequestCreation(projectId, ontologyId, classId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec get2WithResponseSpec(UUID projectId, UUID ontologyId, UUID classId, UUID id) throws RestClientResponseException {
        return get2RequestCreation(projectId, ontologyId, classId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @return List&lt;OntologyPropertyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec list5RequestCreation(UUID projectId, UUID ontologyId, UUID classId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling list5", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling list5", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'classId' is set
        if (classId == null) {
            throw new RestClientResponseException("Missing the required parameter 'classId' when calling list5", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("classId", classId);

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

        ParameterizedTypeReference<List<OntologyPropertyResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @return List&lt;OntologyPropertyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<OntologyPropertyResponse> list5(UUID projectId, UUID ontologyId, UUID classId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyPropertyResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list5RequestCreation(projectId, ontologyId, classId).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @return ResponseEntity&lt;List&lt;OntologyPropertyResponse&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<OntologyPropertyResponse>> list5WithHttpInfo(UUID projectId, UUID ontologyId, UUID classId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyPropertyResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list5RequestCreation(projectId, ontologyId, classId).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec list5WithResponseSpec(UUID projectId, UUID ontologyId, UUID classId) throws RestClientResponseException {
        return list5RequestCreation(projectId, ontologyId, classId);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @param updateOntologyPropertyRequest The updateOntologyPropertyRequest parameter
     * @return OntologyPropertyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec update2RequestCreation(UUID projectId, UUID ontologyId, UUID classId, UUID id, UpdateOntologyPropertyRequest updateOntologyPropertyRequest) throws RestClientResponseException {
        Object postBody = updateOntologyPropertyRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling update2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling update2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'classId' is set
        if (classId == null) {
            throw new RestClientResponseException("Missing the required parameter 'classId' when calling update2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling update2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateOntologyPropertyRequest' is set
        if (updateOntologyPropertyRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'updateOntologyPropertyRequest' when calling update2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);
        pathParams.put("classId", classId);
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

        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @param updateOntologyPropertyRequest The updateOntologyPropertyRequest parameter
     * @return OntologyPropertyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyPropertyResponse update2(UUID projectId, UUID ontologyId, UUID classId, UUID id, UpdateOntologyPropertyRequest updateOntologyPropertyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update2RequestCreation(projectId, ontologyId, classId, id, updateOntologyPropertyRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @param updateOntologyPropertyRequest The updateOntologyPropertyRequest parameter
     * @return ResponseEntity&lt;OntologyPropertyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyPropertyResponse> update2WithHttpInfo(UUID projectId, UUID ontologyId, UUID classId, UUID id, UpdateOntologyPropertyRequest updateOntologyPropertyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyPropertyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update2RequestCreation(projectId, ontologyId, classId, id, updateOntologyPropertyRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param classId The classId parameter
     * @param id The id parameter
     * @param updateOntologyPropertyRequest The updateOntologyPropertyRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec update2WithResponseSpec(UUID projectId, UUID ontologyId, UUID classId, UUID id, UpdateOntologyPropertyRequest updateOntologyPropertyRequest) throws RestClientResponseException {
        return update2RequestCreation(projectId, ontologyId, classId, id, updateOntologyPropertyRequest);
    }
}
