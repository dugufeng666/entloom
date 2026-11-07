# entloom_client.ProjectControllerApi

All URIs are relative to *http://localhost:18080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**change_status1**](ProjectControllerApi.md#change_status1) | **PATCH** /api/v1/projects/{id}/status |
[**create**](ProjectControllerApi.md#create) | **POST** /api/v1/projects |
[**get4**](ProjectControllerApi.md#get4) | **GET** /api/v1/projects/{id} |
[**list**](ProjectControllerApi.md#list) | **GET** /api/v1/projects |
[**update4**](ProjectControllerApi.md#update4) | **PATCH** /api/v1/projects/{id} |


# **change_status1**
> ProjectResponse change_status1(id, change_project_status_request)



### Example


```python
import entloom_client
from entloom_client.models.change_project_status_request import ChangeProjectStatusRequest
from entloom_client.models.project_response import ProjectResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.ProjectControllerApi(api_client)
    id = 'id_example' # str |
    change_project_status_request = entloom_client.ChangeProjectStatusRequest() # ChangeProjectStatusRequest |

    try:
        api_response = api_instance.change_status1(id, change_project_status_request)
        print("The response of ProjectControllerApi->change_status1:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ProjectControllerApi->change_status1: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  |
 **change_project_status_request** | [**ChangeProjectStatusRequest**](ChangeProjectStatusRequest.md)|  |

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
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create**
> ProjectResponse create(create_project_request)



### Example


```python
import entloom_client
from entloom_client.models.create_project_request import CreateProjectRequest
from entloom_client.models.project_response import ProjectResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.ProjectControllerApi(api_client)
    create_project_request = entloom_client.CreateProjectRequest() # CreateProjectRequest |

    try:
        api_response = api_instance.create(create_project_request)
        print("The response of ProjectControllerApi->create:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ProjectControllerApi->create: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_project_request** | [**CreateProjectRequest**](CreateProjectRequest.md)|  |

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
**201** | Created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get4**
> ProjectResponse get4(id)



### Example


```python
import entloom_client
from entloom_client.models.project_response import ProjectResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.ProjectControllerApi(api_client)
    id = 'id_example' # str |

    try:
        api_response = api_instance.get4(id)
        print("The response of ProjectControllerApi->get4:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ProjectControllerApi->get4: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  |

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
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list**
> List[ProjectResponse] list()



### Example


```python
import entloom_client
from entloom_client.models.project_response import ProjectResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.ProjectControllerApi(api_client)

    try:
        api_response = api_instance.list()
        print("The response of ProjectControllerApi->list:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ProjectControllerApi->list: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**List[ProjectResponse]**](ProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update4**
> ProjectResponse update4(id, update_project_request)



### Example


```python
import entloom_client
from entloom_client.models.project_response import ProjectResponse
from entloom_client.models.update_project_request import UpdateProjectRequest
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.ProjectControllerApi(api_client)
    id = 'id_example' # str |
    update_project_request = entloom_client.UpdateProjectRequest() # UpdateProjectRequest |

    try:
        api_response = api_instance.update4(id, update_project_request)
        print("The response of ProjectControllerApi->update4:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ProjectControllerApi->update4: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  |
 **update_project_request** | [**UpdateProjectRequest**](UpdateProjectRequest.md)|  |

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
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

