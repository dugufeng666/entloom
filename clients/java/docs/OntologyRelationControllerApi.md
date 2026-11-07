# OntologyRelationControllerApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create2**](OntologyRelationControllerApi.md#create2) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations |  |
| [**delete**](OntologyRelationControllerApi.md#delete) | **DELETE** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id} |  |
| [**get**](OntologyRelationControllerApi.md#get) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id} |  |
| [**list3**](OntologyRelationControllerApi.md#list3) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations |  |
| [**update**](OntologyRelationControllerApi.md#update) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id} |  |



## create2

> OntologyRelationResponse create2(projectId, ontologyId, createOntologyRelationRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyRelationControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyRelationControllerApi apiInstance = new OntologyRelationControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        CreateOntologyRelationRequest createOntologyRelationRequest = new CreateOntologyRelationRequest(); // CreateOntologyRelationRequest |
        try {
            OntologyRelationResponse result = apiInstance.create2(projectId, ontologyId, createOntologyRelationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyRelationControllerApi#create2");
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
| **createOntologyRelationRequest** | [**CreateOntologyRelationRequest**](CreateOntologyRelationRequest.md)|  | |

### Return type

[**OntologyRelationResponse**](OntologyRelationResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## delete

> delete(projectId, ontologyId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyRelationControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyRelationControllerApi apiInstance = new OntologyRelationControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            apiInstance.delete(projectId, ontologyId, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyRelationControllerApi#delete");
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


## get

> OntologyRelationResponse get(projectId, ontologyId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyRelationControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyRelationControllerApi apiInstance = new OntologyRelationControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyRelationResponse result = apiInstance.get(projectId, ontologyId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyRelationControllerApi#get");
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

[**OntologyRelationResponse**](OntologyRelationResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## list3

> List&lt;OntologyRelationResponse&gt; list3(projectId, ontologyId)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyRelationControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyRelationControllerApi apiInstance = new OntologyRelationControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        try {
            List<OntologyRelationResponse> result = apiInstance.list3(projectId, ontologyId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyRelationControllerApi#list3");
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

[**List&lt;OntologyRelationResponse&gt;**](OntologyRelationResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## update

> OntologyRelationResponse update(projectId, ontologyId, id, updateOntologyRelationRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyRelationControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyRelationControllerApi apiInstance = new OntologyRelationControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID ontologyId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        UpdateOntologyRelationRequest updateOntologyRelationRequest = new UpdateOntologyRelationRequest(); // UpdateOntologyRelationRequest |
        try {
            OntologyRelationResponse result = apiInstance.update(projectId, ontologyId, id, updateOntologyRelationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyRelationControllerApi#update");
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
| **updateOntologyRelationRequest** | [**UpdateOntologyRelationRequest**](UpdateOntologyRelationRequest.md)|  | |

### Return type

[**OntologyRelationResponse**](OntologyRelationResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

