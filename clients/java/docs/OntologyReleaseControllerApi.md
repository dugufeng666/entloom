# OntologyReleaseControllerApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**diff**](OntologyReleaseControllerApi.md#diff) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/releases/diff |  |
| [**list2**](OntologyReleaseControllerApi.md#list2) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/releases |  |
| [**release**](OntologyReleaseControllerApi.md#release) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/releases |  |



## diff

> OntologyReleaseDiffResponse diff(projectId, ontologyId, from, to)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyReleaseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyReleaseControllerApi apiInstance = new OntologyReleaseControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID from = UUID.randomUUID(); // UUID |
        UUID to = UUID.randomUUID(); // UUID |
        try {
            OntologyReleaseDiffResponse result = apiInstance.diff(projectId, ontologyId, from, to);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyReleaseControllerApi#diff");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **projectId** | **UUID**|  | |
| **ontologyId** | **UUID**|  | |
| **from** | **UUID**|  | |
| **to** | **UUID**|  | |

### Return type

[**OntologyReleaseDiffResponse**](OntologyReleaseDiffResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## list2

> List&lt;OntologyReleaseResponse&gt; list2(projectId, ontologyId)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyReleaseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyReleaseControllerApi apiInstance = new OntologyReleaseControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        try {
            List<OntologyReleaseResponse> result = apiInstance.list2(projectId, ontologyId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyReleaseControllerApi#list2");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **projectId** | **UUID**|  | |
| **ontologyId** | **UUID**|  | |

### Return type

[**List&lt;OntologyReleaseResponse&gt;**](OntologyReleaseResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## release

> OntologyReleaseResponse release(projectId, ontologyId, releaseOntologyRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyReleaseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyReleaseControllerApi apiInstance = new OntologyReleaseControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        ReleaseOntologyRequest releaseOntologyRequest = new ReleaseOntologyRequest(); // ReleaseOntologyRequest |
        try {
            OntologyReleaseResponse result = apiInstance.release(projectId, ontologyId, releaseOntologyRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyReleaseControllerApi#release");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **projectId** | **UUID**|  | |
| **ontologyId** | **UUID**|  | |
| **releaseOntologyRequest** | [**ReleaseOntologyRequest**](ReleaseOntologyRequest.md)|  | |

### Return type

[**OntologyReleaseResponse**](OntologyReleaseResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

