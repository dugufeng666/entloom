# OntologyClassControllerApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create3**](OntologyClassControllerApi.md#create3) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes |  |
| [**delete1**](OntologyClassControllerApi.md#delete1) | **DELETE** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id} |  |
| [**get1**](OntologyClassControllerApi.md#get1) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id} |  |
| [**list4**](OntologyClassControllerApi.md#list4) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes |  |
| [**update1**](OntologyClassControllerApi.md#update1) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id} |  |



## create3

> OntologyClassResponse create3(projectId, ontologyId, createOntologyClassRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyClassControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyClassControllerApi apiInstance = new OntologyClassControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        CreateOntologyClassRequest createOntologyClassRequest = new CreateOntologyClassRequest(); // CreateOntologyClassRequest |
        try {
            OntologyClassResponse result = apiInstance.create3(projectId, ontologyId, createOntologyClassRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyClassControllerApi#create3");
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
| **createOntologyClassRequest** | [**CreateOntologyClassRequest**](CreateOntologyClassRequest.md)|  | |

### Return type

[**OntologyClassResponse**](OntologyClassResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## delete1

> delete1(projectId, ontologyId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyClassControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyClassControllerApi apiInstance = new OntologyClassControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            apiInstance.delete1(projectId, ontologyId, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyClassControllerApi#delete1");
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
| **id** | **UUID**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |


## get1

> OntologyClassResponse get1(projectId, ontologyId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyClassControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyClassControllerApi apiInstance = new OntologyClassControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyClassResponse result = apiInstance.get1(projectId, ontologyId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyClassControllerApi#get1");
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
| **id** | **UUID**|  | |

### Return type

[**OntologyClassResponse**](OntologyClassResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## list4

> List&lt;OntologyClassResponse&gt; list4(projectId, ontologyId)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyClassControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyClassControllerApi apiInstance = new OntologyClassControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        try {
            List<OntologyClassResponse> result = apiInstance.list4(projectId, ontologyId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyClassControllerApi#list4");
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

[**List&lt;OntologyClassResponse&gt;**](OntologyClassResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## update1

> OntologyClassResponse update1(projectId, ontologyId, id, updateOntologyClassRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyClassControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyClassControllerApi apiInstance = new OntologyClassControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        UpdateOntologyClassRequest updateOntologyClassRequest = new UpdateOntologyClassRequest(); // UpdateOntologyClassRequest |
        try {
            OntologyClassResponse result = apiInstance.update1(projectId, ontologyId, id, updateOntologyClassRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyClassControllerApi#update1");
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
| **id** | **UUID**|  | |
| **updateOntologyClassRequest** | [**UpdateOntologyClassRequest**](UpdateOntologyClassRequest.md)|  | |

### Return type

[**OntologyClassResponse**](OntologyClassResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

