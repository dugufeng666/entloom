# entloom_client.OntologyPropertyControllerApi

All URIs are relative to *http://localhost:18080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create4**](OntologyPropertyControllerApi.md#create4) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties |
[**delete2**](OntologyPropertyControllerApi.md#delete2) | **DELETE** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id} |
[**get2**](OntologyPropertyControllerApi.md#get2) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id} |
[**list5**](OntologyPropertyControllerApi.md#list5) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties |
[**update2**](OntologyPropertyControllerApi.md#update2) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{classId}/properties/{id} |


# **create4**
> OntologyPropertyResponse create4(project_id, ontology_id, class_id, create_ontology_property_request)



### Example


```python
import entloom_client
from entloom_client.models.create_ontology_property_request import CreateOntologyPropertyRequest
from entloom_client.models.ontology_property_response import OntologyPropertyResponse
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
    api_instance = entloom_client.OntologyPropertyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    class_id = 'class_id_example' # str |
    create_ontology_property_request = entloom_client.CreateOntologyPropertyRequest() # CreateOntologyPropertyRequest |

    try:
        api_response = api_instance.create4(project_id, ontology_id, class_id, create_ontology_property_request)
        print("The response of OntologyPropertyControllerApi->create4:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyPropertyControllerApi->create4: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **class_id** | **str**|  |
 **create_ontology_property_request** | [**CreateOntologyPropertyRequest**](CreateOntologyPropertyRequest.md)|  |

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
**201** | Created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete2**
> delete2(project_id, ontology_id, class_id, id)



### Example


```python
import entloom_client
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
    api_instance = entloom_client.OntologyPropertyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    class_id = 'class_id_example' # str |
    id = 'id_example' # str |

    try:
        api_instance.delete2(project_id, ontology_id, class_id, id)
    except Exception as e:
        print("Exception when calling OntologyPropertyControllerApi->delete2: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **class_id** | **str**|  |
 **id** | **str**|  |

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | No Content |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get2**
> OntologyPropertyResponse get2(project_id, ontology_id, class_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_property_response import OntologyPropertyResponse
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
    api_instance = entloom_client.OntologyPropertyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    class_id = 'class_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.get2(project_id, ontology_id, class_id, id)
        print("The response of OntologyPropertyControllerApi->get2:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyPropertyControllerApi->get2: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **class_id** | **str**|  |
 **id** | **str**|  |

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
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list5**
> List[OntologyPropertyResponse] list5(project_id, ontology_id, class_id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_property_response import OntologyPropertyResponse
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
    api_instance = entloom_client.OntologyPropertyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    class_id = 'class_id_example' # str |

    try:
        api_response = api_instance.list5(project_id, ontology_id, class_id)
        print("The response of OntologyPropertyControllerApi->list5:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyPropertyControllerApi->list5: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **class_id** | **str**|  |

### Return type

[**List[OntologyPropertyResponse]**](OntologyPropertyResponse.md)

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

# **update2**
> OntologyPropertyResponse update2(project_id, ontology_id, class_id, id, update_ontology_property_request)



### Example


```python
import entloom_client
from entloom_client.models.ontology_property_response import OntologyPropertyResponse
from entloom_client.models.update_ontology_property_request import UpdateOntologyPropertyRequest
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
    api_instance = entloom_client.OntologyPropertyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    class_id = 'class_id_example' # str |
    id = 'id_example' # str |
    update_ontology_property_request = entloom_client.UpdateOntologyPropertyRequest() # UpdateOntologyPropertyRequest |

    try:
        api_response = api_instance.update2(project_id, ontology_id, class_id, id, update_ontology_property_request)
        print("The response of OntologyPropertyControllerApi->update2:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyPropertyControllerApi->update2: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **class_id** | **str**|  |
 **id** | **str**|  |
 **update_ontology_property_request** | [**UpdateOntologyPropertyRequest**](UpdateOntologyPropertyRequest.md)|  |

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
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

