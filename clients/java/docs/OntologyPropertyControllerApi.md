# OntologyPropertyControllerApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create4**](OntologyPropertyControllerApi.md#create4) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties |  |
| [**delete2**](OntologyPropertyControllerApi.md#delete2) | **DELETE** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id} |  |
| [**get2**](OntologyPropertyControllerApi.md#get2) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id} |  |
| [**list5**](OntologyPropertyControllerApi.md#list5) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties |  |
| [**update2**](OntologyPropertyControllerApi.md#update2) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id} |  |



## create4

> OntologyPropertyResponse create4(projectId, ontologyId, classId, createOntologyPropertyRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyPropertyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyPropertyControllerApi apiInstance = new OntologyPropertyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID classId = UUID.randomUUID(); // UUID |
        CreateOntologyPropertyRequest createOntologyPropertyRequest = new CreateOntologyPropertyRequest(); // CreateOntologyPropertyRequest |
        try {
            OntologyPropertyResponse result = apiInstance.create4(projectId, ontologyId, classId, createOntologyPropertyRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyPropertyControllerApi#create4");
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
| **classId** | **UUID**|  | |
| **createOntologyPropertyRequest** | [**CreateOntologyPropertyRequest**](CreateOntologyPropertyRequest.md)|  | |

### Return type

[**OntologyPropertyResponse**](OntologyPropertyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## delete2

> delete2(projectId, ontologyId, classId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyPropertyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyPropertyControllerApi apiInstance = new OntologyPropertyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID classId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            apiInstance.delete2(projectId, ontologyId, classId, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyPropertyControllerApi#delete2");
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
| **classId** | **UUID**|  | |
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


## get2

> OntologyPropertyResponse get2(projectId, ontologyId, classId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyPropertyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyPropertyControllerApi apiInstance = new OntologyPropertyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID classId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyPropertyResponse result = apiInstance.get2(projectId, ontologyId, classId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyPropertyControllerApi#get2");
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
| **classId** | **UUID**|  | |
| **id** | **UUID**|  | |

### Return type

[**OntologyPropertyResponse**](OntologyPropertyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## list5

> List&lt;OntologyPropertyResponse&gt; list5(projectId, ontologyId, classId)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyPropertyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyPropertyControllerApi apiInstance = new OntologyPropertyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID classId = UUID.randomUUID(); // UUID |
        try {
            List<OntologyPropertyResponse> result = apiInstance.list5(projectId, ontologyId, classId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyPropertyControllerApi#list5");
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
| **classId** | **UUID**|  | |

### Return type

[**List&lt;OntologyPropertyResponse&gt;**](OntologyPropertyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## update2

> OntologyPropertyResponse update2(projectId, ontologyId, classId, id, updateOntologyPropertyRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyPropertyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyPropertyControllerApi apiInstance = new OntologyPropertyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID classId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        UpdateOntologyPropertyRequest updateOntologyPropertyRequest = new UpdateOntologyPropertyRequest(); // UpdateOntologyPropertyRequest |
        try {
            OntologyPropertyResponse result = apiInstance.update2(projectId, ontologyId, classId, id, updateOntologyPropertyRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyPropertyControllerApi#update2");
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
| **classId** | **UUID**|  | |
| **id** | **UUID**|  | |
| **updateOntologyPropertyRequest** | [**UpdateOntologyPropertyRequest**](UpdateOntologyPropertyRequest.md)|  | |

### Return type

[**OntologyPropertyResponse**](OntologyPropertyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

