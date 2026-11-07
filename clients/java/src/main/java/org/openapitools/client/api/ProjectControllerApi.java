package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ChangeProjectStatusRequest;
import org.openapitools.client.model.CreateProjectRequest;
import org.openapitools.client.model.ProjectResponse;
import java.util.UUID;
import org.openapitools.client.model.UpdateProjectRequest;

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
public class ProjectControllerApi {
    private ApiClient apiClient;

    public ProjectControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public ProjectControllerApi(ApiClient apiClient) {
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
     * @return List&lt;ProjectResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec callListRequestCreation() throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<List<ProjectResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @return List&lt;ProjectResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<ProjectResponse> callList() throws RestClientResponseException {
        ParameterizedTypeReference<List<ProjectResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return callListRequestCreation().body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;List&lt;ProjectResponse&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ProjectResponse>> callListWithHttpInfo() throws RestClientResponseException {
        ParameterizedTypeReference<List<ProjectResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return callListRequestCreation().toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec callListWithResponseSpec() throws RestClientResponseException {
        return callListRequestCreation();
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param changeProjectStatusRequest The changeProjectStatusRequest parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec changeStatus1RequestCreation(UUID id, ChangeProjectStatusRequest changeProjectStatusRequest) throws RestClientResponseException {
        Object postBody = changeProjectStatusRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling changeStatus1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'changeProjectStatusRequest' is set
        if (changeProjectStatusRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'changeProjectStatusRequest' when calling changeStatus1", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{id}/status", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param changeProjectStatusRequest The changeProjectStatusRequest parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectResponse changeStatus1(UUID id, ChangeProjectStatusRequest changeProjectStatusRequest) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return changeStatus1RequestCreation(id, changeProjectStatusRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param changeProjectStatusRequest The changeProjectStatusRequest parameter
     * @return ResponseEntity&lt;ProjectResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectResponse> changeStatus1WithHttpInfo(UUID id, ChangeProjectStatusRequest changeProjectStatusRequest) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return changeStatus1RequestCreation(id, changeProjectStatusRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param changeProjectStatusRequest The changeProjectStatusRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec changeStatus1WithResponseSpec(UUID id, ChangeProjectStatusRequest changeProjectStatusRequest) throws RestClientResponseException {
        return changeStatus1RequestCreation(id, changeProjectStatusRequest);
    }
    /**
     *
     *
     * <p><b>201</b> - Created
     * @param createProjectRequest The createProjectRequest parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createRequestCreation(CreateProjectRequest createProjectRequest) throws RestClientResponseException {
        Object postBody = createProjectRequest;
        // verify the required parameter 'createProjectRequest' is set
        if (createProjectRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'createProjectRequest' when calling create", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param createProjectRequest The createProjectRequest parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectResponse create(CreateProjectRequest createProjectRequest) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createRequestCreation(createProjectRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param createProjectRequest The createProjectRequest parameter
     * @return ResponseEntity&lt;ProjectResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectResponse> createWithHttpInfo(CreateProjectRequest createProjectRequest) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createRequestCreation(createProjectRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param createProjectRequest The createProjectRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createWithResponseSpec(CreateProjectRequest createProjectRequest) throws RestClientResponseException {
        return createRequestCreation(createProjectRequest);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec get4RequestCreation(UUID id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling get4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectResponse get4(UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get4RequestCreation(id).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @return ResponseEntity&lt;ProjectResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectResponse> get4WithHttpInfo(UUID id) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return get4RequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec get4WithResponseSpec(UUID id) throws RestClientResponseException {
        return get4RequestCreation(id);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param updateProjectRequest The updateProjectRequest parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec update4RequestCreation(UUID id, UpdateProjectRequest updateProjectRequest) throws RestClientResponseException {
        Object postBody = updateProjectRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling update4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateProjectRequest' is set
        if (updateProjectRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'updateProjectRequest' when calling update4", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param updateProjectRequest The updateProjectRequest parameter
     * @return ProjectResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectResponse update4(UUID id, UpdateProjectRequest updateProjectRequest) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update4RequestCreation(id, updateProjectRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param updateProjectRequest The updateProjectRequest parameter
     * @return ResponseEntity&lt;ProjectResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectResponse> update4WithHttpInfo(UUID id, UpdateProjectRequest updateProjectRequest) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return update4RequestCreation(id, updateProjectRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param id The id parameter
     * @param updateProjectRequest The updateProjectRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec update4WithResponseSpec(UUID id, UpdateProjectRequest updateProjectRequest) throws RestClientResponseException {
        return update4RequestCreation(id, updateProjectRequest);
    }
}
