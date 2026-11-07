# ProjectControllerApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**callList**](ProjectControllerApi.md#callList) | **GET** /api/v1/projects |  |
| [**changeStatus1**](ProjectControllerApi.md#changeStatus1) | **PATCH** /api/v1/projects/{id}/status |  |
| [**create**](ProjectControllerApi.md#create) | **POST** /api/v1/projects |  |
| [**get4**](ProjectControllerApi.md#get4) | **GET** /api/v1/projects/{id} |  |
| [**update4**](ProjectControllerApi.md#update4) | **PATCH** /api/v1/projects/{id} |  |



## callList

> List&lt;ProjectResponse&gt; callList()



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProjectControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        ProjectControllerApi apiInstance = new ProjectControllerApi(defaultClient);
        try {
            List<ProjectResponse> result = apiInstance.callList();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectControllerApi#callList");
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

[**List&lt;ProjectResponse&gt;**](ProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## changeStatus1

> ProjectResponse changeStatus1(id, changeProjectStatusRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProjectControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        ProjectControllerApi apiInstance = new ProjectControllerApi(defaultClient);
        UUID id = UUID.randomUUID(); // UUID |
        ChangeProjectStatusRequest changeProjectStatusRequest = new ChangeProjectStatusRequest(); // ChangeProjectStatusRequest |
        try {
            ProjectResponse result = apiInstance.changeStatus1(id, changeProjectStatusRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectControllerApi#changeStatus1");
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
| **id** | **UUID**|  | |
| **changeProjectStatusRequest** | [**ChangeProjectStatusRequest**](ChangeProjectStatusRequest.md)|  | |

### Return type

[**ProjectResponse**](ProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## create

> ProjectResponse create(createProjectRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProjectControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        ProjectControllerApi apiInstance = new ProjectControllerApi(defaultClient);
        CreateProjectRequest createProjectRequest = new CreateProjectRequest(); // CreateProjectRequest |
        try {
            ProjectResponse result = apiInstance.create(createProjectRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectControllerApi#create");
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
| **createProjectRequest** | [**CreateProjectRequest**](CreateProjectRequest.md)|  | |

### Return type

[**ProjectResponse**](ProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## get4

> ProjectResponse get4(id)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProjectControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        ProjectControllerApi apiInstance = new ProjectControllerApi(defaultClient);
        UUID id = UUID.randomUUID(); // UUID |
        try {
            ProjectResponse result = apiInstance.get4(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectControllerApi#get4");
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
| **id** | **UUID**|  | |

### Return type

[**ProjectResponse**](ProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## update4

> ProjectResponse update4(id, updateProjectRequest)



### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProjectControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:18080");

        ProjectControllerApi apiInstance = new ProjectControllerApi(defaultClient);
        UUID id = UUID.randomUUID(); // UUID |
        UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest(); // UpdateProjectRequest |
        try {
            ProjectResponse result = apiInstance.update4(id, updateProjectRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectControllerApi#update4");
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
| **id** | **UUID**|  | |
| **updateProjectRequest** | [**UpdateProjectRequest**](UpdateProjectRequest.md)|  | |

### Return type

[**ProjectResponse**](ProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

