# OntologyControllerApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**changeStatus**](OntologyControllerApi.md#changeStatus) | **PATCH** /api/v1/projects/{projectId}/ontologies/{id}/status |  |
| [**create1**](OntologyControllerApi.md#create1) | **POST** /api/v1/projects/{projectId}/ontologies |  |
| [**export**](OntologyControllerApi.md#export) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/export |  |
| [**fork**](OntologyControllerApi.md#fork) | **POST** /api/v1/projects/{projectId}/ontologies/{id}/fork |  |
| [**get3**](OntologyControllerApi.md#get3) | **GET** /api/v1/projects/{projectId}/ontologies/{id} |  |
| [**importOntology**](OntologyControllerApi.md#importOntology) | **POST** /api/v1/projects/{projectId}/ontologies/import |  |
| [**layout**](OntologyControllerApi.md#layout) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/layout |  |
| [**list1**](OntologyControllerApi.md#list1) | **GET** /api/v1/projects/{projectId}/ontologies |  |
| [**listValidationJobs**](OntologyControllerApi.md#listValidationJobs) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/validation-jobs |  |
| [**runValidationJob**](OntologyControllerApi.md#runValidationJob) | **POST** /api/v1/projects/{projectId}/ontologies/{id}/validation-jobs |  |
| [**update3**](OntologyControllerApi.md#update3) | **PATCH** /api/v1/projects/{projectId}/ontologies/{id} |  |
| [**updateLayout**](OntologyControllerApi.md#updateLayout) | **PATCH** /api/v1/projects/{projectId}/ontologies/{id}/layout |  |
| [**validate**](OntologyControllerApi.md#validate) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/validation |  |



## changeStatus

> OntologyResponse changeStatus(projectId, id, changeOntologyStatusRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        ChangeOntologyStatusRequest changeOntologyStatusRequest = new ChangeOntologyStatusRequest(); // ChangeOntologyStatusRequest |
        try {
            OntologyResponse result = apiInstance.changeStatus(projectId, id, changeOntologyStatusRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#changeStatus");
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
| **id** | **UUID**|  | |
| **changeOntologyStatusRequest** | [**ChangeOntologyStatusRequest**](ChangeOntologyStatusRequest.md)|  | |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## create1

> OntologyResponse create1(projectId, createOntologyRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        CreateOntologyRequest createOntologyRequest = new CreateOntologyRequest(); // CreateOntologyRequest |
        try {
            OntologyResponse result = apiInstance.create1(projectId, createOntologyRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#create1");
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
| **createOntologyRequest** | [**CreateOntologyRequest**](CreateOntologyRequest.md)|  | |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## export

> OntologyTransferRequest export(projectId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyTransferRequest result = apiInstance.export(projectId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#export");
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
| **id** | **UUID**|  | |

### Return type

[**OntologyTransferRequest**](OntologyTransferRequest.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## fork

> OntologyResponse fork(projectId, id, forkOntologyRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        ForkOntologyRequest forkOntologyRequest = new ForkOntologyRequest(); // ForkOntologyRequest |
        try {
            OntologyResponse result = apiInstance.fork(projectId, id, forkOntologyRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#fork");
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
| **id** | **UUID**|  | |
| **forkOntologyRequest** | [**ForkOntologyRequest**](ForkOntologyRequest.md)|  | |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## get3

> OntologyResponse get3(projectId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyResponse result = apiInstance.get3(projectId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#get3");
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
| **id** | **UUID**|  | |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## importOntology

> OntologyResponse importOntology(projectId, ontologyTransferRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        OntologyTransferRequest ontologyTransferRequest = new OntologyTransferRequest(); // OntologyTransferRequest |
        try {
            OntologyResponse result = apiInstance.importOntology(projectId, ontologyTransferRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#importOntology");
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
| **ontologyTransferRequest** | [**OntologyTransferRequest**](OntologyTransferRequest.md)|  | |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## layout

> OntologyLayoutResponse layout(projectId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyLayoutResponse result = apiInstance.layout(projectId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#layout");
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
| **id** | **UUID**|  | |

### Return type

[**OntologyLayoutResponse**](OntologyLayoutResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## list1

> List&lt;OntologyResponse&gt; list1(projectId)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        try {
            List<OntologyResponse> result = apiInstance.list1(projectId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#list1");
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

[**List&lt;OntologyResponse&gt;**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## listValidationJobs

> List&lt;OntologyValidationJobResponse&gt; listValidationJobs(projectId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            List<OntologyValidationJobResponse> result = apiInstance.listValidationJobs(projectId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#listValidationJobs");
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
| **id** | **UUID**|  | |

### Return type

[**List&lt;OntologyValidationJobResponse&gt;**](OntologyValidationJobResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## runValidationJob

> OntologyValidationJobResponse runValidationJob(projectId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyValidationJobResponse result = apiInstance.runValidationJob(projectId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#runValidationJob");
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
| **id** | **UUID**|  | |

### Return type

[**OntologyValidationJobResponse**](OntologyValidationJobResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## update3

> OntologyResponse update3(projectId, id, updateOntologyRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        UpdateOntologyRequest updateOntologyRequest = new UpdateOntologyRequest(); // UpdateOntologyRequest |
        try {
            OntologyResponse result = apiInstance.update3(projectId, id, updateOntologyRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#update3");
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
| **id** | **UUID**|  | |
| **updateOntologyRequest** | [**UpdateOntologyRequest**](UpdateOntologyRequest.md)|  | |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## updateLayout

> OntologyLayoutResponse updateLayout(projectId, id, updateOntologyLayoutRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        UpdateOntologyLayoutRequest updateOntologyLayoutRequest = new UpdateOntologyLayoutRequest(); // UpdateOntologyLayoutRequest |
        try {
            OntologyLayoutResponse result = apiInstance.updateLayout(projectId, id, updateOntologyLayoutRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#updateLayout");
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
| **id** | **UUID**|  | |
| **updateOntologyLayoutRequest** | [**UpdateOntologyLayoutRequest**](UpdateOntologyLayoutRequest.md)|  | |

### Return type

[**OntologyLayoutResponse**](OntologyLayoutResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## validate

> OntologyValidationResponse validate(projectId, id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OntologyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        OntologyControllerApi apiInstance = new OntologyControllerApi(defaultClient);
        UUID projectId = UUID.randomUUID(); // UUID |
        UUID id = UUID.randomUUID(); // UUID |
        try {
            OntologyValidationResponse result = apiInstance.validate(projectId, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OntologyControllerApi#validate");
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
| **id** | **UUID**|  | |

### Return type

[**OntologyValidationResponse**](OntologyValidationResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

