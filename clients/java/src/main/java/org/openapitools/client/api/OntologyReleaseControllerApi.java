package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.OntologyReleaseDiffResponse;
import org.openapitools.client.model.OntologyReleaseResponse;
import org.openapitools.client.model.ReleaseOntologyRequest;
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
public class OntologyReleaseControllerApi {
    private ApiClient apiClient;

    public OntologyReleaseControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public OntologyReleaseControllerApi(ApiClient apiClient) {
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
     * @param ontologyId The ontologyId parameter
     * @param from The from parameter
     * @param to The to parameter
     * @return OntologyReleaseDiffResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec diffRequestCreation(UUID projectId, UUID ontologyId, UUID from, UUID to) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling diff", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling diff", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'from' is set
        if (from == null) {
            throw new RestClientResponseException("Missing the required parameter 'from' when calling diff", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'to' is set
        if (to == null) {
            throw new RestClientResponseException("Missing the required parameter 'to' when calling diff", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("projectId", projectId);
        pathParams.put("ontologyId", ontologyId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "from", from));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "to", to));

        final String[] localVarAccepts = {
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<OntologyReleaseDiffResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases/diff", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param from The from parameter
     * @param to The to parameter
     * @return OntologyReleaseDiffResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyReleaseDiffResponse diff(UUID projectId, UUID ontologyId, UUID from, UUID to) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyReleaseDiffResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return diffRequestCreation(projectId, ontologyId, from, to).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param from The from parameter
     * @param to The to parameter
     * @return ResponseEntity&lt;OntologyReleaseDiffResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyReleaseDiffResponse> diffWithHttpInfo(UUID projectId, UUID ontologyId, UUID from, UUID to) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyReleaseDiffResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return diffRequestCreation(projectId, ontologyId, from, to).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param from The from parameter
     * @param to The to parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec diffWithResponseSpec(UUID projectId, UUID ontologyId, UUID from, UUID to) throws RestClientResponseException {
        return diffRequestCreation(projectId, ontologyId, from, to);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return List&lt;OntologyReleaseResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec list2RequestCreation(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling list2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling list2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<List<OntologyReleaseResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return List&lt;OntologyReleaseResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<OntologyReleaseResponse> list2(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyReleaseResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list2RequestCreation(projectId, ontologyId).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @return ResponseEntity&lt;List&lt;OntologyReleaseResponse&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<OntologyReleaseResponse>> list2WithHttpInfo(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        ParameterizedTypeReference<List<OntologyReleaseResponse>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return list2RequestCreation(projectId, ontologyId).toEntity(localVarReturnType);
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
    public ResponseSpec list2WithResponseSpec(UUID projectId, UUID ontologyId) throws RestClientResponseException {
        return list2RequestCreation(projectId, ontologyId);
    }
    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param releaseOntologyRequest The releaseOntologyRequest parameter
     * @return OntologyReleaseResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec releaseRequestCreation(UUID projectId, UUID ontologyId, ReleaseOntologyRequest releaseOntologyRequest) throws RestClientResponseException {
        Object postBody = releaseOntologyRequest;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectId' when calling release", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'ontologyId' is set
        if (ontologyId == null) {
            throw new RestClientResponseException("Missing the required parameter 'ontologyId' when calling release", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'releaseOntologyRequest' is set
        if (releaseOntologyRequest == null) {
            throw new RestClientResponseException("Missing the required parameter 'releaseOntologyRequest' when calling release", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<OntologyReleaseResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/projects/{projectId}/ontologies/{ontologyId}/releases", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param releaseOntologyRequest The releaseOntologyRequest parameter
     * @return OntologyReleaseResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public OntologyReleaseResponse release(UUID projectId, UUID ontologyId, ReleaseOntologyRequest releaseOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyReleaseResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return releaseRequestCreation(projectId, ontologyId, releaseOntologyRequest).body(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param releaseOntologyRequest The releaseOntologyRequest parameter
     * @return ResponseEntity&lt;OntologyReleaseResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OntologyReleaseResponse> releaseWithHttpInfo(UUID projectId, UUID ontologyId, ReleaseOntologyRequest releaseOntologyRequest) throws RestClientResponseException {
        ParameterizedTypeReference<OntologyReleaseResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return releaseRequestCreation(projectId, ontologyId, releaseOntologyRequest).toEntity(localVarReturnType);
    }

    /**
     *
     *
     * <p><b>201</b> - Created
     * @param projectId The projectId parameter
     * @param ontologyId The ontologyId parameter
     * @param releaseOntologyRequest The releaseOntologyRequest parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec releaseWithResponseSpec(UUID projectId, UUID ontologyId, ReleaseOntologyRequest releaseOntologyRequest) throws RestClientResponseException {
        return releaseRequestCreation(projectId, ontologyId, releaseOntologyRequest);
    }
}
