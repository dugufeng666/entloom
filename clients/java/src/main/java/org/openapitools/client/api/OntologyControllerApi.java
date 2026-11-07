package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ChangeOntologyStatusRequest;
import org.openapitools.client.model.CreateOntologyRequest;
import org.openapitools.client.model.ForkOntologyRequest;
import org.openapitools.client.model.OntologyLayoutResponse;
import org.openapitools.client.model.OntologyResponse;
import org.openapitools.client.model.OntologyTransferRequest;
import org.openapitools.client.model.OntologyValidationJobResponse;
import org.openapitools.client.model.OntologyValidationResponse;
import java.util.UUID;
import org.openapitools.client.model.UpdateOntologyLayoutRequest;
import org.openapitools.client.model.UpdateOntologyRequest;

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
public class OntologyControllerApi {
    private ApiClient apiClient;

    public OntologyControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public OntologyControllerApi(ApiClient apiClient) {
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
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param changeOntologyStatusRequest The changeOntologyStatusRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec changeStatusRequestCreation(UUID projectId, UUID id, ChangeOntologyStatusRequest changeOntologyStatusRequest) throws RestClientResponseException {
        Object postBody = changeOntologyStatusRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling changeStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling changeStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'changeOntologyStatusRequest' is set
        if (changeOntologyStatusRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'changeOntologyStatusRequest' when calling changeStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/status", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param changeOntologyStatusRequest The changeOntologyStatusRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyResponse changeStatus(UUID projectId, UUID id, ChangeOntologyStatusRequest changeOntologyStatusRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return changeStatusRequestCreation(projectId, id, changeOntologyStatusRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param changeOntologyStatusRequest The changeOntologyStatusRequest parameter
     * @return ResponseEntity&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyResponse> changeStatusWithHttpInfo(UUID projectId, UUID id, ChangeOntologyStatusRequest changeOntologyStatusRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return changeStatusRequestCreation(projectId, id, changeOntologyStatusRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param changeOntologyStatusRequest The changeOntologyStatusRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec changeStatusWithResponseSpec(UUID projectId, UUID id, ChangeOntologyStatusRequest changeOntologyStatusRequest) throws RestClientResponseException {
        return changeStatusRequestCreation(projectId, id, changeOntologyStatusRequest);
    }
    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param createOntologyRequest The createOntologyRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec create1RequestCreation(UUID projectId, CreateOntologyRequest createOntologyRequest) throws RestClientResponseException {
        Object postBody = createOntologyRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling create1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'createOntologyRequest' is set
        if (createOntologyRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'createOntologyRequest' when calling create1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);

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

        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param createOntologyRequest The createOntologyRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyResponse create1(UUID projectId, CreateOntologyRequest createOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create1RequestCreation(projectId, createOntologyRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param createOntologyRequest The createOntologyRequest parameter
     * @return ResponseEntity&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyResponse> create1WithHttpInfo(UUID projectId, CreateOntologyRequest createOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return create1RequestCreation(projectId, createOntologyRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param createOntologyRequest The createOntologyRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec create1WithResponseSpec(UUID projectId, CreateOntologyRequest createOntologyRequest) throws RestClientResponseException {
        return create1RequestCreation(projectId, createOntologyRequest);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyTransferRequest
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec exportRequestCreation(UUID projectId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling export", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling export", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyTransferRequest> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/export", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyTransferRequest
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyTransferRequest export(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyTransferRequest> localVarReturnType = new ParameterizedTypeReference<>() {};
        return exportRequestCreation(projectId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyTransferRequest&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyTransferRequest> exportWithHttpInfo(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyTransferRequest> localVarReturnType = new ParameterizedTypeReference<>() {};
        return exportRequestCreation(projectId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec exportWithResponseSpec(UUID projectId, UUID id) throws RestClientResponseException {
        return exportRequestCreation(projectId, id);
    }
    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param forkOntologyRequest The forkOntologyRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec forkRequestCreation(UUID projectId, UUID id, ForkOntologyRequest forkOntologyRequest) throws RestClientResponseException {
        Object postBody = forkOntologyRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling fork", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling fork", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'forkOntologyRequest' is set
        if (forkOntologyRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'forkOntologyRequest' when calling fork", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/fork", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param forkOntologyRequest The forkOntologyRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyResponse fork(UUID projectId, UUID id, ForkOntologyRequest forkOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return forkRequestCreation(projectId, id, forkOntologyRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param forkOntologyRequest The forkOntologyRequest parameter
     * @return ResponseEntity&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyResponse> forkWithHttpInfo(UUID projectId, UUID id, ForkOntologyRequest forkOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return forkRequestCreation(projectId, id, forkOntologyRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param forkOntologyRequest The forkOntologyRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec forkWithResponseSpec(UUID projectId, UUID id, ForkOntologyRequest forkOntologyRequest) throws RestClientResponseException {
        return forkRequestCreation(projectId, id, forkOntologyRequest);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec get3RequestCreation(UUID projectId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling get3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling get3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyResponse get3(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get3RequestCreation(projectId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyResponse> get3WithHttpInfo(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get3RequestCreation(projectId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec get3WithResponseSpec(UUID projectId, UUID id) throws RestClientResponseException {
        return get3RequestCreation(projectId, id);
    }
    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyTransferRequest The ontologyTransferRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec importOntologyRequestCreation(UUID projectId, OntologyTransferRequest ontologyTransferRequest) throws RestClientResponseException {
        Object postBody = ontologyTransferRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling importOntology", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyTransferRequest' is set
        if (ontologyTransferRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyTransferRequest' when calling importOntology", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);

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

        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/import", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyTransferRequest The ontologyTransferRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyResponse importOntology(UUID projectId, OntologyTransferRequest ontologyTransferRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return importOntologyRequestCreation(projectId, ontologyTransferRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyTransferRequest The ontologyTransferRequest parameter
     * @return ResponseEntity&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyResponse> importOntologyWithHttpInfo(UUID projectId, OntologyTransferRequest ontologyTransferRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return importOntologyRequestCreation(projectId, ontologyTransferRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyTransferRequest The ontologyTransferRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec importOntologyWithResponseSpec(UUID projectId, OntologyTransferRequest ontologyTransferRequest) throws RestClientResponseException {
        return importOntologyRequestCreation(projectId, ontologyTransferRequest);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyLayoutResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec layoutRequestCreation(UUID projectId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling layout", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling layout", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyLayoutResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/layout", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyLayoutResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyLayoutResponse layout(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyLayoutResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return layoutRequestCreation(projectId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyLayoutResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyLayoutResponse> layoutWithHttpInfo(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyLayoutResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return layoutRequestCreation(projectId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec layoutWithResponseSpec(UUID projectId, UUID id) throws RestClientResponseException {
        return layoutRequestCreation(projectId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @return List&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec list1RequestCreation(UUID projectId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling list1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);

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

        ParameterizedTypeReference<List<OntologyResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @return List&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<OntologyResponse> list1(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list1RequestCreation(projectId).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @return ResponseEntity&lt;List&lt;OntologyResponse&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<OntologyResponse>> list1WithHttpInfo(UUID projectId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list1RequestCreation(projectId).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec list1WithResponseSpec(UUID projectId) throws RestClientResponseException {
        return list1RequestCreation(projectId);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return List&lt;OntologyValidationJobResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listValidationJobsRequestCreation(UUID projectId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling listValidationJobs", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling listValidationJobs", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<List<OntologyValidationJobResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/validation-jobs", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return List&lt;OntologyValidationJobResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<OntologyValidationJobResponse> listValidationJobs(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyValidationJobResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return listValidationJobsRequestCreation(projectId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;List&lt;OntologyValidationJobResponse&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<OntologyValidationJobResponse>> listValidationJobsWithHttpInfo(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyValidationJobResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return listValidationJobsRequestCreation(projectId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec listValidationJobsWithResponseSpec(UUID projectId, UUID id) throws RestClientResponseException {
        return listValidationJobsRequestCreation(projectId, id);
    }
    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyValidationJobResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec runValidationJobRequestCreation(UUID projectId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling runValidationJob", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling runValidationJob", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyValidationJobResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/validation-jobs", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyValidationJobResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyValidationJobResponse runValidationJob(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyValidationJobResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return runValidationJobRequestCreation(projectId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyValidationJobResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyValidationJobResponse> runValidationJobWithHttpInfo(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyValidationJobResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return runValidationJobRequestCreation(projectId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec runValidationJobWithResponseSpec(UUID projectId, UUID id) throws RestClientResponseException {
        return runValidationJobRequestCreation(projectId, id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyRequest The updateOntologyRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec update3RequestCreation(UUID projectId, UUID id, UpdateOntologyRequest updateOntologyRequest) throws RestClientResponseException {
        Object postBody = updateOntologyRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling update3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling update3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateOntologyRequest' is set
        if (updateOntologyRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'updateOntologyRequest' when calling update3", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyRequest The updateOntologyRequest parameter
     * @return OntologyResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyResponse update3(UUID projectId, UUID id, UpdateOntologyRequest updateOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update3RequestCreation(projectId, id, updateOntologyRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyRequest The updateOntologyRequest parameter
     * @return ResponseEntity&lt;OntologyResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyResponse> update3WithHttpInfo(UUID projectId, UUID id, UpdateOntologyRequest updateOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update3RequestCreation(projectId, id, updateOntologyRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyRequest The updateOntologyRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec update3WithResponseSpec(UUID projectId, UUID id, UpdateOntologyRequest updateOntologyRequest) throws RestClientResponseException {
        return update3RequestCreation(projectId, id, updateOntologyRequest);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyLayoutRequest The updateOntologyLayoutRequest parameter
     * @return OntologyLayoutResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateLayoutRequestCreation(UUID projectId, UUID id, UpdateOntologyLayoutRequest updateOntologyLayoutRequest) throws RestClientResponseException {
        Object postBody = updateOntologyLayoutRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling updateLayout", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateLayout", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateOntologyLayoutRequest' is set
        if (updateOntologyLayoutRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'updateOntologyLayoutRequest' when calling updateLayout", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyLayoutResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/layout", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyLayoutRequest The updateOntologyLayoutRequest parameter
     * @return OntologyLayoutResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyLayoutResponse updateLayout(UUID projectId, UUID id, UpdateOntologyLayoutRequest updateOntologyLayoutRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyLayoutResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateLayoutRequestCreation(projectId, id, updateOntologyLayoutRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyLayoutRequest The updateOntologyLayoutRequest parameter
     * @return ResponseEntity&lt;OntologyLayoutResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyLayoutResponse> updateLayoutWithHttpInfo(UUID projectId, UUID id, UpdateOntologyLayoutRequest updateOntologyLayoutRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyLayoutResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateLayoutRequestCreation(projectId, id, updateOntologyLayoutRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @param updateOntologyLayoutRequest The updateOntologyLayoutRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateLayoutWithResponseSpec(UUID projectId, UUID id, UpdateOntologyLayoutRequest updateOntologyLayoutRequest) throws RestClientResponseException {
        return updateLayoutRequestCreation(projectId, id, updateOntologyLayoutRequest);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyValidationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec validateRequestCreation(UUID projectId, UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling validate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling validate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
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

        ParameterizedTypeReference<OntologyValidationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{id}/validation", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return OntologyValidationResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyValidationResponse validate(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyValidationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return validateRequestCreation(projectId, id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseEntity&lt;OntologyValidationResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyValidationResponse> validateWithHttpInfo(UUID projectId, UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyValidationResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return validateRequestCreation(projectId, id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec validateWithResponseSpec(UUID projectId, UUID id) throws RestClientResponseException {
        return validateRequestCreation(projectId, id);
    }
}
