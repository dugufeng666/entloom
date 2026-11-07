# DefaultApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1AuthMeGet**](DefaultApi.md#apiV1AuthMeGet) | **GET** /api/v1/auth/me | Read the authenticated user |
| [**apiV1ProjectsGet**](DefaultApi.md#apiV1ProjectsGet) | **GET** /api/v1/projects | List projects |
| [**apiV1ProjectsPost**](DefaultApi.md#apiV1ProjectsPost) | **POST** /api/v1/projects | Create a project |
| [**apiV1ProjectsProjectIdOntologiesGet**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesGet) | **GET** /api/v1/projects/{projectId}/ontologies | List project ontologies |
| [**apiV1ProjectsProjectIdOntologiesImportPost**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesImportPost) | **POST** /api/v1/projects/{projectId}/ontologies/import | Import a transfer JSON document as a new draft |
| [**apiV1ProjectsProjectIdOntologiesOntologyIdExportGet**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesOntologyIdExportGet) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/export | Export an ontology as transfer JSON |
| [**apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/layout | Read graph layout |
| [**apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/layout | Save graph layout |
| [**apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/validation-jobs | List validation jobs |
| [**apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/validation-jobs | Run a validation job |
| [**apiV1ProjectsProjectIdOntologiesPost**](DefaultApi.md#apiV1ProjectsProjectIdOntologiesPost) | **POST** /api/v1/projects/{projectId}/ontologies | Create an ontology |



## apiV1AuthMeGet

> apiV1AuthMeGet()

Read the authenticated user

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        try {
            apiInstance.apiV1AuthMeGet();
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1AuthMeGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Authenticated user |  -  |


## apiV1ProjectsGet

> apiV1ProjectsGet()

List projects

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        try {
            apiInstance.apiV1ProjectsGet();
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Project list |  -  |


## apiV1ProjectsPost

> apiV1ProjectsPost()

Create a project

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        try {
            apiInstance.apiV1ProjectsPost();
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsPost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created project |  -  |


## apiV1ProjectsProjectIdOntologiesGet

> apiV1ProjectsProjectIdOntologiesGet(projectId)

List project ontologies

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesGet(projectId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesGet");
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

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ontology list |  -  |


## apiV1ProjectsProjectIdOntologiesImportPost

> apiV1ProjectsProjectIdOntologiesImportPost(projectId)

Import a transfer JSON document as a new draft

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesImportPost(projectId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesImportPost");
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

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Imported draft ontology |  -  |


## apiV1ProjectsProjectIdOntologiesOntologyIdExportGet

> apiV1ProjectsProjectIdOntologiesOntologyIdExportGet(projectId, ontologyId)

Export an ontology as transfer JSON

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        UUID ontologyId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesOntologyIdExportGet(projectId, ontologyId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesOntologyIdExportGet");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ontology transfer document |  -  |


## apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet

> apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet(projectId, ontologyId)

Read graph layout

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        UUID ontologyId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet(projectId, ontologyId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesOntologyIdLayoutGet");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Graph layout |  -  |


## apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch

> apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch(projectId, ontologyId)

Save graph layout

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        UUID ontologyId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch(projectId, ontologyId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesOntologyIdLayoutPatch");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Saved graph layout |  -  |


## apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet

> apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet(projectId, ontologyId)

List validation jobs

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        UUID ontologyId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet(projectId, ontologyId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsGet");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Validation job history |  -  |


## apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost

> apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost(projectId, ontologyId)

Run a validation job

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        UUID ontologyId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost(projectId, ontologyId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesOntologyIdValidationJobsPost");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Completed validation job |  -  |


## apiV1ProjectsProjectIdOntologiesPost

> apiV1ProjectsProjectIdOntologiesPost(projectId)

Create an ontology

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID | 
        try {
            apiInstance.apiV1ProjectsProjectIdOntologiesPost(projectId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#apiV1ProjectsProjectIdOntologiesPost");
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

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created ontology |  -  |

